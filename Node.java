import java.util.*;

public class Node {
  public Board board;
  public int value;
  public Node bestMove;
  public Move lastMove;
  public ArrayList<Node> children;
  public boolean turn; //True = player 1(max); False = player 2(min)
  //Initializers
  public Node() {
    init();
  }//Node

  public Node(Board aBoard, Move aLastMove, boolean aTurn){
    init();
    board = aBoard;
    lastMove = aLastMove;
    turn = aTurn;
  }

  private void init() {
    board = new Board();
    value = 0;
    children = new ArrayList<Node>();
    turn = true;
    bestMove = null;
    lastMove = null;
  }//init

  //PUBLICS
  public void generate(int branches) {
    value = board.score(); //BOARD SCORER
    if(branches <= 0) {
      return;
    }//terminator

    if(children.size() > 0) {
      for(Node child : children) {
        child.generate(branches-1);
      }//for each child
    }//if children exist
    for(Move move : board.generateLegalMoves(turn)) {
      Node child  = new Node(board.deepCopy(), move, !turn);
      child.board.makeMove(move);
      children.add(child);
      child.generate(branches-1);
    }//for
  }//generate

  public void minimax(int branches) {
    if(branches <= 0) {
      return;
    }//branches
    if(children.size() == 0) {
      return;
    }
    int ayo = (turn) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    for(Node child : children) {
      child.minimax(branches-1);
      if(turn) {
        if(child.value > ayo) {
          ayo = child.value;
          bestMove = child;
        }
      } else {
        if(child.value < ayo) {
          ayo = child.value;
          bestMove = child;
        }
      }
    }//for child
    value = ayo;
  }//minimax

  public String toString() {
    String s = "";
    return "Turn: " + turn + "\tValue: " + value;
  }
  //PRIVATES
}//node
