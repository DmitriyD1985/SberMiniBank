package dataBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.sun.deploy.util.Property;
import org.apache.log4j.Logger;

public class ConnectionDB {
    private static final Logger log = Logger.getLogger(ConnectionDB.class);
    public static Connection connection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось найти драйвер для базы данных");
            log.info("Не удалось найти драйвер для базы данных");
            e.printStackTrace();
        }
        File file = new File("G:\\sberMiniBank2TMP_work\\src\\main\\resources\\dataBase.properties");

        Properties properties = new Properties();
        try {
            properties.load(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Фаил с данными подключения не найден");
        }

        try {
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        } catch (SQLException e) {
            System.out.println("Подключение к базе не удалось");
            log.info("Подключение к базе не удалось");
            e.printStackTrace();
        }
        return connection;
    }
}