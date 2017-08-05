public class NQueens//main class
{
   public static void main(String [] args)//main method
   {
      Chessboard chessboard = new Chessboard();//make a placeholder chessboard
      boolean start = true;//helper bool that is set to false on arg errors
      try
      {
         if((Integer.parseInt(args[1])) >= 4)//check if n is 4 or more
         {
            chessboard = new Chessboard(Integer.parseInt(args[1]));//create chessboard to be used in the program with n coming from args
         }
         else
         {
            System.out.print("N must be greater than or equal to 4! Exiting.");//nice error message!
            start = false;//dont run the rest of the program
         }
      }
      catch(ArrayIndexOutOfBoundsException exception)//good coding practice, try catch!!
      {
         System.out.print("Args error! Exiting.");//nice error message!
         start = false;//dont run the rest of the program
      }
      
      if(args[0].equalsIgnoreCase("Brute") && start)//if they select brute force and everything is ok
      {
         BruteForce algoBrute = new BruteForce(chessboard);//make the brute force object(this also solves the puzzle in itself)
         System.out.println("Puzzle solve time: " + algoBrute.getTime() + " nanoseconds");//print out the solve time
         System.out.print(chessboard.toString());//print the board
      }
      else if(args[0].equalsIgnoreCase("Iterative") && start)//if they select iterative repair and everything is ok
      {
         IterativeRepair algoIterative = new IterativeRepair(chessboard);//make the iterative repair object(this also solves the puzzle in itself)
         System.out.println("Puzzle solve time: " + algoIterative.getTime() + " nanoseconds");//print out the solve time
         System.out.print(chessboard.toString());//print the board
      }
   }
}