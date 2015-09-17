package billes;

import java.util.Random;

public class Agent {
	private static Random r = new Random();
	private int posX;
	private int posY;
	private int stepX;
	private int stepY;
	private Environnement env;
	
	// Create the agent and choose a random position (cell must be empty) and direction in the environment
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
		
		this.stepX = r.nextInt(2) - 1;
		this.stepY = r.nextInt(2) - 1;
		
		return;
	}
	
	// Ask agent to make a decision for the current turn
	public void decide() {
		
	}
	
}

