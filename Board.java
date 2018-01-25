import java.util.*;
//TicTacToe

public class Board extends BaseBoard {
  int[][] gameboard;

  public Board() {
    gameboard = new int[][] {{0,0,0},{0,0,0},{0,0,0}};
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

  public boolean isLegalMove(Move move) {
    if(move == null) return false;
    return gameboard[move.x][move.y] == 0;
  }//isLegalMove

  public void makeMove(Move move) {
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

  public String toString() {
    String s = "";
    for(int[] row : gameboard) {
      for(int spot = 0; spot < row.length; spot++) {
        s += ((row[spot] == 0) ? " " : (row[spot] == 1) ? "X" : "O");
        s += (spot == 2) ? "" : "|";
      }
      s += "\n";
    }
    return s;
  }//toString

  public boolean isGameOver() {
    return (generateLegalMoves(true).size() == 0 || score() != 0);
  }

  public Board deepCopy() {
    Board aboard = new Board();
    for(int row = 0; row < 3; row++) {
      for(int col = 0; col < 3; col++) {
        aboard.gameboard[row][col] = gameboard[row][col];
      }
    }
    return aboard;
  }
}//TicTacToeBoard
