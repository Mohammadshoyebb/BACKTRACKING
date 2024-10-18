public class N_Queen_All_Rows {
  
    public static void main(String[] args) {
        // Create a 2x2 chess board
        char board[][] = new char[2][2];
        
        // Initialize the chess board with 'x' to represent empty squares
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                board[i][j] = 'x'; // Setting each position to 'x'
            }
        }
        
        // Start the process of placing queens, beginning with the first row (row 0)
        assigningQueen(board, 0);
        
    }

    // Recursive method to place queens on the chess board
    // arr is the current state of the chess board
    // row is the current row we are attempting to place a queen on
    public static void assigningQueen(char arr[][], int row) {
        // Base case: If we have processed all rows, print the board configuration
        if(row == 2) {
            printQueen(arr); // Print the board when all rows are processed

           

            return; // Return to backtrack
        }
        
        // Try placing a queen in each column of the current row
        for(int j = 0; j < arr.length; j++) {
            // Place a queen at position (row, j)
            arr[row][j] = 'Q';
            
            // Recursively attempt to place queens in the next row
            assigningQueen(arr, row + 1);
            
            // Backtracking step: Remove the queen and try the next position
            arr[row][j] = 'x'; // Reset the position to 'x' (empty)
        }
    }

    // Method to print the current state of the chess board
    public static void printQueen(char arr[][]) {
        System.out.println("--------------------CHESS BOARD--------------------");
        
        // Iterate over the rows of the board
        for(int i = 0; i < 2; i++) {
            // Iterate over the columns of the board
            for(int j = 0; j < 2; j++) {
                // Print the character at the current position (either 'Q' or 'x')
                System.out.print(arr[i][j]);
            }
            // Move to the next line after printing each row
            System.out.println();
        }
    }
}

/*
Dry Run:

Initial board:
x x
x x

Step 1: Start placing queens from row 0.
        Place 'Q' at (0, 0):
        Q x
        x x
    - Call assigningQueen with row = 1.
        Place 'Q' at (1, 0):
        Q x
        Q x
        - Call assigningQueen with row = 2.
            Base case reached, print board:
            --------------------CHESS BOARD--------------------
            Qx
            Qx
        Backtrack: Remove 'Q' from (1, 0):
        Q x
        x x
        Place 'Q' at (1, 1):
        Q x
        x Q
        - Call assigningQueen with row = 2.
            Base case reached, print board:
            --------------------CHESS BOARD--------------------
            Qx
            xQ
        Backtrack: Remove 'Q' from (1, 1):
        Q x
        x x
    Backtrack: Remove 'Q' from (0, 0):
    x x
    x x

Step 2: Place 'Q' at (0, 1):
        x Q
        x x
    - Call assigningQueen with row = 1.
        Place 'Q' at (1, 0):
        x Q
        Q x
        - Call assigningQueen with row = 2.
            Base case reached, print board:
            --------------------CHESS BOARD--------------------
            xQ
            Qx
        Backtrack: Remove 'Q' from (1, 0):
        x Q
        x x
        Place 'Q' at (1, 1):
        x Q
        x Q
        - Call assigningQueen with row = 2.
            Base case reached, print board:
            --------------------CHESS BOARD--------------------
            xQ
            xQ
        Backtrack: Remove 'Q' from (1, 1):
        x Q
        x x
    Backtrack: Remove 'Q' from (0, 1):
    x x
    x x

All possible placements of queens have been explored and printed.
*/
