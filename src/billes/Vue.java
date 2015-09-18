package billes;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vue implements Observer {

	JFrame frame;
	JPanel envPanel;
	int width, height;
	
	public Vue(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void init() {
		this.frame = new JFrame("SCI_Billes");
		this.frame.setSize(new Dimension(width*10, height*10));
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.envPanel = new JPanel();
		this.frame.setContentPane(this.envPanel);
		
		this.frame.setVisible(true);
	}
	
	public void update(Observable arg0, Object arg1) {
		SMA sma = (SMA)arg0;
		for(int i = 0; i < sma.getNbAgents(); i++) {
			Agent a = sma.getAgent(i);
			this.envPanel.getGraphics().fillOval(a.getPosX()*10, a.getPosY()*10, 10, 10);
		}
	}

}
