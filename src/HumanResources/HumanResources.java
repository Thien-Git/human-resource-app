package HumanResources;
import java.util.*;

public class HumanResources {

    static ArrayList<Staff> staff = new ArrayList<>();
    static ArrayList<Department> departments = new ArrayList<>();

    public static void myCompany() {
        Employee employee1 = new Employee(123, "Lê Thị Mai", 30, 1.5, "24/08/2021", "Bộ phận Kế Toán", 12, 4);
        Employee employee2 = new Employee(124, "Trần Kim Ngọc", 25, 1.6, "05/12/2019", "Bộ phận Mua Hàng", 12, 2);
        Employee employee3 = new Employee(125, "Lê Thị Mắm", 26, 1.1, "01/08/2020", "Bộ phận Sản Xuất", 12, 3);
        Employee employee4 = new Employee(125, "Lê Thị Bông", 26, 1.2, "08/08/2020", "Bộ phận Mua Hàng", 12, 1);

        Manager manager1 = new Manager(200, "Lê Thị Mắm", 30, 1.8, "25/05/2021", "Bộ phận Sản Xuất", 12, "Technical Leader");
        Manager manager2 = new Manager(201, "Phạm Mạnh Toàn", 48, 1.6, "25/05/2021", "Bộ phận Dự Án", 12, "Technical Leader");

        Department department1 = new Department(111, "Bộ phận Kế Toán", 1);
        Department department2 = new Department(112, "Bộ phận Mua Hàng", 2);
        Department department3 = new Department(113, "Bộ phận Sản Xuất", 2);
        Department department4 = new Department(114, "Bộ phận Dự Án", 1);

        staff.add(employee1);
        staff.add(employee2);
        staff.add(employee3);
        staff.add(employee4);
        staff.add(manager1);
        staff.add(manager2);
        departments.add(department1);
        departments.add(department2);
        departments.add(department3);
        departments.add(department4);
    }

