import java.util.*; 

/**
 * TicTacToe2 class responsible for runnign TicTacToe2 game.
 * Managers all user input including piece selection, win conditions, etc.
 */
public class TicTacToe2 {
    //user variables
    private int userCount;
    private Vector<user> users = new Vector<user>();
    private user lastUser;

    //game variables
    private int winCondition;
    private boolean gameOver;
    private boolean tie;
    private int moves;

    public static void main(String[] args) throws Exception {
        //start new game
        TicTacToe2 newGame = new TicTacToe2();
    }

    public TicTacToe2() {
        //initialize vars
        userCount = 0;
        winCondition = 0;
        gameOver = false;
        tie = false;
        moves = 0;

        //get number of users
        Scanner in = new Scanner(System.in);
        while (userCount < 3 || userCount > 10) {
            System.out.print("Please enter the number of players (3-10): ");
            userCount = in.nextInt();
        }

        //create users
        char piece;
        boolean pieceTaken;
        user newUser;
        for (int i = 0; i < userCount; i++) {
            //get user pieces
            do {
                System.out.print("Enter User " + (i+1) + " piece: ");
                piece = in.next().charAt(0);
                pieceTaken = false;
                newUser = new user(piece, i);
                //check if piece already taken (except for first piece)
                if (i != 0) {
                    //loop through users vector
                    for (int j = 0; j < users.size(); j++) {
                        //prompt user to enter new piece if piece taken
                        if (users.get(j).equals(newUser)) {
                                System.out.print("Piece already taken. ");
                                pieceTaken = true;
                                break;
                        }
                    }
                }
            } while (pieceTaken);
            users.add(newUser);
        }

        //ask for winning condition
        while (winCondition < 3 || winCondition > userCount + 1) {
            System.out.print("How many pieces in a row for a win? ");
            winCondition = in.nextInt();
            if (winCondition < 3 || winCondition > userCount + 1) {
                System.out.print("Invalid amount. ");
            }
        }
        
        //create board
        board newBoard = new board(userCount);
        int x , y;
        //run game while game is not over
        while (!gameOver) {
            //loop through all users
            for (int i = 0; i < userCount; i++) {
                //if game is not over
                if (!gameOver)
                {
                    //make user move
                    do
                    {
                        System.out.println("User " + (i+1) + "(" + users.get(i).getSym() + ")" + " - Enter row and column location of move:");
                        x = in.nextInt();
                        y = in.nextInt();
                    } while (!newBoard.move(x, y, users.get(i).getSym()));
                    
                    moves++;
                    lastUser = users.get(i);

                    //check for win/tie
                    gameOver = gameLogic.checkWin(x, y, newBoard.getBoard(), newBoard.getBoardSize(), winCondition);
                    if (moves == newBoard.getBoardSize() * newBoard.getBoardSize() && gameOver == false) {
                        gameOver = true;
                        tie = true;
                    }
                }
            }
        }

        //end game
        if (tie)
            System.out.println("Game tied!");
        else
            System.out.println("User " + (lastUser.getNum()+1) + " wins!");
        
        //close scanner
        in.close();
    }
}

