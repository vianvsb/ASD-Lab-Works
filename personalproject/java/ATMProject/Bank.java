package personalproject.java.ATMProject;
import java.util.ArrayList;
import java.util.Random;


public class Bank {
    private String name; 
    private ArrayList<User> users;
    /*every item in this array (user) already have "account" info in it
     * but its a good idea to have another parallel array that keeps track of each other
     * in this case, every item in the Account array also has the user information
     * so for ex. there's a sus activity in that particular acc, the bank can contact the user. 
     */     
    private ArrayList<Account> accounts;
    // we want the bank to have the data for how many users how many accounts, and which account belongs to who 

    public Bank(String name){
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    /*UUID is a random string, and we want it to generate a different one every time 
     * check whether or not the ID generated already exists or not be it in the 
     * user's or account 
     */
    public String getNewUserUUID(){
        String uuid; 
        Random rng = new Random();
        int idLength = 6; 
        boolean nonUnique;
        
        do {
            uuid = ""; 
            for (int i = 0; i < idLength; i++){
                uuid += ((Integer)rng.nextInt(10)).toString(); 
            } 

            nonUnique = false;
            for (User a : this.users){
                if (uuid.compareTo(a.getUUID()) == 0){
                    nonUnique = true; 
                    break; 
                }
            }
        } while (nonUnique == true);
        return uuid; 
    }

    public String getNewAccountUUID(){
        String uuid; 
        Random rng = new Random();
        int idLength = 10; 
        boolean nonUnique;
        
        do {
            uuid = ""; 
            for (int i = 0; i < idLength; i++){
                uuid += ((Integer)rng.nextInt(10)).toString(); 
            } 

            nonUnique = false;
            for (Account a : this.accounts){
                if (uuid.compareTo(a.getUUID()) == 0){
                    nonUnique = true; 
                    break; 
                }
            }
        } while (nonUnique == true);
        return uuid; 
    }

    public void addAccount(Account a){
        this.accounts.add(a); 
    }

    public User addUser(User a){
        this.users.add(a); 
        Account u = new Account("Savings", a, this);
        a.addAccount(u);
        this.addAccount(u);
        return a; 
    }

    public User addUser(String firstName, String lastName, String pin){
        User newUser = new User(firstName, lastName, pin, this); //this here refers to the bank obj
        this.users.add(newUser);

        //create a savings acc 
        Account newAcc = new Account("SAVINGS", newUser, this);
        //add to holder and bank list
        newUser.addAccount(newAcc); //when this account created, it adds itself to the appropriate holder and bank
        this.addAccount(newAcc);

        return newUser; 
    }

    public User userLogin(String userID, String pin){
        //return valid User if the userId and pin is correct
        //if not, return null
        //search list of users 
        for (User a : this.users){
            //check if user id is correct
            if (a.getUUID().compareTo(userID) == 0 && a.validatePin(pin)){
                return a; 
            }
        }
        //if user is not found and/or invalid pin
        return null;
    }

    public String getName(){
        return this.name; 
    }
}
