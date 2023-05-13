package HumanResources;

public abstract class Staff {
    private int id; //mã nhân viên
    private String name; //tên nhân viên
    private int age; //tuổi nhân viên
    private double coefficients; //hệ số lương
    private String startingDate; //ngày vào làm
    private String department; //bô phân làm việc
    private int annualLeave; //số ngày nghỉ phép

    public Staff() {
    }

    public Staff(int id, String name, int age, double coefficients, String startingDate, String department, int annualLeave) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.coefficients = coefficients;
        this.startingDate = startingDate;
        this.department = department;
        this.annualLeave = annualLeave;
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

    public double getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(double coefficients) {
        this.coefficients = coefficients;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAnnualLeave() {
        return annualLeave;
    }

    public void setAnnualLeave(int annualLeave) {
        this.annualLeave = annualLeave;
    }

    public abstract void displayInformation();


    public abstract double displaySalary();
}