    //Bảng điều khiển- menu
    public static void menu() {
        System.out.println("Mời bạn chọn chức năng: ");
        System.out.println("Bấm phím 1: Hiển thị danh sách nhân viên hiện có trong công ty ");
        System.out.println("Bấm phím 2: Hiển thị các bộ phận trong công ty ");
        System.out.println("Bấm phím 3: Hiển thị các nhân viên theo từng bộ phận ");
        System.out.println("Bấm phím 4: Thêm nhân viên mới vào công ty ");
        System.out.println("Bấm phím 5: Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
        System.out.println("Bấm phím 6: Hiển thị bảng lương của nhân viên toàn công ty ");
        System.out.println("Bấm phím 7: Hiển thị bảng lương của nhân viên theo thứ tự tăng dần ");
        System.out.println("Bấm phím 8: Hiển thị bảng lương của nhân viên theo thứ tự giảm dần ");

        int selectNumber = new Scanner(System.in).nextInt();

        switch (selectNumber) {
            case 1:
                System.out.println("DANH SÁCH NHÂN VIÊN HIỆN CÓ: ");
                displayStaffInfo();
                break;
            case 2:
                System.out.println("CÁC BỘ PHẬN TRONG CÔNG TY: ");
                displayDepartmentInfo();
                break;
            case 3:
                System.out.println("NHÂN VIÊN THEO TỪNG BỘ PHẬN");
                displayStaffEachDepartment();
                break;
            case 4:
                System.out.println("THÊM NHÂN VIÊN");
                addStaff();
                break;
            case 5:
                System.out.println("TÌM KIẾM THÔNG TIN");
                find();
                break;
            case 6:
                System.out.println("BẢNG LƯƠNG TẤT CẢ NHÂN VIÊN: ");
                listStaffSalary();
                break;
            case 7:
                System.out.println("BẢNG LƯƠNG TẤT CẢ NHÂN VIÊN THEO THỨ TỰ TĂNG DẦN: ");
                displaySalaryIncrease();
                break;
            case 8:
                System.out.println("BẢNG LƯƠNG TẤT CẢ NHÂN VIÊN THEO THỨ TỰ GIẢM DẦN: ");
                displaySalaryDecrease();
                break;
            case 0:
                System.err.println("Chương trình kết thúc !");
                System.exit(0);
            default:
                System.out.println("Bạn nhâp sai số rồi, hãy thử lại");
                menu();
        }
    }

    // Tính lương chính xác cho staff là Employee hay Manager
    public static double calculatorSalary(Staff staff1) {
        double salary = 0;
        if (staff1 instanceof Employee) {
            salary = ((Employee)staff1).calculateSalary();
        } else if (staff1 instanceof Manager) {
            salary = ((Manager)staff1).calculateSalary();
        }
        return salary;
    }

    //8.Sắp xếp lương theo thứ tự giảm dần
    private static void displaySalaryDecrease() {
        Collections.sort(staff, (a, b) -> (int) (calculatorSalary(b) - calculatorSalary(a)));
        headerTable();
        System.out.println();
        for (Staff st : staff) {
            st.displayInformation();
            System.out.print("** Lương của nhân viên này là: ");
            st.displaySalary();
        }
        System.out.println();
        questionContinue();
    }

    //7.Sắp xếp lương theo thứ tự tăng dần
    private static void displaySalaryIncrease() {

        Collections.sort(staff , (a, b) -> (int) (calculatorSalary(a) - calculatorSalary(b)));
        headerTable();
        System.out.println();
        for (Staff st : staff) {
            st.displayInformation();
            System.out.printf("%19s%10s%5s", "* Lương của nhân viên ", st.getName()," là: ");
            st.displaySalary();
        }
        System.out.println();
        questionContinue();

    }

    //6. Hiển thị lương nhân viên
    private static void listStaffSalary() {
        double salary = 0;
        headerTable();
        System.out.println();

        for (Staff st : staff) {
            st.displayInformation();
            if (st instanceof Manager) {
                salary = ((Manager) st).calculateSalary();
            } else if (st instanceof Employee) {
                salary = ((Employee) st).calculateSalary();
            }
            System.out.printf("%19s%10s%5s%5.0f%3s", "* Lương của nhân viên ", st.getName()," là: ", salary,"vnd");
            System.out.println();
        }
        System.out.println();
        questionContinue();
    }

    //Hỏi bạn có muốn tiếp tục không?
    public static void questionContinue() {
        System.out.println("Bạn có muốn dùng các chức năng khác (1) Có - (2) Không ?");

        int selection = new Scanner(System.in).nextInt();
        if (selection == 1) {
            menu();
        } else if (selection == 2){
            System.err.println("Kết thúc chương trình. Tạm biệt!");
            System.exit(0);
        } else {
            System.out.println("Tôi không hiểu ý bạn, bạn chọn 1 hay 2 vậy. Mời bạn chọn lại.");
            questionContinue();
        }
    }


    //Hàm nhập các thông tin chung của Staff-thuộc tính chung
    private static void enterStaff(Staff st) {
        System.out.println("Mã nhân viên :");
        int id = new Scanner(System.in).nextInt();
        st.setId(id);

        System.out.println("tên nhân viên :");
        String name = new Scanner(System.in).nextLine();
        st.setName(name);

        System.out.println("Tuổi nhân viên :");
        int age = new Scanner(System.in).nextInt();
        st.setAge(age);

        System.out.println("Hệ số lương :");
        double coefficients = new Scanner(System.in).nextDouble();
        st.setCoefficients(coefficients);

        System.out.println("Ngày vào làm:");
        String startingDate = new Scanner(System.in).nextLine();
        st.setStartingDate(startingDate);

        System.out.println("Bộ phận làm việc:");
        String department = new Scanner(System.in).nextLine();
        st.setDepartment(department);

        System.out.println("Số ngày nghỉ phép: ");
        int annualLeave = new Scanner(System.in).nextInt();
        st.setAnnualLeave(annualLeave);
}

    //Chọn chức danh cho quản lý-thuộc tính riêng của Manager
    private static void selectTitle(Manager manager) {
        System.out.println("Chức danh của quản lý là (bấm số tương ứng :");
        System.out.println("1.Business Leader");
        System.out.println("2.Project Leader");
        System.out.println("3.Technical Leader");

        int numSelect = new Scanner(System.in).nextInt();
        String title;
        switch (numSelect) {
            case 1:
                title = "Business Leader";
                manager.setTitle(title);
                break;
            case 2:
                title = "Project Leader";
                manager.setTitle(title);
                break;
            case 3:
                title = "Technical Leader";
                manager.setTitle(title);
                break;
            default:
                System.err.println("Wrong format, please re-enter");
                selectTitle(manager);
        }
    }
    //    Tăng số lượng nhân viên khi thêm nhân viên mới (Employee)
    // nếu nhân viên mới vào có bộ phận trùng vs bộ phận nào đó thì
    // ta lấy bộ phận đó(theo thứ tự (get(0, 1, 2....) set số nhân viên = (get số nhân viên + 1)

    public static void increaseNumberOfPeopleEmployee(Employee em) {
        if (em.getDepartment().equals("Bộ phận Kế Toán")) {
            departments.get(0).setNumberOfPeople(departments.get(0).getNumberOfPeople() + 1);
        } else if (em.getDepartment().equals("Bộ phận Mua Hàng")) {
            departments.get(1).setNumberOfPeople(departments.get(1).getNumberOfPeople() + 1);
        } else if (em.getDepartment().equals("Bộ phận Sản Xuất")) {
            departments.get(2).setNumberOfPeople(departments.get(2).getNumberOfPeople() + 1);
        } else {
            departments.get(3).setNumberOfPeople(departments.get(3).getNumberOfPeople() + 1);
        }
    }

    //    Tăng số lượng nhân viên khi thêm nhân viên mới (Manager)
    // nếu nhân viên mới vào có bộ phận trùng vs bộ phận nào đó thì
    // ta lấy bộ phận đó(theo thứ tự (get(0, 1, 2....) set số nhân viên = (get số nhân viên + 1)

    public static void increaseNumberOfPeopleManager(Manager manager) {
        if (manager.getDepartment().equals("Bộ phận Kế Toán")) {
            departments.get(0).setNumberOfPeople(departments.get(0).getNumberOfPeople() + 1);
        } else if (manager.getDepartment().equals("Bộ phận Mua Hàng")) {
            departments.get(1).setNumberOfPeople(departments.get(1).getNumberOfPeople() + 1);
        } else if (manager.getDepartment().equals("Bộ phận Sản Xuất")) {
            departments.get(2).setNumberOfPeople(departments.get(2).getNumberOfPeople() + 1);
        } else {
            departments.get(3).setNumberOfPeople(departments.get(3).getNumberOfPeople() + 1);
        }
    }

    //4. Thêm nhân viên
    private static void addStaff() {

        System.out.println("Bạn muốn thêm nhân viên. (1)Employee, (2) Manager");

        int numSelect = new Scanner(System.in).nextInt();

        switch (numSelect) {
            case 1:
                Employee em = new Employee();
                enterStaff(em); //hàm nhập thông tin chung của các staff
                System.out.println("Số giờ tăng ca: ");
                int overtime = new Scanner(System.in).nextInt();
                em.setOverTime(overtime); //hàm nhập số giờ làm thêm
                staff.add(em);
                increaseNumberOfPeopleEmployee(em); //tăng số nhân viên của bộ phận
                break;
            case 2:
                Manager manager = new Manager();
                enterStaff(manager); //hàm nhập thông tin chung của các staff
                selectTitle(manager); // hàm nhập chức danh
                staff.add(manager);
                increaseNumberOfPeopleManager(manager); //tăng số nhân viên của bộ phận
                break;

            default:
                System.err.println("Wrong format, please re-enter");
                addStaff();
        }
        System.out.println();
        questionContinue();
    }

    public static void find() {
        System.out.println("Mời bạn chọn cách thức tìm kiếm");
        System.out.println("Bấm phím 1 nếu tìm kiếm theo ID");
        System.out.println("Bấm phím 2 nếu tìm kiếm theo tên");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num == 1){
            searchStaffWithId();
        } else if( num == 2){
            searchStaffWithName();
        } else {
            System.out.println("Bạn bấm sai rồi, mời bạn làm lại: ");
            find();
        }
    }

