import java.util.*;

public class Tree {
  private int difficulty;
  public Node tree;
  public Tree() {
    difficulty = 10;//Magic value for now
    tree = new Node();
    tree.generate(difficulty);
    tree.minimax(difficulty);
  }//Tree
  public Tree(int aDifficulty) {
    tree = new Node();
    difficulty = aDifficulty;
    tree.generate(difficulty);
    tree.minimax(difficulty);
  }//Tree
  public Move bestMove() {
    tree.generate(difficulty);
    tree.minimax(difficulty);
    return tree.bestMove.lastMove;
  }//bestMove
  public void makeMove(Move move) {
    Node child = tree.makeMove(move);
    tree = (child == null) ? tree : child;//Make the move only if the move exists
  }

  public void makeBestMove() {
    tree = (tree.bestMove == null) ? tree : tree.bestMove;
  }
}
