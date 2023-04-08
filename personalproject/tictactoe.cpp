#include <iostream> 
using namespace std;

void print(int board[][]){
    cout << board[0][0] << " " << board[0][1] << " " << board[0][2] << endl; 
    cout << board[1][0] << " " << board[1][1] << " " << board[1][2] << endl;
    cout << board[2][0] << " " << board[2][1] << " " << board[2][2] << endl;
}


void display_board(int[][] board){
    for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (board[i][j] == 0){
                cout << board[i][j] = "_"; 
            }
            else if (board[i][j] == 1){
                cout << board[i][j] = "X"
            }
            else {cout << board[i][j] = "0"}
        }
    }
}

int main(){
    int row, column; 
    int turn = 1; 
    int turns = 100; 
 int board[][] = {{0 ,0, 0} , {0, 0, 0} , {0, 0, 0}};
    display_board(board);
    // while (turns > 0){
    //     cout << "input row: ";
    //     cin >> row; 
    //     cout << "input column: "; 
    //     cin >> column;
    //     turns--; 
    //     if (turn == 1){ //player 1's turn 
    //         board[row-1][column-1] = 1; 
    //         turn = 2; //now its player 2's turn
    //         print(board[3][3])
    //     }
    //     else {
    //         board[row-1][column-1] = 2;
    //         turn = 1; 
    //     }
    
    // }
}