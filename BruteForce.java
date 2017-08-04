import java.util.*;
import java.io.*;
import java.awt.*;
//imports

public class BruteForce
{
   Chessboard chessboard;//a chessboard for the class
   long time;//the runtime for the algorithm
   
   public BruteForce(Chessboard chessboard)//constructor for the bruteforce algorithm
   {
      this.chessboard = chessboard;//give the object a chessboard
      time = 0;//set time to inital 0
      Chessboard testboard = chessboard;
      time = bruteSolve(testboard);//solve the chessboard and set the time for the object to be the runtime
   }
   
   public long bruteSolve(Chessboard chessboard)//main algorithm method to solve the chessboard
   {
      long startTime = System.nanoTime();//start the timer(kinda)
      
      Chessboard testboard = chessboard;//make a new chessboard out of the old one
      
      int count = 0;//for testing
      
      boolean solved = false;//assume not solved
      
      while(!solved)//while the board is not solved
      {
         for(int i = 0; i <= testboard.queenLocations.size() - 1; i++)
         {
            Point queenOne = testboard.queenLocations.get(i);
            for(int j = 0; j <= testboard.queenLocations.size() - 1; j++)
            {
               Point queenTwo = testboard.queenLocations.get(j);
               
               testboard.swapQueens(queenOne, queenTwo);
               
               solved = testboard.checkBoard();
               
               if(solved)
               {
                  break;
               }
            }
            if(solved)
            {
               break;
            }
         }
         
         
         
         
         count++;
         System.out.println("while loop has run " + count + " times!");//for testing
      }
   
      
      
      
      long endTime = System.nanoTime();//stop the timer(kinda)
      long totalTimeEstimate = endTime - startTime;//figure out total time
      
      setTime(totalTimeEstimate);//set the total time just to be sure
      return totalTimeEstimate;//return the time
   }
   public void setTime(long time)//method to easily set the time after an algorithm run
   {
      time = this.time;//set the time
   }
   
   public long getTime()//method to easily get the time after an algorithm run
   {
      return time;//get the time
   }
}
