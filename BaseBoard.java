import java.util.*;

//Just to show the required functions
public interface BaseBoard {
  public int score();
  public boolean isLegalMove(Move move, boolean turn);
  public boolean makeMove(Move move);
  public ArrayList<BaseMove> generateLegalMoves(boolean turn);
}
