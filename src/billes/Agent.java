package billes;

import java.util.Random;

public class Agent {
	private static Random r = new Random();
	private int posX;
	private int posY;
	private Environnement env;
	
	public Agent(Environnement env) {
		boolean positionFound = false;
		this.env = env;
		
		while (!positionFound) {
			int x = r.nextInt(env.getWidth());
			int y = r.nextInt(env.getHeight());
			
			if (!env.isBusy(x, y)) {
				posX=x;
				posX=y;
				positionFound = true;
			}
		}
		
		return;
	}
}

