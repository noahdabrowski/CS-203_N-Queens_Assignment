//none yet
//imports
import java.awt.*;
public class NQueens
{
   public static void main(String [] args)//main method
   {
      Chessboard chessboard = new Chessboard(4);
      /*
      chessboard.queenLocations.clear();
      
      chessboard.queenLocations.add(new Point(1,3));
      chessboard.queenLocations.add(new Point(2,1));
      chessboard.queenLocations.add(new Point(3,4));
      chessboard.queenLocations.add(new Point(4,2));
      
      System.out.println(chessboard.checkBoard());
      */
      System.out.print(chessboard.toString());
   }
}