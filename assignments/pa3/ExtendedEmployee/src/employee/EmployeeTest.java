package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class EmployeeTest {
    public static void main(String[] args) {
        
        System.out.println("Employee information.");
        
        // Create employees
        CommissionEmployee employee1 = new CommissionEmployee("Fred", "Jones", "111-11-1111", 2000.0, .05);
        BasePlusCommissionEmployee employee2 = new BasePlusCommissionEmployee("Sue", "Smith", "222-22-2222", 3000.0, .05, 300);
        SalariedEmployee employee3 = new SalariedEmployee("Sha", "Yang", "333-33-3333", 1150.0);
        HourlyEmployee employee4 = new HourlyEmployee("Ian", "Tanning", "444-44-4444", 15.0, 50);
        HourlyEmployee employee5 = new HourlyEmployee("Angela", "Domchek", "555-55-5555", 20.0, 40);
        System.out.printf("%s%s%s%s%s", employee1, employee2, employee3, employee4, employee5);
        
        // Create Employee[] array and assign employees 1-5 to it
        Employee[] employees = new Employee[5];
        
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;
        employees[3] = employee4;
        employees[4] = employee5;
        
        System.out.printf("%nEmployee information after raises.%n");
        
        // Give all non-salaried employees a 2% raise
        // Give all salaried employees a 4% raise
        for (Employee employee : employees) {
            if (employee instanceof SalariedEmployee) {
                employee.raise(0.04);
            }
            else {
                employee.raise(0.02);
            }
            System.out.print(employee);
        }
    }
}
