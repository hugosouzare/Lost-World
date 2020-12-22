package model;

import exceptions.EquipsException;

public class DiegoPackage extends SpecialItens {
	
	public DiegoPackage() {
		name = "Diego's Package";
		itemID = 6;
		price = 0;
	}

	@Override
	public void use() {
		System.out.println("This item cannot be used");
		
	}

	

}
