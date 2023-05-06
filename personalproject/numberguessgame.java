package personalproject;

import java.util.Scanner;

/*create a number guess game, where the program 
 * generates a random number, and the user inputs
 * answers. if too high or too low, the program will 
 * reply. 
 * users have 3 tries
 */
public class numberguessgame {
    
    public static int randomNumberGenerator(){
        int random = (int) Math.random()*3;
        return random + 1; 
    }

    public static void main(String[] args){
        int answer;
        int guesses = 3; 
        int randomNumber; 
        Scanner scan = new Scanner(System.in);

        while (guesses != 0){
            randomNumber = randomNumberGenerator();
            System.out.println("Guess the random number! - ");
            answer = scan.nextInt();

            if (answer > randomNumber){
                System.out.println("try lower! - ");
            }
            else if (answer < randomNumber){
                System.out.println("try higher! - ");
            }
            else if (answer == randomNumber){
                System.out.println("that is correct! game over!");
                break;
            }
            guesses--; 
        }        
    }
}
