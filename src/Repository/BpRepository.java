package Repository;

import controller.IBpRepository;
import exceptions.EquipsException;
import model.BackPack;
import model.Item;
import model.Player;

public class BpRepository implements IBpRepository {
	
	private static BpRepository instancy = null;
	
	public BpRepository() {
		
	}
	
	public static BpRepository getInstancy() {
		if (instancy == null) {
			instancy = new BpRepository();
		}
		return instancy;
	}

	public void add(Item it, BackPack bp) throws EquipsException {
		int cont = 0;
		for (int i = 0; i < 20; i++) {
			if (bp.getItens()[i] != null) {
				cont++;
			}
		}

		if (cont == 20) {
			throw new EquipsException("Sorry, your BackPack is full");
		}

		for (int i = 0; i < bp.getItens().length; i++) {
			if (bp.getItens()[i] == null) {
				bp.getItens()[i] = it;
				break;
			}
		}
	}

	public void delete(int id, BackPack bp) throws EquipsException {
		for (int i = 0; i < bp.getItens().length; i++) {
			if (bp.getItens()[i] != null && bp.getItens()[i].getItemID() == id) {
				bp.getItens()[i] = null;
				break;
			}
		}
	}

	public void read(BackPack bp) {
		for (int i = 0; i < bp.getItens().length; i++) {
			if (bp.getItens()[i] != null) {
				System.out.println(i + 1 + " - " + bp.getItens()[i].getName());
			}
		}
	}
	
	public boolean hasItem(int id, BackPack bp) throws EquipsException {
		if (bp == null) {
			throw new EquipsException("No BackPack found");
		}
		for (int i = 0; i < bp.getItens().length; i++) {
			if (bp.getItens()[i] != null && bp.getItens()[i].getItemID() == id) {
				return true;
			}	
		}
		return false;
	}
	
	public boolean hasItem(String name, BackPack bp) throws EquipsException {
		if (bp == null) {
			throw new EquipsException("No BackPack found");
		}
		for (int i = 0; i < bp.getItens().length; i++) {
			if (bp.getItens()[i] != null && bp.getItens()[i].getName().equalsIgnoreCase(name)) {
				return true;
			}	
		}
		return false;
		
	}
	
	public Item returnItem (Player p, String name) throws EquipsException {
		if (!hasItem(name, p.getInventory().getBackpack())) {
			throw new EquipsException("You don't have this item");
		}
		for (int i = 0; i < p.getInventory().getBackpack().getItens().length; i++) {
			if (p.getInventory().getBackpack().getItens()[i].getName().equalsIgnoreCase(name)) {
				return p.getInventory().getBackpack().getItens()[i];
			}
		}
		return null;
	}
}