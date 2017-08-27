package savingsaccount;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class SavingsAccountTest {
    public static void main(String[] args) {
        
        // Set up savers
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);
        
        // Set interest rate to 4%
        SavingsAccount.setAnnualInterestRate(0.04);
        
        // Print headers
        System.out.println("Savings Account Balances");
        System.out.println("Month     Saver1        Saver2");
        
        // For months 1 - 12:
        // - calculate interest for saver1 and saver2
        // - print: month, saver1 balance, saver2 balance
        for (int i = 1; i <= 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.printf("%-4d $%10.2f   $%10.2f%n", i, 
                    saver1.getSavingsBalance(),
                    saver2.getSavingsBalance());
        }
        
        // Increase interest rate to 5%
        SavingsAccount.setAnnualInterestRate(0.05);
        
        // Calculate interest for month 13 and print output
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("%-4d $%10.2f   $%10.2f%n", 13, 
                    saver1.getSavingsBalance(),
                    saver2.getSavingsBalance());
        
    }
}
