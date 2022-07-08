import Menu.MenuAccount;

import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) {
        MenuAccount menuAccount = new MenuAccount();
        menuAccount.Connection();
    }
}
