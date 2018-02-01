import java.util.*;

public class Tree <T extends BaseBoard, B extends BaseMove> {
  private int difficulty;
  public Node<T, B> tree;
  public Tree() {
    difficulty = 10;//Magic value for now
    tree = new Node();
    tree.generate(difficulty);
    tree.minimax(difficulty);
  }//Tree
  public Tree(int aDifficulty) {
    tree = new Node<T, B>();
    difficulty = aDifficulty;
    tree.generate(difficulty);
    tree.minimax(difficulty);
  }//Tree
  public B bestMove() {
    tree.generate(difficulty);
    tree.minimax(difficulty);
    return (B)tree.bestMove.lastMove;
  }//bestMove
  public void makeMove(B move) {
    Node<T, B> child = tree.makeMove(move);
    tree = (child == null) ? tree : child;//Make the move only if the move exists
  }

  public void makeBestMove() {
    tree = (tree.bestMove == null) ? tree : tree.bestMove;
  }
}
