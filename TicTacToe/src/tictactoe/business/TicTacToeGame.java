package tictactoe.business;

import java.util.ArrayList;

import tictactoe.domain.Signs;
import tictactoe.domain.Table;

public class TicTacToeGame {
	
	private Table table = new Table();
	private Signs[][] gameBoard = table.getGameBoard();
	private GameStatus status = GameStatus.ONGOING;
	
	public TicTacToeGame() {
		
	}
	
	public void put(int x, int y, Signs correctSign) {
		if (gameBoard[x][y]== Signs.URES) {
			gameBoard[x][y] = correctSign;
			return;
		}
		throw new IllegalStateException("Selected field has already reserved.");	
	}
	
	public void drawTable() {
		table.drawTable();
	}
	
	public Signs[][] getGameBoard(){
		return gameBoard;
	}
	
	public GameStatus getStatus()
	{
		return status;
	}
	
	public void setStatus(GameStatus status) {
		this.status = status;
	}
}
