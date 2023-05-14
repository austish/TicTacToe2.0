/**
 * user class responsible for managing user objects.
 * Tracks user pieces and user id number.
 */
public class user {
    private char piece;
    private int userNum;    //user id number

    public user(char p, int num) {
        piece = p;
        userNum = num;
    }

    public char getSym() {
        return piece;
    }

    public int getNum() {
        return userNum;
    }

    //overide equals() for user objects
    @Override
    public boolean equals(Object obj) {
        //return false if compared object is not a user object
        if (this.getClass() != obj.getClass() || obj == null) {
            return false;
        }

        //create user object and compare symbols
        user temp = (user) obj;
        return temp.getSym() == this.getSym();
    }
}
