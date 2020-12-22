package model;

public class Status {

	private int hp;
	private int currenthp;
	private int attack;
	private int def;
	private int mana;
	private int currentmana;
	private int magicpower;

	public Status(int hp, int attack, int def, int mana, int magicpower, int currenthp, int currentmana) {
		this.hp = hp;
		this.attack = attack;
		this.def = def;
		this.mana = mana;
		this.magicpower = magicpower;
		this.currenthp = currenthp;
		this.currentmana = currentmana;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHp() {
		return hp;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getAttack() {
		return attack;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getDef() {
		return def;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getMana() {
		return mana;
	}

	public void setMp(int magicpower) {
		this.magicpower = magicpower;
	}

	public int getMp() {
		return magicpower;
	}

	public void setCurrentHP(int currenthp) {
		this.currenthp = currenthp;

	}

	public int getCurrentHP() {
		return currenthp;
	}

	public int getCurrentmana() {
		return currentmana;
	}

	public void setCurrentmana(int currentmana) {
		this.currentmana = currentmana;
	}
}
