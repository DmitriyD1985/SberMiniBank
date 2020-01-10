package dataBase;

import entities.UserOperation;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


import static dataBase.ConnectionDB.connection;

public class UserOperationListDao {
    private static final Logger log = Logger.getLogger(UserOperationListDao.class);
    public static ArrayList<UserOperation> getAllOperations(String userLogin2) {
        ArrayList<UserOperation> operationList = new ArrayList<>();
        try {
            Connection connection = connection();
            System.out.println("Формируем список по логину - "+userLogin2);
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM useroperationhistory WHERE userLogin = '" + userLogin2.trim() + "' ");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                UserOperation userOperation = new UserOperation();
                userOperation.setOperationContrAgentLogin(rs.getString("operationContrAgentLogin"));
                userOperation.setOperationName(rs.getString("operationName"));
                userOperation.setOperationSum(rs.getString("operationSum"));
                userOperation.setUserLogin(rs.getString("userLogin"));
                operationList.add(userOperation);
            }
        } catch (SQLException e) {
            log.info("Список операций клиента не загрузился");
            e.printStackTrace();
        }
        return operationList;
    }
}