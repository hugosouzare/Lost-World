package model;

public abstract class Monster extends PlayerObject{

	public Monster() {
		super();
	}

	public Monster(Status status, String name, int level, int gold, int exp) {
		super(status, name, level, gold, exp);
	}
	
	public abstract void words();
	public abstract void draw();
}