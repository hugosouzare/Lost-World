package model;

public class Wolf extends Monster {
	
	private Status ms = new Status(230, Constants.baseattack - 5, Constants.basedef - 5, 300, 0, 230, 0);
	
	public Wolf() {
      status = ms;
      name = "Wolf";
      level = 1;
      gold = 50;
      exp = 30;
	}

	@Override
	public void words() {
		System.out.println("ROARRRRR");
	}

	@Override
	public void draw() {
		System.out.println(
				"        _\r\n" + "       / \\      _-'\r\n" + "     _/|  \\-''- _ /\r\n" + "__-' { |          \\\r\n"
						+ "    /             \\\r\n" + "    /       \"o.  |o }\r\n" + "    |            \\ ;\r\n"
						+ "                  ',\r\n" + "       \\_         __\\\r\n" + "         ''-_    \\.//\r\n"
						+ "           / '-____'\r\n" + "          /\r\n" + "        _'\r\n" + "      _-'");		
	}

}
