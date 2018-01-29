import java.util.*;

public class TicTacToeGameAI {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    Tree tictactoe = new Tree(9);
    System.out.print("Enter 1 for X anything else to be O: ");
    boolean player = keyboard.nextInt() == 1 ? true : false;
    System.out.println(tictactoe.tree.board);
    while(!tictactoe.tree.board.isGameOver()) {
      if(tictactoe.tree.turn == player) {
        Move move = null;
        while(!tictactoe.tree.board.isLegalMove(move)) {
          System.out.print("Enter row then column separated by a space [a b] ie \"1 1\": ");
          move = new Move(keyboard.nextInt(), keyboard.nextInt(), player);
        }
        tictactoe.makeMove(move);
      } else {
        tictactoe.makeBestMove();
        System.out.println("AI is making move...");
      }
      System.out.println(tictactoe.tree.board);
    }

  }
}
