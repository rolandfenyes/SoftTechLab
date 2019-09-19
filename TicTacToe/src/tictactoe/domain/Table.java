package tictactoe.domain;

public class Table {
	
	private Signs[][] gameBoard = new Signs[3][3];
	
	public Table() {
		for (int rows = 0; rows < 3; rows++) {
			for (int columns = 0; columns < 3; columns++) {
				gameBoard[rows][columns] = Signs.URES;
			}
		}
	}
	
	public Signs[][] getGameBoard(){
		return gameBoard;
	}

	public void drawTable() {
		for (int rows = 0; rows < 3; rows++) {
			for (int columns = 0; columns < 3; columns++) {
				System.out.print(gameBoard[rows][columns].getSign() + " | ");
			}
			System.out.println();
			for (int drawRow = 0; drawRow < 12; drawRow++) {
				System.out.print("-");
			}
			System.out.println();
		}
	}
}
