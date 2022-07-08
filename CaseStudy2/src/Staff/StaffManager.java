package Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffManager implements Serializable {
    ArrayList<Staff> staffList = new ArrayList<>();

    public void ghiFile(ArrayList<Staff> staffList) {
        File file = new File("Staff.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(staffList);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("File đã tồn tại!");
        }
    }

    public ArrayList<Staff> docFile() {
        File file = new File("Staff.txt");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            staffList = (ArrayList<Staff>) objectInputStream.readObject();
            objectInputStream.close();
            return staffList;
        } catch (Exception e) {
            System.out.println("File ko đọc được!");
        }
        return null ;
    }

    public boolean checkId(int id) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Staff creatNewStaff(Scanner scanner) {
        System.out.println("Nhập Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        while (checkId(id)) {
            System.out.println("Id nhân viên đã tồn tại, vui lòng nhập Id khác: ");
            id = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Nhập tên của nhân viên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi của nhân viên: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính của nhân viên: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập lương của nhân viên: ");
        double salary = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập địa chỉ của nhân viên: ");
        String address = scanner.nextLine();
        System.out.println("Thêm mới Nhân viên thành công!");
        System.out.println("------------------------------");
        return new Staff(name, age, gender, address, salary);
    }

    public void addStaff(Scanner scanner) {
        Staff staff = creatNewStaff(scanner);
        staffList.add(staff);
        ghiFile(staffList);
    }

    public void displayAllStaff() {
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }

    public void displayStaffById(Scanner scanner) {
        boolean check = false;
        System.out.println("Nhập id của Nhân viên cần hiển thị: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Staff staff : staffList) {
            if (staff.getId() == id) {
                System.out.println(staff);
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Không tìm thấy Nhân viên");
        }
    }

    public void displayStaffByName(Scanner scanner) {
        boolean check = false;
        System.out.print("Nhập tên của Nhân viên cần hiển thị: ");
        String name = scanner.nextLine();
        for (Staff a : staffList) {
            if (a.getName().equalsIgnoreCase(name)) {
                System.out.println(a);
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Không tìm thấy nhân viên!");
        }
    }

    public void updateStaff(Staff staff){
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getId() == staff.getId()){
                staffList.set(i, staff);
                break;
            }
        }
    }
    public Staff getStaffById(int id){
        for (Staff staff: staffList){
            if (staff.getId() == id){
                return staff;
            }
        }
        return null;
    }

    public void updateStaffById(Scanner scanner) {
        displayAllStaff();
        System.out.println("Nhập Id của Nhân viên cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Staff staff = getStaffById(id);
        System.out.println(staff);
        System.out.println("Nhập tên mới: ");
        String name = scanner.nextLine();
        staff.setName(name);
        System.out.println("Nhập tuổi mới: ");
        int age = Integer.parseInt(scanner.nextLine());
        staff.setAge(age);
        System.out.println("Nhập giới tính mói: ");
        String gender = scanner.nextLine();
        staff.setGender(gender);
        System.out.println("Nhập tiền lương mới: ");
        double salary = Integer.parseInt(scanner.nextLine());
        staff.setSalary(salary);
        System.out.println("Nhập địa chỉ mới: ");
        String address = scanner.nextLine();
        staff.setAddress(address);
        updateStaff(staff);
        ghiFile(staffList);
        System.out.println("Cập nhật thành công!");
        System.out.println("--------------------");
    }

    public void deleteStaffById(Scanner scanner) {
        boolean check = false;
        System.out.println("Nhập Id của Nhân viên cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getId() == id) {
                staffList.remove(i);
                ghiFile(staffList);
                check = true;
                System.out.println("Xóa thành công!");
                System.out.println("---------------");
            }
        }
        if (check == false) {
            System.out.println("Không tìm thấy Nhân viên!");
        }
    }


}

