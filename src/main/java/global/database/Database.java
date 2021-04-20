package global.database;

import global.entity.Sensor;
import global.log.Log;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Database {
    private final String getGeneralData = "SELECT d.sensor_type, d.sensor_unit, d.sensor_value, d.date_time FROM tmeasurementv1 d " +
            "WHERE d.date_time IN (SELECT MAX(d2.date_time) FROM tmeasurementv1 d2 WHERE d2.sensor_type=d.sensor_type);";
    private final String getDataBySensorType = "SELECT * FROM tmeasurementv1 WHERE sensor_type LIKE ?";
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

    public Map<String, Float> getGeneralData(){
        //this is method to get general data for landing page
        Map<String, Float> map = new HashMap<>();
        try (Connection connection = getConnection()) {
            if (connection != null){
                PreparedStatement ps = connection.prepareStatement(getGeneralData);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    String type = null;
                    switch(rs.getInt("sensor_type")){
                        case 1: type = "rainfall"; break;
                        case 2: type = "temperature"; break;
                        case 3: type = "humidity"; break;
                        case 4: type = "pressure"; break;
                    }
                    map.put(type, rs.getFloat("sensor_value"));
                    System.out.println(map);
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
}
