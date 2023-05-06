package personalproject.java.ATMProject;
import java.util.ArrayList;

public class Account {
    private String name; //ex. Savings, Investment, etc
    private String uuid; // account id number 
    private User holder; //who holds this account, the user object that owns this acc 
    private ArrayList<Transaction> transactions; // list of transactions for/from this acc

    
    public Account(String name, User holder, Bank theBank){
        this.name = name;
        this.holder = holder;

        //get new account uuid 
        this.uuid = theBank.getNewAccountUUID(); 

        //initialize transaction list
        this.transactions = new ArrayList<Transaction>();

    }
 
    public String getUUID(){
        return this.uuid; 
    }

    public String getSummaryLine(){
        //get the acc's balance 
        double balance = this.getBalance(); 

        //format the summary line, depending on whether the balance is negative 
        if(balance >= 0){
            return String.format("%s : $%.02f : %s", this.uuid, balance, this.name); // a float with 2 digits of precision after the decimal point 
        }
        else {
            return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }
    }

    /**
     * Get the balance of this acc by adding the amounts of the transactions
     * @return the balance 
     */
    public double getBalance(){
        double balance = 0; 
        for (Transaction t : this.transactions){
            balance += t.getAmount(); 
        }
        return balance;
    }

    /**
     * Print the transaction history of the account 
     */
    public void printTransactionsHistory(){
        System.out.printf("\n Transaction history for account %s", this.uuid);
        for (int i = this.transactions.size()-1; i >= 0; i--){
            //loop from the last transaction (recent)
            System.out.println(this.transactions.get(i).getSummaryLine());
        }
        System.out.println();
    }

    /**
     * Add a new transaction in this account
     * @param amount the amount of transaction
     * @param memo transaction memo 
     */
    public void addTransaction(double amount, String memo){
        Transaction newTransaction = new Transaction(amount, this, memo);
        this.transactions.add(newTransaction);
    }
}
