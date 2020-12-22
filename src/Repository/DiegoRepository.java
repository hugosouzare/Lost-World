package Repository;

import java.util.ArrayList;

import controller.IDiegoRepository;
import exceptions.EquipsException;
import model.Weapon;

public class DiegoRepository implements IDiegoRepository{

	private static DiegoRepository instancy = null;
	private ArrayList<Weapon> weaponlist;

	private DiegoRepository() {
		weaponlist = new ArrayList<Weapon>();
	}

	public static DiegoRepository getInstancy() {
		if (instancy == null) {
			instancy = new DiegoRepository();
		}
		return instancy;
	}

	public void add(Weapon w) throws EquipsException {

		if (w == null) {
			throw new EquipsException("Invalid weapon");
		}

		if (existsWeapon(w.getName())) {
			throw new EquipsException("Already have this weapon");
		}
		if (!existsWeapon(w.getName())) {
			weaponlist.add(w);
		}

	}

	public boolean existsWeapon(String name) {
		for (Weapon w : weaponlist) {
			if (w.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}

		return false;
	}
       
	public void deleteWeapon(String name) {
		if (existsWeapon(name)) {
			for (Weapon h : weaponlist) {
				if (h.getName().equalsIgnoreCase(name)) {
					weaponlist.remove(h);
					break;
				}
			}
		}
	}

	public Weapon search(String name) throws EquipsException {
		if (existsWeapon(name)) {
			for (Weapon h : weaponlist) {
				if (h.getName().equalsIgnoreCase(name)) {
					return h;
				}
			}
		}
		
		else {
			throw new EquipsException("This helmet are not on our repository");
		}
		return null;
	}
	
	public void read() {
		int cont = 0;
		for (Weapon w : weaponlist) {
			cont++;
			System.out.println(cont + " - " + w.getName() + "--------------" + w.getPrice());
		}
	}

    public boolean isEmpty() {
    	if (weaponlist.isEmpty()) {
    		return true;
    	}
    	
    	return false;
    }
}