import java.util.*;
//OTHELLO
public class Board implements BaseBoard {
  private static final int BOARD_SIZE = 6;

  public int[][] gameBoard;
  private boolean gameOver;
  public int[][] VECTORS = {{1,1},{-1,-1},{1,-1},{-1,1},{1,0},{-1,0},{0,1},{0,-1}};

  public Board() {
    init();
  }

  public Board(int[][] aGameBoard) {
    gameBoard = aGameBoard;
    gameOver = false;
  }

  private void init() {
    gameBoard = new int[BOARD_SIZE][BOARD_SIZE];
    //1 = player 1, -1 = player 2
    gameboard[BOARD_SIZE/2-1][BOARD_SIZE/2-1] = 1;
    gameboard[BOARD_SIZE/2][BOARD_SIZE/2] = 1;
    gameboard[BOARD_SIZE/2-1][BOARD_SIZE/2] = -1;
    gameboard[BOARD_SIZE/2][BOARD_SIZE/2-1] = -1;

    gameOver = false;
  }//init

  public int score() {
    int score = 0;
    for(int[] row : gameBoard) {
      for(int spot : row) {
        score += spot;
      }//for spot
    }//for row
    return score;
  }//score

  public boolean isLegalMove(Move move, boolean turn) {
    if(!legalSpot(move.x,move.y)) return false; //Needs to be on board
    if(whoisat(move.x,move.y) != 0) return false; //Needs to be empty
    int originalSpot = board[move.x][move.y];
    for(int[] vector : VECTORS) {
      int x = move.x;
      int y = move.y;
      x += vector[0];
      y += vector[1];
      //TODO make subroutine to get all spots that need to be flipped
    }

    return false;
  }//isLegalMove



  public boolean legalSpot(int x, int y) {
    return x >= 0 && y >= 0 && x < board.length && y < board[x].length;
  }

  public int whoisat(int x, int y) {
    if(legalSpot(x,y)) {
      return board[x][y];
    }
    return 0;
  }

  public boolean makeMove(Move move) {
    //TODO make a move on the board, no care for whos going, check if legal move
    return false;
  }//makeMove

  public ArrayList<Move> generateLegalMoves(boolean turn) {
    //Generate moves
    return new ArrayList<Move>();
  }//generateLegalMoves


}//Board
