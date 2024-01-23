import java.util.Scanner;

public class ATM{
    private static class Account{
        private int balance;

        public Account(int initialBalance){
            this.balance = initialBalance; // initialize the balance with the initial balance
        }

        public void deposit(int amount){
            if(amount > 0){
                balance += amount; // add the deposit amount to the balance
                System.out.println("Current Balance: " + balance); // print the current balance
            }
            else{
                System.out.println("Invalid amount"); // print an error message if the deposit amount is not valid
            }
        }

        public void withdraw(int amount){
            if (amount > 0 && amount < balance){
                balance -= amount; // subtract the withdrawal amount from the balance
                System.out.println("Remaining Balance: " + balance); // print the remaining balance
            }
            else if(amount >= balance){
                System.out.println("Insufficient Balance"); // print an error message if the withdrawal amount is greater than or equal to the balance
            }
            else{
                System.out.println("Invalid amount"); // print an error message if the withdrawal amount is not valid
            }
        }

        public int getBalance() {
            return balance; // return the current balance
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Account account = new Account(1000); // create an account with an initial balance of 1000
        String ans = "y";
        while (ans.equalsIgnoreCase("y")){
            System.out.println("Enter 'd' to deposit or 'w' to withdraw or 'b' to checkBalance :");
            String option = scanner.next();
            if (option.equalsIgnoreCase("d")){
                System.out.println("Enter amount to deposit:");
                int amount = scanner.nextInt();
                account.deposit(amount);
            }
            else if (option.equalsIgnoreCase("w")){
                System.out.println("Enter amount to withdraw:");
                int amount = scanner.nextInt();
                account.withdraw(amount);
            }
            else if(option.equalsIgnoreCase("b")){
                System.out.println("Current Balance: " + account.getBalance()); // print the current balance
            }
            else{
                System.out.println("Invalid option"); // print an error message if the user enters an invalid option
            }
            System.out.println("Do u have any other queries....:");
            ans = scanner.next();
            if(!ans.equalsIgnoreCase("y")){
                System.out.println("Thanks for using ATM");
                break;
            }
        }
    }
}