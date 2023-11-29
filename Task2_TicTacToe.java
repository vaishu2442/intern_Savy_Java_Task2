package java_task;

import java.util.Scanner;

public class Task2_TicTacToe {
	 private char[][] board;
	    private char currentPlayer;

	    public Task2_TicTacToe() {
	        board = new char[3][3];
	        currentPlayer = 'X';

	        
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                board[i][j] = ' ';
	            }
	        }
	    }
	    public void printBoard() {
	        System.out.println("-------------");
	        for (int i = 0; i < 3; i++) {
	            System.out.print("| ");
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j] + " | ");
	            }
	            System.out.println();
	            System.out.println("-------------");
	        }
	    }

	    public boolean makeMove(int row, int col) {
	        
	        if (board[row][col] == ' ') {
	            board[row][col] = currentPlayer;
	            return true;
	        } else {
	            System.out.println("Cell already occupied. Try again.");
	            return false;
	        }
	    }

	    public boolean checkWin() {
	        
	        for (int i = 0; i < 3; i++) {
	            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
	                return true; 
	            }
	            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
	                return true; 
	            }
	        }
	        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
	            return true; 
	        }
	        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
	            return true; 
	        }
	        return false;
	    }
	    public boolean isBoardFull() {
	        
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] == ' ') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    public void switchPlayer() {
	       
	        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Task2_TicTacToe game = new Task2_TicTacToe();

	        do {
	            game.printBoard();
	            System.out.println("Player " + game.currentPlayer + "'s turn");
	            System.out.print("Enter row (0-2): ");
	            int row = scanner.nextInt();
	            System.out.print("Enter column (0-2): ");
	            int col = scanner.nextInt();

	            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
	                if (game.makeMove(row, col)) {
	                    if (game.checkWin()) {
	                        game.printBoard();
	                        System.out.println("Player " + game.currentPlayer + " wins!");
	                        break;
	                    } else if (game.isBoardFull()) {
	                        game.printBoard();
	                        System.out.println("It's a draw!");
	                        break;
	                    } else {
	                        game.switchPlayer();
	                    }
	                }
	            } else {
	                System.out.println("Invalid input. Row and column must be between 0 and 2.");
	            }

	        } while (true);

	        scanner.close();
	    }
	

}
