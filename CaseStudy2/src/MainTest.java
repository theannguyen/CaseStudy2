import Menu.MenuAccount;

import java.io.Serializable;

public class MainTest implements Serializable {
    public static void main(String[] args) {
        MenuAccount menuAccount = new MenuAccount();
        menuAccount.Connection();
    }
}
