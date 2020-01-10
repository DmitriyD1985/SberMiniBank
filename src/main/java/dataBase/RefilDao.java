package dataBase;

import entities.UserOperation;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;

import static dataBase.ConnectionDB.connection;

public class RefilDao {
    private static final Logger log = Logger.getLogger(RefilDao.class);
    static boolean status;

    public static boolean refilAckount(String loginUser, String sum) {
        try (Connection conn = connection()) {
            PreparedStatement prep = conn.prepareStatement("insert into useroperationhistory(operationName, operationSum, operationContrAgentLogin, userLogin) values (?, ?, ?, ?);");
            prep.setString(1, "refil");
            prep.setString(2, sum);
            prep.setString(3, loginUser);
            prep.setString(4, loginUser);
            prep.execute();
            log.info("in sheme useroperationhistory is added information about Refill operation");
            log.info(prep);
            Statement statement1 = conn.createStatement();
            statement1.execute("SELECT userAccount FROM users WHERE userLogin = '" + loginUser.trim() + "' ");
            ResultSet rs = statement1.getResultSet();
            String oldSum = null;

            while (rs.next()) {
                oldSum = rs.getString("userAccount");
            }

            String resul = new BigDecimal(sum).add(new BigDecimal(oldSum)).toString();
            statement1.execute("update users set userAccount ='" + resul + "' where userLogin = '" + loginUser.trim() + "' ");
            log.info("information about userAccount is updated");
            status = true;
        } catch (SQLException e) {
            log.info("Запись операции пополнения в БД или само пополнение не удалась");
            log.info(e);
            status = false;
        }

        return status;
    }
}