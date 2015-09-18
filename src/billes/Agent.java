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
				this.posX = x;
				this.posY = y;
				this.env.putAgent(x, y, this);
				positionFound = true;
			}
		}
		
		this.stepX = r.nextInt(3) - 1;
		this.stepY = r.nextInt(3) - 1;
		
		return;
	}
	
	// Ask agent to make a decision for the current turn
	public void decide() {
		this.env.removeAgent(this.posX, this.posY);
		if(env.isToric()) {
			this.posX = (this.env.getWidth() + this.posX + this.stepX) % this.env.getWidth();
			this.posY = (this.env.getHeight() + this.posY + this.stepY) % this.env.getHeight();
		} else {
			if(this.posX + this.stepX >= this.env.getWidth() || this.posX + this.stepX < 0) this.stepX = -this.stepX;
			if(this.posY + this.stepY >= this.env.getHeight() || this.posY + this.stepY < 0) this.stepY = -this.stepY;
			this.posX = this.posX + this.stepX;
			this.posY = this.posY + this.stepY;
		}
		this.env.putAgent(this.posX, this.posY, this);
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
}