    //5.2 Tìm kiếm bằng tên nhân vien
    private static void searchStaffWithName() {
        System.out.print("Mời bạn nhập tên nhân viên :");

        String findName = new Scanner(System.in).nextLine();
        int count = 0;
        for (Staff i : staff) {
            if(i.getName().equals(findName)){
                System.out.println("THÔNG TIN NHÂN VIÊN BẠN CẦN TÌM: ");
                headerTable();
                System.out.println();
                i.displayInformation();
                count++;
            }
        }
        if (count == 0){
            System.out.println("Không tìm thấy tên nhân viên. Bạn có muốn THỬ LẠI không ?. Bấm 1 (Có), 2 (Không)");
            int x = new Scanner(System.in).nextInt();
            if (x == 1){
                searchStaffWithName();
            }
            System.out.println("Kết thúc chương trình tìm kiếm");
        }
        questionContinue();
    }

    //5.1 Tìm kiếm bằng mã nhân viên
    private static void searchStaffWithId() {
        System.out.print("Mời bạn nhập mã nhân viên :");
        int findID = new Scanner(System.in).nextInt();
        int count = 0;
        for (Staff i : staff) {
            if(findID == i.getId()){
                System.out.println("THÔNG TIN NHÂN VIÊN BẠN CẦN TÌM: ");
                headerTable();
                System.out.println();
                i.displayInformation();
                count++;
            }
        }
        if (count == 0){
            System.out.println("Không tìm thấy mã nhân viên. Bạn có muốn THỬ LẠI không ?. Bấm 1 (Có), 2 (Không)");
            int x = new Scanner(System.in).nextInt();
            if (x == 1){
                searchStaffWithId();
            }
            System.out.println("Kết thúc chương trình tìm kiếm");
        }
        questionContinue();
    }



