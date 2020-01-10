package dataBase;

import org.apache.log4j.Logger;

import java.sql.*;

import static dataBase.ConnectionDB.connection;

public class LoginDao {
    private static final Logger log = Logger.getLogger(LoginDao.class);
    static boolean status;

    public static boolean validate(String name, String pass) {
        status = false;
        try {
            Connection connection = connection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE userLogin=? and userPassword=?");
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                log.info("Логин и пароль проверены в БД");
                System.out.println("Логин и пароль проверены в БД");
                status = true;
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            log.info(e);
        }
        return status;
    }
}