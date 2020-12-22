package model;

public class BackPack {
	private Item[] itens;
	
	public BackPack() {
		
	}

	public BackPack(Item[] itens) {
		this.itens = itens;
	}

	public Item[] getItens() {
		return itens;
	}

	public void setItens(Item[] itens) {
		this.itens = itens;
	}
}