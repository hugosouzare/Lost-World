package view;

import java.util.Scanner;


import controller.Fachada;
import controller.IBpRepository;
import controller.IHelmetRepository;
import controller.Util;
import exceptions.EquipsException;
import exceptions.PlayerException;
import model.Helmet;
import model.Item;
import model.LeatherHelmet;
import model.Player;
import model.SteelHelmet;

public class GoslingShop {
    
	static IBpRepository bprepo = Fachada.getInstancy();
	static IHelmetRepository hrepo = Fachada.getInstancy();
	static Scanner s = new Scanner(System.in);
	private Scanner s1;
	private Scanner s12;
 
	public void helmetshop(Player p) {
		
		if (hrepo.isRepoEmpty()) {
			Helmet lh = new LeatherHelmet();
			Helmet sh = new SteelHelmet();
			hrepo.add(lh);
			hrepo.add(sh);
		}
		int opcao = 0;
		Util.clear();
		System.out.println("     .-\"\"-.\r\n" + "      /-.{}  \\\r\n" + "      | _\\__.|\r\n" + "      \\/^)^ \\/\r\n"
				+ "       \\ =  /\r\n" + "  .---./`--`\\.--._\r\n" + " /     `;--'`     \\\r\n"
				+ ";        /`       ;\r\n" + "|       |*        |\r\n" + "/   |   |     |    \\\r\n"
				+ "|    \\  |*    /    |\r\n" + "\\_   |\\_|____/|  __/\r\n" + "  \\__//======\\\\__/\r\n"
				+ "  / //_      _\\\\ \\\r\n" + "  -'  |`\"\"\"\"`|  `-\r\n" + "      |  L   |\r\n"
				+ "      >_ || _<\r\n" + "      |  ||  |\r\n" + "      |  ||  |\r\n" + "     /   ||   \\\r\n"
				+ "    /    /,    \\\r\n" + "     `|\"|`\"|\"|\"`\r\n" + "     /  )  /  )  " + "    /__/  /__/");
		System.out.println("Hello " + p.getName() + ", what bring you here?");
		do {
			System.out.println("1 - BUY");
			System.out.println("2 - SELL");
			System.out.println("3 - BACK");
			opcao = s.nextInt();
			switch (opcao) {
			case 1:
				Util.clear();
				helmetSection(p);
				break;
			case 2:
				Util.clear();
				sellSection(p);
				break;
			case 3:
				Util.clear();
				opcao = 0;
				break;
			default:
				System.out.println("Invalid option");
				break;
			}

		} while (opcao != 0);

	}

	private void helmetSection(Player p) {
		s12 = new Scanner(System.in);
		String option = null;
		int opti = 0;
		System.out.println("Ok, here are the options");
		hrepo.read();
		System.out.println("\nTell me the name of wich helmet you want");
		option = s12.nextLine();
		if (hrepo.existsHelmet(option)) {
			Item h = new Item();
			try {
				h = hrepo.searchByName(option);
			} catch (EquipsException e1) {
				System.out.println(e1.getMessage());
			}
			System.out
					.println("Ok, you want the " + h.getName() + " alright? it will cost " + h.getPrice() + " to you");
			System.out.println("1 - YES");
			System.out.println("2 - NO");
			opti = s.nextInt();
			switch (opti) {
			case 1:
				try {
					Util.buy(p, h);
					try {
						hrepo.delete(option);
					} catch (EquipsException e) {
						System.out.println(e.getMessage());
					}
				} catch (PlayerException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				break;
			}

		}

		else {
			System.out.println("Sorry, can't find any helmet with this name");
		}
	}

	private void sellSection(Player p) {
		s1 = new Scanner(System.in);
	    int opt = 0;
		String helm = null;
		System.out.println("Ok, tell the name of the helmet that you wanna sell to me ");
		helm = s1.nextLine();
		try {
			Item h = (Helmet) new Item();
			h = (Helmet) bprepo.returnItem(p, helm);
			if (!hrepo.existsHelmet(helm)) {
				System.out.println("Yes, i'm interested in your helmet. i offer you " + h.getPrice() + ". Deal?");
				System.out.println("1 - YES");
				System.out.println("2 - NO");
				opt = s.nextInt();
				if (opt == 1) {
					bprepo.delete(h.getItemID(), p.getInventory().getBackpack());
					p.setGold(p.getGold() + h.getPrice());
					System.out.println("Thanks");
					hrepo.add((Helmet)h);
				}
			}
		} catch (EquipsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
