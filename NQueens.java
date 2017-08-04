import java.io.*;
import java.util.*;
//imports

public class NQueens
{
   public static void main(String [] args)//main method
   {
      Chessboard chessboard = new Chessboard(8);
      
      System.out.print(chessboard.toString());
   }
}