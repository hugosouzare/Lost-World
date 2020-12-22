package model;

import exceptions.EquipsException;

public class WoodenSword extends Weapon{

	public WoodenSword() {
		this.setAtk(6);
		this.setName("Wooden Sword");
		this.setType(1);
		itemID = 3;
		price = 100;
	}
	
	public void equip(Player p) throws EquipsException {
		WoodenSword s = new WoodenSword();
		
		if (p.getVocation() != "Knight") {
			throw new EquipsException("Sorry, your vocation cannot use this weapon");
		}
      
		if (p.getInventory().getWeapon() != null) {
			throw new EquipsException("You are already using an weapon, please, unequip first");
		}
	  
		p.getStatus().setAttack(p.getStatus().getAttack() + s.getAtk()); 
		p.getInventory().setWeapon(s);
	}

	public void unequip(Player p) throws EquipsException {
		WoodenSword s = new WoodenSword();
		
		if (p.getInventory().getWeapon() == null) {
			throw new EquipsException("Can't do this");
		}
	
		if (p.getInventory().getHelmet().getItemID() != 3) {
			throw new EquipsException("Can't do this");
		}
		
		p.getStatus().setAttack(p.getStatus().getAttack() - s.getAtk());
		p.getInventory().setWeapon(null);
	}
}