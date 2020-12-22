package model;

import exceptions.EquipsException;

public class SteelSword extends Weapon {

	public SteelSword() {
		this.setAtk(18);
		this.setName("Steel Sword");
		this.setType(1);
		itemID = 4;
		price = 1500;
	}

	public void equip(Player p) throws EquipsException {
		SteelSword s = new SteelSword();
		
		if (p.getVocation() != "Knight") {
			throw new EquipsException("Sorry, your vocation cannot use this weapon");
		}

		if (p.getInventory().getWeapon() != null) {
			throw new EquipsException("You are already using an weapon, please, unequip first");
		}

		p.getStatus().setAttack(p.getStatus().getAttack() + s.getAtk());
		p.getStatus().setDef(p.getStatus().getDef() + 3);
		p.getInventory().setWeapon(s);
	}

	public void unequip(Player p) throws EquipsException {
		SteelSword s = new SteelSword();
		
		if (p.getInventory().getWeapon() == null) {
			throw new EquipsException("Can't do this");
		}

		if (p.getInventory().getHelmet().getItemID() != 4) {
			throw new EquipsException("Can't do this");
		}
		
		p.getStatus().setAttack(p.getStatus().getAttack() - s.getAtk());
		p.getStatus().setDef(p.getStatus().getDef() - 3);
		p.getInventory().setWeapon(null);
	}
}
