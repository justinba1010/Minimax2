import java.util.*;

public class Node {
  public Board board;
  private int value;
  private ArrayList<Node> children;
  private boolean turn; //True = player 1(max); False = player 2(min)
  private Node parent;
  private Move lastMove;

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

  private init() {
    board = new Board();
    value = 0;
    children = new ArrayList<Node>();
    turn = true;
    parent = null;
    lastMove = null;
  }

  //PUBLICS
  public void generate(int branches) {
    if(branches <= 0) return; //Halt condition

    if(children.size() != 0) { //We have children already
      for(Node child : children) {
        child.generate(branches-1);//Generate x children of each child
      }
    } else {
      for(Move move : board.generateLegalMoves()) {
        Node newNode = new Node(board, move, turn);
        newNode.makeLastMove(move); //This will
        children.add(newNode);
        if(!newNode.board.isOver)
      }
    }//if children size
  }//generate

  public void nextMove() {//Go to the next move
    turn = !turn;
  }

  //PRIVATES
}//node
