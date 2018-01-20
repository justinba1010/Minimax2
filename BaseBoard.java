import java.util.*;

//Just to show the required functions
public class BaseBoard {
  public int score(){
    return 0;
  }
  public boolean isLegalMove(Move move) {
    return false;
  }
  public void makeMove(Move move){
  }
  public ArrayList<Move> generateLegalMoves(boolean turn){
    return new ArrayList<Move>();
  }
  public String toString() {
    return "";
  }
  public boolean isGameOver() {
    return false;
  }
}
