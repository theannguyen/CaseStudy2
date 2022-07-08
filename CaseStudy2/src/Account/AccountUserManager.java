package Account;
import Menu.MenuStaff;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountUserManager implements Serializable {
    public ArrayList<AccountUser> accountUsers = new ArrayList<>();
    public void ghiFile(ArrayList<AccountUser> accountUsers) {
        File file = new File("Account.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(accountUsers);
            objectOutputStream.close();
        }
        catch (Exception e) {
            System.out.println("Tài khoản đã tồn tại!");
        }
    }

    public ArrayList<AccountUser> docFile() {
        File file = new File("Account.txt");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            accountUsers = (ArrayList<AccountUser>) objectInputStream.readObject();
            objectInputStream.close();
            return accountUsers;
        } catch (Exception e) {
            System.out.println("Không đọc được file!");
        }
        return accountUsers;
    }

    public boolean checkAccount(String account) {
        for (int i = 0; i < accountUsers.size(); i++) {
            if (accountUsers.get(i).getAccount().equals(account)) {
                return true;
            }
        }
        return false;
    }

    public AccountUser registerAccount(Scanner scanner){
        System.out.println("Nhập tên Tài khoản mới: ");
        String account = scanner.nextLine();
        while (checkAccount(account)) {
            System.out.println("Tài khoản đã tồn tại, vui lòng đăng ký Tài khoản khác: ");
            account = scanner.nextLine();
        }
        System.out.println("Nhập mật khẩu mới: ");
        String password = scanner.nextLine();
        return new AccountUser(account, password);
    }

    public void addAccount(Scanner scanner) {
        AccountUser accountUser = registerAccount(scanner);
        accountUsers.add(accountUser);
        System.out.println("Đăng ký thành công!");
        System.out.println("-------------------");
        ghiFile(accountUsers);
    }

    public void displayAccount() {
        for (AccountUser accountUser : accountUsers) {
            System.out.println(accountUser);
        }
    }

    public boolean checkAccountAdmin(AccountAdmin accountAdmin) {
        if (accountAdmin.getAdminAcc().equals("ADMIN") && accountAdmin.getAdminPass().equals("910JQK")) {
            return true;
        } else {
            return false;
        }
    }

    public void loginAccount(Scanner scanner) {
        AccountAdmin accountAdmin = new AccountAdmin("ADMIN", "910JQK");
       MenuStaff menuStaff = new MenuStaff();
        System.out.println("Tên đăng nhập: ");
        String userAccount = scanner.nextLine();
        System.out.println("Mật khẩu đăng nhập: ");
        String password = scanner.nextLine();
        System.out.println("Đăng nhập thành công!");
        System.out.println("---------------------");
        if (checkLogin(userAccount,password)){
            menuStaff.MenuStaff();
        } if (checkAccountAdmin(accountAdmin)) {
            menuStaff.Menu();
        }
        else {
            System.out.println("Sai tài khoản hoặc mật khẩu, vui lòng lựa chọn lại: ");
        }
    }

    public boolean checkLogin(String userAccount, String password){
        for (AccountUser accountUser : accountUsers) {
            if (accountUser.getAccount().equals(userAccount) &&
                    accountUser.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void deleteAccount(Scanner scanner) {
        String account = "";
        System.out.println("Nhập tài khoản muốn xóa: ");
        account = scanner.nextLine();
        for (int i = 0; i < accountUsers.size(); i++) {
            if (accountUsers.get(i).getAccount().equals(account)) {
                accountUsers.remove(i);
                System.out.println("Xóa tài khoản thành công!");
                ghiFile(accountUsers);
            }
        }
    }


}
