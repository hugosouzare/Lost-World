package model;

import exceptions.EquipsException;

public abstract class Helmet extends Item {
	int def;

	public Helmet() {

	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}


	public abstract void equip(Player p) throws EquipsException;

	public abstract void unequip(Player p) throws EquipsException;

}