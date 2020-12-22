package controller;

import Repository.AccountRepository;
import Repository.BankRepository;
import Repository.BpRepository;
import Repository.DiegoRepository;
import Repository.HelmetRepository;
import Repository.PlayerRepository;
import exceptions.AccountException;
import exceptions.EquipsException;
import exceptions.PlayerException;
import model.BackPack;
import model.BankAccount;
import model.Conta;
import model.Helmet;
import model.Item;
import model.Player;
import model.Weapon;

public class Fachada implements IDiegoRepository, IAccountRepository,IBankRepository, IBpRepository, IPlayerRepository, IHelmetRepository{
	private IAccountRepository controllerAccount;
	private IBankRepository controllerBank;
	private IBpRepository controllerBackPack;
	private IPlayerRepository controllerPlayer;
	private IHelmetRepository controllerHelmet;
	private IDiegoRepository controllerDiego;
	
	private static Fachada instancy;
	
	public static Fachada getInstancy() {
		if(instancy == null) {
			instancy = new Fachada();
		}
		return instancy;
	}
	private Fachada() {
		controllerAccount = AccountRepository.getInstancy();
		controllerBank = BankRepository.getInstancy();
		controllerBackPack = BpRepository.getInstancy();
		controllerPlayer = PlayerRepository.getInstancy();
		controllerHelmet = HelmetRepository.getInstancy();
		controllerDiego = DiegoRepository.getInstancy();
	}
	

	public void insertAccount(Conta a) throws AccountException {
		controllerAccount.insertAccount(a);
	}


	public Conta loginSuccess(String acc, String pass) {
		return controllerAccount.loginSuccess(acc, pass);
	}


	public void removeAccount(Conta c) throws AccountException {
		controllerAccount.removeAccount(c);
	}

	public void insertPlayer(Player p) throws PlayerException {
		controllerPlayer.insertPlayer(p);
	}

	public boolean existsPlayer(String name) {
		return controllerPlayer.existsPlayer(name);
	}

	public void deletePlayer(Player p) throws PlayerException {
		controllerPlayer.deletePlayer(p);
	}

	public void insertPlayerIntoAccount(Conta c, Player p) throws PlayerException {
		controllerPlayer.insertPlayerIntoAccount(c, p);
	}

	public Player searchPlayer(String name) throws PlayerException {
		return controllerPlayer.searchPlayer(name);
	}

	public void read(BackPack bp) {
		controllerBackPack.read(bp);	
	}

	public void delete(int it, BackPack bp) throws EquipsException {
		controllerBackPack.delete(it, bp);		
	}

	public void add(Item it, BackPack bp) throws EquipsException {
		controllerBackPack.add(it, bp);
	}

	public boolean hasItem(int id, BackPack bp) throws EquipsException {
		return controllerBackPack.hasItem(id, bp);
	}

	public void insertAcc(BankAccount b) throws PlayerException {
		controllerBank.insertAcc(b);
	}

	public int lastID() {
		return controllerBank.lastID();
	}

	public void deposit(int qnt, Player p) throws PlayerException {
		controllerBank.deposit(qnt, p);
	}

	public BankAccount searchId(int id) {
		return controllerBank.searchId(id);
	}

	public void withdraw(int qnt, Player p) throws PlayerException {
		controllerBank.withdraw(qnt, p);
	}

	public void transfer(int qnt, String name, Player ps) throws PlayerException {
		controllerBank.transfer(qnt, name, ps);
	}
	
	public boolean hasaccount() {
		return controllerBank.hasaccount();
	}
	@Override
	public boolean hasItem(String name, BackPack bp) throws EquipsException {
		return controllerBackPack.hasItem(name, bp);
	}
	@Override
	public Item returnItem(Player p, String name) throws EquipsException {
		return controllerBackPack.returnItem(p, name);
	}
	@Override
	public void add(Helmet h) {
	 controllerHelmet.add(h);
		
	}
	@Override
	public boolean existsHelmet(String name) {
		return controllerHelmet.existsHelmet(name);
	}
	@Override
	public void delete(String name) throws EquipsException {
		controllerHelmet.delete(name);
		
	}
	@Override
	public Helmet searchByName(String name) throws EquipsException {
		return controllerHelmet.searchByName(name);
	}
	@Override
	public void updatePrice(String name, int price) {
		controllerHelmet.updatePrice(name, price);
		
	}
	@Override
	public void read() {
		controllerHelmet.read();
		controllerDiego.read();
		
	}
	@Override
	public boolean isRepoEmpty() {
		return controllerHelmet.isRepoEmpty();
	}
	@Override
	public void add(Weapon w) throws EquipsException {
		controllerDiego.add(w);
		
	}
	@Override
	public boolean existsWeapon(String name) {
		return controllerDiego.existsWeapon(name);
	}
	@Override
	public Weapon search(String name) throws EquipsException {
		return controllerDiego.search(name);
	}
	@Override
	public void deleteWeapon(String name) {
		controllerDiego.deleteWeapon(name);
		
	}
	@Override
	public boolean isEmpty() {
		return controllerDiego.isEmpty();
	}
}