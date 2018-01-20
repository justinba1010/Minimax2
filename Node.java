import java.util.*;

public class Node {
  public Board board;
  public int value;
  public Move bestMove;
  public ArrayList<Node> children;
  public boolean turn; //True = player 1(max); False = player 2(min)
  public Move lastMove;

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
    lastMove = null;
    bestMove = null;
  }

  //PUBLICS
  public void generate(int branches) {
    if(branches <= 0) return; //Halt condition

    if(children.size() != 0) { //We have children already
      for(Node child : children) {
        child.generate(branches-1);//Generate x children of each child
      }
    } else {
      for(Move move : board.generateLegalMoves(turn)) {//If there are no legal moves, the game is over.
        Node newNode = new Node(board, move, turn);
        newNode.makeLastMove(move); //This will
        newNode.generate(branches-1);
        newNode.score();
        children.add(newNode);
      }
    }//if children size
  }//generate

  private void makeLastMove(Move move) {
    board.makeMove(move);
    lastMove = move;
    nextMove();
  }//makeLastMove

  public void makeMove(Move move) {
    if(board.isLegalMove(move, move.turn)) {
      board.makeMove(move);
      nextMove();
    } else {
      System.out.println("Error Move... Need more error checking.");
    }
  }//makeMove

  public void score() {
    value = board.score();
  }

  public void minimax(int branches) {
    if(branches <= 0) return; //End of search
    if(children.size() == 0) return; //End of tree
    for(Node child : children) {
      child.minimax(branches-1);
      if(turn) {//Maximize for player 1
        if(child.value >= value) {
          value = child.value;
          bestMove = child.lastMove;
        }//if child value is greater
      } else {
        if(child.value <= value) {
          value = child.value;
          bestMove = child.lastMove;
        }//if child value is lesser
      }//whos turn
    }//for child
  }//minimax

  public void nextMove() {//Go to the next move
    turn = !turn;
  }

  //PRIVATES
}//node
