package global.database;

import global.entity.Sensor;
import global.log.Log;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class Database {
    private final String getGeneralData = "SELECT d.sensor_type, d.sensor_unit, d.sensor_value, d.date_time FROM measurement d " +
            "WHERE d.date_time IN (SELECT MAX(d2.date_time) FROM measurement d2 WHERE d2.sensor_type=d.sensor_type);";
    private final String getDataBySensorType = "SELECT * FROM measurement WHERE sensor_type LIKE ?";
    private final String insertSensor = "INSERT INTO measurement(sensor_type, sensor_unit, sensor_value)" +
            " VALUES(?, ?, ?)";
    Log log = new Log();

    public Connection getConnection() throws IOException, SQLException {
        Properties prop = new Properties();
        InputStream loader = getClass().getClassLoader().getResourceAsStream("data.properties");
        prop.load(loader);
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String pass = prop.getProperty("password");
        Connection connection = DriverManager.getConnection(url, user, pass);
        if (connection != null){
            log.ok("Connection established");
            return connection;
        }
        return null;
    }

    public HashMap getGeneralData(){
        //this is method to get general data for landing page
        HashMap<String, Float> map = new HashMap<>();
        try (Connection connection = getConnection()) {
            if (connection != null){
                PreparedStatement ps = connection.prepareStatement(getGeneralData);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    map.put(rs.getString("sensor_type"), rs.getFloat("sensor_value"));
                }
            }
        } catch (Exception e) { log.error(e.toString()); }
        return map;
    }

    public List<Sensor> getDataBySensorType(String sensorType){
        //this is method to get data from specific sensor
        try (Connection connection = getConnection()) {
            if (connection != null){
                PreparedStatement ps = connection.prepareStatement(getDataBySensorType);
                ps.setString(1, sensorType);
                return executeSelect(ps);
            }
        } catch (Exception e) { log.error(e.toString()); }
        return null;
    }

    private List<Sensor> executeSelect(PreparedStatement ps){
        List<Sensor> list = new ArrayList<>();
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String sensor_type = rs.getString("sensor_type");
                String sensor_unit = rs.getString("sensor_unit");
                Float sensor_value = rs.getFloat("sensor_value");
                Timestamp date_time = rs.getTimestamp("date_time");
                list.add(new Sensor(sensor_type, sensor_unit, sensor_value, new Date(date_time.getTime())));
            }
        } catch (Exception e) { log.error(e.toString()); }
        return list;
    }

    /**
     * This method inserts new record into database(table measurement)
     * @param sensor sensor entity to be recorded
     * @return true when insert was successful, false when insert didn't happen
     * */
    public boolean insertRecord(Sensor sensor){
        log.info("Executing Database.insertRecord");
        if (sensor == null) return false;

        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(insertSensor);

            ps.setString(1, sensor.getType());
            ps.setString(2, sensor.getUnit());
            ps.setFloat(3, sensor.getValue());

            if (ps.executeUpdate() != 0){
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }
        } catch (IOException | SQLException e) {
            log.error(e.toString());
        }

        return false;
    }
}
