package controller;

import exceptions.AccountException;
import model.Conta;

public interface IAccountRepository {

	public void insertAccount(Conta a) throws AccountException;
	public Conta loginSuccess(String acc, String pass);
	public void removeAccount(Conta c) throws AccountException;
}
