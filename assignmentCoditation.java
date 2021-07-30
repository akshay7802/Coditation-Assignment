import java.util.*;
// Tie and Space complexity for below implementation : 
//      * Time: O(m*n)
//      * Space: O(m*n)
// class Cell{
//     final int LIVE=1;
//     final int DEAD=0;
//     private int cState;
//     private string cName;

//     Cell(){
//         cState=DEAD;
//         string cName="None";
//     }
//     bool isAlive(){
//         if(this.cState == DEAD){
//             return false;
//         }
//         return true;
//     }
//     string getName(){
//         return this.cName;
//     }

//     bool setcName(string cName){
//         if(cName==""){
//             return false;
//         }
//         this.cName=cName;
//         return true;
//     }

// }
class Solution{
    public static void coditationAssignment(int[][] board){
        int height = board.length;
        int width = board[0].length;
        int[][] next = new int[height][width];
        // next is a temporary 2D array
        int[][] members = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        //This are the eight neighbouring members of 2D array example : 

        //                                     (-1,-1) (-1,0) (-1,-1)
        //                                     (0,-1)  (0,0)  (0,1)
        //                                     (1,-1)  (1,0)  (1,1)

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCellsCount = 0;
                //count all its live cells

                for (int[] dir : members) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && y >= 0 && x < height && y < width && board[x][y] == 1) {
                        liveCellsCount++;
                    }
                }

                if (board[i][j] == 1) {
                    //Any live cell with two or three live neighbors lives, unchanged, to the next generation.
                    if (liveCellsCount <= 3 && liveCellsCount >= 2) {
                        next[i][j] = 1;
                    }
                } else if (board[i][j] == 0) {
                //Any dead cell with exactly three live neighbors comes to life.
                    if (liveCellsCount == 3) {
                        next[i][j] = 1;
                    }
                }
                // else if(liveCellsCount<2){
                // Any live cell with fewer than two live neighbors dies, as if by loneliness.
                // next[i][j] = 0;
                // }
                // if(liveCellsCount>3){
                // Any live cell with more than three live neighbors dies, as if by overcrowding.
                // next[i][j] = 0;
                // }

                //1. Any live cell with fewer than two live neighbors dies, as if by loneliness.
                //2. Any live cell with more than three live neighbors dies, as if by overcrowding.  

                //  For the above cases we dont need to change anything because when we initilized next array 
                //  the default values for next[i][j] is already 0 which is cell is dead.

            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = next[i][j];
                //We simply assign every value from next array to board. 
            }
        }
      
        for(int r=0; r<board.length; r++) {
            for(int c=0; c<board[r].length; c++)
                System.out.print(board[r][c] + " ");   
              System.out.println();     
        }
    }
    public static void main(String[] args) {
        int [][] board = {
            //Sample input to see if the implementation works.
            {0,1,0},    
            {0,0,1},
            {1,1,1},
            {0,0,0}
        };
        coditationAssignment(board);
    }
}