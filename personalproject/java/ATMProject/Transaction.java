package personalproject.java.ATMProject;
import java.util.Date; 

public class Transaction {
    private double amount; 
    private Date timestamp; //time and date of this transaction
    private String memo; //berita bca(?)
    private Account inAccount; //the acc in which the transaction was performed

    public Transaction(double amount, Account inAccount) {
        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date(); 
        this.memo = "";
    }

    public Transaction(double amount, Account inAccount, String memo){
        //call two-arg constructor
        this(amount, inAccount); 
        
        //set memo 
        this.memo = memo;
    }

    public double getAmount(){
        return this.amount; 
    }

    public String getSummaryLine(){
        if(this.amount >= 0){
            return String.format("%s : $%.02f : %s", this.timestamp.toString(), 
            this.amount, this.memo);
        } 
        else {
            return String.format("%s : $(%.02f) : %s", this.timestamp.toString(), 
            -this.amount, this.memo);
        }
    }

    
}
