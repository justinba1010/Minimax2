import java.util.*;
//TicTacToe

public class TicTacToeBoard implements BaseBoard {
  int[][] gameboard;

  public TicTacToeBoard() {
    gameboard = {{0,0,0},{0,0,0},{0,0,0}};
  }
  public int score() {
    //ROWS && COLUMNS
    for(int x = 0; x < gameboard.length; x++) {
      //Check row
      if(gameboard[x][0] != 0 && gameboard[x][0] == gameboard[x][1] && gameboard[x][2] == gameboard[x][0]) return gameboard[x][0];
      //Check Column
      if(gameboard[0][x] != 0 && gameboard[0][x] == gameboard[1][x] && gameboard[2][x] == gameboard[0][x]) return gameboard[0][x];
    }
    //Check diagonals
    if(gameboard[0][0] != 0 && gameboard[0][0] == gameboard[1][1] && gameboard[2][2] == gameboard[0][0]) return gameboard[0][0];
    if(gameboard[2][0] != 0 && gameboard[2][0] == gameboard[1][1] && gameboard[1][1] == gameboard[0][2]) return gameboard[0][2];
    return 0;//TIE
  }//score

  public boolean isLegalMove(Move move, boolean turn) {
    return gameboard[move.x][move.y] == 0;
  }//isLegalMove

  public boolean makeMove(Move move) {
    gameboard[move.x][move.y] = (move.turn) ? 1 : -1;
  }//makeMove

  public ArrayList<Move> generateLegalMoves(boolean turn) {
    ArrayList<Move> moves = new ArrayList<Move>();
    for(int x = 0; x < 3; x++) {
      for(int y = 0; y < 3; y++) {
        Move move = new Move(x,y,turn);
        if(isLegalMove(move)) {
          moves.add(move);
        }//if legal`
      }//for y
    }//for x
    return moves;
  }//generateLegalMoves
}//TicTacToeBoard