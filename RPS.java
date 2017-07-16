/* Program to simulate player vs PC rock, paper, scissors
 * @Author: Olwethu Myeza
 * @Date: 30/06/2017
 */
 
import java.util.*;

public class RPS{
   static int score;
   
   enum Guess {ROCK, PAPER, SCISSORS};

   static Guess guess;
   String name;
  
   public RPS(String name){
      this.name = name;
   }
   
   public static void main(String[] args){
   
      /* Utilities for getting player input */
      Random rand = new Random();
      Scanner in = new Scanner(System.in);
      boolean again = true;   /* Keeps check of whether the player still wants to play */
      double wins = 0;
      int total = 0; /* total matches played */
      
      while(again){
         for(int i = 0; i < 3; i++){
            int compGuess = rand.nextInt(3);
            System.out.println("Please Enter your guess: ");
            String guessInput = in.nextLine().toUpperCase(); /* take in user input as string */
            
            /* Convert input to guess */
            if(guessInput.equals("ROCK")){guess = Guess.ROCK;}
            else if(guessInput.equals("PAPER")){guess = Guess.ROCK;}
            else if(guessInput.equals("SCISSORS")){guess = Guess.ROCK;}
            else{System.out.println("Invalid Input. Bye Bye!"); System.exit(0);}
            
            /* increment/decreament the score accordingly */
            switch(guess){
               case ROCK:
                  if(compGuess == 0){score += 0;}
                  else if(compGuess == 1){score--;}
                  else if(compGuess == 2){score++;}
                  break;
                  
               case PAPER:
                  if(compGuess == 0){score++;}
                  else if(compGuess == 1){score += 0;}
                  else if(compGuess == 2){score--;}
                  
               case SCISSORS:
                  if(compGuess == 0){score--;}
                  else if(compGuess == 1){score++;}
                  else if(compGuess == 2){score += 0;}         
            }
            
            if(compGuess == 0){System.out.println("PC: Rock");}
            else if(compGuess == 1){System.out.println("PC: Paper");}
            else if(compGuess == 2){System.out.println("PC: Scissors");}
         }
        
         /* Output score and enquire about next game */
         if(score > 0 ){System.out.println("Win"); wins++;}
         else if(score == 0){System.out.println("Tie");}
         else{System.out.println("Lose");}
         total++;
      
         System.out.println("Play again? Y/N: ");
         String choice = in.nextLine(); 

         if(choice.equals("y")){again = true;}
         else if (choice.equals("n")){again = false; }
         else{System.out.println("Invalid Input. I wont even give you another chance."); System.exit(0);}
      }
      double per = (wins/total)*100; /* win percentage */
      
      System.out.println("Final win percentage: " + per );
   }
}