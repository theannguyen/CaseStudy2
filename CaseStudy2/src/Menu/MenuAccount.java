package Menu;

import Account.AccountUser;
import Account.AccountUserManager;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAccount {
    private ArrayList<AccountUser> accountUsers ;

    AccountUserManager accountUserManager = new AccountUserManager();
    public MenuAccount() {
        accountUsers = accountUserManager.docFile();
    }


    public void Connection() {
        Scanner scanner = new Scanner(System.in);
        MenuAccount menuAccount = new MenuAccount();
        int choice = -1;
        do {
            try {
                System.out.println("******               MENU            ******");
                System.out.println("***                                     ***");
                System.out.println("**           1. Đăng ký                  **");
                System.out.println("**           2. Đăng nhập                **");
                System.out.println("**           3. Hiển thị tài khoản       **");
                System.out.println("**           4. Xóa tài khoản            **");
                System.out.println("**           0. Thoát chương trình       **");
                System.out.println("***                                     ***");
                System.out.println("******                               ******");
                System.out.println("                Nhập lựa chọn:             ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        accountUserManager.addAccount(scanner);
                        break;
                    case 2:
                        accountUserManager.loginAccount(scanner);
                        break;
                    case 3:
                        accountUserManager.displayAccount();
                        break;
                    case 4:
                        accountUserManager.deleteAccount(scanner);
                        break;
                }
            }catch (NumberFormatException e){
                System.err.println("Lựa chọn sai dịnh dạng, vui lòng nhập lại!");
            }

        }
        while (choice != 0);
    }
}
