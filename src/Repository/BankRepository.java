package Repository;

import java.util.ArrayList;

import controller.Fachada;
import controller.IBankRepository;
import controller.IPlayerRepository;
import exceptions.PlayerException;
import model.BankAccount;
import model.Player;

public class BankRepository implements IBankRepository {

	private static BankRepository instancy;
	private ArrayList<BankAccount> accounts;
	static IPlayerRepository playerRepo = Fachada.getInstancy();

	private BankRepository() {
		accounts = new ArrayList<BankAccount>();
	}

	public static BankRepository getInstancy() {
		if (instancy == null) {
			instancy = new BankRepository();
		}
		return instancy;
	}

	public void insertAcc(BankAccount b) throws PlayerException {
		if (b == null) {
			throw new PlayerException("This bank account is invalid");
		}
		accounts.add(b);
	}

	public int lastID() {
		return accounts.get(accounts.size()-1).getID();
	}

	public void deposit(int qnt, Player p) throws PlayerException {
		if (p.getGold() < qnt) {
			throw new PlayerException("Sorry, you don't have enough gold");
		}

		for (BankAccount b : accounts) {
			if (b.getID() == p.getBankid()) {
				b.setGold(b.getGold() + qnt);
				p.setGold(p.getGold()-qnt);
				break;
			}
		}
	}

	public BankAccount searchId(int id) {
		for (BankAccount b : accounts) {
			if (b.getID() == id) {
				return b;
			}
		}
		return null;
	}

	public void withdraw(int qnt, Player p) throws PlayerException {
		BankAccount b = searchId(p.getBankid());

		if (b.getGold() < qnt) {
			throw new PlayerException("Sorry, your account don't have this ammount of gold");
		}

		if (qnt < 1) {
			throw new PlayerException("Sorry, you can't withdraw this value");
		}

		p.setGold(p.getGold() + qnt);
		b.setGold(b.getGold() - qnt);
	}

	public void transfer(int qnt, String name, Player ps) throws PlayerException {
		Player p = new Player();
		
	    if (name == ps.getName()) {
	    	throw new PlayerException("You can't transfer to yourself");
	    }
		
		try {
			p = playerRepo.searchPlayer(name);
			if (p == null) {
				throw new PlayerException("Invalid Player");
			}

			BankAccount b = searchId(ps.getBankid());

			if (b.getGold() < qnt) {
				throw new PlayerException("Sorry, your account don't have this ammount of gold");
			}

			if (qnt < 1) {
				throw new PlayerException("Sorry, you can't transfer this value");
			}

			BankAccount bc = searchId(p.getBankid());

			bc.setGold(bc.getGold() + qnt);
			b.setGold(b.getGold() - qnt);

		} catch (PlayerException e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean hasaccount() {
		if (accounts.isEmpty()) {
			return true;
		}
		return false;
	}
}
