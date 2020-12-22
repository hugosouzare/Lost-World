package view;

import model.*;
import controller.*;
import exceptions.PlayerException;

import java.util.Scanner;

public class GameStart {

	Scanner s = new Scanner(System.in);

	public void startChar(Player p) {
		int opcao = 0;
		Util.clear();

		System.out.println("You are in home " + p.getName() + ". Choose one option");
		do {
			System.out.println("     _|=|__________\r\n" + "    /              \\\r\n" + "   /                \\\r\n"
					+ "  /__________________\\\r\n" + "   ||  || /--\\ ||  ||\r\n" + "   ||[]|| | .| ||[]||\r\n"
					+ " ()||__||_|__|_||__||()\r\n" + "( )|-|-|-|====|-|-|-|( ) \r\n" + "^^^^^^^^^^====^^^^^^^^^^^");
			System.out.println("1 - GO TO CITY MARKET");
			System.out.println("2 - GO TO ADVENTURE");
			System.out.println("3 - CHECK INVENTORY");
			System.out.println("4 - LOGOUT");
			while (!s.hasNextInt()) {
				s.nextLine();
			}

			opcao = s.nextInt();

			switch (opcao) {
			case 1:
				cityMarket(p);
				break;
			case 2:
				adventure(p);
				break;
			case 3:
				Util.clear();
				Util.inventory(p);
				break;
			case 4:
				opcao = 0;
				break;
			default:
				System.out.println("Invalid Option");
			}

		} while (opcao != 0);

	}

	private void cityMarket(Player p) {
		City city = new City();
		city.market(p);
	}

	private void adventure(Player p) {
        Adventure ad = new Adventure();
        try {
			ad.forest(p);
		} catch (PlayerException e) {
			Util.clear();
			System.out.println(e.getMessage());
		}
	}
}