package entities;

public class UserOperation {

    private String operationName;
    private String operationSum;
    private String operationContrAgentLogin;
    private String userLogin;

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationSum() {
        return operationSum;
    }

    public void setOperationSum(String operationSum) {
        this.operationSum = operationSum;
    }

    public String getOperationContrAgentLogin() {
        return operationContrAgentLogin;
    }

    public void setOperationContrAgentLogin(String operationContrAgentLogin) {
        this.operationContrAgentLogin = operationContrAgentLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}