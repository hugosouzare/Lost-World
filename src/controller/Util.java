package controller;

import java.util.Scanner;

import exceptions.AccountException;
import exceptions.EquipsException;
import exceptions.PlayerException;
import model.*;

public class Util {

	static Scanner s = new Scanner(System.in);
	static IAccountRepository accRepo = Fachada.getInstancy();
	static IPlayerRepository playerRepo = Fachada.getInstancy();
	static IBpRepository bpRepo = Fachada.getInstancy();
	static IBankRepository bankRepo = Fachada.getInstancy();

	public static int monsterPercentHP(Monster p) {
		int hp = p.getStatus().getCurrentHP();
		int chp = p.getStatus().getCurrentHP();
		int percent = (100 * chp) / hp;
		return percent;
	}

	public static void create() {

		Player[] players = new Player[5];
		System.out.println("Please, tell me your account name");
		String acc = s.next();
		System.out.println("Now tell me your password");
		String pass = s.next();

		Conta account = new Conta(acc, pass, players);

		try {
			accRepo.insertAccount(account);
			System.out.println("\n");
			System.out.println("Account Created");
			System.out.println("\n");
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void create(Conta a) throws PlayerException {
		Status g = new Status(Constants.basehp, Constants.baseattack, Constants.basedef, Constants.basemana,
				Constants.basemp, Constants.basehp, Constants.basemana);
		System.out.println("Please, tell your character name");
		String name = s.next();
		System.out.println("Now tell your vocation: \n1 - Sorcerer \n2 - Knight \n3 - Archer \n4 - Thief");
		String voca = null;
		while (!s.hasNextInt()) {
			System.out.println("Only number is allowed. 1 - Sorcerer, 2 - Knight, 3 - Archer, 4 - Thief");
			s.nextLine();
		}
		int vocan = s.nextInt();

		switch (vocan) {
		case 1:
			voca = "Sorcerer";
			break;
		case 2:
			voca = "Knight";
			break;
		case 3:
			voca = "Archer";
			break;
		case 4:
			voca = "Thief";
			break;

		}

		Item[] it = new Item[20];
		BackPack bp = new BackPack(it);
		Inventory inventory = new Inventory(null, null, bp);

		Player p = new Player(g, name, Constants.baselevel, 1000, 0, voca, false, inventory, 0);

		try {
			playerRepo.insertPlayer(p);
			playerRepo.insertPlayerIntoAccount(a, p);
		} catch (PlayerException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void inventory(Player p) {
		if (p.getInventory().getWeapon() == null) {
			System.out.println("Weapon: None");
		} else {
			System.out.println("Weapon: " + p.getInventory().getWeapon().getName());
		}

		if (p.getInventory().getHelmet() == null) {
			System.out.println("Helmet: None");
		}

		else {
			System.out.println("Helmet: " + p.getInventory().getHelmet().getName());
		}
		System.out.println("\n");
		System.out.println("BACKPACK: \n\n");
		bpRepo.read(p.getInventory().getBackpack());
		System.out.println("\n");
	}

	public static void buy(Player p, Item s) throws PlayerException {
		if (p.getGold() < s.getPrice()) {
			throw new PlayerException("You don't have enough gold");
		}

		try {
			bpRepo.add(s, p.getInventory().getBackpack());
			System.out.println("You buy a " + s.getName());
		} catch (EquipsException e) {
			System.out.println(e.getMessage());
		}
	}

	public static PlayerObject battleWinner(Player p, Monster m) {
		int opcao = 0;
		do {
			clear();
			m.draw();
			m.words();
			System.out.println("Your HP: " + p.getStatus().getCurrentHP() + "/" + p.getStatus().getHp());
			System.out.println(m.getName() + " HP: " + m.getStatus().getCurrentHP() + "/" + m.getStatus().getHp());
			System.out.println("\nYour mana: " + p.getStatus().getCurrentmana() + "/" + p.getStatus().getMana());
			System.out.println("1 - ATTACK");
			System.out.println("2 - HEAL");
			opcao = s.nextInt();
			if (opcao == 1) {
				battle(p, m);
			}

			if (opcao == 2) {
				Spell s = new HealSpell();
				try {
					s.cast(p);
				} catch (PlayerException e) {
					System.out.println(e.getMessage());
				}
			}
		} while (p.getStatus().getCurrentHP() > 0 & m.getStatus().getCurrentHP() > 0);

		if (p.getStatus().getCurrentHP() == 0) {
			System.out.println("GAME OVER");
			System.exit(0);
		}

		if (m.getStatus().getCurrentHP() == 0) {
			clear();
			p.setGold(p.getGold() + m.getGold());
			p.setExp(p.getExp() + m.getExp());
			System.out.println("Your HP: " + p.getStatus().getCurrentHP() + "/" + p.getStatus().getHp());
			System.out.println(m.getName() + " HP: " + m.getStatus().getCurrentHP() + "/" + m.getStatus().getHp());
			System.out.println("You defeated the " + m.getName() + "\n\n");
			return p;
		}

		else {
			return p;
		}
	}

	public static void battle(Player p, Monster m) {
		int playerdmg = (p.getStatus().getAttack() * 5) - (m.getStatus().getDef() * 5);
		int monsterdmg = (m.getStatus().getAttack() * 5) - (p.getStatus().getDef() * 5);

		p.getStatus().setCurrentHP(p.getStatus().getCurrentHP() - monsterdmg);
		m.getStatus().setCurrentHP(m.getStatus().getCurrentHP() - playerdmg);
		if (p.getStatus().getCurrentHP() < 0) {
			p.getStatus().setCurrentHP(0);
		}

		if (m.getStatus().getCurrentHP() < 0) {
			m.getStatus().setCurrentHP(0);
		}
	}

	public static void createBankAcc(Player p) {
		BankAccount ori = new BankAccount(1, 1);
		while (bankRepo.hasaccount()) {
			try {
				bankRepo.insertAcc(ori);
			} catch (PlayerException e) {
				System.out.println(e.getMessage());
			}
		}

		int ID = bankRepo.lastID() + 1;
		int gold = 0;

		BankAccount b = new BankAccount(gold, ID);

		try {
			bankRepo.insertAcc(b);
			p.setBankid(ID);
			System.out.println("Alright " + p.getName()
					+ ", your account was created. It will be a pleasure to have you in our client list");
		} catch (PlayerException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void clear() {
		System.out.println(
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}
