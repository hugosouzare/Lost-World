package model;

import exceptions.EquipsException;

public class SteelHelmet extends Helmet {
	
	public SteelHelmet() {
		this.setName("Steel Helmet");
		itemID = 2;
		this.setDef(14);
		price = 1200;
	}

	public void equip(Player p) throws EquipsException {
		SteelHelmet h = new SteelHelmet();
		if (p.getInventory().getHelmet() != null) {
			throw new EquipsException("You are already using an helmet, please, unequip first");
		}
		
		p.getInventory().setHelmet(h);
		p.getStatus().setDef(p.getStatus().getDef() + h.getDef());
		p.getStatus().setHp(p.getStatus().getHp() + 200);
		p.getStatus().setCurrentHP(p.getStatus().getCurrentHP() + 200);
	}

	public void unequip(Player p) throws EquipsException {
		SteelHelmet h = new SteelHelmet();
		if (p.getInventory().getHelmet() == null) {
			throw new EquipsException("Can't do this");
		}
		
		if (p.getInventory().getHelmet().getItemID() != 2) {
			throw new EquipsException("Can't do this");
		}
		p.getStatus().setDef(p.getStatus().getDef() - h.getDef());
		p.getInventory().setHelmet(null);
	}
}
