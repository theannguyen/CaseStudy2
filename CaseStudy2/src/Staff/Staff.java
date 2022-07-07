package Staff;

import java.io.Serializable;

public class Staff implements Serializable {
    private static int ID_STAFF = 1;
    int id;
    String name;
    int age;
    String gender, address;
    double salary;

    public Staff() {
    }

    public Staff(String name, int age, String gender, String address, double salary) {
        this.id = ID_STAFF++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Nhân viên{" +
                "id=" + id +
                ", Tên='" + name + '\'' +
                ", Tuổi=" + age +
                ", Giới tính='" + gender + '\'' +
                ", Địa chỉ='" + address + '\'' +
                ", Tiền lương=" + salary +
                '}';
    }
}
