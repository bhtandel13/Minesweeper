package ClassExamples; 

import java.util.Random;
import java.util.Scanner; 

public class Minesweeper {
	private int size;
	public int mines;
	public int flags = 0; 
	private int[][] game;
	private String[][] board; 


	public Minesweeper(int sizeOfBoard, int numberOfMines) {
		size = sizeOfBoard;
		mines = numberOfMines; 
		game = new int [size][size];
		board = new String [size][size];
		for (int i = 0; i < size; i ++)
		{
			for(int j = 0; j < size; j++) {
				board[i][j] = "| |";
			}
		}
		Random position = new Random(); 
		int placedMines = 0;
		while(placedMines < mines) {
			int r = position.nextInt(size);
			int c = position.nextInt(size);
			if (game[r][c] != -1) {
				game[r][c] = -1;
				placedMines++;	
			}
		}
		for (int j = 0; j < size; j++) {
			for(int k = 0; k < size; k++) {
				if(game[j][k] == -1 && j == 0 && k == 0) {
					if(game[j][k + 1] != -1) {
						game[j][k + 1] += 1;
					}
					if(game[j + 1][k + 1] != -1) {
						game[j + 1][k + 1] += 1;
					}
					if(game[j + 1][k] != -1) {
						game[j + 1][k] += 1;
					}
				}
				else if(game[j][k] == -1 && j == 0 && k == size - 1) {
					if(game[j][k - 1] != -1) {
						game[j][k - 1] += 1;
					}
					if(game[j + 1][k - 1] != -1) {
						game[j + 1][k - 1] += 1;
					}
					if(game[j + 1][k] != -1) {
						game[j + 1][k] += 1;
					}
					
				}
				else if(game[j][k] == -1 && j == size - 1 && k == 0) {
					if(game[j - 1][k] != -1) {
						game[j- 1][k] += 1;
					}
					if(game[j - 1][k + 1] != -1) {
						game[j - 1][k + 1] += 1;
					}
					if(game[j][k + 1] != -1) {
						game[j][k + 1] += 1;
					}
				}
				else if(game[j][k] == -1 && j == size - 1 && k == size - 1) {
					if(game[j][k - 1] != -1) {
						game[j][k - 1] += 1;
					}
					if(game[j - 1][k - 1] != -1) {
						game[j - 1][k - 1] += 1;
					}
					if(game[j - 1][k] != -1) {
						game[j - 1][k] += 1;
					}
				}
				else if (game[j][k] == -1 && j == 0) {
					if(game[j][k - 1] != -1) {
						game[j][k - 1] += 1;
					}
					if(game[j][k + 1] != -1) {
						game[j][k + 1] += 1;
					}
					if(game[j + 1][k - 1] != -1) {
						game[j + 1][k - 1] += 1;
					}
					if(game[j + 1][k] != -1) {
						game[j + 1][k] += 1;
					}
					if(game[j + 1][k + 1] != -1) {
						game[j + 1][k + 1] += 1;
					}
				}
				else if (game[j][k] == -1 && j == size - 1) {
					if(game[j - 1][k - 1] != -1) {
						game[j - 1][k - 1] += 1;
					}
					if(game[j - 1][k] != -1) {
						game[j - 1][k] += 1;
					}
					if(game[j - 1][k + 1] != -1) {
						game[j - 1][k + 1] += 1;
					}
					if(game[j][k - 1] != -1) {
						game[j][k - 1] += 1;
					}
					if(game[j][k + 1] != -1) {
						game[j][k + 1] += 1;
					}
				}
				else if (game[j][k] == -1 && k == 0) {
					if(game[j - 1][k] != -1) {
						game[j - 1][k] += 1;
					}
					if(game[j - 1][k + 1] != -1) {
						game[j - 1][k + 1] += 1;
					}
					if(game[j][k + 1] != -1) {
						game[j][k + 1] += 1;
					}
					if(game[j + 1][k] != -1) {
						game[j + 1][k] += 1;
					}
					if(game[j + 1][k + 1] != -1) {
						game[j + 1][k + 1] += 1;
					}
				}
				else if (game[j][k] == -1 && k == size - 1) {
					if(game[j - 1][k - 1] != -1) {
						game[j - 1][k - 1] += 1;
					}
					if(game[j - 1][k] != -1) {
						game[j - 1][k] += 1;
					}
					if(game[j][k - 1] != -1) {
						game[j][k - 1] += 1;
					}
					if(game[j + 1][k - 1] != -1) {
						game[j + 1][k - 1] += 1;
					}
					if(game[j + 1][k] != -1) {
						game[j + 1][k] += 1;
					}
				}
				else if(game[j][k] == -1) {
					if(game[j - 1][k - 1] != -1) {
						game[j - 1][k - 1] += 1;
					}
					if(game[j - 1][k] != -1) {
						game[j - 1][k] += 1;
					}
					if(game[j - 1][k + 1] != -1) {
						game[j - 1][k + 1] += 1;
					}
					if(game[j][k - 1] != -1) {
						game[j][k - 1] += 1;
					}
					if(game[j][k + 1] != -1) {
						game[j][k + 1] += 1;
					}
					if(game[j + 1][k - 1] != -1) {
						game[j + 1][k - 1] += 1;
					}
					if(game[j + 1][k] != -1) {
						game[j + 1][k] += 1;
					}
					if(game[j + 1][k + 1] != -1) {
						game[j + 1][k + 1] += 1;
					}
				}
			}
		}
	}
	
