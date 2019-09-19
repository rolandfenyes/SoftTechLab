package blackjack.domain;

public enum CardShapes {
	
	TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), 
	SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9), 
	TEN("10", 10), JACK("J", 10), QUEEN("Q", 10), KING("K", 10),
	ACE("A", 1);
	
	private String symbol;
	private int value;

	private CardShapes(String symbol, int value) {
		this.symbol = symbol;
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public String toString() {
		return symbol;
	}
	
}
