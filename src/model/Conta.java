package model;

public class Conta {
	private String account;
	private String password;
	private Player[] players;
	
	public Conta(String account, String password, Player[] players) {
		this.account = account;
		this.password = password;
		this.players = players;
	}
	
	public Conta() {
		
	}
	
	public void setConta(String account) {
		this.account = account;
	}

	public String getConta() {
		return account;
	}
	
	public void setPassowrd(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void setPlayers(Player[] players) {
		this.players = players;
	}
}
