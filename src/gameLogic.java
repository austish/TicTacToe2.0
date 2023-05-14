/**
 * gameLogic class responsible for checking valid moves and wins
 */
public class gameLogic {
    /**
     * checks if move is valid
     * @param row
     * @param col
     * @return boolean
     */
    public static boolean checkMove(int row, int col, char[][] board, int boardSize) {
        //check board dimensions
        if (row >= boardSize || row < 0 || col >= boardSize || col < 0) {
            return false;
        }
        //check if space is empty
        if (board[row][col] != ' ') {
            return false;
        }
        return true;
    }

    /**
     * checks move for win
     * @param row
     * @param col
     * @return true if winner found
     */
    public static boolean checkWin(int row, int col, char[][] board, int boardSize, int winCondition) {
        //count number of pieces in a row
        int consecutivePieces = 0;

        //check horizontal
        for (int i = 0; i < boardSize - 1; i++) {
            if (board[row][i] == board[row][i+1] && board[row][i] != ' ') {
                consecutivePieces++;
                if (consecutivePieces == winCondition - 1) {
                    return true;
                }
            }
            else {
                consecutivePieces = 0;
            }
        }

        //check vertical
        consecutivePieces = 0;     //reset count
        for (int i = 0; i < boardSize - 1; i++) {
            if (board[i][col] == board[i+1][col] && board[i][col] != ' ') {
                consecutivePieces++;
                if (consecutivePieces == winCondition - 1) {
                    return true;
                }
            }
            else {
                consecutivePieces = 0;
            }
        }

        // check left to right diagonal
        consecutivePieces = 0;
        int tempRow = row;
        int tempCol = col;
        //get as far upper left as possible
        while (tempRow > 0 && tempCol > 0) {
            tempRow--;
            tempCol--;
        }
        //check diagonal for win
        while (tempRow < boardSize - 1 && tempCol < boardSize - 1) {
            if (board[tempRow][tempCol] == board[tempRow+1][tempCol+1] && board[tempRow][tempCol] != ' ') {
                consecutivePieces++;
                if (consecutivePieces == winCondition - 1) {
                    return true;
                }
            }
            else {
                consecutivePieces = 0;
            }
            tempRow++;
            tempCol++;
        }

        //check right to left diagonal
        consecutivePieces = 0;
        tempRow = row;
        tempCol = col;
        //get as far upper right as possible
        while (tempRow > 0  && tempCol < boardSize - 1) {
            tempRow--;
            tempCol++;
        }
        //check diagonal for win
        while (tempRow < boardSize - 1 && tempCol > 0) {
            if (board[tempRow][tempCol] == board[tempRow+1][tempCol-1] && board[tempRow][tempCol] != ' ') {
                consecutivePieces++;
                if (consecutivePieces == winCondition - 1) {
                    return true;
                }
            }
            else {
                consecutivePieces = 0;
            }
            tempRow++;
            tempCol--;
        }
        return false;
    }
}
