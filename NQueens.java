//none yet
//imports
import java.awt.*;
public class NQueens
{
   public static void main(String [] args)//main method
   {
      Chessboard chessboard = new Chessboard(8);
      
      BruteForce algo = new BruteForce(chessboard);
      
      System.out.println("Puzzle solve time: " + algo.getTime() + " nanoseconds");
      
      System.out.print(chessboard.toString());
   }
}