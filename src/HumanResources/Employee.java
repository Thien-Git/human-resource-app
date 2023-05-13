package HumanResources;

public class Employee extends Staff implements ICalculator{
    private int overTime; //số giờ làm thêm

    public Employee(int id, String name, int age, double coefficients, String startingDate, String department, int annualLeave, int overTime) {
        super(id, name, age, coefficients, startingDate, department, annualLeave);
        this.overTime = overTime;
    }

    public Employee() {

    }

    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    @Override
    public double calculateSalary() {
        double salary = getCoefficients() * 3000000 + getOverTime() *200000;
        return salary;
    }

    @Override
    public double displaySalary() {
        System.out.printf("%5.0f%3s",calculateSalary(),"vnd");
        System.out.println();
        return 0;
    }

    @Override
    public void displayInformation() {
        System.out.printf("%5d%20s%5d%15.1f%15s%18s%15d%12s%20s%12d", getId(), getName(), getAge(), getCoefficients(),
                getStartingDate(), getDepartment(), getAnnualLeave(),"Employee","-", overTime);
        System.out.println();
    }
}
