package controller;

import exceptions.PlayerException;
import model.Player;
import model.Conta;

public interface IPlayerRepository {
	public void insertPlayer(Player p) throws PlayerException;
	public boolean existsPlayer(String name);
	public void deletePlayer (Player p) throws PlayerException;
	public void insertPlayerIntoAccount(Conta c, Player p) throws PlayerException;
	public Player searchPlayer(String name) throws PlayerException;
}