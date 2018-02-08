public class Node <T extends BaseBoard, B extends BaseMove> {
  public T<B> board;
  public int value;
  public NodeG<T,B> bestMove;
  public B lastMove;
  public ArrayList<NodeG<T, B>> children;
  public boolean turn; //True = player 1(max); False = player 2(min)

  public Node() {
    init();
  }//NodeG

  public Node(T aBoard, B aLastMove, boolean aTurn){
    init();
    board = (T)aBoard;
    lastMove = aLastMove;
    turn = aTurn;
  }

  private void init() {
    board = (T)(new BaseBoard());
    value = 0;
    children = new ArrayList<Node<T,B>>();
  }//init

  public void test() {
    for(B move : board.generateLegalMoves()) {

    }
  }

}
