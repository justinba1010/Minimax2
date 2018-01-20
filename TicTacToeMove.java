import java.util.*;
//Tic Tac Toe
public class Move implements BaseMove{
  public int x;
  public int y;
  public boolean turn;

  public Move(int aX, int aY, boolean aTurn) {
    x = aX;
    y = aY;
    turn = aTurn;
  }

  public String toString() {
    return "Player " + (turn) ? "1" : "2" + "made the move at: " + x + "|" + y;
  }
}
