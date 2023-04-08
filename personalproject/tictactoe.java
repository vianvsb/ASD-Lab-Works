package personalproject;
import java.util.Scanner;

public class tictactoe {
    public static void display_board(int[][] board){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == 0){
                    System.out.print("- "); 
                }
                else if (board[i][j] == 1){
                    System.out.print("X ");
                }
                else {System.out.print("Z ");}
            }
            System.out.println(); 
        }
    }

    public static boolean gameOver(int[][] board){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][0] == board[i][1] && board[i][0] != 0){
                    if(board[i][1] == board[i][2]) {//horizontal win
                        return true; 
                    }
                }
            }
        }

        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[0][j] == board[1][j] && board[0][j] != 0){
                    if (board[1][j] == board[2][j]){//vertical win 
                        return true; 
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[0][0] == board[1][1] && board [0][0] != 0){
                    if (board[1][1] == board[2][2]){//diagonal win 1 
                        return true; 
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[0][2] == board[1][1] && board[0][2] != 0){
                    if (board[1][1] == board[2][0]){
                        return true;
                    }
                }
            }
        }
        return false; 
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int[][] board = {{0 ,0, 0} , {0, 0, 0} , {0, 0, 0}};
        int row, column; 
        int turn = 1; 
        int turns = 9; 
        display_board(board);
        //gameOver(board);
            
        do{
            System.out.println("input row: "); //yg diambil int
            row = scan.nextInt(); //kalo string pake scan.nextLine(); //kalo double pake scan.nextDouble();
            System.out.println("input column: "); 
            column = scan.nextInt(); //while(board[row][column] != 0);
            if (turn == 1){ //player 1's turn 
                board[row-1][column-1] = 1; 
                turn = 2; //now its player 2's turn
                turns--; 
                display_board(board);
            }
            else {
                board[row-1][column-1] = 2;
                turn = 1; 
                turns--; 
                display_board(board);
            }     
        }while(!gameOver(board));
    }
}
