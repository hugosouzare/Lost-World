package Repository;

import controller.IAccountRepository;
import exceptions.AccountException;
import model.*;

public class AccountRepository implements IAccountRepository {

	private static AccountRepository instancy;
	private Conta[] accountList;

	private AccountRepository() {
		accountList = new Conta[100];
	}

	public static AccountRepository getInstancy() {
		if (instancy == null) {
			instancy = new AccountRepository();
		}
		return instancy;
	}

	public void insertAccount(Conta a) throws AccountException {
		if (a == null) {
			throw new AccountException("This account is invalid");
		}
		
		if (!existsAccount(a.getConta())) {
			for (int i = 0; i < accountList.length; i++) {
				if (accountList[i] == null) {
					accountList[i] = a;
				}
			}
		}
		
		else {
			throw new AccountException("This account is already in use");
		}
	}

	public boolean existsAccount(String name) {
		for (int i = 0; i < accountList.length; i++) {
			if (accountList[i] != null && accountList[i].getConta().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public Conta loginSuccess(String acc, String pass) {
		for (int i = 0; i < accountList.length; i++) {
			if (accountList[i] != null && accountList[i].getConta().contentEquals(acc)
					&& accountList[i].getPassword().contentEquals(pass)) {
				return accountList[i];
			}
		}
		return null;
	}

	public void removeAccount(Conta c) throws AccountException {
		int cont = 0;
		
		for (int i = 0; i < accountList.length; i++) {
			if (accountList[i] != null && accountList[i].getConta().equals(c.getConta())) {
				accountList[i] = null;
				cont++;
				System.out.println("Removed Successfulytd");
			}

			if (cont == 0) {
				throw new AccountException("Sorry, this account aren't in our account repository");
			}
		}
	}
}