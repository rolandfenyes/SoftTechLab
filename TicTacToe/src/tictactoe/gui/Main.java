package tictactoe.gui;

import java.util.Scanner;

import tictactoe.business.GameStatus;
import tictactoe.business.TicTacToeGame;
import tictactoe.domain.Fields;
import tictactoe.domain.Signs;

public class Main {
	
	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		Fields player = new Fields(game.getGameBoard(), Signs.X);
		Fields enemy = new Fields(game.getGameBoard(), Signs.O);
		
		Scanner scanner = new Scanner(System.in);
		
		int[] enemyCoordinates = new int[2];
		enemyCoordinates[0] = 0;
		enemyCoordinates[1] = 0;
		
		while (game.getStatus() == GameStatus.ONGOING) {
			System.out.println("Type a coordinate. (x, y), (0-2)");
			String cmd = scanner.nextLine();
			int[] coordinates = transformInput(cmd);
			while (true) {
				try {
					game.put(coordinates[0], coordinates[1], player.getSign());
					break;
				} catch (IllegalStateException e){
					System.out.println(e.getMessage());
				}
			}
			if (player.hasWon(player.getSign())) {
				game.setStatus(GameStatus.PLAYER_WON);
				game.drawTable();
				break;
			}while (true) {
				try {
					game.put(enemyCoordinates[0], enemyCoordinates[1], enemy.getSign());					
					break;
				} catch (IllegalStateException e){
					enemyCoordinates = enemyCoordinateChanger(enemyCoordinates);
				}
			}
			
			if (enemy.hasWon(enemy.getSign())) {
				game.setStatus(GameStatus.COMPUTER_WON);
				game.drawTable();
				break;
			}
			enemyCoordinates = enemyCoordinateChanger(enemyCoordinates);
			game.drawTable();
		}
		System.out.println(game.getStatus() == GameStatus.PLAYER_WON ? "You won!" : "You lost!");
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

}
