package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    Character[][] board;
    //{x,x,o}
    //2d array, column and rows                                     //{x,x,x}
    //first one is y(row), first is x                               //{x,o,o}
    public Board(Character[][] matrix) {
        //board is passing a character array
        this.board=matrix;
    }

    public Boolean isInFavorOfX() {
        //Check vertical
        //bc we start at 0 per usual ... so we put 3 and it will stop at 2
        //everytime this loop runs once, j runs three times
        for (int i = 0; i < 3; i++) {
            //iteratng row... while value under matches it will continue
            for (int j = 0; j < 3; j++) {
                //if value we are at is equal to current value
                //row and then column... we are checking vertically
                if (j == 2) {
                    return true;
                }
                if (this.board[j][i] == 'X' && this.board[j + 1][i] == 'X') {
                    continue;
                } else {
                    break;
                    //if the first column doesnt match
                    //not false yet bc it wont check the next columns
                }
            }
        }

        //Now we check Horizontly
        //swap i and j
        for (int i = 0; i < 3; i++) {
            //
            for (int j = 0; j < 3; j++) {
                //
                if (j == 2) {
                    return true;
                }
                //when we swtitc arrays we switch 'row'.....J+1 stays bc its the inner loop but switch it with the spot of i
                //inner loop is checking cloumn
                if (this.board[i][j] == 'X' && this.board[i][j + 1] == 'X') {
                    continue;
                } else {
                    break;
                    //
                }
            }
        }
        //chcking both the diagonals
        if ((this.board[0][0]=='X'&&this.board[1][1]=='X'&&this.board[2][2]=='X') ||
                (this.board[2][0]=='X'&&this.board[1][1]=='X'&&this.board[0][2]=='X'))
        {
            //if both are true in the or statement
            return true;
        }



        return false;
        //this is we dont get a true value at all after going thru this whole for loop^^^
    }




    public Boolean isInFavorOfO() {
        //now we repeat for O... replaces all the x's
        for (int i = 0; i < 3; i++) {
            //iteratng row... while value under matches it will continue
            for (int j = 0; j < 3; j++) {
                //if value we are at is equal to current value
                //row and then column... we are checking vertically
                if (j == 2) {
                    return true;
                }
                if (this.board[j][i] == 'O' && this.board[j + 1][i] == 'O') {
                    continue;
                } else {
                    break;

                }
            }
        }


        for (int i = 0; i < 3; i++) {
            //
            for (int j = 0; j < 3; j++) {
                //
                if (j == 2) {
                    return true;
                }

                if (this.board[i][j] == 'O' && this.board[i][j + 1] == 'O') {
                    continue;
                } else {
                    break;
                    //
                }
            }
        }
        //chcking both the diagonals.. hardwired
        if ((this.board[0][0]=='O'&&this.board[1][1]=='O'&&this.board[2][2]=='O') ||
                (this.board[2][0]=='O'&&this.board[1][1]=='O'&&this.board[0][2]=='O'))
        {

            return true;
        }



        return false;

    }

    public Boolean isTie() {
        // so now we can write an if statement in case of a tie... win and lose tie
        if((isInFavorOfO()==true && isInFavorOfX()==true)||(isInFavorOfO()==false && isInFavorOfX()==false)) {
            return true;
        } else {
            return false;
        }

    }

    public String getWinner() {
        String win = "";



        if (isInFavorOfX()==true&&isInFavorOfO()==false) {

            win+="X";
        } else if (isInFavorOfX()==false&&isInFavorOfO()==true) {

            win+= "O";
        }
        return win;

    }

}
