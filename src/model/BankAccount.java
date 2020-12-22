package model;

public class BankAccount {
	private int gold;
	private int ID;
	
	public BankAccount(int gold, int ID) {
		this.gold = gold;
		this.ID = ID;
	}
	
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}