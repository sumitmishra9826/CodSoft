public class Main {
    public static void main(String[] args) {
        double initialBalance = 1000.0; 
        UserAccount userAccount = new UserAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}