/**
 * board class responsible for storing properties of the board
 * including size, pieces on the board, and the board itself.
 */
public class board {
    private int boardSize;      //size of board
    char[][] gameBoard;         //2d array of board
    
    /**
     * Board constructor
     * @param playerCount number of players
     */
    public board(int playerCount) {
        //initialize variables
        boardSize = playerCount + 1;

        
        //initialize board w/ empty spaces
        gameBoard = new char[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                gameBoard[row][col] = ' ';
            }
        }

        printBoard();
    }

    /**
     * Make a move on the board
     * @param row
     * @param col
     * @param sym user piece
     * @return true if move was successful
     */
    public boolean move(int row, int col, char sym) {
        //check if move is valid
        if (!gameLogic.checkMove(row, col, gameBoard, boardSize)) {
            printBoard(); 
            System.out.println("Invalid move.");
            return false;
        }
        //make the move
        else {
            gameBoard[row][col] = sym;
            printBoard();
            return true;
        }
    }

    /**
     * print board
     */
    public void printBoard() {
        //create row divider
        StringBuilder dividerBuilder = new StringBuilder(" ");
        for (int row = 0; row < boardSize * 2 + 1; row++)
            dividerBuilder.append("-");
        String divider = dividerBuilder.toString();

        //print column numbers
        System.out.print("\n  ");
        for (int i = 0; i < boardSize; i++)
            System.out.print(i + " ");
        System.out.println();

        //print board
        for (int row = 0; row < boardSize; row++) {
            //print row numbers
            System.out.print(row + " ");
            for (int col = 0; col < boardSize; col++) {
                System.out.print(gameBoard[row][col]);
                if (col + 1 != boardSize) {
                    System.out.print('|');
                }
            }
            System.out.println();
            if (row + 1 != boardSize) {
                System.out.println(divider);
            }
        }

        //extra spacing
        System.out.println('\n');
    }

    /**
     * @return 2d array of board
     */
    public char[][] getBoard() {
        return gameBoard;
    }

    /**
     * @return size of board
     */
    public int getBoardSize() {
        return boardSize;
    }
}