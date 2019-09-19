package tictactoe.domain;

public enum Signs {
	
	X("X"), O("O"), URES(" ");
	
	private String sign;
	
	private Signs(String sign) {
		this.sign = sign;
	}
	
	public String getSign() {
		return sign;
	}

}
