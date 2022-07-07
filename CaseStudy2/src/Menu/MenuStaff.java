package Menu;

import Staff.Staff;
import Staff.StaffManager;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuStaff {
    public Scanner scanner = new Scanner(System.in);
    StaffManager staffManager = new StaffManager();
    public ArrayList<Staff> arrayList = staffManager.docFile();
    public  void MenuStaff() {
        int choice = -1;
        do {
            try {
                System.out.println("*****                                   *****");
                System.out.println("****               NHÂN VIÊN             ****");
                System.out.println("**                                         **");
                System.out.println("**   1. Hiển thị thông tin các Nhân viên   **");
                System.out.println("**   2. Tìm kiếm Nhân viên theo Id         **");
                System.out.println("**   3. Tìm kiếm Nhân viên theo tên        **");
                System.out.println("**   0. Thoát chương trình                 **");
                System.out.println("****                                     ****");
                System.out.println("*****                                   *****");
                System.out.println("                 Nhập lựa chọn:              ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: staffManager.displayAllStaff();
                        break;
                    case 2:
                        staffManager.displayStaffById(scanner);
                        break;
                    case 3:
                        staffManager.displayStaffByName(scanner);
                        break;
                }
            }catch (NumberFormatException e){
                System.err.println("Nhập vào không đúng định dạng, vui lòng nhập lại");
            }
        }
        while (choice != 0);
        }
    public void Menu() {
        int choice = -1;
        do {
            try {
                System.out.println("******                                       ******");
                System.out.println("****             QUẢN LÝ NHÂN VIÊN             ****");
                System.out.println("**                                               **");
                System.out.println("**            1. Thêm Nhân viên mới              **");
                System.out.println("**         2. Hiển thị danh sách Nhân viên       **");
                System.out.println("**         3. Tìm kiếm Nhân viên theo Id         **");
                System.out.println("**         4. Tìm kiếm Nhân viên theo tên        **");
                System.out.println("**         5. Cập nhật Nhân viên theo Id         **");
                System.out.println("**           6. Xóa Nhân viên theo Id            **");
                System.out.println("**            0. Thoát chương trình              **");
                System.out.println("****                                           ****");
                System.out.println("******             Nhập lựa chọn             ******");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        staffManager.addStaff(scanner);
                        break;
                    case 2:
                        staffManager.displayAllStaff();
                        break;
                    case 3:
                        staffManager.displayStaffById(scanner);
                        break;
                    case 4:
                        staffManager.displayStaffByName(scanner);
                        break;
                    case 5:
                        staffManager.updateStaffById(scanner);
                        break;
                    case 6:
                        staffManager.deleteStaffById(scanner);
                        break;
            }


            }
            catch (NumberFormatException e) {
                System.err.println("Nhập vào không đúng định dạng, vui lòng nhập lại");
            }
        } while (choice != 0);
    }


}
