import java.io.*;
import java.util.*;
//imports

public class NQueens
{
   public static void main(String [] args)//main method
   {
      Chessboard chessboard = new Chessboard(8);
      
      chessboard.placeQueens();
      
      System.out.print(chessboard.toString());
      
      System.out.println(chessboard.checkBoard());
   }
}