	public void printBoard() {
		System.out.print("  ");
		for (int t = 1; t <= size; t++) {
			System.out.print(t + "  ");
		}
		System.out.println();
		for (int i = 0; i < size; i ++)
		{
			System.out.print(i + 1);
			for(int j = 0; j < size; j++) {
				if (game[i][j] == -1) {
					System.out.print("|M|");
				}
				else {
				System.out.print("|" + game[i][j] + "|");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printVisible() {
		System.out.print("  ");
		for (int t = 1; t <= size; t++) {
			System.out.print(t + "  ");
		}
		System.out.println();
		for (int i = 0; i < size; i ++)
		{
			System.out.print(i + 1);
			for(int j = 0; j < size; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void checkPosition(String input) {
		String[] commands = input.split(" ");
		if(commands.length == 3) { 
		char r = commands[0].charAt(0);
		char c = commands[1].charAt(0);
		String action = commands[2];
		action = action.toLowerCase(); 
		if (Character.isDigit(r) == true && commands[0].length() == 1) {
			int i = Integer.parseInt(commands[0]) -1;
			if(Character.isDigit(c) == true && commands[1].length() == 1) {
				int j = Integer.parseInt(commands[1]) - 1;
				if (i >= 0 && i <= size - 1 && j >= 0 && j <= size - 1 && (action.equals("t") || action.equals("f"))){
					if(game[i][j] == -1 && action.equals("t")) {
						board[i][j] = "|M|";
					}
					else if (action.equals("f")) {
						if (flags < mines) {
						board[i][j] = "|F|";
						flags++;
						}
						else 
						{
							System.out.println("The maximum number of flags has been reached!");
						}
					}
					else {
						if (game[i][j] == 0) {
							clearZeroes(i, j);
						}
						else {
							board[i][j] = "|" + Integer.toString(game[i][j]) + "|";
						}
					}
					printVisible(); 
				}
				else {
					System.out.println("Not a valid input");
					}
			}
			else {
				System.out.println("Not a valid input");
				}
		}
		else {
			System.out.println("Not a valid input");
			}
		}
		else {
			System.out.println("Not a valid input");
		}
	}
	
	public boolean gameOver() {
		boolean gameOver = false; 
		for (int i = 0; i < size; i ++)
		{
			for(int j = 0; j < size; j++) {
				if (board[i][j] == "|M|") {
					gameOver = true; 
				}
			}
		}
		return gameOver; 
	}
	
	public boolean gameWon() {
		boolean gameWon = true;
		for (int i = 0; i < size; i ++)
		{
			for(int j = 0; j < size; j++) {
				if (board[i][j] == "| |") {
					gameWon = false; 
				}
			}
		}
		return gameWon;
	}
	
	public void clearZeroes(int j, int k) {
			board[j][k] = "|0|";
			if(j == 0 && k == 0) {
				if(game[j][k + 1] == 0 && !board[j][k + 1].equals("|0|")) {
					board[j][k + 1] = "|0|";
					clearZeroes(j, k + 1);
				}
				if(game[j + 1][k + 1] == 0 && !board[j + 1][k + 1].equals("|0|")) {
					board[j + 1][k + 1] = "|0|";
					clearZeroes(j + 1, k + 1);
				}
				if(game[j + 1][k] == 0 && !board[j + 1][k].equals("|0|")) {
					board[j + 1][k] = "|0|";
					clearZeroes(j + 1, k);
				}
			}
			else if(j == 0 && k == size - 1) {
				if(game[j][k - 1] == 0 && !board[j][k - 1].equals("|0|")) {
					board[j][k - 1] = "|0|";
					clearZeroes(j, k - 1);
				}
				if(game[j + 1][k - 1] == 0 && !board[j + 1][k - 1].equals("|0|")) {
					board[j + 1][k - 1] = "|0|";
					clearZeroes(j + 1, k - 1);
				}
				if(game[j + 1][k] == 0 && !board[j + 1][k].equals("|0|")) {
					board[j + 1][k] = "|0|";
					clearZeroes(j + 1, k);
				}
				
			}
			else if(j == size - 1 && k == 0) {
				if(game[j - 1][k] == 0 && !board[j - 1][k].equals("|0|")) {
					board[j - 1][k] = "|0|";
					clearZeroes(j - 1, k);
				}
				if(game[j - 1][k + 1] == 0 && !board[j - 1][k + 1].equals("|0|")) {
					board[j - 1][k + 1] = "|0|";
					clearZeroes(j - 1, k + 1);
				}
				if(game[j][k + 1] == 0 && !board[j][k + 1].equals("|0|")) {
					board[j][k + 1] = "|0|";
					clearZeroes(j, k + 1);
				}
			}
			else if(j == size - 1 && k == size - 1) {
				if(game[j][k - 1] == 0 && !board[j][k - 1].equals("|0|")) {
					board[j][k - 1] = "|0|";
					clearZeroes(j, k - 1);
				}
				if(game[j - 1][k - 1] == 0 && !board[j - 1][k - 1].equals("|0|")) {
					board[j - 1][k - 1] = "|0|";
					clearZeroes(j - 1, k - 1);
				}
				if(game[j - 1][k] == 0 && !board[j - 1][k].equals("|0|")) {
					board[j - 1][k] = "|0|";
					clearZeroes(j - 1, k);
				}
			}
			else if (j == 0) {
				if(game[j][k - 1] == 0 && !board[j][k - 1].equals("|0|")) {
					board[j][k - 1] = "|0|";
					clearZeroes(j, k - 1);
				}
				if(game[j][k + 1] == 0 && !board[j][k + 1].equals("|0|")) {
					board[j][k + 1] = "|0|";
					clearZeroes(j, k + 1);
				}
				if(game[j + 1][k - 1] == 0 && !board[j + 1][k - 1].equals("|0|")) {
					board[j + 1][k - 1] = "|0|";
					clearZeroes(j + 1, k - 1);
				}
				if(game[j + 1][k] == 0 && !board[j + 1][k].equals("|0|")) {
					board[j + 1][k] = "|0|";
					clearZeroes(j + 1, k);
				}
				if(game[j + 1][k + 1] == 0 && !board[j + 1][k + 1].equals("|0|")) {
					board[j + 1][k + 1] = "|0|";
					clearZeroes(j + 1, k + 1);
				}
			}
			else if (j == size - 1) {
				if(game[j - 1][k - 1] == 0 && !board[j - 1][k - 1].equals("|0|")) {
					board[j - 1][k - 1] = "|0|";
					clearZeroes(j - 1, k - 1);
				}
				if(game[j - 1][k] == 0 && !board[j - 1][k].equals("|0|")) {
					board[j - 1][k] = "|0|";
					clearZeroes(j - 1, k);
				}
				if(game[j - 1][k + 1] == 0 && !board[j - 1][k + 1].equals("|0|")) {
					board[j - 1][k + 1] = "|0|";
					clearZeroes(j - 1, k + 1);
				}
				if(game[j][k - 1] == 0 && !board[j][k - 1].equals("|0|")) {
					board[j][k - 1] = "|0|";
					clearZeroes(j, k - 1);
				}
				if(game[j][k + 1] == 0 && !board[j][k + 1].equals("|0|")) {
					board[j][k + 1] = "|0|";
					clearZeroes(j, k + 1);
				}
			}
			else if (k == 0) {
				if(game[j - 1][k] == 0 && !board[j - 1][k].equals("|0|")) {
					board[j - 1][k] = "|0|";
					clearZeroes(j - 1, k);
				}
				if(game[j - 1][k + 1] == 0 && !board[j - 1][k + 1].equals("|0|")) {
					board[j - 1][k + 1] = "|0|";
					clearZeroes(j - 1, k + 1);
				}
				if(game[j][k + 1] == 0 && !board[j][k + 1].equals("|0|")) {
					board[j][k + 1] = "|0|";
					clearZeroes(j, k + 1);
				}
				if(game[j + 1][k] == 0 && !board[j + 1][k].equals("|0|")) {
					board[j + 1][k] = "|0|";
					clearZeroes(j + 1, k);
				}
				if(game[j + 1][k + 1] == 0 && !board[j + 1][k + 1].equals("|0|")) {
					board[j + 1][k + 1] = "|0|";
					clearZeroes(j + 1, k + 1);
				}
			}
			else if (k == size - 1) {
				if(game[j - 1][k - 1] == 0 && !board[j - 1][k - 1].equals("|0|")) {
					board[j - 1][k - 1] = "|0|";
					clearZeroes(j - 1, k - 1);
				}
				if(game[j - 1][k] == 0 && !board[j - 1][k].equals("|0|")) {
					board[j - 1][k] = "|0|";
					clearZeroes(j - 1, k);
				}
				if(game[j][k - 1] == 0 && !board[j][k - 1].equals("|0|")) {
					board[j][k - 1] = "|0|";
					clearZeroes(j, k - 1);
				}
				if(game[j + 1][k - 1] == 0 && !board[j + 1][k - 1].equals("|0|")) {
					board[j + 1][k - 1] = "|0|";
					clearZeroes(j + 1, k - 1);
				}
				if(game[j + 1][k] == 0 && !board[j + 1][k].equals("|0|")) {
					board[j + 1][k] = "|0|";
					clearZeroes(j + 1, k);
				}
			}
			else{
				if(game[j - 1][k - 1] == 0 && !board[j - 1][k - 1].equals("|0|")) {
					board[j - 1][k - 1] = "|0|";
					clearZeroes(j - 1, k - 1);
				}
				if(game[j - 1][k] == 0 && !board[j - 1][k].equals("|0|")) {
					board[j - 1][k] = "|0|";
					clearZeroes(j - 1, k);
				}
				if(game[j - 1][k + 1] == 0 && !board[j - 1][k + 1].equals("|0|")) {
					board[j - 1][k + 1] = "|0|";
					clearZeroes(j - 1, k + 1);
				}
				if(game[j][k - 1] == 0 && !board[j][k - 1].equals("|0|")) {
					board[j][k - 1] = "|0|";
					clearZeroes(j, k - 1);
				}
				if(game[j][k + 1] == 0 && !board[j][k + 1].equals("|0|")) {
					board[j][k + 1] = "|0|";
					clearZeroes(j, k + 1);
				}
				if(game[j + 1][k - 1] == 0 && !board[j + 1][k - 1].equals("|0|")) {
					board[j + 1][k - 1] = "|0|";
					clearZeroes(j + 1, k - 1);
				}
				if(game[j + 1][k] == 0 && !board[j + 1][k].equals("|0|")) {
					board[j + 1][k] = "|0|";
					clearZeroes(j + 1, k);
				}
				if(game[j + 1][k + 1] == 0 && !board[j + 1][k + 1].equals("|0|")) {
					board[j + 1][k + 1] = "|0|";
					clearZeroes(j + 1, k + 1);
				}
			}
		}		
}
