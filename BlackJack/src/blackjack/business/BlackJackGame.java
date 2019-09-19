package blackjack.business;

import blackjack.domain.*;

public class BlackJackGame {
	
	private Deck deck = new Deck();
	private Hand player = new Hand(), dealer = new Hand();
	
	private GameStatus status = GameStatus.ONGOING;

	public BlackJackGame() {
		player.take(deck.draw());
		player.take(deck.draw());
		
		dealer.take(deck.draw());
		dealer.take(deck.draw());	
	}
	
	public void hit() {
		if (status != GameStatus.ONGOING) {
			throw new IllegalStateException("Game already finished.");
		}
		
		player.take(deck.draw());
		
		if (21 < player.getScore()) {
			dealerActs();
		}
	}
	
	private void dealerActs() {
		if (21 < player.getScore()) {
			status = GameStatus.DEALER_WON;
			return;
		}
		while(dealer.getScore() < player.getScore() && 21 < dealer.getScore()) {
			dealer.take(deck.draw());
			
			if (21 < dealer.getScore()) {
				status = GameStatus.PLAYER_WON;
				return;
			}
		}
		
		status = dealer.getScore() <= player.getScore() ? 
				GameStatus.PLAYER_WON : GameStatus.DEALER_WON;
		
	}

	public void stand() {
		if (status != GameStatus.ONGOING) {
			throw new IllegalStateException("Game already finished.");
		}
		dealerActs();
	}

	public Hand getPlayer() {
		return player;
	}

	public Hand getDealer() {
		return dealer;
	}

	public GameStatus getStatus() {
		return status;
	}
	
	
	

}
