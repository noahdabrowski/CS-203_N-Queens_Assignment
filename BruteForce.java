import java.util.*;//just in case
import java.io.*;//just in case
import java.awt.*;//for the point class
//imports

public class BruteForce
{
   Chessboard chessboard;//needs a chessboard
   long time;//time
   
   public BruteForce(Chessboard chessboard)//constructor for the bruteforce algorithm
   {
      this.chessboard = chessboard;//give the object a chessboard
      time = 0;//set time to inital 0
      //Chessboard testboard = chessboard;
      time = bruteSolve(chessboard);//solve the chessboard and set the time for the object to be the runtime
   }
   
   public long bruteSolve(Chessboard chessboard)//main algorithm
   {
      long startTime = System.nanoTime();//start the timer(kinda)
      
      Chessboard testBoard = chessboard;//make a new chessboard out of the old one
      
      //int count = 0;//for testing/seeing how many times it runs
      
      while(!testBoard.checkBoard())//while the board is not solved
      {
         Random randomizer = new Random();//initialize the randomizer to pick the random queens
         
         int randomIndexOne = randomizer.nextInt(testBoard.queenLocations.size());//pick a random index for the first queen
         int randomIndexTwo = randomizer.nextInt(testBoard.queenLocations.size());//pick a random index for the second queen
         
         Point queenOne = testBoard.queenLocations.get(randomIndexOne);//get a point from the first index
         Point queenTwo = testBoard.queenLocations.get(randomIndexTwo);//get a point from the second index
         
         int queenColumnOne = (int)queenOne.getY();//get the first points column value
         int queenColumnTwo = (int)queenTwo.getY();//get the second points column value
         
         queenOne.setLocation(queenOne.getX(), queenColumnTwo);//swap the column for the point
         queenTwo.setLocation(queenTwo.getX(), queenColumnOne);//swap the column for the point
         
         testBoard.queenLocations.set(randomIndexOne, queenOne);//put the new point back in the board
         testBoard.queenLocations.set(randomIndexTwo, queenTwo);//put the new point back in the board
         
         //count++;//for testing
         //System.out.println("while loop has run " + count + " times!");//for testing
      }
      
      long endTime = System.nanoTime();//stop the timer(kinda)
      long totalTimeEstimate = endTime - startTime;//figure out total time
      setTime(totalTimeEstimate);//set the total time
      return totalTimeEstimate;//return the time cause why not
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
