package model;

public class PlayerObject {
	
	protected Status status;
	protected String name;
	protected int level;
	protected int gold;
	protected int exp;

	public PlayerObject(Status status, String name, int level, int gold, int exp) {
		this.status = status;
		this.name = name;
		this.level = level;
		this.gold = gold;
		this.exp = exp;
	}

	public PlayerObject() {

	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getGold() {
		return gold;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getExp() {
		return exp;
	}
}