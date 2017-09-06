
package savingsaccount;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public class SavingsAccount {
    
    private static double annualInterestRate;
    
    private double savingsBalance;

    public SavingsAccount(double savingsBalance) {
        if (savingsBalance >= 0.0) {
            this.savingsBalance = savingsBalance;
        }
    }
    /**
     * @return the annualInterestRate
     */
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * @param newAnnualInterestRate the annualInterestRate to set
     */
    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        if (newAnnualInterestRate >= 0.0 && newAnnualInterestRate <= 1.0) {
            annualInterestRate = newAnnualInterestRate;
        }
    }

    /**
     * @return the savingsBalance
     */
    public double getSavingsBalance() {
        return savingsBalance;
    }

    /**
     * @param savingsBalance the savingsBalance to set
     */
    public void setSavingsBalance(double savingsBalance) {
        if (savingsBalance >= 0.0) {
            this.savingsBalance = savingsBalance;
        }
    }
    
    /**
     * Calculates interest for one month (annual rate / 12) and adds to
     * savingsBalance
     */
    public void calculateMonthlyInterest() {
        savingsBalance = savingsBalance * (1 + annualInterestRate / 12);
    }
    
    public static void main(String[] args) {
        // Set up savers
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);
        
        // Set interest rate to 4%
        SavingsAccount.setAnnualInterestRate(0.04);
        
        // Print headers
        System.out.println("Savings Account Balances");
        System.out.println("Month    Saver1     Saver2");
        
        // For months 1 - 12:
        // - calculate interest for saver1 and saver2
        // - print: month, saver1 balance, saver2 balance
        for (int i = 1; i <= 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.printf("%-4d %10.2f %10.2f%n", i, 
                    saver1.getSavingsBalance(),
                    saver2.getSavingsBalance());
        }
        
        // Increase interest rate to 5%
        SavingsAccount.setAnnualInterestRate(0.05);
        
        // Calculate interest for month 13 and print output
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("%-4d %10.2f %10.2f%n", 13, 
                    saver1.getSavingsBalance(),
                    saver2.getSavingsBalance());
    }
}
