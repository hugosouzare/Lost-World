package controller;

import exceptions.EquipsException;
import model.BackPack;
import model.Item;
import model.Player;

public interface IBpRepository {
	public abstract void read(BackPack bp);
	public abstract void delete(int it, BackPack bp) throws EquipsException;
	public abstract void add(Item it, BackPack bp) throws EquipsException;
	public abstract boolean hasItem(int id, BackPack bp) throws EquipsException;
	public boolean hasItem(String name, BackPack bp) throws EquipsException;
	public Item returnItem (Player p, String name) throws EquipsException;
	
}
