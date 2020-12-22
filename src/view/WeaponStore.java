package view;

import java.util.Scanner;
import controller.Fachada;
import controller.IBpRepository;
import controller.IDiegoRepository;
import controller.Util;
import exceptions.EquipsException;
import exceptions.PlayerException;
import model.Item;
import model.Player;
import model.SteelSword;
import model.Weapon;
import model.WoodenSword;

public class WeaponStore {
	static Scanner s = new Scanner(System.in);
	static int state = 0;
	static IDiegoRepository wrepo = Fachada.getInstancy();
	static IBpRepository bpRepo = Fachada.getInstancy();

	public void enter(Player p) {

		Util.clear();
		if (p.getAccess() < 1) {
			firstQuest(p);
		}

		else if (p.getAccess() == 1) {
			Util.clear();
			int opc = 0;
			do {
				System.out.println("  .------\\ /------.\r\n" + "   |       -       |\r\n" + "   |               |\r\n"
						+ "   |               |\r\n" + "   |               |\r\n" + "_______________________\r\n"
						+ "===========.===========\r\n" + "  / ~~~~~     ~~~~~ \\\r\n" + " /|     |     |\\\r\n"
						+ " W   ---  / \\  ---   W\r\n" + " \\.      |o o|      ./\r\n" + "  |                 |\r\n"
						+ "  \\    #########    /\r\n" + "   \\  ## ----- ##  /\r\n" + "    \\##         ##/\r\n"
						+ "     \\_____v_____/");
				System.out.println("You found my package?");
				System.out.println("1 - YES");
				System.out.println("2 - NO");
				opc = s.nextInt();
				switch (opc) {
				case 1:
					if (state == 0) {
						if (bringPackage(p)) {
							state = 1;
							opc = 0;
						}

						else {
							System.out.println("Hey, you don't have my package. Back here when you have it");
						}
						break;
					}

				case 2:
					Util.clear();
					System.out.println("Alright, come back here when you have it");
					opc = 0;
					break;
				default:
					System.out.println(" ");
					break;
				}
			} while (opc != 0);
		}

		else {

			System.out.println("Hello, i'm Diego Souza and i sell a lot of weapons. Please, take a look into my store");
			int opcao = 0;
			do {
				System.out.println("  .------\\ /------.\r\n" + "   |       -       |\r\n" + "   |               |\r\n"
						+ "   |               |\r\n" + "   |               |\r\n" + "_______________________\r\n"
						+ "===========.===========\r\n" + "  / ~~~~~     ~~~~~ \\\r\n" + " /|     |     |\\\r\n"
						+ " W   ---  / \\  ---   W\r\n" + " \\.      |o o|      ./\r\n" + "  |                 |\r\n"
						+ "  \\    #########    /\r\n" + "   \\  ## ----- ##  /\r\n" + "    \\##         ##/\r\n"
						+ "     \\_____v_____/");
				System.out.println("1 - SWORDS");
				System.out.println("2 - BACK");

				while (!s.hasNextInt()) {
					s.nextLine();
				}

				opcao = s.nextInt();

				switch (opcao) {
				case 1:
					swordSection(p);
					break;
				case 2:
					opcao = 0;
					break;
				}
			} while (opcao != 0);
		}
	}

