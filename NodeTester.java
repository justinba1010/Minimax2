public class NodeTester {
  public static void main(String[] args) {
    Node node = new Node();
    node.generate(9);
    node.minimax(9);
    printNode(node, 3);
  }
  public static void printNode(Node node, int a) {
    if(a <= 0) return;
    System.out.println(node);
    if(node.children.size() == 0 || a == 1) return;
    System.out.println("Has Children:");
    for(Node child : node.children) {
      printNode(child,a-1);
    }//for
  }
}
