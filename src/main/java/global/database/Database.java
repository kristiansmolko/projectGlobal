package global.database;

import global.log.Log;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private final String getGeneralData = "SELECT ";
    private final String getDataBySensorType = "SELECT ";
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

    public String getGeneralData(){
        //this is method to get general data for landing page
        try (Connection connection = getConnection()) {
            if (connection != null){

            }
        } catch (Exception e) { log.error(e.toString()); }
        return null;
    }

    public String getDataBySensorType(String sensorType){
        //this is method to get data from specific sensor
        try (Connection connection = getConnection()) {
            if (connection != null){

            }
        } catch (Exception e) { log.error(e.toString()); }
        return null;
    }
}
