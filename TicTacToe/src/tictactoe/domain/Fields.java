package tictactoe.domain;

import java.util.ArrayList;

import tictactoe.business.GameStatus;

public class Fields {
	
	Signs[][] gameBoard;
	Signs sign;
	boolean isPlayer = false;
	
	public Fields(Signs[][] gameBoard, Signs sign) {
		this.gameBoard = gameBoard;
		this.sign = sign;
	}
	
	public void setPlayer() {
		isPlayer = true;
	}
	
	public boolean getIsPlayer() {
		return isPlayer;
	}
	
	public GameStatus getGameStatusDependingOnIsPlayer() {
		if (isPlayer) {
			return GameStatus.PLAYER_WON;
		}
		return GameStatus.COMPUTER_WON;
	}
	
	public Signs getSign() {
		return sign;
	}

	public boolean hasWon(Signs sign) {		
		if (hasWonInRows(sign)) {
			return true;
		} else if (hasWonInColumns(sign)) {
			return true;
		} else if (hasWonInDiagonals1(sign)) {
			return true;
		} else if (hasWonInDiagonals2(sign)) {
			return true;
		} else {
			return false;
		}
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
		for (int diagonal = 0; diagonal < 3; diagonal++) {
			if (gameBoard[diagonal][diagonal] == sign) {
				correct.add(sign);
			}
		}
		if (correct.size() == 3) {
			return true;
		}
		return false;
	}
	
	public boolean hasWonInDiagonals2(Signs sign) {
		ArrayList<Signs> correct = new ArrayList<Signs>();
		int column = 2;
		for (int diagonal = 0; diagonal < 3; diagonal++) {
			if (gameBoard[diagonal][column] == sign) {
				correct.add(sign);
			}
			column--;
		}
		if (correct.size() == 3) {
			return true;
		}
		return false;
	}
}
