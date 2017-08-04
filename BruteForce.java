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
      
      boolean stuck = false;//assume not stuck
      
      int n = testboard.queenLocations.size();
      testboard.queenLocations.clear();//clear the original config? kinda conflicts with my earlier code. but dont feel like changing it all
      
      while(!solved)//while the board is not solved
      {
         if(stuck)
         {
            Random randomizer = new Random();
            Point rand1 = testboard.queenLocations.get(randomizer.nextInt(testboard.queenLocations.size()));
            Point rand2 = testboard.queenLocations.get(randomizer.nextInt(testboard.queenLocations.size()));
            
            testboard.swapQueens(rand1, rand2);
            
            if((!(testboard.checkQueen(rand1))) || (!(testboard.checkQueen(rand2))))
            {
               testboard.swapQueens(rand2, rand1);
            }
            
            System.out.println(testboard.toString());
            stuck = false;
         }
         for(int i = 1; i <= n; i++)
         {
            for(int j = 1; j <= n; j++)
            {
               Point current = new Point(i, j);
               boolean valid = testboard.checkQueen(current);
               if(valid)
               {
                  testboard.queenLocations.add(current);
                  System.out.println(testboard.toString());
               }
            }
         }
         solved = testboard.checkBoard();
         if(!solved)
         {
            stuck = true;
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
   
   public void setChessboard(Chessboard chessboard)//method to set the chessboard
   {
      chessboard = this.chessboard;//set the chessboard
   }
   
   public Chessboard getChessboard()//method to get the chessboard
   {
      return chessboard;//get the chessboard
   }
}
