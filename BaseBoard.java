import java.util.*;

//Just to show the required functions
public class BaseBoard {
  public int score(){
    return 0;
  }
  public boolean isLegalMove(BaseMove move) {
    return false;
  }
  public void makeMove(BaseMove move){
  }
  public ArrayList<BaseMove> generateLegalMoves(boolean turn){
    return new ArrayList<BaseMove>();
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
