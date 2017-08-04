import java.io.*;
import java.util.*;
//imports

public class NQueens
{
   public static void main(String [] args)//main method
   {
      Chessboard chessboard = new Chessboard(8);
      
      chessboard.addQueen(1,3);
      chessboard.addQueen(2,2);
      
      System.out.print(chessboard.toString());
      
      System.out.println(chessboard.checkBoard());
   }
}