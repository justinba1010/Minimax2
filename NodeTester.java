public class NodeTester {
  public static void main(String[] args) {
    Node node = new Node();
    node.generate(2);
    node.minimax(2);
    printNode(node);
  }
  public static void printNode(Node node) {
    System.out.println(node);
    if(node.children.size() == 0) return;
    System.out.println("Has Children:");
    for(Node child : node.children) {
      printNode(child);
    }//for
  }
}
