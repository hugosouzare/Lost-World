package model;

public class Inventory {
	
	Helmet helmet;
	Weapon weapon;
	BackPack backpack;
	
	public Inventory (Helmet helmet, Weapon weapon, BackPack backpack) {
		this.helmet = helmet;
		this.weapon = weapon;
		this.backpack = backpack;
	}
	public Helmet getHelmet() {
		return helmet;
	}
	public void setHelmet(Helmet helmet) {
		this.helmet = helmet;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public BackPack getBackpack() {
		return backpack;
	}
	public void setBackpack(BackPack backpack) {
		this.backpack = backpack;
	}
}