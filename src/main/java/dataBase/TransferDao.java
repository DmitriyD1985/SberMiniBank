package dataBase;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;

import static dataBase.ConnectionDB.connection;

public class TransferDao {
    private static final Logger log = Logger.getLogger(TransferDao.class);
    static boolean status;
    public static boolean transfer(String loginUser, String contrAgent, String sum){
        try(Connection conn = connection()){
            Statement statement1 = conn.createStatement();

            statement1.execute("SELECT userAccount FROM users WHERE userLogin = '" + loginUser.trim() + "' ");
            ResultSet rs3 = statement1.getResultSet();
            String oldSumRec = null;
            while (rs3.next()) {
                oldSumRec = rs3.getString("userAccount");
            }

            BigDecimal result4 = new BigDecimal(oldSumRec).subtract(new BigDecimal(sum));

            if(result4.signum()!=-1){
//            Statement statement4 = conn.createStatement();
            statement1.execute("update users set userAccount ='" + result4.toString() + "' where userLogin = '" + contrAgent.trim() + "' ");
            log.info("information about user recepient account is updated");

            PreparedStatement prep = conn.prepareStatement("insert into useroperationhistory(operationName, operationSum, operationContrAgentLogin, userLogin) values (?, ?, ?, ?);");
            prep.setString(1, "transfer");
            prep.setString(2, sum);
            prep.setString(3, contrAgent);
            prep.setString(4, loginUser);
            prep.execute();

            statement1.execute("SELECT userAccount FROM users WHERE userLogin = '" + contrAgent.trim() + "' ");
            ResultSet rs = statement1.getResultSet();
            String oldSum = null;
            while (rs.next()) {
                oldSum = rs.getString("userAccount");
            }

            String result = new BigDecimal(sum).add(new BigDecimal(oldSum)).toString();
//            Statement statement2 = conn.createStatement();
            statement1.execute("update users set userAccount ='" + result + "' where userLogin = '" + contrAgent.trim() + "' ");
            log.info("information about user sender account is updated");
//            Statement statement3 = conn.createStatement();

            status = true;}
            else {
                status = false;
                System.out.println("недостаточно средств");
                log.info("not enough funds in the sender's account");
            }
        }
        catch (SQLException e)
        {
            log.info(e);
            e.printStackTrace();
            status = false;
        }

        return status;
    }
}