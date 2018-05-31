import java.util.Scanner;

public class Game {

	// /INSTATNTIATED VARIABLES ;)
	static String[][] board = new String[3][3];
	static String player;
	private static Scanner ans;
	private static Scanner move;
	private static int count;

	public Game() {

	}

	public String[][] newBoard(int row, int column) {

		return new String[row][column];
	}

	// / MAKE A BOARD, GOTTA
	public static void makeBoard() {
		for (int c = 0; c < board.length; c++)
			for (int r = 0; r < board.length; r++)
				board[r][c] = "";
	}

	// /PRINTS OUT THE INDEX OF THE ARRAYS BETWEEN THE LINES IN ORDER TO MAKE A
	// BOARD :)
	public void printBoard() {

		System.out.println(board[0][0] + "   |" + board[0][1] + "   |"
				+ board[0][2]);
		System.out.println("------------");
		System.out.println(board[1][0] + "   |" + board[1][1] + "   |"
				+ board[1][2]);
		System.out.println("------------");
		System.out.println(board[2][0] + "   |" + board[2][1] + "   |"
				+ board[2][2]);

	}

	// / EVERYTIME A PLAYER ENDS THEIR TURN, IT SWITCHES TO THE OPPONENT
	public String changePlayer(String player) {
		String whoseTurn = "o";
		if (player == "o")
			whoseTurn = "x";
		if (player == "x")
			whoseTurn = "o";
		count++;
		return whoseTurn;
	}

	// /SUBTRACTED BY 1 SO THE USER DOESNT HAVE TO INPUT 0,1,2 BUT INSTEAD CAN
	// SAY 1,2,3
	public void updateBoard(String player, int row, int column) {
		board[row - 1][column - 1] = player;

	}

	// / CHECKS THE INPUT TO SEE IF THE NUMBERS ARE VALID OR IF THE SPOT IS
	// TAKEN
	public boolean checkIfIllegal(int row, int column) {
		if ((row > 3 || column > 3) || (row < 0 || column < 0))
			return true;

		else if (board[row][column] == "x" || board[row][column] == "o")
			return true;

		return false;
	}

	// /COULDN'T FIGURE OUT AN EASY WAY TO DO THIS BUT WE MANUALLY TYPED OUT ALL
	// THE WINNING POSSIBILITIES :')
	public boolean checkIfWinner() {
		if (board[0][0] == board[1][0] && board[1][0] == board[2][0]
				&& (board[0][0] == "x" || board[0][0] == "o"))
			return true;
		else if (board[0][1] == board[1][1] && board[1][1] == board[2][1]
				&& (board[0][1] == "x" || board[0][1] == "o"))
			return true;
		else if (board[0][2] == board[1][2] && board[1][2] == board[2][2]
				&& (board[0][2] == "x" || board[0][2] == "o"))
			return true;
		else if (board[0][0] == board[1][1] && board[1][1] == board[2][2]
				&& (board[0][0] == "x" || board[0][0] == "o"))
			return true;
		else if (board[2][0] == board[1][1] && board[1][1] == board[0][2]
				&& (board[2][0] == "x" || board[2][0] == "o"))
			return true;
		else if (board[0][0] == board[0][1] && board[0][1] == board[0][2]
				&& (board[0][0] == "x" || board[0][0] == "o"))
			return true;
		else if (board[1][0] == board[1][1] && board[1][1] == board[1][2]
				&& (board[1][0] == "x" || board[1][0] == "o"))
			return true;
		else if (board[2][0] == board[2][1] && board[2][1] == board[2][2]
				&& (board[2][0] == "x" || board[2][0] == "o"))
			return true;

		else
			return false;
	}

	public boolean checkIfTie() {
		if (count >= 9 && checkIfWinner() != true)
			return true;
		else
			return false;
	}

	// /MAIN
	public static void main(String[] args) {
		move = new Scanner(System.in);
		ans = new Scanner(System.in);
		Game g = new Game();
		g.makeBoard();
		System.out.println("Game ready !\n");
		// / GOT THIS IDEA FROM PYTHON GAME, TO PUT IT IN A LOOP

		while (true) {
			
			player = g.changePlayer(player);
			System.out.print("choose a spot (row, column):");
			int row = move.nextInt();
			int column = move.nextInt();

			while (g.checkIfIllegal(row - 1, column - 1)) {
				System.out.println();
				System.out.println("That slot is invalid :(");
				g.printBoard();
				System.out.print("choose a spot (row, column):");
				row = move.nextInt();
				column = move.nextInt();
			}
			g.updateBoard(player, row, column);
			g.printBoard();
			if (g.checkIfTie()) {
				System.out.println("huh");
			}
			if (g.checkIfWinner()) {
				System.out.println("\nThe winner is " + player + " !");
				System.out.println("Play Again? 1. Yes  2. No");
				int Ans = ans.nextInt();
				if (Ans == 1) {
					makeBoard();
					count = 0;
					continue;
				}
				if (Ans == 2) {
					System.out.println("Thanks For Playing!!");
					break;
				}
			}

		}

	}
		
}

