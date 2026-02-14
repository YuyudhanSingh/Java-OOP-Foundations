package hwk2;

// Author: Yuyudhan Singh
// Student ID: 1002327079

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissor {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the game of Rock, Paper, and Scissor!");
		// Creating variables for Scanner and Random 
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		String userChoice = "no"; // default choice
		
		// do-while loop lets game run for a minimum of 1 round every playthrough
		do{
			
			int userScore = 0;
			int compScore = 0;
			
			// for loop to simulate 3 rounds of RPS gameplay
			for(int i = 0; i < 3; i++) {
				
				String compChoice;
				int roundNum = i+1;
				
				System.out.println("Round " + roundNum + ":");
				System.out.print("Please enter Rock, Paper, or Scissors: ");
				
				String userMove = input.nextLine();
				
				int compNum = rand.nextInt(3); // Selects random number from 0, 1, 2
				
				// Assigning computer's move using rand.nextInt()
				if (compNum == 0) {
					compChoice = "Rock";
				}
				else if (compNum == 1) {
					compChoice = "Paper";
				}
				else {
					compChoice = "Scissors";
				}
				
				// Switch case handles all possible RPS game inputs
				switch(userMove.toLowerCase()) {
					case "rock":
						if(compChoice.equalsIgnoreCase("rock")) {
							System.out.println("Computer chose " + compChoice);
							System.out.println("It was a tie...");
						}
						else if(compChoice.equalsIgnoreCase("paper")) {
							System.out.println("Computer chose " + compChoice);
							System.out.println("Computer won this round!");
							compScore++;
						}
						else {
							System.out.println("Computer chose " + compChoice);
							System.out.println("You won this round!");
							userScore++;
						}
						break;
					case "paper":
						if(compChoice.equalsIgnoreCase("paper")) {
							System.out.println("Computer chose " + compChoice);
							System.out.println("It was a tie...");
						}
						else if(compChoice.equalsIgnoreCase("scissors")) {
							System.out.println("Computer chose " + compChoice);
							System.out.println("Computer won this round!");
							compScore++;
						}
						else {
							System.out.println("Computer chose " + compChoice);
							System.out.println("You won this round!");
							userScore++;
						}
						break;
					case "scissors":
						if(compChoice.equalsIgnoreCase("scissors")) {
							System.out.println("Computer chose " + compChoice);
							System.out.println("It was a tie...");
						}
						else if(compChoice.equalsIgnoreCase("rock")) {
							System.out.println("Computer chose " + compChoice);
							System.out.println("Computer won this round!");
							compScore++;
						}
						else {
							System.out.println("Computer chose " + compChoice);
							System.out.println("You won this round!");
							userScore++;
						}
						break;
					default:
							System.out.println("Invalid input. Computer wins by default.");
							compScore++;
						
				}
				
				// Special text for result after final round
				if(i == 2) {
					System.out.println("Final score:");
					System.out.println("User: " + userScore);
					System.out.println("Computer: " + compScore);
				}
				else {
					System.out.println("Current score:");
					System.out.println("User: " + userScore);
					System.out.println("Computer: " + compScore);
				}
				
			}
			// if-else block to declare winner of RPS
			if(compScore > userScore) {
				System.out.println("Computer was the overall winner! Better luck next time...");
			}
			else if(userScore > compScore) {
				System.out.println("Congratulations! You are the overall winner!");
			}
			else {
				System.out.println("Close game! It was a tie!");
			}
			System.out.print("Would you like to play again? (yes/no): ");
			userChoice = input.nextLine(); // User chooses to stop or continue playing
			

		} while(userChoice.equalsIgnoreCase("yes"));
		
		System.out.println("Thank you for playing!");
		input.close();
	}

}
