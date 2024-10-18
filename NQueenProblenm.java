public class NQueenProblenm {
    public static int count = 0;
    public static void main(String[] args) {
        // Create a 4x4 chess board
        char board[][] = new char[4][4];
        
        // Initialize the chess board with 'x' to represent empty squares
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                board[i][j] = 'X'; // Setting each position to 'x'
            }
        }
        
        // Start the process of placing queens, beginning with the first row (row 0)
        assigningQueen(board, 0);

        System.out.println("Number of Ways: "+count);
    }

    // Recursive method to place queens on the chess board
    // arr is the current state of the chess board
    // row is the current row we are attempting to place a queen on
    public static void assigningQueen(char arr[][], int row) {
        // Base case: If we have processed all rows, print the board configuration
        if(row == 4) {
            printQueen(arr); // Print the board when all rows are processed

            count++;
            
            return; // Return to backtrack
        }
        
        // Try placing a queen in each column of the current row
        for(int j = 0; j < arr.length; j++) {
            if(isSafe(arr, row, j)) { // Check if it's safe to place the queen at (row, j)
                // Place a queen at position (row, j)
                arr[row][j] = 'Q';
                
                // Recursively attempt to place queens in the next row
                assigningQueen(arr, row + 1);
                
                // Backtracking step: Remove the queen and try the next position
                arr[row][j] = 'X'; // Reset the position to 'x' (empty)
            }
        }
    }

    // Method to check if it's safe to place a queen at arr[row][col]
    public static boolean isSafe(char arr[][], int row, int col) {
        // Check this column on upper side
        for(int i = row - 1; i >= 0; i--) {
            if(arr[i][col] == 'Q') {
                return false; // There is another queen in the same column
            }
        }

        // Check upper left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(arr[i][j] == 'Q') {
                return false; // There is another queen on the upper left diagonal
            }
        }

        // Check upper right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
            if(arr[i][j] == 'Q') {
                return false; // There is another queen on the upper right diagonal
            }
        }

        return true; // It's safe to place the queen
    }

    // Method to print the current state of the chess board
    public static void printQueen(char arr[][]) {
        System.out.println("--------------------CHESS BOARD--------------------");
        
        // Iterate over the rows of the board
        for(int i = 0; i < 4; i++) {
            // Iterate over the columns of the board
            for(int j = 0; j < 4; j++) {
                // Print the character at the current position (either 'Q' or 'x')
                System.out.print(arr[i][j]+" ");
            }
            // Move to the next line after printing each row
            System.out.println();
        }
    }
}

/*
Dry Run:

Initial board:
x x x x
x x x x
x x x x
x x x x

Step 1: Start placing queens from row 0.
        Place 'Q' at (0, 0) since it's safe:
        Q x x x
        x x x x
        x x x x
        x x x x
    - Call assigningQueen with row = 1.
    
Step 2: Try placing queens in row 1.
        Place 'Q' at (1, 0):
        Q x x x
        Q x x x
        x x x x
        x x x x
        - Check if it's safe: False (same column conflict), backtrack.
        Place 'Q' at (1, 1):
        Q x x x
        x Q x x
        x x x x
        x x x x
        - Check if it's safe: False (upper left diagonal conflict), backtrack.
        Place 'Q' at (1, 2):
        Q x x x
        x x Q x
        x x x x
        x x x x
        - Check if it's safe: False (upper right diagonal conflict), backtrack.
        Place 'Q' at (1, 3):
        Q x x x
        x x x Q
        x x x x
        x x x x
        - Check if it's safe: True.
    - Call assigningQueen with row = 2.

Step 3: Try placing queens in row 2.
        Place 'Q' at (2, 0):
        Q x x x
        x x x Q
        Q x x x
        x x x x
        - Check if it's safe: False (same column conflict), backtrack.
        Place 'Q' at (2, 1):
        Q x x x
        x x x Q
        x Q x x
        x x x x
        - Check if it's safe: False (upper left diagonal conflict), backtrack.
        Place 'Q' at (2, 2):
        Q x x x
        x x x Q
        x x Q x
        x x x x
        - Check if it's safe: False (upper left diagonal conflict), backtrack.
        Place 'Q' at (2, 3):
        Q x x x
        x x x Q
        x x x Q
        x x x x
        - Check if it's safe: False (same column conflict), backtrack.

Backtrack to row 1:
        Remove 'Q' from (1, 3):
        Q x x x
        x x x x
        x x x x
        x x x x

Step 4: Try placing queens in row 1 starting from column 1.
        Place 'Q' at (1, 1):
        Q x x x
        x Q x x
        x x x x
        x x x x
        - Check if it's safe: True.
    - Call assigningQueen with row = 2.

Step 5: Try placing queens in row 2.
        Place 'Q' at (2, 0):
        Q x x x
        x Q x x
        Q x x x
        x x x x
        - Check if it's safe: False (same column conflict), backtrack.
        Place 'Q' at (2, 1):
        Q x x x
        x Q x x
        x Q x x
        x x x x
        - Check if it's safe: False (same column conflict), backtrack.
        Place 'Q' at (2, 2):
        Q x x x
        x Q x x
        x x Q x
        x x x x
        - Check if it's safe: False (upper left diagonal conflict), backtrack.
        Place 'Q' at (2, 3):
        Q x x x
        x Q x x
        x x x Q
        x x x x
        - Check if it's safe: True.
    - Call assigningQueen with row = 3.

Step 6: Try placing queens in row 3.
        Place 'Q' at (3, 0):
        Q x x x
        x Q x x
        x x x Q
        Q x x x
        - Check if it's safe: False (same column conflict), backtrack.
        Place 'Q' at (3, 1):
        Q x x x
        x Q x x
        x x x Q
        x Q x x
        - Check if it's safe: False (same column conflict), backtrack.
        Place 'Q' at (3, 2):
        Q x x x
        x Q x x
        x x x Q
        x x Q x
        - Check if it's safe: False (same column conflict), backtrack.
        Place 'Q' at (3, 3):
        Q x x x
        x Q x x
        x x x Q
        x x x Q
        - Check if it's safe: False (same column conflict), backtrack.

Backtrack to row 2:
        Remove 'Q' from (2, 3):
        Q x x x
        x Q x x
        x x x x
        x x x x

Backtrack to row 1:
        Remove 'Q' from (1, 1):
        Q x x x
        x x x x
        x x x x
        x x x x

Backtrack to row 0:
        Remove 'Q' from (0, 0):
        x x x x
        x x x x
        x x x x
        x x x x

Step 7: Try placing queens in row 0 starting from column 1.
        Place 'Q' at (0, 1):
        x Q x x
        x x x x
        x x x x
        x x x x
    - Call assigningQueen with row = 1.

Step 8: Try placing queens in row 1.
        Place 'Q' at (1, 0):
        x Q x x
        Q x x x
        x x x x
        x x x x
        - Check if it's safe: True.
    - Call assigningQueen with row = 2.

Continue this process, backtracking and exploring all possibilities until all solutions are found.
*/
