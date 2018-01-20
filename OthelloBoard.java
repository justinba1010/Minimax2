import java.util.*;
//OTHELLO
public class Board implements BaseBoard {
  private static final int BOARD_SIZE = 6;

  public int[][] gameBoard;
  private boolean gameOver;

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
    //TODO check if move is legal

    return false;
  }//isLegalMove

  public boolean makeMove(Move move) {
    //TODO make a move on the board, no worries about checking player, check if legal move
    return false;
  }//makeMove

  public ArrayList<Move> generateLegalMoves(boolean turn) {
    //Generate moves
    return new ArrayList<Move>();
  }//generateLegalMoves


}//Board
