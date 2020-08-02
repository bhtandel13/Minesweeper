package ClassExamples;

import java.util.Scanner;

/**
 * @author Mr. Turner
 * Class that starts a game of Minesweeper
 */
public class MinesweeperTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Greeting
		System.out.println("Welcome to Minesweeper!");
		Scanner in = new Scanner(System.in);
		boolean playing = true; 
		do {
			//initialize variables
			int size = 0; 
			int mines = 0; 
			boolean validSetup = false;
			// Ask for game setup 
			do {
				System.out.print("Size of board:");
				size = in.nextInt();
				System.out.print("Number of mines:");
				mines = in.nextInt();
				if(mines < size * size) {
					validSetup = true; 
				}
				else {
					System.out.println("\nError: The number of mines is greater than"
							+ "\nor equal to the size of the board\n");
				}
			}
			while(!validSetup);
			Minesweeper game = new Minesweeper(size, mines);
			System.out.println("Game ready!\n");
			//Consumes remaining characters in the scanner
			in.nextLine();
			game.printVisible();
			
			//Ask for user moves
			do {
				System.out.println("Enter coordinates with a space between followed with"
						+ "\na T to test the point or F to place a flag.");
				System.out.printf("Mines Remaining: %d\n", game.mines - game.flags);
				
				game.checkPosition(in.nextLine());
			}
			while(!game.gameOver() && !game.gameWon());
		
		//Informs player they won
		if (game.gameWon()) {
			System.out.println("CONGRATULATIONS!\nYou have won!");
			game.printBoard();
		}
		
		//informs player they lost
		else if(game.gameOver()) {
			System.out.println("Game over :(");
			game.printBoard();
	}	
		
		//Asks the player if they want to play again
		System.out.print("Play again (y/n)?: ");
		String play = in.next();
		if(play.equalsIgnoreCase("y")) {
			playing = true; 
		}
		else if (play.equalsIgnoreCase("n")) {
			playing = false;
		}
		else {
			System.out.println("Invalid input! Program terminated.");
		}
		//Continues to create new game as long as the user asks for a new game
	}while(playing);
	
	in.close();

		}
}