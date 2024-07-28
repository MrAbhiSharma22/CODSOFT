import java.util.Scanner;

class ATM {
    private Bankacc acc;

    public ATM(Bankacc acc) {
        this.acc = acc;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amout: ");
                    double d_amt = scanner.nextDouble();
                    deposit(d_amt);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amout: ");
                    double w_amt = scanner.nextDouble();
                    withdraw(w_amt);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + acc.getBalance());
    }

    public void deposit(double amout) {
        if (amout > 0) {
            acc.deposit(amout);
            System.out.println("Successfully deposited $" + amout);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amout) {
        if (amout > 0 && acc.getBalance() >= amout) {
            acc.withdraw(amout);
            System.out.println("Successfully withdrew $" + amout);
        } else if (amout <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class Bankacc {
    private double balance;

    public Bankacc(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amout) {
        if (amout > 0) {
            balance += amout;
        }
    }

    public void withdraw(double amout) {
        if (amout > 0 && balance >= amout) {
            balance -= amout;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Bankacc acc = new Bankacc(500.0); // Initial balance of $500
        ATM atm = new ATM(acc);
        atm.showMenu();
    }
}
