import java.util.*;
//OTHELLO
public class Board {
  private class inBoard {
    public int[][] gameBoard;

    public inBoard() {
      init();
    }

    public inBoard(int[][] aGameBoard) {
      gameBoard = aGameBoard;
    }

    private void init() {
      gameBoard = new int[8][8];
      //1 = player 1, -1 = player 2
      gameboard[3][3] = 1;
      gameboard[4][4] = 1;
      gameboard[3][4] = -1;
      gameboard[4][3] = -1;
    }//init
  }//inBoard
}//Board
