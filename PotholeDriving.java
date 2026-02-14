package hwk3;
// Yuyudhan Singh
// 1002327079

import java.util.Scanner;
import java.util.Random;

public class PotholeDriving {

	public static void main(String[] args) {
		// Declaring Objects and while loop conditions
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		boolean userChoice = true;
		
		while(userChoice) {
			
			System.out.println("Welcome to Pothole Driving! Get home while avoiding potholes!");
			
			String[][] environment = new String[10][10]; 
			
			// Loop to setup the display environment with "_", "X", and "^" for user
			for(int i = 0; i < 10; i++) {
				
				for(int j = 0; j < 10; j++) {
					
					if(i == 0 && j == 0) {
						environment[i][j] = "X";
					}
					else if(i == 9 && j == 9) {
						environment[i][j] = "^";
					}
					else{
						environment[i][j] = "_";
					}
				}
			}
			
			int count = 0;
			
			// Randomly generating unique potholes
			do {		
				int potRow = rand.nextInt(10);
				int potCol = rand.nextInt(10);
				
				if (environment[potRow][potCol].equals("P") || (potRow == 0 && potCol == 0) || (potRow == 9 && potCol == 9)) {
					continue;
				}
				
				environment[potRow][potCol] = "P";
				count++;
				
			} while(count < 5);
			
			int userCol = 0;
			int userRow = 0;
			
			// Loop handling all game logic
			while(true) {
				
				// Printing out the environment to display
				for(int i = 0; i < 10; i++) {
					
					for(int j = 0; j < 10; j++) {
						// Hiding potholes with "_"
						if(environment[i][j].equals("P")) {
							System.out.print("_");
						}
						else {
							System.out.print(environment[i][j]);
						}
					}
					
					System.out.println(); // Enter to next line after 9 iterations of inner j-loop
				}
				
				System.out.println("Enter either a -1, 0, or 1 on the X-axis or 9 to quit");
				
				// Validating type of input using hasNextInt()
				while (!input.hasNextInt()) {
				    System.out.println("Invalid Input! Please enter a number.");
				    input.next(); 
				    
				}
				int inX = input.nextInt(); // Use to move left-right
				
				if(inX == 9) {
					input.nextLine();
					break;
				}
				
				if(!(inX == 0 || inX == 1 || inX == -1)) {
					System.out.println("Invalid Input! Please try again...");
					input.nextLine();
					continue;
				}
			
				input.nextLine();
				
				System.out.println("Enter either a -1, 0, or 1 on the Y-axis or 9 to quit");
				
				// Validating type of input using hasNextInt()
				while (!input.hasNextInt()) {
				    System.out.println("Invalid Input! Please enter a number.");
				    input.next(); 
				    
				}
				
				int inY = input.nextInt(); // Use to move up-down
				
				if(inY == 9) {
					input.nextLine();
					break;
				}
				
				if(!(inY == 0 || inY == 1 || inY == -1)) {
					System.out.println("Invalid Input! Please try again...");
					input.nextLine();
					continue;
				}
				if (inX == 0 && inY == 0) {
				    System.out.println("You must move! Staying still is not allowed.");
				    input.nextLine();
				    continue;
				}
				
				input.nextLine();
				// Using new variables to validate user index before updating on the matrix
				int futureCol = userCol + inX;
				int futureRow = userRow + inY;
				
				// Preventing car from going out of the 10x10 matrix environment
				if(futureCol < 0 || futureCol > 9 || futureRow < 0 || futureRow > 9) {
					System.out.println("Invalid Input, car going out of bounds! Please try again..."); 
					continue;
				}
				
				environment[userRow][userCol] = "_"; // Setting the previously "X" to "_" as car moves
				
				userRow = futureRow;
				userCol = futureCol;
				
				// Losing condition when user hits a pothole
				if(environment[userRow][userCol].equals("P")) {
					System.out.println("OH NO! POTHOLE!");
					break;
				}
				
				environment[userRow][userCol] = "X";
				
				// Winning condition when user reaches home
				if(userRow == 9 && userCol == 9) {
					System.out.println("You have reached home! Congratulations on the completing the game!");
					break;
				}
				
				
			}
			
			System.out.println("Would you like to play again? (yes/no)");
			
			if(!(input.nextLine().equalsIgnoreCase("yes"))) {
				userChoice = false;
				System.out.println("Goodbye...");
			}
		}
		
		input.close();	
	}
}
