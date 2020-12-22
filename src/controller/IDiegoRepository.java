package controller;

import exceptions.EquipsException;
import model.Weapon;

public interface IDiegoRepository {
	public void add(Weapon w) throws EquipsException;
	public boolean existsWeapon(String name);
	public void deleteWeapon(String name);
	public Weapon search(String name) throws EquipsException;
	public void read();
	public boolean isEmpty();
}
