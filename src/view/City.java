package view;

import java.util.Scanner;

import controller.Util;
import model.Player;

public class City {

	Scanner s = new Scanner(System.in);

	public void market(Player p) {

		Util.clear();
		int opcao = 0;
		
		System.out.println("Welcome to Java's Market center! Choose one option");
		do {
			System.out.println("                                                           |>>>\r\n"
					+ "                   _                      _                |\r\n"
					+ "    ____________ .' '.    _____/----/-\\ .' './========\\   / \\\r\n"
					+ "   //// ////// /V_.-._\\  |.-.-.|===| _ |-----| u    u |  /___\\\r\n"
					+ "  // /// // ///==\\ u |.  || | ||===||||| |T| |   ||   | .| u |_ _ _ _ _ _\r\n"
					+ " ///////-\\////====\\==|:::::::::::::::::::::::::::::::::::|u u| U U U U U\r\n"
					+ " |----/\\u |--|++++|..|'''''''''''::::::::::::::''''''''''|+++|+-+-+-+-+-+\r\n"
					+ " |u u|u | |u ||||||..|              '::::::::'           |===|>=== _ _ ==\r\n"
					+ " |===|  |u|==|++++|==|              .::::::::.           | T |....| V |..\r\n"
					+ " |u u|u | |u ||HH||         \\|/    .::::::::::.\r\n"
					+ " |===|_.|u|_.|+HH+|_              .::::::::::::.              _\r\n"
					+ "                __(_)___         .::::::::::::::.         ___(_)__\r\n"
					+ "---------------/  / \\  /|       .:::::;;;:::;;:::.       |\\  / \\  \\-------\r\n"
					+ "______________/_______/ |      .::::::;;:::::;;:::.      | \\_______\\________\r\n"
					+ "|       |     [===  =] /|     .:::::;;;::::::;;;:::.     |\\ [==  = ]   |\r\n"
					+ "|_______|_____[ = == ]/ |    .:::::;;;:::::::;;;::::.    | \\[ ===  ]___|____\r\n"
					+ "     |       |[  === ] /|   .:::::;;;::::::::;;;:::::.   |\\ [=  ===] |\r\n"
					+ "_____|_______|[== = =]/ |  .:::::;;;::::::::::;;;:::::.  | \\[ ==  =]_|______\r\n"
					+ " |       |    [ == = ] /| .::::::;;:::::::::::;;;::::::. |\\ [== == ]      |\r\n"
					+ "_|_______|____[=  == ]/ |.::::::;;:::::::::::::;;;::::::.| \\[  === ]______|_\r\n"
					+ "   |       |  [ === =] /.::::::;;::::::::::::::;;;:::::::.\\ [===  =]   |\r\n"
					+ "___|_______|__[ == ==]/.::::::;;;:::::::::::::::;;;:::::::.\\[=  == ]___|_____");

			System.out.println("1 - DIEGO'S WEAPON STORE");
			System.out.println("2 - CORDEL'S BANK");
			System.out.println("3 - GOSLING'S  ARMOR SHOP");
			System.out.println("4 - BACK TO HOUSE");

			while (!s.hasNextInt()) {
				s.nextLine();
			}

			opcao = s.nextInt();

			switch (opcao) {
			case 1:
				weaponStore(p);
				break;
			case 2:
			    bankCordel(p);
				break;
			case 3:
				goslingShop(p);
				break;
			case 4:
				Util.clear();
				opcao = 0;
				break;
			default:
				Util.clear();
				System.out.println("Invalid Option");
				break;
			}
		} while (opcao != 0);
	}

	private void weaponStore(Player p) {
       WeaponStore ws = new WeaponStore();
       ws.enter(p);
	}
	
	private void bankCordel(Player p) {
		Bank b = new Bank();
		b.cordel(p);
	}
	
	private void goslingShop(Player p) {
		GoslingShop g = new GoslingShop();
		g.helmetshop(p);
	}
}