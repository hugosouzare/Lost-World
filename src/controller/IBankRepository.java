package controller;

import exceptions.PlayerException;
import model.BankAccount;
import model.Player;

public interface IBankRepository {

	public abstract void insertAcc(BankAccount b) throws PlayerException;
	public abstract int lastID();
	public abstract void deposit(int qnt, Player p) throws PlayerException;
	public abstract BankAccount searchId(int id);
	public abstract void withdraw(int qnt, Player p) throws PlayerException;
	public abstract void transfer(int qnt, String name, Player ps) throws PlayerException;
	public abstract boolean hasaccount();
	
}
