import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeBook {
    public int empCount;
    private final Employee[] employees;
    public String firstName;
    public String middleName;
    public String lastName;
    public int empDepartment;
    public double empSalary;
    public Employee employee;
    public double minSalary;
    public double maxSalary;
    public int countQtyOfEmpFromDep = 0;
    public ArrayList<Double> array = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public EmployeeBook(int empArraySize) {
        employees = new Employee[empArraySize];
    }

    public String readFirstName() {
        System.out.println("Enter the first name of employee:");
        firstName = scanner.next();
        return firstName;
    }

    public String readMiddleName() {
        System.out.println("Enter the middle name of employee:");
        middleName = scanner.next();
        return middleName;
    }

    public String readLastName() {
        System.out.println("Enter the last name of employee:");
        lastName = scanner.next();
        return lastName;
    }

    public void fillOutEmployeeInfo() {

        int answer;
        System.out.println("Do you want to add new employee? \nType - 1 if 'yes' OR - 0 if 'no'");
        answer = scanner.nextInt();
        empCount = 1;
        do {
            System.out.println(empCount + " employee");
            firstName = readFirstName();
            middleName = readMiddleName();
            lastName = readLastName();
            System.out.println("Enter the department number:");
            int empDepartmentScan = scanner.nextInt();
            if (empDepartmentScan >= 6 || empDepartmentScan <= 0) {
                do {
                    System.out.println("Department number must be from 1 to 5");
                    System.out.println("Enter the department number: ");
                    empDepartmentScan = scanner.nextInt();
                } while (empDepartmentScan >= 6 || empDepartmentScan <= 0);
            } else
                empDepartment = empDepartmentScan;
            System.out.println("Enter the employee salary:");
            double empSalaryScan = scanner.nextDouble();
            if (empSalaryScan <= 0) {
                do {
                    System.out.println("Salary must be more then 0");
                    System.out.println("Enter the employee salary: ");
                    empSalaryScan = scanner.nextDouble();
                } while (empSalaryScan <= 0);
            } else
                empSalary = empSalaryScan;
            employee = new Employee(firstName, middleName, lastName, empDepartment, empSalary);
            addEmployee(employee);
            System.out.println("Employee " + employee.toString() + " was successfully added.");
            empCount++;
            System.out.println("Do you want to add new employee? \nType - 1 if 'yes' OR - 0 if 'no'");
            answer = scanner.nextInt();
        } while (answer != 0);
    }

    public int checkFreeIndexOfPosition() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void addEmployee(Employee employee) {
        int positionIndex = checkFreeIndexOfPosition();
        if (positionIndex == -1) {
            System.out.println("Array of employees is full.");
            return;
        }
        employees[positionIndex] = employee;
    }


    public void printListOfEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee("", "", "", 0, 0);
            } else
                System.out.println(employees[i].toString());
        }
    }

    public double totalSalaryExpenses() {
        double totalSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            totalSalary = totalSalary + employees[i].getSalary();
        }
        return totalSalary;
    }

    public double minSalaryOfEmployee() {
        for (int i = 0; i < employees.length - 1; i++) {
            if (employees[i + 1].getSalary() != 0) {
                minSalary = employees[i].getSalary();
                if (employees[i + 1].getSalary() < employees[i].getSalary())
                    minSalary = employees[i + 1].getSalary();
            }
        }
        return minSalary;
    }

    public double maxSalaryOfEmployee() {
        for (int i = 0; i < employees.length - 1; i++) {
            if (employees[i + 1].getSalary() != 0) {
                maxSalary = employees[i].getSalary();
                if (employees[i + 1].getSalary() > employees[i].getSalary())
                    maxSalary = employees[i + 1].getSalary();
            }
        }
        return maxSalary;
    }

    public double averageEmployeeSalary() {
        double averageSalary = 0;
        averageSalary = totalSalaryExpenses() / (empCount - 1);
        return averageSalary;
    }

    public void printEmployeeFullName() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getLastName() != "") {
                System.out.println(employees[i].getFirstName() + " " + employees[i].getMiddleName() + " " + employees[i].getLastName());
            }
        }
    }

    //difficult level
    public void increaseEmployeeSalary(double indexSalary) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].getSalary() * indexSalary);
            if (employees[i].getSalary() != 0) {
                System.out.printf("Increased salary of employee: %.2f\n", employees[i].getSalary());
            }
        }
    }

    public void minSalaryOfEmployeeByEmpDep(int empDep) {
        for (int i = 0; i < empCount; i++) {
            if (empDep == employees[i].getEmplDepartment()) {
                countQtyOfEmpFromDep++;
                array.add(employees[i].getSalary());
                Collections.sort(array);
            }
        }
        minSalary = array.get(0);
        for (int i = 0; i < empCount; i++) {
            if (employees[i].getSalary() == minSalary) {
                System.out.println("Employee: " + employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName() +
                        " has min salary: " + minSalary);
            }
        }
    }

    public void maxSalaryOfEmployeeByEmpDep(int empDep) {
        for (int i = 0; i < empCount; i++) {
            if (empDep == employees[i].getEmplDepartment()) {
                array.add(employees[i].getSalary());
                Collections.sort(array);
            }
        }
        maxSalary = array.get(array.size() - 1);
        for (int i = 0; i < empCount; i++) {
            if (employees[i].getSalary() == maxSalary) {
                System.out.println("Employee: " + employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName() +
                        " has max salary: " + maxSalary);
            }
        }
    }

    public double totalSalaryOfEmployeeByEmpDep(int empDep) {
        double totalSalaryOfDep = 0;
        for (int i = 0; i < employees.length; i++) {
            if (empDep == employees[i].getEmplDepartment()) {
                array.add(employees[i].getSalary());
                totalSalaryOfDep = totalSalaryOfDep + array.get(i);
            }
        }
        return totalSalaryOfDep;
    }

    public double averageEmployeeSalaryByDep(int empDep) {
        double averageSalaryOfDep = 0;
        averageSalaryOfDep = totalSalaryOfEmployeeByEmpDep(empDep) / countQtyOfEmpFromDep;
        return averageSalaryOfDep;
    }

    public void printListOfEmployeesFromDep(int empDep) {
        ArrayList<String> employeesFromDep = new ArrayList<>();
        for (int i = 0; i < empCount; i++) {
            if (empDep == employees[i].getEmplDepartment()) {
                employeesFromDep.add(employees[i].getFirstName() + " "
                        + employees[i].getMiddleName() + " "
                        + employees[i].getLastName() + ", salary:  "
                        + Math.round(employees[i].getSalary() * 100) / 100);
            }
        }
        for (int j = 0; j < employeesFromDep.size(); j++) {
            System.out.println(employeesFromDep.get(j));
        }
    }

    public void deleteEmployeeById(int empId) {
        for (int i = 0; i < empCount; i++) {
            if (empId == employees[i].getEmplId()) {
                employees[i] = null;
            }
        }
    }

    public int selectChoice() {
        int choice;
        System.out.println("Please, select the option:\n" +
                "1 - change employee department N\n" +
                "2 - change employee salary\n" +
                "0 - exit");
        choice = scanner.nextInt();
        return choice;
    }

    public void changeEmpSalaryDepByFullName() {
        int choice = selectChoice();
        String firstNameScan = "";
        String middleNameScan = "";
        String lastNameScan = "";
        do {
            if (choice == 1) {
                firstNameScan = readFirstName();
                middleNameScan = readMiddleName();
                lastNameScan = readLastName();
                System.out.println("Enter the new department number:");
                int empDepartmentNew = scanner.nextInt();
                for (int i = 0; i < empCount; i++) {
                    if (firstNameScan.equals(employees[i].getFirstName()) &&
                            middleNameScan.equals(employees[i].getMiddleName()) &&
                            lastNameScan.equals(employees[i].getLastName())) {
                        employees[i].setEmpDepartment(empDepartmentNew);
                        System.out.println(employees[i].toString());
                    }
                }
            } else if (choice == 2) {
                firstNameScan = readFirstName();
                middleNameScan = readMiddleName();
                lastNameScan = readLastName();
                System.out.println("Enter the new salary of employee:");
                double empSalaryNew = scanner.nextDouble();
                for (int i = 0; i < empCount; i++) {
                    if (firstNameScan.equals(employees[i].getFirstName()) &&
                            middleNameScan.equals(employees[i].getMiddleName()) &&
                            lastNameScan.equals(employees[i].getLastName())) {
                        employees[i].setSalary(empSalaryNew);
                        System.out.println(employees[i].toString());
                    }
                }
            } else {
                return;
            }
            choice = selectChoice();
        }
        while (choice != 0);
    }

    public void printListsOfEmployeesByDepartments() {
        ArrayList<Integer> arrDepartments = new ArrayList<>();
        for (int i = 0; i < empCount - 1; i++) {
            arrDepartments.add(employees[i].getEmplDepartment());
        }
        Collections.sort(arrDepartments);
        for (int i = 0; i < arrDepartments.size(); i++) {
            for (int j = i + 1; j < arrDepartments.size(); j++) {
                if (arrDepartments.get(i) == arrDepartments.get(j) ) {
                    arrDepartments.remove(j);
                    j--;
                }
            }
        }
        for (int i = 0; i < arrDepartments.size(); i++) {
            if(arrDepartments.get(i) == 0){
                arrDepartments.remove(i);
            }
        }
        for (int i = 0; i < arrDepartments.size(); i++) {
            System.out.println(arrDepartments.get(i));
            for (int j = 0; j < empCount; j++) {
                if (arrDepartments.get(i) == employees[j].getEmplDepartment()) {
                    System.out.println(employees[j].toString());
                }
            }
        }
    }
}
