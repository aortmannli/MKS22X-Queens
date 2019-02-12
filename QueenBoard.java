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

    private boolean addQueen(int r, int c){
      if(safe(r, c)) {
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


    //bryan lai told me hes doing it using a safe checker method and about this for loop format
    public boolean safe(int r, int c){
      for(int i =0; i < board.length; i++){
        if (board[r][i] == -1) return false;
        if (board[i][c] == -1) return false;
      }

      for(int x = c, y = r; x < board[y].length - 1 && y > 0; x++, y--) {
        if(board[y][x] == -1) return false;
      }

      for(int x = c, y = r; x >= 0 && y < board.length; x--, y++) {
        if(board[y][x] == -1) return false;
      }

      for(int x = c, y = r; x < board[y].length - 1 && y < board.length - 1; x++, y++) {
        if(board[y][x] == -1) return false;
      }

      for(int x = c, y = r; x >= 0 && y >= 0; x--, y--) {
        if(board[y][x] == -1) return false;
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

   public boolean solve(){
     for(int r = 0; r < board.length; r++) {
       for(int c = 0; c < board[r].length; c++) {
         if(board[r][c] != 0) throw new IllegalStateException();
       }
     }
     return solveHelp(0);
   }

   /*
   boolean solveR(int col)
      if col is past end of board:
         return true
      for each row:
          if addQueen:
              if solveR(col+1):
                  return true
              removeQueen
      return false
   */

   public boolean solveHelp(int c){
     if (c==board.length) return true;
     for(int i = 0; i < board.length; i++) {
          if(safe(i,c)) {
            addQueen(i,c);
            if(solveHelp(c + 1)) {
              return true;
            }
            removeQueen(i,c);
          }
      }
     return false;
   }


   /**
   *@return the number of solutions found, and leaves the board filled with only 0's
   *@throws IllegalStateException when the board starts with any non-zero value
   */
   /*
   public int countSolutions(){
     int count;

     return count;
   }*/



   public int countSolutions(){
     for(int r = 0; r < board.length; r++) {
       for(int c = 0; c < board[r].length; c++) {
         if(board[r][c] != 0) throw new IllegalStateException();
       }
     }
     for(int r = 0; r < board.length; r++) {
       for(int c = 0; c < board[r].length; c++) {
         board[r][c] = 0;
       }
     }
     return cSHelp(0);
   }



   public int cSHelp(int x) {
     int c = 0;
     if(x == board.length) return 1;
     for(int i = 0; i < board.length; i++) {
      if(addQueen(i,x)) {
        c += cSHelp(x + 1);
      }
        removeQueen(i, x);
      }
     return c;
   }


}