	private void swordSection(Player p) {
		String opcao = null;
		Scanner s1 = new Scanner(System.in);
		Item bs = new Item();
		int op = 0;
		Util.clear();
		System.out.println("  .------\\ /------.\r\n" + "   |       -       |\r\n" + "   |               |\r\n"
				+ "   |               |\r\n" + "   |               |\r\n" + "_______________________\r\n"
				+ "===========.===========\r\n" + "  / ~~~~~     ~~~~~ \\\r\n" + " /|     |     |\\\r\n"
				+ " W   ---  / \\  ---   W\r\n" + " \\.      |o o|      ./\r\n" + "  |                 |\r\n"
				+ "  \\    #########    /\r\n" + "   \\  ## ----- ##  /\r\n" + "    \\##         ##/\r\n"
				+ "     \\_____v_____/");
		System.out.println("Ok, here are the options");
		if (wrepo.isEmpty()) {
			Weapon ws = new WoodenSword();
			try {
				wrepo.add(ws);
			} catch (EquipsException e) {
				e.printStackTrace();
				System.exit(0);
			}
			Weapon ss = new SteelSword();
			try {
				wrepo.add(ss);
			} catch (EquipsException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		wrepo.read();
		System.out.println("Tell me the name of the Sword that you wanna buy");
		System.out.println("YOUR GOLD - " + p.getGold());
		opcao = s1.nextLine();
		try {
			bs = wrepo.search(opcao);
			Util.clear();
			System.out.println(
					"Oh, you choose " + bs.getName() + " right? It will cost " + bs.getPrice() + " to you. Deal?");
			System.out.println("1 - YES");
			System.out.println("2 - NO");
			op = s.nextInt();
			if (op == 1) {
				try {
					Util.buy(p, bs);
					p.setGold(p.getGold() - bs.getPrice());
					wrepo.deleteWeapon(bs.getName());
				} catch (PlayerException e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (EquipsException e) {
			System.out.println(e.getMessage());
		}

		if (op == 2) {

		}

	}

	private void firstQuest(Player p) {
		int opcao = 0;
		Util.clear();
		do {
			System.out.println("  .------\\ /------.\r\n" + "   |       -       |\r\n" + "   |               |\r\n"
					+ "   |               |\r\n" + "   |               |\r\n" + "_______________________\r\n"
					+ "===========.===========\r\n" + "  / ~~~~~     ~~~~~ \\\r\n" + " /|     |     |\\\r\n"
					+ " W   ---  / \\  ---   W\r\n" + " \\.      |o o|      ./\r\n" + "  |                 |\r\n"
					+ "  \\    #########    /\r\n" + "   \\  ## ----- ##  /\r\n" + "    \\##         ##/\r\n"
					+ "     \\_____v_____/");
			System.out.println(
					"Hello i'm Diego Souza and i sell a lot of weapons. Oh, you don't have money? Ok boy, i have some job to you if you are interested");
			System.out.println("1 - YES, I'M INTERESTED");
			System.out.println("2 - NO THANKS");
			opcao = s.nextInt();

			switch (opcao) {
			case 1:
				Util.clear();
				Weapon ws = new WoodenSword();
				System.out.println("  .------\\ /------.\r\n" + "   |       -       |\r\n" + "   |               |\r\n"
						+ "   |               |\r\n" + "   |               |\r\n" + "_______________________\r\n"
						+ "===========.===========\r\n" + "  / ~~~~~     ~~~~~ \\\r\n" + " /|     |     |\\\r\n"
						+ " W   ---  / \\  ---   W\r\n" + " \\.      |o o|      ./\r\n" + "  |                 |\r\n"
						+ "  \\    #########    /\r\n" + "   \\  ## ----- ##  /\r\n" + "    \\##         ##/\r\n"
						+ "     \\_____v_____/");
				System.out.println(
						"Alright, i lost a package in the mountains because i had to run of some wild wolves. Go there and bring it to me and i'll reward you. Oh, take this sword, it will help you");
				System.out.println("YOU RECEIVED A WOODEN SWORD");
				p.getInventory().setWeapon(ws);
				p.setAccess(1);
				opcao = 0;
				break;
			case 2:
				Util.clear();
				System.out.println("Ok, see you later");
				opcao = 0;
			}
		} while (opcao != 0);
	}

	private boolean bringPackage(Player p) {
		try {
			if (bpRepo.hasItem(6, p.getInventory().getBackpack())) {
				Util.clear();
				System.out.println("  .------\\ /------.\r\n" + "   |       -       |\r\n" + "   |               |\r\n"
						+ "   |               |\r\n" + "   |               |\r\n" + "_______________________\r\n"
						+ "===========.===========\r\n" + "  / ~~~~~     ~~~~~ \\\r\n" + " /|     |     |\\\r\n"
						+ " W   ---  / \\  ---   W\r\n" + " \\.      |o o|      ./\r\n" + "  |                 |\r\n"
						+ "  \\    #########    /\r\n" + "   \\  ## ----- ##  /\r\n" + "    \\##         ##/\r\n"
						+ "     \\_____v_____/");
				System.out.println(
						"Oh, you really found my package with my itens, now i can open my store again. Take this reward, it will help you in your journey");
				System.out.println("YOU RECEIVED 1000 GOLD");
				p.setGold(p.getGold() + 1000);
				p.setAccess(2);
				bpRepo.delete(6, p.getInventory().getBackpack());
				return true;
			}

		} catch (EquipsException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}
}