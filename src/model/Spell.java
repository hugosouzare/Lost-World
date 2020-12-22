package model;

import exceptions.PlayerException;

public abstract class Spell {

	protected String name;
	protected int id;
	protected int manacost;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public abstract void cast(Player p) throws PlayerException;
	public abstract void cast(Player p, Monster m) throws PlayerException;
}