package personalproject.java.ATMProject;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //initialize bank 
        Bank theBank = new Bank("Kyoto Bank");
        
        //add a user 
        User aUser = new User("John", "Clark", "6374", theBank);
        theBank.addUser(aUser);

        //add a checking account 
        Account newAccount = new Account("Checking", aUser, theBank); 
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser; 
        while (true){
            //stay in login prompt until successful login 
            curUser = ATM.mainMenuPrompt(theBank, scan); 

            //stay in main menu until user quits 
            ATM.printUserMenu(curUser, scan);
        }
    }


    public static User mainMenuPrompt(Bank theBank, Scanner scanner){
        String userID; 
        String pin; 
        User authUser; 

        //prompt the user for user ID/pin combo until the correct one is reached 
        do{
            System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
            System.out.println("Enter User ID: ");
            userID = scanner.nextLine();
            System.out.println("Enter PIN: ");
            pin = scanner.nextLine();

            //try to get the user obh corresponding to the ID and pin combo 
            authUser = theBank.userLogin(userID, pin); 
            if (authUser == null){
                System.out.println("Incorrect userID/PIN combination. Please try again.");
            }
        } while(authUser == null);

        return authUser;
    }

    
    public static void printUserMenu(User theUser, Scanner scanner){
        //print a summary of the user's accounts 
        theUser.printAccountsSummary();

        int choice; 

        //user menu
        do{
            System.out.printf("Welcome %s, what would you like to do?\n", theUser.getFirstName());
            System.out.println("1. Show account transactions history");
            System.out.println("2. Withdrawal ");
            System.out.println("3. Deposit ");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.println();
            System.out.println("Enter choice: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > 5){
                System.out.println("Invalid choice, please enter 1-5");
            }
        } while (choice < 1 || choice > 5); 

        //process the choice 
        switch (choice){
            case 1: 
                ATM.showTransactionHistory(theUser, scanner); 
                break;
            case 2: 
                ATM.withdrawalFunds(theUser, scanner);
                break;
            case 3: 
                ATM.depositFunds(theUser, scanner);
                break;
            case 4: 
                ATM.transferFunds(theUser, scanner);
                break; 
            case 5: 
            scanner.nextLine();
            break;
        }

        //redisplay this menu unless the user wants to quit 
        if (choice != 5){
            ATM.printUserMenu(theUser, scanner);
        }
    }

    /**
     * Show the transation history for an account 
     * @param theUser   the logged-in User object 
     * @param scanner   the Scanner object used for user input 
     */
    public static void showTransactionHistory(User theUser, Scanner scanner){
        int theAcc; 

        do{
            System.out.printf("Enter the number (1-%d) of the account \n" + 
                    "whose transaction you want to see : ", 
                     theUser.numAccounts());
            
            theAcc = scanner.nextInt()-1; 
            if(theAcc < 0 || theAcc >= theUser.numAccounts()){
                System.out.println("Invalid account. Please try again");
            }
        }while(theAcc < 0 || theAcc >= theUser.numAccounts());

        //print trasaction history 
        theUser.printAccountTransactionsHistory(theAcc); 

    }

    /**
     * Process transferring funds from one account to another 
     * @param theUser   the logged-in User object 
     * @param scanner   the Scanner object used for user input 
     */
    public static void transferFunds(User theUser, Scanner scanner){
        int fromAcc; 
        int toAcc; 
        double amount; 
        double accountBalance; 

        do{
            System.out.printf("Enter the number (1-%d) of the account \n" +
                    "to transfer from: ", theUser.numAccounts());
            fromAcc = scanner.nextInt()-1; 
            if (fromAcc < 0 || fromAcc >= theUser.numAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        } while(fromAcc < 0 || fromAcc >= theUser.numAccounts()); 
        accountBalance = theUser.getAccBalance(fromAcc); 

        //get the account to tranfer to 
        do{
            System.out.printf("Enter the number (1-%d) of the account \n" +
                    "to transfer to: ", theUser.numAccounts());
            toAcc = scanner.nextInt()-1; 
            if (toAcc < 0 || toAcc >= theUser.numAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        } while(toAcc < 0 || toAcc >= theUser.numAccounts()); 

        do{
            //get the amount to transfer 
            System.out.printf("Enter the amount to transfer (max $%.02f) : $",
            accountBalance);
            amount = scanner.nextDouble(); 
            if (amount < 0){
                System.out.println("Amount must be greater than zero");
            } else if (amount > accountBalance){
                System.out.printf("Amount must not be greater than \n" +
                        "balance of $%.02f.", accountBalance);
            } 
        } while (amount < 0 || amount > accountBalance);

        //do the transfer
        //substract money from acc
        theUser.addAccountTransaction(fromAcc, -1*amount, String.format(
            "Transfer to account %s", theUser.getAccUUID(toAcc)));
        //adding money to acc
        theUser.addAccountTransaction(toAcc, amount, String.format(
            "Transfer to account %s", theUser.getAccUUID(fromAcc)));
    }

    /**
     * Process a fund withdraw from an account
     * @param theUser the logged in user
     * @param scanner the Scanner obj user for user input 
     */
    public static void withdrawalFunds(User theUser, Scanner scanner){
        int fromAcc; 
        double amount; 
        double accountBalance; 
        String memo; 

        //get the acc to transfer from
        do{
            System.out.printf("Enter the number (1-%d) of the account \n" +
                    "to withdraw from: ", theUser.numAccounts());
            fromAcc = scanner.nextInt()-1; 
            if (fromAcc < 0 || fromAcc >= theUser.numAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        } while(fromAcc < 0 || fromAcc >= theUser.numAccounts()); 
        accountBalance = theUser.getAccBalance(fromAcc); 

        //get the amount to transfer 
        do{
            System.out.printf("Enter the amount to withdraw (max $%.02f) : $",
            accountBalance);
            amount = scanner.nextDouble(); 
            if (amount < 0){
                System.out.println("Amount must be greater than zero");
            } else if (amount > accountBalance){
                System.out.printf("Amount must not be greater than " +
                        "balance of $%.02f.", accountBalance);
                System.out.println();
            } 
        } while (amount < 0 || amount > accountBalance);

        //gobble up rest of previous inputs
        scanner.nextLine(); 

        System.out.println("Enter a memo: ");
        memo = scanner.nextLine();

        //do the withdrawal 
        theUser.addAccountTransaction(fromAcc, -1*amount, memo); 
    }

    /**
     * Process a fund deposit to an acc
     * @param theUser the logged in user
     * @param scanner the Scanner obj used for user input 
     */
    public static void depositFunds(User theUser, Scanner scanner){
        int toAcc; 
        double amount; 
        double accountBalance; 
        String memo; 

        //get the acc to transfer from
        do{
            System.out.printf("Enter the number (1-%d) of the account \n" +
                    "to deposit in: ", theUser.numAccounts());
            toAcc = scanner.nextInt()-1; 
            if (toAcc < 0 || toAcc >= theUser.numAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        } while(toAcc < 0 || toAcc >= theUser.numAccounts()); 
        accountBalance = theUser.getAccBalance(toAcc); 

        //get the amount to transfer 
        do{
            System.out.printf("Enter the amount to transfer : $",
            accountBalance);
            amount = scanner.nextDouble(); 
            if (amount < 0){
                System.out.println("Amount must be greater than zero");
            } 
        } while (amount < 0);

        //gobble up rest of previous inputs
        scanner.nextLine(); 

        System.out.println("Enter a memo: ");
        memo = scanner.nextLine();

        //do the withdrawal 
        theUser.addAccountTransaction(toAcc, amount, memo); 
    }
}