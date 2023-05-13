package HumanResources;

public class Department {
    private int idDepartment; //mã bộ phận
    private String nameDepartment; // tên bộ phận
    private int numberOfPeople; //số lượng nhân viên hiện tại

    public Department() {
    }

    public Department(int idDepartment, String nameDepartment, int numberOfPeople) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
        this.numberOfPeople = numberOfPeople;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {

        return String.format("%8s%25s%14d", idDepartment, nameDepartment, numberOfPeople);
    }
}
