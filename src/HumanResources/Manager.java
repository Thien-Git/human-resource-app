package HumanResources;

public class Manager extends Staff implements ICalculator{
    private String title;

    public Manager(int id, String name, int age, double coefficients, String startingDate, String department, int annualLeave, String title) {
        super(id, name, age, coefficients, startingDate, department, annualLeave);
        this.title = title;
    }

    public Manager() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //Tính lương trách nhiệm cho mỗi chức vụ
    public int responsibilityAllowance () {
        if(title == "Business Leader") {
            return 8000000;
        } else if(title == "Project Leader") {
            return 5000000;
        } else if(title == "Technical Leader") {
            return 6000000;
        }
        return 0;
    }

    @Override
    public double calculateSalary() {
        double salary = getCoefficients() * 5000000 + responsibilityAllowance();
        return salary;
    }

    @Override
    public double displaySalary() {
        System.out.printf("%5.0f%3s",calculateSalary(), "vnd");
        System.out.println();
        return 0;
    }

    @Override
    public void displayInformation() {
        System.out.printf("%5d%20s%5d%15.1f%15s%18s%15d%12s%20s%12s", getId(), getName(), getAge(),
                getCoefficients(), getStartingDate(), getDepartment(), getAnnualLeave(),"Manager",getTitle(), "-");
        System.out.println();

//        System.out.println("Tên Manager là: " + getName());
//        System.out.println("   + Mã của Manager là: " +getId());
//        System.out.println("   + Hệ số lương: " +getCoefficients());
//        System.out.println("   + Ngày vào làm: " + getStartingDate());
//        System.out.println("   + Bộ phận làm việc: " +getDepartment());
//        System.out.println("   + Số ngày nghỉ phép: " + getAnnualLeave());
//        System.out.println("   + Chức danh: " +getTitle());
    }
}
