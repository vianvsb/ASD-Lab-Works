package personalproject.java.ATMProject;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String firstName; 
    private String lastName;
    private String uuid; // user's id code/ id number 
    private byte pinHash[]; // (MD5)hash of the user's pin 
    private ArrayList<Account> accounts; 

    public User(String firstName, String lastName, String pin, Bank theBank){
        this.firstName = firstName;
        this.lastName = lastName;
        //uuid is not chosen or made by the user, hence not inputed

        //store the pin's MD5 Hash, rather than the original for security 
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                this.pinHash = md.digest(pin.getBytes()); 
                /*getting the memory/bytes of the pin obj, and digesting them through the MD5 alg, 
                which will return a diffeerent array of bytes, thats then stored in pinHash array
                */
            } catch (NoSuchAlgorithmException e) {
                //this block of code is never gonna run cuz MD5 is a valid algorithm 
                //only for the "what if the algorith doesnt work"
                // TODO Auto-generated catch block
                System.err.println("error, caught NoSuchAlgorithmException");
                e.printStackTrace(); //basically to pinpoint where the error is 
                // https://www.educative.io/answers/what-is-the-printstacktrace-method-in-java 
                System.exit(1); // teriminate running code 
            }

            //get a new, unique id for the user
            this.uuid = theBank.getNewUserUUID(); 
            
            //empty list of accounts 
            this.accounts = new ArrayList<Account>();

            //print log message
            System.out.printf("New user %s, %s with ID %s, created. \n", lastName, firstName, this.uuid);
    }  

    public void addAccount (Account a){
        this.accounts.add(a); 
    }

    public String getUUID(){
        return this.uuid;
    }

    public boolean validatePin(String aPin){
          try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace(); 
            System.exit(1); 
        }
        return false;
    }

    /**
     * returns the user's first name
     */
    public String getFirstName(){
        return this.firstName; 
    }

    /**
     * Print summaries for the accounts of this user
     */
    public void printAccountsSummary(){
        System.out.printf("\n\n %s's accounts summary\n", this.firstName);
        for (int i = 0; i < this.accounts.size(); i++) {
            System.out.printf("  %d) %s \n", i+1, this.accounts.get(i).getSummaryLine()); 
        }
    }

    /**
     * Get the number of accounts of the user 
     * @return the number of accounts
     */
    public int numAccounts(){
        return this.accounts.size();
    }

    /**
     * Print the transaction history for a particular account
     * @param accIndex the index of the account to use 
     */
    public void printAccountTransactionsHistory(int accIndex){
        //only print a particular account transaction history
        this.accounts.get(accIndex).printTransactionsHistory(); 
    }

    /**
     * Get the balance of a particular account
     * @param accIndex the index of the account to use 
     * @return  the balance of the account  
     */
    public double getAccBalance(int accIndex){
        return this.accounts.get(accIndex).getBalance();
    }

    /**
     * Get the UUID of a particular account
     * @param accIndex the index of the account to use
     * @return UUID of the account
     */
    public String getAccUUID(int accIndex){
        return this.accounts.get(accIndex).getUUID();
    }

    public void addAccountTransaction(int accountIndex, double amount, String memo){
        this.accounts.get(accountIndex).addTransaction(amount, memo);
    }
}
