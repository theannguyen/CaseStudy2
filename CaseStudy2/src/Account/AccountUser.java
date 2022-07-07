package Account;

import java.io.Serializable;

public class AccountUser implements Serializable {
String account, password;

    public AccountUser() {
    }

    public AccountUser(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Tài khoản Người dùng{" +
                "Tài Khoản='" + account + '\'' +
                ", Mật Khẩu='" + password + '\'' +
                '}';
    }
}
