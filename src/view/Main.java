package view;

import java.util.Scanner;
import controller.*;
import model.Conta;

public class Main {
	private static Scanner s = new Scanner(System.in);
	public Conta conta = null;

	public static void main(String[] args) {
		int opcao = 0;

		
		
			System.out.println("  _     ___   ___  _____  __      __ ___   ___  _     ___  \r\n" + 
					" | |   / _ \\ / __||_   _| \\ \\    / // _ \\ | _ \\| |   |   \\ \r\n" + 
					" | |__| (_) |\\__ \\  | |    \\ \\/\\/ /| (_) ||   /| |__ | |) |\r\n" + 
					" |____|\\___/ |___/  |_|     \\_/\\_/  \\___/ |_|_\\|____||___/ \r\n" + 
					"                                                           \n\n\n");
			do {
			System.out.println("1 - NEW ACCOUNT");
			System.out.println("2 - START");
			System.out.println("\n\n0 - EXIT");
			opcao = s.nextInt();

			switch (opcao) {
			case 1:
				Util.clear();
				Util.create();
				break;
			case 2:
				Util.clear();
				accountLogin();
				break;
			case 0:
				Util.clear();
				System.out.println("Good Bye");
                break;
			}
		}
		while (opcao != 0);
	}
	
	
	
	public static void accountLogin() {
		Login login = new Login();
		login.logarA();
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
