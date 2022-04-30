//////////////////////////////////////////////////////////////////////////////
//MarkAlan Mills
// CSC 160 Computer Science I, section 680
// Apr 29, 2022
// Final Project - Dice Game: 30 or Bust!
//////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

class Final {

    public static void main(String[] args) {
    //MAIN METHOD
        String play_again = "Y";
        //Y or N value to replay game
        while (play_again.equals("Y")) {
        //Created loop to replay and reset the game
            int g = 0;
            //variable for winners score
            int score;
            //variable for either players score
            String p;
            //variable for either players username
            int p1_score = 0;
            //Player 1 score
            int p2_score = 0;
            //Player 2 score
            int round = 1;
            //Track rounds
            int coin = 0;
            //Created coin to activate game
            String winner = "";
            //Track winner 
            String p_taunt[] = new String[4];
            //Array copying the winners taunt array
            String[] voiceLine = {"Good luck! You're going to need it...", "*que Jeopardy music*", "The clock is ticking!"};
            //Array of commentator voice lines
            String[] taunt1 = {"You're going to have to do better than that next time!", "Next time I'll actually try.", "I guess I'm just better", "Your money is better off in my pockets anyway."};
            //Array of player 1 voice lines
            String[] taunt2 = {"Were you even trying?", "I could do this all night!", "Like taking candy from a baby...", "Pay up buddy."};
            //Array of player 2 voice lines
            System.out.println("\nEpic Commentator:\n     -----WELCOME TO MARKALAN'S ONLINE CASINO!-----\n");
            //Print intro

            while (coin != 1) {
            //Loop to activate game with coin
                System.out.print("*INSERT 25 CENTS TO PLAY*\n\nEnter '1' to insert coin:");
                //Print to accept coin
                Scanner input = new Scanner(System.in);
                //Scanner set in place of an actual coin
                coin = input.nextInt();
                //Give coin the user input value
                if (coin != 1) {
                //Loop to see if the right ammount was entered
                    System.out.println("-----\nInvalid amount!\n-----");
                    //Print invalid message
                }
            }
            Scanner input2 = new Scanner(System.in);
            //Scanner for usernames
            System.out.println("-----\nYour next game will be on the house (:\n-----");
            //Fun message (meaningless)
            System.out.print("-Player 1- Please enter a username:");
            String p1 = input2.nextLine();
            //Input player 1 username
            System.out.print("-Player 2- Please enter a username:");
            String p2 = input2.nextLine();
            //Input player 2 username 
            System.out.println("-----\nPleasure to meet you, "+ p1 +" and "+ p2 +"!\nYou'll soon notice that things work a little different around here...\n*que ominous laugh*\n-----");
            //Print greeting
            System.out.println("The goal of this game is to accumulate 30 gems. The First player with exactly 30 gems wins! No more, no less...\nYou will roll a pair of dice, then you must choose the score of one of the dice OR the total of the two dice. This value is added to your sack of gems. If a player holds more than 30 gems at once, they will explode and be set back to zero gems! The player turn changes after each roll of the dice. Once a player has exactly 30 gems, they can taunt their opponent and take their earnings.\nMay the odds be ever in your favor ^_^\n-----");
            //Print rules

            while (p1_score != 30 && p2_score != 30) {
            //Loop to end game when a player reaches 30 gems
                for (int i = 2; p1_score != 30 && p2_score != 30; i++) {
                //For loop to determine which players turn it is starting with player 1
                    if (i % 2 == 0) {
                        //Test if 'i' is odd or even. Even is player 1's turn and odd is player 2's turn
                        p = p1;
                        //Set p to player 1's username 
                        score = p1_score;
                        //Set score to player 1's score
                        System.out.println("Round "+ round +" - FIGHT!\n-----");
                        //Print the round
                        round++;
                        //Increment rounds
                    } else {
                    //Player 2's turn
                        p = p2;
                        //Set p to player 2's username 
                        score = p2_score;
                        //set score to player 2's score
                    }
                    System.out.print(p +", it is your turn! ");
                    //Print which players turn it is
                    int r = (int)(Math.random() * 3);
                    //Random num generator 0-2
                    System.out.println(voiceLine[r] + "\n");
                    //Use random num generator to pick a voice line
                    System.out.println("You have a whopping score of "+ score +"!\n");
                    //Print score
                    System.out.println("Your roll:");
                    //Print roll
                    int d1 = (int)(Math.random() * 6 + 1);
                    int d2 = (int)(Math.random() * 6 + 1);
                    //Random num generator for each die
                    int total = d1 + d2;
                    //Set total as the sum of both dice
                    System.out.println("Die 1: "+ d1 +"\nDie 2: "+ d2 +"\n\nYou rolled "+ total +"!\n");
                    //Print die 1, die 2, and the total of both
                    System.out.print("Do you wish to (1) Keep die 1, (2) Keep die 2, (3) Keep the total? (Respond with 1, 2 or 3):");
                    //Ask user for their next move
                    Scanner choice = new Scanner(System.in);
                    //Scanner to collect move input
                    int move = choice.nextInt();
                    //Set move equal to user input
                    if (move == 1) {
                        score += d1;
                        //If move is 1 then add die 1 to score
                    } else if (move == 2) {
                        score += d2;
                        //If move is 2 then add die 2 to score
                    } else if (move == 3) {
                        score += total;
                        //If move is 3 then add both dice to score
                    }
                    if (score < 30) {
                    //Determine if the player has less than 30 score
                        System.out.println("\nYou now have "+ score +" gems! Nice work!\n-----");
                        //Summary
                    } else if (score > 30) {
                    //Determine if the player has more than 30 score                      
                        System.out.println("\nYou have "+ score +" gems! *BOOM* You exploded and your gems have been reset to zero.\nThings aren't looking too good your you...\n-----");  
                        //Summary
                        score = 0;
                        //Reset score
                    }
                    if (i % 2 == 0) {
                    //If i % 2 == 0 then its player 1's turn
                        p1_score = score;
                            //Set player 1's score to 'score'
                    } else {
                    //Else player 2's turn
                        p2_score = score;
                        //Set player 2's score to 'score'
                    }
                }
            }
            if (p1_score == 30) {
            //If statement to check the winner
                winner = p1;
                //Set winner as player 1
                for (int i = 0; i < taunt1.length; i++) {
                //For loop to itterate through array
                    p_taunt[i] = taunt1[i];
                    //Copy taunt1 to p1_taunt
                    g = p1_score;
                    //Variable to display player 1's score
                }
            } else if (p2_score == 30) {
            //Else if statement to check winner
                winner = p2;
                //Set winner as player 2
                for (int j = 0; j < taunt2.length; j++) {
                //For loop to itterate through array
                    p_taunt[j] = taunt2[j];
                    //Copy taunt2 to p2_taunt 
                    g = p2_score;
                    //Variable to display player 2's score 
                }
            }
            System.out.println("\n-----CONGRATULATIONS "+ winner.toUpperCase() +", YOU AQUIRED "+ g +" GEMS! Check the cash dispenser for your $1,000,000 reward!-----\n\nYou have earned the right to taunt your enemy... Enter a number between 1 and 4.");
            //Print winning message based off the previous if/ else if statement. Ask player to pick a random taunt
            Scanner t_input = new Scanner(System.in);
            //Scanner for taunt choice
            int choose_taunt = t_input.nextInt();
            //Set taunt choice as an int
            choose_taunt -= 1;
            //Subtract 1 to account for java counting from zero
            System.out.println(p1 +" said, '"+ p_taunt[choose_taunt] +"'\n-----\nThank you for joining us at MARKALANS ONLINE CASINO!\n-----\nWould you like to play again? [Y/N]");
            //Promt the user to play again
            Scanner replay = new Scanner(System.in);
            //Scanner to decide weather to play again or not
            play_again = replay.nextLine();
            //Set play_again to Y or N from scanner
            play_again = play_again.toUpperCase();
            //Change user input to uppercase to account for errors
        }
    }
}