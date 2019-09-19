package tictactoe.domain;

import java.util.ArrayList;

public class Fields {
	
	Signs[][] gameBoard;
	Signs sign;
	
	public Fields(Signs[][] gameBoard, Signs sign) {
		this.gameBoard = gameBoard;
		this.sign = sign;
	}
	
	public Signs getSign() {
		return sign;
	}

	public boolean hasWon(Signs sign) {
		boolean hasWon = false;
		hasWon = hasWonInRows(sign);
		if (hasWon) {
			return true;
		}
		hasWon = hasWonInColumns(sign);
		if (hasWon) {
			return true;
		}
		hasWon = hasWonInDiagonals1(sign);
		if (hasWon) {
			return true;
		}
		hasWon = hasWonInDiagonals2(sign);
		if (hasWon) {
			return true;
		}
		return false;
	}
	
	public boolean hasWonInRows(Signs sign) {
		ArrayList<Signs> correct = new ArrayList<Signs>();
		for (int rows = 0; rows < 3; rows++) {
			for (int columns = 0; columns < 3; columns++) {
				if (gameBoard[rows][columns] == sign) {
					correct.add(sign);
				}
			}
			if (correct.size() == 3) {
				return true;
			}
			correct.removeAll(correct);
		}
		return false;
	}
	
	public boolean hasWonInColumns(Signs sign) {
		ArrayList<Signs> correct = new ArrayList<Signs>();
		for (int columns = 0; columns < 3; columns++) {
			for (int rows = 0; rows < 3; rows++) {
				if (gameBoard[rows][columns] == sign) {
					correct.add(sign);
				}
			}
			if (correct.size() == 3) {
				return true;
			}
			correct.removeAll(correct);
		}
		return false;
	}
	
	public boolean hasWonInDiagonals1(Signs sign) {
		ArrayList<Signs> correct = new ArrayList<Signs>();
		for (int rows = 0; rows < 3; rows++) {
			int columns = 0;
			if (gameBoard[rows][columns] == sign) {
				correct.add(sign);
			}
			columns++;
		}
		if (correct.size() == 3) {
			return true;
		}
		return false;
	}
	
	public boolean hasWonInDiagonals2(Signs sign) {
		ArrayList<Signs> correct = new ArrayList<Signs>();
		for (int rows = 0; rows < 3; rows++) {
			int columns = 2;
			if (gameBoard[rows][columns] == sign) {
				correct.add(sign);
			}
			columns--;
		}
		if (correct.size() == 3) {
			return true;
		}
		return false;
	}
}
