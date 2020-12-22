package view;

import controller.*;
import model.*;
import java.util.Scanner;
import javax.security.auth.login.AccountException;

public class Login {

	static Scanner s = new Scanner(System.in);
	static IAccountRepository accRepo = Fachada.getInstancy();
	public void logarA() {
		Conta conta = null;
		int opcao = 0;

		Util.clear();

		do {

			System.out.println("1 - LOGIN");
			System.out.println("2 - BACK");
			while (!s.hasNextInt()) {
				s.nextLine();
			}

			opcao = s.nextInt();

			switch (opcao) {
			case 1:
				try {
					loginAcc();
				} catch (AccountException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				opcao = 0;
				break;
			default:
				System.out.println("Invalid Option");
				break;
			}

		}

		while (opcao != 0);

	}

	private void loginAcc() throws AccountException {
		Util.clear();
		System.out.println("Account: ");
		String acc = s.next();
		System.out.println("Password: ");
		String pass = s.next();

		Conta conta = accRepo.loginSuccess(acc, pass);

		if (conta != null) {
			playAcc(conta);
		}

		else {
			throw new AccountException("Suas credenciais não batem");
		}
	}

	private void playAcc(Conta conta) {
		UserView user = new UserView();
		user.inGame(conta);

	}
}
