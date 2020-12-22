package controller;

import exceptions.EquipsException;
import model.Helmet;

public interface IHelmetRepository {
	public void add(Helmet h);
	public boolean existsHelmet(String name);
	public void delete(String name) throws EquipsException;
	public Helmet searchByName(String name) throws EquipsException;
	public void updatePrice(String name, int price);
	public void read();
	public boolean isRepoEmpty();
}
