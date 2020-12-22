package model;

import exceptions.EquipsException;

public abstract class Weapon extends Item {
	private int atk;
	private int type;

	public Weapon() {
		
	}
	
	public int getAtk() {
		return atk;
	}
	
	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
    

	public abstract void equip(Player p) throws EquipsException;

	public abstract void unequip(Player p) throws EquipsException;
}