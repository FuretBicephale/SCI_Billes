package billes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class SMA extends Observable {
	
	int sleepLength;
	Environnement env;
	List<Agent> agents;
	
	public SMA(int width, int height, int sleepLength) {
		this.env = new Environnement(width, height);
		this.sleepLength = sleepLength;
	}
	
	// Initialize environment and agent
	public void init() {
		this.env.init();
		this.agents = new ArrayList<Agent>();		
	}
	
	public void addAgent() {
		this.agents.add(new Agent(this.env));
	}
	
	public int getNbAgents() {
		return this.agents.size();
	}

	// Run the simulation for nbTours turns. Each turn, agents is shuffled and each agent are asked to make a decision.
	public void run(int nbTours) throws InterruptedException {
		
		for(int i = 0; i < nbTours; i++) {
			Collections.shuffle(this.agents);
			for(Agent a : agents) {
				a.decide();
				Thread.sleep(sleepLength);
				this.setChanged();
			}			
		}
		
	}
	
}
