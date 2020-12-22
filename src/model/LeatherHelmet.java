package model;

import exceptions.EquipsException;

public class LeatherHelmet extends Helmet {

	public LeatherHelmet() {		
		this.def = 2;
		this.setName("Leather Helmet");
	    itemID = 1;
	    price = 80;
	}

	public void equip(Player p) throws EquipsException {
		Helmet h = new LeatherHelmet();
		if (p.getInventory().getHelmet() != null) {
			throw new EquipsException("You are already using an helmet, please, unequip first");
		}
		p.getInventory().setHelmet(h);
		p.getStatus().setDef(p.getStatus().getDef() + h.getDef());
	}

	@Override
	public void unequip(Player p) throws EquipsException {
		Helmet h = new LeatherHelmet();
		if (p.getInventory().getHelmet() == null) {
			throw new EquipsException("Can't do this");
		}
		
		if (p.getInventory().getHelmet().getItemID() != 1) {
			throw new EquipsException("Can't do this");
		}
		p.getStatus().setDef(p.getStatus().getDef() - h.getDef());
		p.getInventory().setHelmet(null);
	}

}
