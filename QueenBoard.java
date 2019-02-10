public class QueenBoard{
    private int[][]board;

    public static void main(String[] args){

    }

    public QueenBoard(int size){
      board = new int[size][size];
      for(int r = 0; r < board.length; r++) {
      for(int c = 0; c < board[r].length; c++) {
        board[r][c] = 0;
      }
    }
    }

    public boolean addQueen(int r, int c){
      if(safe(board, r, c)) {
        board[r][c] = -1;
        return true;
      }
      return false;
    }

    private boolean removeQueen(int r, int c) {
    if (board[r][c] == -1){
      board[r][c] = 0;
      return true;
    }
    return false;
    }

    public boolean safe(int[][] board, int r, int c){
      for(int i =0; i < board.length; i++){
        if (board[r][i] == -1) return false;
        if (board[i][c] == -1) return false;
      }

      for(int x = c, y = r ; x < board[y].length - 1 && y > 0; x++, y--){
          if(board[x][y] == -1) return false;
      }

      for(int u = c, d = r; u >= 0 && d < board.length - 1; u--, d++) {
      if(board[d][u] == -1) {
        return false;
      }
    }

    for(int u = c, d = r; u < board[d].length - 1 && d < board.length - 1; u++, d++) {
      if(board[d][u] == -1) {
        return false;
      }
    }

    //Checks for the top diagonal to the left.
    for(int u = c, d = r; u >= 0 && d >= 0; u--, d--) {
      if(board[d][u] == -1) {
        return false;
      }
    }


      return true;
    }
    /**
   *@return The output string formatted as follows:
   *All numbers that represent queens are replaced with 'Q'
   *all others are displayed as underscores '_'
   *There are spaces between each symbol:
   *"""_ _ Q _
   *Q _ _ _

   *_ _ _ Q

   *_ Q _ _"""
   *(pythonic string notation for clarity,
   *excludes the character up to the *)
   */
   public String toString(){
     String out = "";
     for (int r = 0; r < board.length; r++) {
       for (int c = 0; c < board[0].length; c++) {
         if(board[r][c] == -1) out += "Q ";
         else if(!safe(board,r,c)) out += "X ";
         else out += "_ ";
       }
       out += "\n";
     }
     return out;
   }



   /**
   *@return false when the board is not solveable and leaves the board filled with zeros;
   *        true when the board is solveable, and leaves the board in a solved state
   *@throws IllegalStateException when the board starts with any non-zero value
   */
/*
   public boolean solve(){

   }*/

   /**
   *@return the number of solutions found, and leaves the board filled with only 0's
   *@throws IllegalStateException when the board starts with any non-zero value
   */
   /*
   public int countSolutions(){
     int count;

     return count;
   }*/









}
