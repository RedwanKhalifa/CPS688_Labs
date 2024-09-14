//Author Redwan Khalifa 501------
import java.util.Arrays;

public class NQueen {

    int[][] board;
    int N;

    public NQueen(int num) { //Use class object to initizlize variables and find solution

        board = new int[num][num];
        N = num;

        for (int[] row : board) { //Fill board with zeros row by row
            Arrays.fill(row, 0);
        }

        if (!boardCol( 0)) { //Run solution algorithum
            System.out.println("Solution can not be found"); //If no solution exists print this as well
        }
    }

    public boolean boardCol(int col) {

        if (col == N) { //If last column is reached, all queens have been placed down
            return true;
        }

        for (int i = 0; i < N; i++) { //Go through all columns

            if (emptySpot(i, col)) { //If any empty spot is found place a queen
                board[i][col] = 1; 

                if (boardCol(col + 1)) { //Run algorithm again to place next queen
                    return true;
                }

                board[i][col] = 0; //Remove misplaced queen
            }
        }

        return false; // If the queen cannot be placed in any row, return false
    }

    public boolean emptySpot(int row, int col) {
        
        for (int i = 0; i < col; i++) { //Check if a queen exists to the left of a row of a potential spot
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) { //Check if a queen exists in the upper diagonal path
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < N && j >= 0; i++, j--) { //Check if a queen exists in the lower diagonal path
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public void outputBoard() { //Output resultant solution
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the N-Queens solution
    public static void main(String[] args) {

        NQueen example = new NQueen(8);
        example.outputBoard();
    }
}