public class Employee {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    public int empId;
    private int empDepartment;
    private double salary;
    public static int count = 1;

    public Employee(String firstName, String middleName, String lastName, int empDepartment, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.empDepartment = empDepartment;
        this.salary = salary;
        empId = count;
        count ++;
    }

    public void setEmpDepartment(int empDepartment) {
        if(empDepartment < 6 && empDepartment > 0){
            this.empDepartment = empDepartment;
        }else {
            throw new IllegalArgumentException("The department number can not be less then 0 and more then 5");
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public static int getCount() {
        return count;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getEmplId() {
        return empId;
    }

    public int getEmplDepartment() {
        return empDepartment;
    }

    @Override
    public String toString() {
        return
                "id: " + empId +
                ", Full name: " + firstName +
                " " + middleName +
                " " + lastName +
                ", Department: " + empDepartment +
                ", Salary: " + salary;
    }
}
