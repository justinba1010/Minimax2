public class BoardTester {
  public static void main(String[] args) {
    Node node = new Node();
    System.out.println(node);
    node = node.makeMove(new Move(2,2,true));
    System.out.println(node);
    node = node.makeMove(new Move(2,1,false));
    System.out.println(node);
    node = node.makeMove(new Move(2,0,true));
    node.generate(9);
    node.minimax(9);
    System.out.println(node);
    node = node.makeMove(new Move(1,1,false));
    System.out.println(node);
    node = node.makeMove(new Move(1,0,true));
    node.generate(9);
    node.minimax(9);
    System.out.println(node);
    node = node.makeMove(new Move(0,1,false));
    node.generate(9);
    node.minimax(9);
    System.out.println(node);

  }
}
/*
Node node = new Node();
System.out.println(node);
node = node.makeMove(new Move(2,2,true));
System.out.println(node);
node = node.makeMove(new Move(2,1,false));
System.out.println(node);
node = node.makeMove(new Move(2,0,true));
node.generate(9);
node.minimax(9);
System.out.println(node);
node = node.makeMove(new Move(1,1,false));
System.out.println(node);
node = node.makeMove(new Move(1,0,true));
node.generate(9);
node.minimax(9);
System.out.println(node);
*/
