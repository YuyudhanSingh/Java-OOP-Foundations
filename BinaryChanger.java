package hwk1;

// Yuyudhan Singh 
//Student ID: 1002327079

import java.util.Scanner;
public class BinaryChanger {

	public static void main(String[] args) {
		
		// Set up scanner variable to take input from user
		Scanner input = new Scanner (System.in);
		
		System.out.println("Enter a 4-bit binary number");
		
		// Initialize the first decimal value and the binary input
		int decimalInt1 = 0;
		int x = Integer.parseInt(input.nextLine()); // Converts string into integer
		
		// Iterate through the number using % (mod) to get last digit 
		for(int i = 0; i < 4; i++) {
			int power = (int) Math.pow(2, i);
			decimalInt1 = decimalInt1 + ((x%10)*power); // Converting binary to decimal
			x = x/10; // Update first input to check value of next bit
		}
		
		System.out.println("Enter another 4-bit binary number");
		
		// Initialize the second decimal value and the binary input
		int decimalInt2 = 0;
		int y = Integer.parseInt(input.nextLine());
		
		// Iterate same as with first input
		for(int i = 0; i < 4; i++) {
			int power = (int) Math.pow(2, i);
			decimalInt2 = decimalInt2 + ((y%10)*power); // Converting binary to decimal
			y = y/10; // Update second input to check value of next bit
		}
		
		// Printing decimal values of binary input
		System.out.println("The first number is " + decimalInt1);
		System.out.println("The second number is " + decimalInt2);
		
		int sum = decimalInt1 + decimalInt2; // Add the decimal values of given binary numbers
		
		System.out.println("Their sum is " + sum);
		
		input.close();
		
	}

}
