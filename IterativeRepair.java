import java.util.*;//just in case
import java.io.*;//just in case
import java.awt.*;//for the point class
//imports

public class IterativeRepair
{
   Chessboard chessboard;//a chessboard for the class
   long time;//the runtime for the algorithm
   
   public IterativeRepair(Chessboard chessboard)//constructor for the iterative repair algorithm
   {
      chessboard = this.chessboard;//give the object a chessboard
      time = 0;//set time to inital 0
      //Chessboard testboard = chessboard;
      time = iterativeSolve(chessboard);//solve the chessboard and set the time for the object to be the runtime
   }
   
   public long iterativeSolve(Chessboard chessboard)//main algorithm method to solve the chessboard
   {
      long startTime = System.nanoTime();//start the timer(kinda)
      
      Chessboard testboard = chessboard;//make a new chessboard out of the old one
      
      int count = 0;//for testing
      
      while(!testboard.checkBoard())//while the board is not solved
      {
         
         
         
         
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
