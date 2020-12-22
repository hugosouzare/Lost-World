package view;

import java.util.Scanner;
import controller.Fachada;
import controller.IBankRepository;
import controller.Util;
import exceptions.PlayerException;
import model.BankAccount;
import model.Player;

public class Bank {
	
	static Scanner s = new Scanner(System.in);
	static IBankRepository bankRepo = Fachada.getInstancy();
	public void cordel(Player p) {
		int opcao = 0;
		int opt = 0;
		Util.clear();

		if (p.getBankid() == 0) {

			do {
				Util.clear();
				System.out.println("               ,\r\n" + "            ,:' `..;\r\n" + "            `. ,;;'%\r\n"
						+ "            +;;'%%%%%\r\n" + "             /- %,)%%\r\n" + "             `   \\ %%\r\n"
						+ "              =  )/ \\\r\n" + "              `-'/ / \\\r\n" + "                /\\/.-.\\\r\n"
						+ "               |  (    |\r\n" + "               |  |   ||\r\n"
						+ "               |  |   ||\r\n" + "           _.-----'   ||\r\n"
						+ "          / \\________,'|\r\n" + "         (((/  |       |\r\n"
						+ "         //    |       |\r\n" + "        //     |\\      |\r\n"
						+ "       //      | \\     |\r\n" + "      //       |  \\    |\r\n"
						+ "     //        |   \\   |\r\n" + "    //         |    \\  |\r\n"
						+ "   //          |    |\\ |\r\n" + "  //           |    | \\|\r\n"
						+ " //            \\    \\\r\n" + "c'             |\\    \\\r\n"
						+ "               | \\    \\\r\n" + "               |  \\    \\\r\n"
						+ "               |.' \\    \\\r\n" + "              _\\    \\.-' \\ MJP\r\n"
						+ "             (___.-(__.'\\/");
				System.out.println(
						"Hello, i'm Alexandre Cordel, i'm the banker of Java's city. Do you wanna create an account with us?");
				System.out.println("1 - YES");
				System.out.println("2 - NO, THANKS");
				opt = s.nextInt();
				switch (opt) {
				case 1:
					Util.createBankAcc(p);
					opt = 0;
					break;
				case 2:
					Util.clear();
					opt = 0;
					break;
				default:
					System.out.println("Invalid option");
					break;
				}

			} while (opt != 0);
		}

		else {
			do {
				final BankAccount b = bankRepo.searchId(p.getBankid());
				System.out.println("               ,\r\n" + "            ,:' `..;\r\n" + "            `. ,;;'%\r\n"
						+ "            +;;'%%%%%\r\n" + "             /- %,)%%\r\n" + "             `   \\ %%\r\n"
						+ "              =  )/ \\\r\n" + "              `-'/ / \\\r\n" + "                /\\/.-.\\\r\n"
						+ "               |  (    |\r\n" + "               |  |   ||\r\n"
						+ "               |  |   ||\r\n" + "           _.-----'   ||\r\n"
						+ "          / \\________,'|\r\n" + "         (((/  |       |\r\n"
						+ "         //    |       |\r\n" + "        //     |\\      |\r\n"
						+ "       //      | \\     |\r\n" + "      //       |  \\    |\r\n"
						+ "     //        |   \\   |\r\n" + "    //         |    \\  |\r\n"
						+ "   //          |    |\\ |\r\n" + "  //           |    | \\|\r\n"
						+ " //            \\    \\\r\n" + "c'             |\\    \\\r\n"
						+ "               | \\    \\\r\n" + "               |  \\    \\\r\n"
						+ "               |.' \\    \\\r\n" + "              _\\    \\.-' \\ MJP\r\n"
						+ "             (___.-(__.'\\/");
				System.out.println("Welcome " + p.getName() + " , What you want to do now?");
				System.out.println("BALANCE: " + b.getGold());
				System.out.println("1 - DEPOSIT");
				System.out.println("2 - WITHDRAW");
				System.out.println("3 - TRANSFER");
				System.out.println("4 - BACK");
				opcao = s.nextInt();

				switch (opcao) {
				case 1:
					Util.clear();
					deposit(p);
					break;
				case 2:
					Util.clear();
					withdraw(p);
					break;
				case 3:
					Util.clear();
					transfer(p);
					break;
				case 4:
					Util.clear();
					opcao = 0;
					break;
				default:
					Util.clear();
					System.out.println("Invalid option");
				}
			} while (opcao != 0);
		}
	}

	private void deposit(Player p) {
		System.out.println("How much you want to deposit?");
		int qnt = s.nextInt();
		try {
			bankRepo.deposit(qnt, p);
			System.out.println("You deposited " + qnt + " to your account.");
		} catch (PlayerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void transfer(Player p) {
		System.out.println("Tell the person's name that you wanna transfer");
		String name = s.next();
		System.out.println("How much you want to transfer to " + name);
		int qnt = s.nextInt();

		try {
			bankRepo.transfer(qnt, name, p);
		} catch (PlayerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void withdraw(Player p) {
		System.out.println("How much you want to withdraw?");
		int qnt = s.nextInt();

		try {
			bankRepo.withdraw(qnt, p);
			System.out.println("You withdraw " + qnt);
		} catch (PlayerException e) {
			System.out.println(e.getMessage());
		}
	}
}