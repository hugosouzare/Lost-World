package model;

import exceptions.PlayerException;

public class HealSpell extends Spell {

	public HealSpell() {
		name = "Heal";
		id = 1;
		manacost = 50;
	}

	public void cast(Player p) throws PlayerException {
		int qnt = 200;
		if (p.getStatus().getCurrentmana() - manacost <= 0) {
			throw new PlayerException("You don't have enough mana");
		}
		
		if (p.getStatus().getCurrentHP() + qnt > p.getStatus().getHp()) {
			p.getStatus().setCurrentHP(p.getStatus().getHp());
		} else {
			p.getStatus().setCurrentHP(p.getStatus().getCurrentHP() + qnt);
		}
		System.out.println("You healed " + qnt);
		
		p.getStatus().setCurrentmana(p.getStatus().getCurrentmana() - manacost);
	}

	public void cast(Player p, Monster m) throws PlayerException {

	}
}