package tictactoe.gui;

import tictactoe.business.GameStatus;
import tictactoe.business.TicTacToeGame;
import tictactoe.domain.Fields;
import tictactoe.domain.Signs;

public class Main {
	
	private static TicTacToeGame game = new TicTacToeGame();
	private static Fields player = new Fields(game.getGameBoard(), Signs.X);
	private static Fields enemy = new Fields(game.getGameBoard(), Signs.O);

	
	public static void main(String[] args) {
		
		player.setPlayer();
		
		int[] enemyCoordinates = new int[2];
		enemyCoordinates[0] = 0;
		enemyCoordinates[1] = 0;
		
		while (game.getStatus() == GameStatus.ONGOING) {
			
			game.step(player);
			
			if (checkIfPlayerWon(player)) {
				game.setStatus(GameStatus.PLAYER_WON);
				game.drawTable();
			}
			game.step(enemyCoordinates, enemy);
			
			if (checkIfPlayerWon(enemy)) {
				game.setStatus(GameStatus.COMPUTER_WON);
				game.drawTable();
				break;
			}
			
			enemyCoordinates = TicTacToeGame.enemyCoordinateChanger(enemyCoordinates);
			game.drawTable();
		}
		
		System.out.println(game.getStatus() == GameStatus.PLAYER_WON ? "You won!" : "You lost!");
	}
	
	public static boolean checkIfPlayerWon(Fields actualPlayer) {
		if (actualPlayer.hasWon(actualPlayer.getSign())) {
			return true;
		}
		return false;
	}

}
