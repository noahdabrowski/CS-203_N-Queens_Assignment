//none yet
//imports
import java.awt.*;
public class NQueens
{
   public static void main(String [] args)//main method
   {
      Chessboard chessboard = new Chessboard(8);
      /*
      chessboard.queenLocations.clear();
      
      chessboard.queenLocations.add(new Point(1,3));
      chessboard.queenLocations.add(new Point(2,1));
      chessboard.queenLocations.add(new Point(3,4));
      chessboard.queenLocations.add(new Point(4,2));
      
      System.out.println(chessboard.checkBoard());
      */
      
      BruteForce algo = new BruteForce(chessboard);
      System.out.println("Puzzle solve time: " + algo.getTime());
   
      System.out.print(chessboard.toString());
   }
}