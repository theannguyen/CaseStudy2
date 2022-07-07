package Account;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountAdmin implements Serializable {
    String adminAcc, adminPass;
    private final ArrayList<AccountAdmin> accountAdminList = new ArrayList<>();

    public AccountAdmin() {
        accountAdminList.add(new AccountAdmin("ADMIN", "12345"));
    }

    public AccountAdmin(String adminAcc, String adminPass) {
        this.adminAcc = adminAcc;
        this.adminPass = adminPass;
    }

    public String getAdminAcc() {
        return adminAcc;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdmin(String adminAcc, String adminPass) {
        accountAdminList.add(new AccountAdmin(adminAcc, adminPass));
    }

    public ArrayList<AccountAdmin> getAccountAdminList() {
        return accountAdminList;
    }

    @Override
    public String toString() {
        return "Tài Khoản Admin{" +
                "Tài Khoản='" + adminAcc + '\'' +
                ", Mật khẩu='" + adminPass + '\'' +
                '}';
    }
}
