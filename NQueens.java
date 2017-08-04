import java.io.*;
import java.util.*;
//imports

public class NQueens
{
   public static void main(String [] args)//main method
   {
      Chessboard chessboard = new Chessboard(8);
      
      //chessboard.placeQueens();
      
      BruteForce algo = new BruteForce(chessboard);
      
      //System.out.println("Puzzle solve time: " + algo.bruteSolve(chessboard));
      System.out.println("Puzzle solve time: " + algo.getTime());
      
      System.out.print(chessboard.toString());
   }
}