import java.util.*;
import java.io.*;
import java.awt.*;
//imports

public class Chessboard
{
   ArrayList<Point> chessboard;//the chessboard
   ArrayList<Point> queenLocations;//the list of queen positions
   
   public Chessboard()//default constructor. Should never be used but figured it should have one
   {
      chessboard = new ArrayList<Point>();//initialize chessboard
      queenLocations = new ArrayList<Point>();//initialize list of queen locations
      
      for(int i = 1; i <= 4; i++)//i is the row value. 4 is the lowest number n can be(from the assignment guide), so that is why its the default
      {
         for(int j = 1; j <= 4; j++)//j is the column value
         {
            chessboard.add(new Point(i, j));//add a point at the current position in the arraylist
         }
      }
   }//once the constructor is done, you will have an empty default 4 by 4 chessboard
   
   public Chessboard(int n)//constructor that will take the n value from the user to make an n by n board
   {
      if(n >=4)//make sure it is a valid n (based on what the assignment decided the lowest number could be)
      {
         chessboard = new ArrayList<Point>();//initialize the chessboard
         queenLocations = new ArrayList<Point>();//initialize the list of queen locations
         
         for(int i = 1; i <= n; i++)//i is the row value. n is the value from the user on how big the board will be and how many queens there will be
         {
            for(int j = 1; j <= n; j++)//j is the column value
            {
               chessboard.add(new Point(i, j));//add a point at the current position
            }
         }
      }
      else
      {
         System.out.println("The n value for the chessboard must be at least 4 or more.");//if the chessboard isnt valid, tell the user
      }
   }//once the constructor is done you will have an empty chessboard, size n by n
   
   public void addQueen(int x, int y)//take the position for the queen
   {
      queenLocations.add(new Point(x, y));//add the position into the list of queen locations
   }
   
   public boolean checkBoard()//this method will check the board and see if it is a valid solution
   {
      boolean solved = true;//assume it is solved, this will change if a conflict is found
      
      for(int i = 0; i <= queenLocations.size() - 1; i++)//iterate through the whole list of queens
      {
         Point queenI = new Point((int)queenLocations.get(i).getX(), (int)queenLocations.get(i).getY());//store the queen to be checked from the first list
         for(int j = 0; j <= queenLocations.size() - 1; j++)//iterate through the list of queens for each queen, aka check them all against each other
         {
            Point queenJ = new Point((int)queenLocations.get(j).getX(), (int)queenLocations.get(j).getY());//store the queen to be checked from the second list
            
            if(!(   (queenI.getX() != queenJ.getX()) &&
                  (queenI.getY() != queenJ.getY()) &&
                  (  (queenI.getX() - queenJ.getY()) != (queenJ.getX() - queenI.getY())) &&
                  (  (queenI.getX() - queenI.getY()) != (queenJ.getX() - queenJ.getY()))
               ))//math to check whether the 2 queens are in the same row/column/diagonal, if they are in the same one, then the if is true
            {
               solved = false;//set solved to false so we know we can stop
               break;//break the loop
            }
         }
         if(solved == false)//if we know its not solved
         {
            break;//break the loop
         }
      }
      return solved;//return whether its solved or not
   }
   
   public String toString()//tostring method for printing the board
   {
      int n = (int)Math.sqrt(chessboard.size());//int n because its the n-queens problem, the board is n by n squares
      //get n by square rooting the size of the chessboard(wont need a double because itll always be squareable)
      
      String chessboardString = "";
      //initialize empty string to be printed later
      
      for(int i = 1; i <= n; i++)//i is effectively the row value. n is the number of rows/columns as stated before
      {
         for(int j = 1; j <= n; j++)//j is the column value
         {
            Point current = new Point(i, j);//make a point of the current position to be used in comparison
            boolean queenPresent = false;//if queen is found in the current position, set to true
            
            for(int k = 0; k <= queenLocations.size() - 1; k++)//k is the index in the queenLocations arraylist, iterate through this looking for queens
            {
               if (current.equals(queenLocations.get(k)))//if the point at the current position is equal to the point at the current index of the queens
               {
                  chessboardString = chessboardString + "x ";//mark queens as an x
                  queenPresent = true;//let the program know there is a queen here
                  break;//stop iterating through the list of queens, only 1 queen can be in a square
               }//basically this will happen if any queens in the list of queens is at this current point
            }
            
            if(!queenPresent)//if there is no queen
            {
               chessboardString = chessboardString + "o ";//mark the space as empty(an o)
            }
         }
         chessboardString = chessboardString + "\n";//after each row, add a newline to separate the rows
      }
      return chessboardString;//return the representation of the board
   }
}