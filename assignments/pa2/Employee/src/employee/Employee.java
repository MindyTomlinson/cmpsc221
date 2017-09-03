package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class Employee {
    
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }
    
    public double earnings() {
        return 0.0;
    }
    
    @Override
    public String toString() {
        return String.format(
              "%s: %s %s with ssn: %s%n",
                "Employee", firstName, lastName, socialSecurityNumber);
    }
}
