package Account;

import java.io.Serializable;

public class AccountAdmin implements Serializable {
    String adminAcc, adminPass;

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

}
