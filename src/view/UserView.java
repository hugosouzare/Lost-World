package view;

import model.*;
import java.util.Scanner;
import javax.security.auth.login.AccountException;
import controller.*;
import exceptions.PlayerException;

public class UserView {

	static Scanner s = new Scanner(System.in);

	public void inGame(Conta a) {
		int option = 0;

		do {
			Util.clear();
			System.out.println("  _     ___   ___  _____  __      __ ___   ___  _     ___  \r\n"
					+ " | |   / _ \\ / __||_   _| \\ \\    / // _ \\ | _ \\| |   |   \\ \r\n"
					+ " | |__| (_) |\\__ \\  | |    \\ \\/\\/ /| (_) ||   /| |__ | |) |\r\n"
					+ " |____|\\___/ |___/  |_|     \\_/\\_/  \\___/ |_|_\\|____||___/ \r\n"
					+ "                                                           ");
			System.out.println("--------------------------------");
			System.out.println("1 - Select Character");
			System.out.println("2 - Create New Character");
			System.out.println("\n\n0 - Logout");
			System.out.println("--------------------------------");
			try {
				showPlayers(a);
			}

			catch (AccountException e) {

			}
			option = s.nextInt();

			switch (option) {

			case 1:
				try {
					selectChar(a);
				} catch (AccountException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				Util.clear();
				try {
					Util.create(a);
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

		} while (option != 0);
	}

	private void showPlayers(Conta a) throws AccountException {

		if (a.getPlayers()[0] == null) {
			System.out.println("You don't have any character yet");
		}

		else {
			for (int i = 0; i < a.getPlayers().length; i++) {
				if (a.getPlayers()[i] != null) {
					System.out.println(i + 1 + " - " + a.getPlayers()[i].getName() + "          "
							+ a.getPlayers()[i].getVocation());
				}
			}
		}
	}

	

	private void selectChar(Conta a) throws AccountException {

		Util.clear();
		int contaux = 0;

		for (int i = 0; i < a.getPlayers().length; i++) {
			if (a.getPlayers()[i] == null) {
				contaux++;
			}
		}
		if (contaux == 5) {
			throw new AccountException("This account don't have any character");
		}

		else {
			int cont = 0;
			for (int o = 0; o < a.getPlayers().length; o++) {
				if (a.getPlayers()[o] != null) {
					cont++;
				}
			}

			System.out.println("Select the number of the character that you wanna play: ");
			try {
				showPlayers(a);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			int charchose = s.nextInt();
			charchose--;

			if (a.getPlayers()[charchose] != null) {
				GameStart lw = new GameStart();
				lw.startChar(a.getPlayers()[charchose]);
			}

			else {
				System.out.println("You don't have any characters");
			}
		}
	}
}
