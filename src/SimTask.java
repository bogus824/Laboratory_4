import java.util.TimerTask;

public class SimTask extends TimerTask{
	
	private SimEngine simEngine;
	private SpringApplet springApplet;
	private double dt;
	
	//constructor with parameters - objects of the classes 
	public SimTask(SimEngine simEngine,SpringApplet springApplet, double dt)
	{
		this.simEngine = simEngine;
		this.springApplet = springApplet;
		this.dt = dt;
	}

	//Overriden method run which is responsible for resetting applet surface and calculating the step and carrying simulation out
	@Override
	public void run() {
		
		simEngine.Simulate(dt);
		springApplet.repaint();
		
		
	}
	
	
	
	

}
