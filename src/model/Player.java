package model;

public class Player extends PlayerObject {

	private String vocation;
	private boolean hasaccount;
	private Inventory inventory;
	private int access;
	private int bankid;

	public Player() {
		super();
	}
	
	public Player(Status status, String name, int level, int gold, int exp, String vocation, boolean hasaccount, Inventory inventory, int access) {
		super(status, name, level, gold, exp);
		this.vocation = vocation;
		this.hasaccount = hasaccount;
		this.inventory = inventory;
		this.access = access;
	}
	
	public String getVocation() {
		return vocation;
	}
	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
	public boolean isHasaccount() {
		return hasaccount;
	}
	public void setHasaccount(boolean hasaccount) {
		this.hasaccount = hasaccount;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory (Inventory inventory) {
		this.inventory = inventory;
	}
	
	public int getAccess() {
		return access;
	}
	
	public void setAccess(int access) {
		this.access = access;
	}
	
	public int getBankid() {
		return bankid;
	}
	
	public void setBankid(int bankid) {
		this.bankid = bankid;
	}
}