import java.util.*;

public class Tree {
  private int difficulty;
  public Node tree;
  public Tree() {
    difficulty = 9;//Magic value for now
    tree.generate(1);
  }//Tree
  public Tree(int aDifficulty) {
    difficulty = aDifficulty;
    tree.generate(1);
  }//Tree
  public Move bestMove() {
    tree.generate(difficulty);
    tree.minimax(difficulty);
    return tree.bestMove;
  }//bestMove
  public void makeMove(Move move) {
    tree = tree.makeMove(move);
  }
}
