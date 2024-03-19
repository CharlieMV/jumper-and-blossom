package info.gridworld.actor;

import java.awt.Color;

public class Blossom extends Flower {
	
	private int lifetime;
	
	public Blossom () {
		lifetime = 10;
		setColor(color.GREEN);
	}
	
	public Blossom(int life) {
		lifetime = life;
		setColor(color.Green);
	}
	
	 /**
     * Causes the color of this blossom to darken and disappear when its
     * lifetime is over.
     */
	public void Act() {
		if (lifetime > 0) {
			color c = getColor();
			int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
			int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
			int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
			
			setColor(new Color(red, green, blue));
			lifetime --;
		}
	}
}
