import java.sql.Array;
import java.util.*;

public class Main {
    static int empDep = 2;
    static double indexSalary = 1.1;
    static Employee[] employees = new Employee[10];
    static EmployeeBook employeeBook = new EmployeeBook(employees.length);

    public static void main(String[] args) {
        int empId = 1;
        employeeBook.fillOutEmployeeInfo();
        employeeBook.printListOfEmployees();
        System.out.println("Total salary of employees is: " + employeeBook.totalSalaryExpenses());
        System.out.println("Min salary of employee is: " + employeeBook.minSalaryOfEmployee());
        System.out.println("Max salary of employee is: " + employeeBook.maxSalaryOfEmployee());
        System.out.println("Average salary of employees is: " + Math.round(employeeBook.averageEmployeeSalary()));
        employeeBook.printEmployeeFullName();


        //difficult level
        employeeBook.increaseEmployeeSalary(indexSalary);
        employeeBook.minSalaryOfEmployeeByEmpDep(empDep);
        employeeBook.maxSalaryOfEmployeeByEmpDep(empDep);
        System.out.printf("Total salary of employees of department N%d,  is: %.2f\n", empDep, employeeBook.totalSalaryOfEmployeeByEmpDep(empDep));
        System.out.printf("Average salary of employees in department N%d is: %.2f\n" , empDep, employeeBook.averageEmployeeSalaryByDep(empDep));
        employeeBook.printListOfEmployeesFromDep(empDep);

        //super difficult level
        employeeBook.deleteEmployeeById(empId);
        employeeBook.printListOfEmployees();
        employeeBook.changeEmpSalaryDepByFullName();
        employeeBook.printListsOfEmployeesByDepartments();

    }
}