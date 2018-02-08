import java.util.*;

//Just to show the required functions
public class BaseBoard<B extends BaseMove> {
  public int score(){
    return 0;
  }
  public boolean isLegalMove(B move) {
    return false;
  }
  public void makeMove(B move){
  }
  public ArrayList<B> generateLegalMoves(boolean turn){
    return new ArrayList<B>();
  }
  public String toString() {
    return "";
  }
  public boolean isGameOver() {
    return false;
  }
  public Object deepCopy() {
    return null;
  }
}
