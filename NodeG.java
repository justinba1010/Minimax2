import java.util.*;


//TODO Make generics so board can be specified eventually.
public class NodeG <T extends BaseBoard, B extends BaseMove>{
  public T<B> board;
  public int value;
  public NodeG<T,B> bestMove;
  public B lastMove;
  public ArrayList<NodeG<T, B>> children;
  public boolean turn; //True = player 1(max); False = player 2(min)
  //Initializers
  public NodeG() {
    init();
  }//NodeG

  public NodeG(T aBoard, B aLastMove, boolean aTurn){
    init();
    board = (T)aBoard;
    lastMove = aLastMove;
    turn = aTurn;
  }

  private void init() {
    board = (T)(new BaseBoard());
    value = 0;
    children = new ArrayList<NodeG<T, B>>();
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

    //Stop generating when game is over, leads to glitches
    if(board.isGameOver()) return;


    if(children.size() > 0) {
      for(NodeG<T, B> child : children) {
        child.generate(branches-1);
      }//for each child
    }//if children exist


    for(Object move : board.generateLegalMoves(turn)) {
      NodeG<T,B> child  = new NodeG<T,B>((T)(board.deepCopy()), (B)move, !turn);
      child.board.makeMove((B)move);
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
    for(NodeG<T, B> child : children) {
      child.minimax(branches-1);
      if(turn) {
        if(child.value >= ayo) {
          ayo = child.value;
          bestMove = child;
        }
      } else {
        if(child.value <= ayo) {
          ayo = child.value;
          bestMove = child;
        }
      }
    }//for child
    value = ayo;
  }//minimax

  public String toString() {
    return board.toString() + "Turn: " + turn + "\tValue: " + value;
  }

  public NodeG<T, B> makeMove(B move) {
    generate(1);
    for(NodeG<T, B> child : children) {
      if(child.lastMove.equals(move)) return child;
    }
    return null;
  }//makeMove
  //PRIVATES
}//NodeG
