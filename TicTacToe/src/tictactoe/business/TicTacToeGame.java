package tictactoe.business;

import java.util.Scanner;

import tictactoe.domain.Fields;
import tictactoe.domain.Signs;
import tictactoe.domain.Table;

public class TicTacToeGame {
	
	private Table table = new Table();
	private Signs[][] gameBoard = table.getGameBoard();
	private GameStatus status = GameStatus.ONGOING;
	private static Scanner scanner = new Scanner(System.in);
	
	public TicTacToeGame() {
		
	}
	
	public void step(Fields actualPlayer) {
		while (true) {
			String input = input();
			int[] coordinates = transformInput(input);
			try {
				put(coordinates[0], coordinates[1], actualPlayer.getSign());
				break;
			} catch (IllegalStateException error){
				coordinates = handleException(error, actualPlayer, coordinates);
			}
		}
	}
	
	public void step(int[] coordinates, Fields actualPlayer) {
		while (true) {
			try {
				put(coordinates[0], coordinates[1], actualPlayer.getSign());
				break;
			} catch (IllegalStateException error){
				coordinates = handleException(error, actualPlayer, coordinates);
			}
		}
	}
	
	public static int[] handleException(Exception e, Fields actualPlayer, int[] coordinates) {
		if (actualPlayer.getIsPlayer()) {
			System.out.println(e.getMessage());
			return coordinates;
		} else {
			return enemyCoordinateChanger(coordinates);
		}
	}
	
	public static String input() {
		System.out.println("Type a coordinate. (x, y), (0-2)");
		String input = scanner.nextLine();
		return input;
	}
	
	public static int[] transformInput(String cmd){
		int[] coordinates = new int[2];
		String[] coordinatesInString = cmd.split(", ");
		coordinates[0] = Integer.parseInt(coordinatesInString[0]);
		coordinates[1] = Integer.parseInt(coordinatesInString[1]);
		return coordinates;
	}
	
	public static int[] enemyCoordinateChanger(int[] coordinates) {
		if (coordinates[1] < 2) {
			coordinates[1]++;
		} else {
			coordinates[0]++;
			coordinates[1] = 0;
		}
		return coordinates;
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
