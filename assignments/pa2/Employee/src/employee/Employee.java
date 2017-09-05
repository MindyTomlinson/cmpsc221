package employee;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public abstract class Employee {
    
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
    
    protected String displayName() {
        return String.format("%s %s with ssn: %s",
                firstName, lastName, socialSecurityNumber);
    }
    
    @Override
    public abstract String toString();
    
    public abstract double earnings();
}
