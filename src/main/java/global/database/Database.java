package global.database;

import global.log.Log;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
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
}
