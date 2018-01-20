import java.util.*;

public class TicTacToeGame {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    Board tictactoe = new Board();

    boolean turn = true;
    System.out.print(tictactoe);
    while(tictactoe.generateLegalMoves(turn).size() != 0 && !tictactoe.isGameOver()) {
      Move move = new Move(keyboard.nextInt(), keyboard.nextInt(), turn);
      if(tictactoe.isLegalMove(move)) {
        tictactoe.makeMove(move);
        turn = !turn;
      }
      System.out.print(tictactoe);
    }

  }
}
