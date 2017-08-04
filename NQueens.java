import java.io.*;
import java.util.*;

public class NQueens
{
   public static void main(String [] args)//main method
   {
      Chessboard chessboard = new Chessboard(8);
      
      System.out.print(chessboard.toString());
   }
}