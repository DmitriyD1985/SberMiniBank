package entities;

import java.math.BigDecimal;
import java.util.Objects;

public class User
{
    private String userFirstname;
    private String userLastname;
    private String userOtchestvo;
    private String userPassword;
    private String userLogin;

    public User(String userFirstname, String userLastname, String userOtchestvo, String userPassword, String userLogin) {
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.userOtchestvo = userOtchestvo;
        this.userPassword = userPassword;
        this.userLogin = userLogin;
    }

    public User() {
    }


    public String getUserFirstname() {
        return userFirstname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public String getUserOtchestvo() {
        return userOtchestvo;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public void setUserOtchestvo(String userOtchestvo) {
        this.userOtchestvo = userOtchestvo;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "User{" +
                ", userFirstname='" + userFirstname + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", userOtchestvo='" + userOtchestvo + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userLogin='" + userLogin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userFirstname.equals(user.userFirstname) &&
                userLastname.equals(user.userLastname) &&
                userOtchestvo.equals(user.userOtchestvo) &&
                userPassword.equals(user.userPassword) &&
                userLogin.equals(user.userLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userFirstname, userLastname, userOtchestvo, userPassword, userLogin);
    }
}
