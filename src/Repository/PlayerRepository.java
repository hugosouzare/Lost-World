package Repository;

import java.util.ArrayList;

import controller.IPlayerRepository;
import exceptions.PlayerException;
import model.Player;
import model.Conta;

public class PlayerRepository implements IPlayerRepository {
	private static PlayerRepository instancy = null;
	private ArrayList<Player> playerList;

	private PlayerRepository() {
		playerList = new ArrayList<Player>();
	}

	public static PlayerRepository getInstancy() {
		if (instancy == null) {
			instancy = new PlayerRepository();
		}
		return instancy;
	}

	public void insertPlayer(Player p) throws PlayerException {
		if (p == null) {
			throw new PlayerException("Null Player");
		}
		if (!existsPlayer(p.getName())) {
			playerList.add(p);
		} else {
			throw new PlayerException("This name is already in use");
		}
	}

	public boolean existsPlayer(String name) {
		for (Player p : playerList) {
			if (p.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public void deletePlayer(Player p) throws PlayerException {
		if (p == null) {
			throw new PlayerException("Null Player");
		}
		if (existsPlayer(p.getName())) {
			playerList.remove(p);
		} else {
			throw new PlayerException("Sorry, can't find any characters with this name in our player base");
		}
	}

	public void insertPlayerIntoAccount(Conta c, Player p) throws PlayerException {

		if (p == null || c == null) {
			throw new PlayerException("Sorry, your account or player is invalid");
		}
		if (existsPlayer(p.getName()) && p.isHasaccount()) {
			throw new PlayerException("This players already have an account");
		}

		if (existsPlayer(p.getName()) && !p.isHasaccount()) {
			for (int i = 0; i < c.getPlayers().length; i++) {
				if (c.getPlayers()[i] == null) {
					c.getPlayers()[i] = p;
					break;
				}
			}
		}
	}
	
	public Player searchPlayer(String name) throws PlayerException {
		if (!existsPlayer(name)) {
			throw new PlayerException("This players doesn't exist");
		}
		
		for (Player p : playerList) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
}
