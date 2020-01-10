package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sberminibank?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8", "root", "Terma137099");
        } catch (SQLException e) {
            System.out.println("Подключение к базе не удалось");
            log.info("Подключение к базе не удалось");
            e.printStackTrace();
        }
        return connection;
    }
}