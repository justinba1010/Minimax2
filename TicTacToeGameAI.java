import java.util.*;

public class TicTacToeGameAI {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    Node tictactoe = new Node();
    tictactoe.generate(10);
    tictactoe.minimax(10);
    for(Node child : tictactoe.children) {
      System.out.println(child.value);
    }

  }
}
