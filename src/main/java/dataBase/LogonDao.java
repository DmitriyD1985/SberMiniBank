package dataBase;

import org.apache.log4j.Logger;
import java.sql.*;

import static dataBase.ConnectionDB.connection;

public class LogonDao {
    private static final Logger log = Logger.getLogger(LogonDao.class);
    static boolean status;
    public static boolean validate(String fio,String name, String pass){
        String query = " insert into users (userFIO, userPassword, userLogin)"  + " values (?, ?, ?)";
        try(Connection conn = connection();){
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, fio);
        preparedStmt.setString(2, pass);
        preparedStmt.setString(3, name);
        preparedStmt.execute();
        status = true;
        }
        catch (SQLException e)
        {
            log.info(e);
            e.printStackTrace();
            status = false;
        }
        log.info("Пользователь зарегестрирован - "+status);
        System.out.println(status);
        return status;

    }
}