    //3. Hiển thị các nhân viên theo từng bộ phận
    private static void displayStaffEachDepartment() {
        headerTable();
        System.out.println();
        for (Department department: departments) {
            for (Staff st : staff) {
                if (st.getDepartment().equals(department.getNameDepartment()))
                    st.displayInformation();
                }
            }
            questionContinue();
        }

    //2. Hiển thị các bộ phận trong công ty
    private static void displayDepartmentInfo() {
        System.out.printf("%5s%21s%20s" ,"ID department" , "Name department", "Number of people");
        System.out.println();
        for (Department dpm : departments) {
            System.out.println(dpm);
        }
        questionContinue();
    }

    //1. Hiển thị danh sách nhân viên hiện có trong công ty
    private static void displayStaffInfo() {
        headerTable();
        System.out.println();
        for (Staff st: staff) {
            st.displayInformation();
        }
        questionContinue();
    }

    //Hiển thị tiêu đề của bảng
    public static void headerTable() {
        System.out.printf("%5s", "ID"); //d
        System.out.printf("%20s", "Name"); //s
        System.out.printf("%5s", "Age"); //d
        System.out.printf("%15s", "Coefficients"); //f
        System.out.printf("%15s", "Starting date"); //s
        System.out.printf("%18s", "Department"); //s
        System.out.printf("%15s", "Annual leave"); //d
        System.out.printf("%12s", "Staff type"); //s
        System.out.printf("%20s", "Title"); //s
        System.out.printf("%15s", "Over time(h)");//d
    }


    public static void main(String[] args) {
        myCompany();
        menu();

    }
}
