public class BoardTester {
  public static void main(String[] args) {
    Node aNode = new Node();
    Node bNode = new Node(aNode.board, null, false);
    bNode.board.makeMove(new Move(1,1,true));
    System.out.println(aNode.board);
  }
}
