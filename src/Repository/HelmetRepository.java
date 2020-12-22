package Repository;

import java.util.ArrayList;

import controller.IHelmetRepository;
import exceptions.EquipsException;
import model.Helmet;

public class HelmetRepository implements IHelmetRepository {

	private static HelmetRepository instancy = null;
	private ArrayList<Helmet> helmetlist;

	public HelmetRepository() {
		helmetlist = new ArrayList<Helmet>();
	}

	public static HelmetRepository getInstancy() {
		if (instancy == null) {
			instancy = new HelmetRepository();
		}
		return instancy;
	}

	public void add(Helmet h) {
		if (!existsHelmet(h.getName())) {
			helmetlist.add(h);
		}
	}

	public boolean existsHelmet(String name) {
		for (Helmet h : helmetlist) {
			if (h.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}

		return false;
	}

	public void delete(String name) throws EquipsException {

		if (!existsHelmet(name)) {
			throw new EquipsException("Helmet not found");
		}
		for (Helmet h : helmetlist) {
			if (h.getName().equalsIgnoreCase(name)) {
				helmetlist.remove(h);
				break;
			}
		}
	}

	public Helmet searchByName(String name) throws EquipsException {
		if (!existsHelmet(name)) {
			throw new EquipsException("This helmet is not in our database");
		}
		for (Helmet h : helmetlist) {
			if (h.getName().equalsIgnoreCase(name)) {
				return h;
			}
		}
		return null;
	}

	public void updatePrice(String name, int price) {
		for (Helmet h : helmetlist) {
			if (h.getName().equalsIgnoreCase(name)) {
				h.setPrice(price);
			}
		}
	}

	public void read() {
		int cont = 0;
		for (Helmet h : helmetlist) {
			cont++;
			System.out.println(cont + " - " + h.getName() + " ---------- " + h.getPrice());

		}

	}

	public boolean isRepoEmpty() {
		if (helmetlist.isEmpty()) {
			return true;
		}
		return false;
	}
}
