package view;

import java.util.Scanner;
import controller.Fachada;
import controller.IBpRepository;
import controller.Util;
import exceptions.EquipsException;
import exceptions.PlayerException;
import model.Constants;
import model.DiegoPackage;
import model.Item;
import model.Monster;
import model.Player;
import model.PlayerObject;
import model.SpecialItens;
import model.Status;
import model.Wolf;

public class Adventure {
	private static int st = 0;
	static IBpRepository bpRepo = Fachada.getInstancy();
	Scanner s = new Scanner(System.in);

	public void forest(Player p) throws PlayerException {
		if (p.getAccess() < 1) {
			throw new PlayerException("Wait " + p.getName()
					+ ", this way is too dangerous! Go to the city and talk to Diego Souza to get some help!");
		}

		else if (p.getAccess() == 1) {
			Util.clear();
			if (st == 0) {
				wolfQuest(p);
			}

			else {
				System.out.println("Deliver the package to Diego to get more adventures");
			}
		}

		else if (p.getAccess() == 2) {
			Util.clear();
			System.out.println("WE DON'T HAVE MORE QUESTS TO YOU, THANKS TO TRY OUT THE LOST WORLD BETA.");
		}

	}

	private void fightWolf(Player p) {
		int opcao = 0;
		Item pac = new Item();
		Util.clear();

		Wolf m = new Wolf();

		PlayerObject winner = Util.battleWinner(p, m);
		if (winner == p) {
			System.out.println("1 - Take the package");
			while (opcao != 1) {
				opcao = s.nextInt();
			}
			Util.clear();
			System.out.println("You found the Diego's package!");
			pac = new DiegoPackage();
			st = 1;
			try {
				bpRepo.add(pac, p.getInventory().getBackpack());
			} catch (EquipsException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void wolfQuest(Player p) {
		Util.clear();
		int opcao = 0;
		do {
			System.out.println("         /\\\r\n" + "         /**\\\r\n" + "        /****\\   /\\\r\n"
					+ "       /      \\ /**\\\r\n"
					+ "      /  /\\    /    \\        /\\    /\\  /\\      /\\            /\\/\\/\\  /\\\r\n"
					+ "     /  /  \\  /      \\      /  \\/\\/  \\/  \\  /\\/  \\/\\  /\\  /\\/ / /  \\/  \\\r\n"
					+ "    /  /    \\/ /\\     \\    /    \\ \\  /    \\/ /   /  \\/  \\/  \\  /    \\   \\\r\n"
					+ "   /  /      \\/  \\/\\   \\  /      \\    /   /    \\\r\n"
					+ "__/__/_______/___/__\\___\\__________________________________________________");
			System.out.println("JAVA'S Mountains");
			System.out.println("A wild wolf appears");
			System.out.println("1 - FIGHT");
			System.out.println("2 - RUN");
			opcao = s.nextInt();

			switch (opcao) {
			case 1:
				fightWolf(p);
				opcao = 0;
				break;
			case 2:
				opcao = 0;
				break;
			}
		} while (opcao != 0);
	}
}
