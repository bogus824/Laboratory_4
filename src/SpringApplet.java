import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import static java.lang.Math.abs;
import java.awt.Graphics2D;

/**
 * Inherited class whose aim is to declare and display drawings on the surface of the applet 
 * @author bogus
 *
 */

public class SpringApplet extends JApplet{

	public int wdth,hgth;
	
	//Declaring objects 
	private SimTask simTask;
	private SimEngine simEngine;
	private Timer timer;
	
	/**
	 * Overriden Method which is initialized at the moment of running the program
	 * 
	 */
	public void init()
	{
		// Setting the size of the window 
		setSize(1000,1000);
		
		//Setting parameters of the simulation ( Mass, k,c,Lo,coordinates)
		simEngine = new SimEngine(20,0.8,0.13,150,500,100,500,10);
		
		//Setting parameters of time ( object responsible for simulation and steptime)
		simTask = new SimTask(simEngine,this,0.5);
		timer = new Timer();
		timer.scheduleAtFixedRate(simTask, 0, 30);
	}
	
	/**
	 * Overriden Method which is responsible for drawing on the surface of the applet 
	 */
	public void paint(Graphics g)
	{
		int width = this.getWidth();
		int hgth = this.getHeight();
		
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, width, hgth);
		
		
		//Creating X Y Axis 
		
		//Construction responsible for setting the color of the line on the basis of the RGB scale
		
		g.setColor(Color.BLACK);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
		
		//Creating grid
		for(int i=1;i<30;i++)
		{
			g.drawLine(0,(int)Math.round(hgth-i*hgth/30),width,(int)Math.round(hgth-i*hgth/30));
			g.drawLine(0+i*width/30,0,0+i*width/30,hgth);
			
		}
		
		//Creating holding point
		g2.setStroke(new BasicStroke(10));
		
		g.setColor(Color.GREEN);
		g.drawLine((int)abs(100-simEngine.getmass_xholdingpoint()), (int)abs(simEngine.getmass_yholdingpoint()), (int)abs(100+simEngine.getmass_xholdingpoint()), (int)abs(simEngine.getmass_yholdingpoint()));
				
		g2.setStroke(new BasicStroke(3));
		g.setColor(Color.GREEN);
		for(int i=0 ; i<15;i++) {
        g.drawLine((int) abs(105 - simEngine.getmass_xholdingpoint())+15*i, (int)abs(simEngine.getmass_yholdingpoint()), (int) abs(105 - simEngine.getmass_xholdingpoint()) + 30 + 15*i, (int) abs(simEngine.getmass_yholdingpoint()) - 30);
        }
		
		//Creating spring
		g.setColor(Color.BLUE);
		int springWidth = 70;
    	g.drawLine((int)simEngine.getmass_xholdingpoint(), (int)simEngine.getmass_yholdingpoint(), (int)simEngine.getmass_xholdingpoint()-springWidth, (int)(simEngine.getmass_yholdingpoint()+0.1*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()-springWidth, (int)(simEngine.getmass_yholdingpoint()+0.1*simEngine.getMassPositionY()), (int)simEngine.getmass_xholdingpoint()+springWidth, (int)(simEngine.getmass_yholdingpoint()+0.2*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()+springWidth, (int)(simEngine.getmass_yholdingpoint()+0.2*simEngine.getMassPositionY()), (int)simEngine.getmass_xholdingpoint()-springWidth, (int)(simEngine.getmass_yholdingpoint()+0.3*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()-springWidth, (int)(simEngine.getmass_yholdingpoint()+0.3*simEngine.getMassPositionY()), (int)simEngine.getmass_xholdingpoint()+springWidth, (int)(simEngine.getmass_yholdingpoint()+0.4*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()+springWidth, (int)(simEngine.getmass_yholdingpoint()+0.4*simEngine.getMassPositionY()), (int)simEngine.getmass_xcoordinate()-springWidth, (int)(simEngine.getmass_yholdingpoint()+0.5*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()-springWidth, (int)(simEngine.getmass_yholdingpoint()+0.5*simEngine.getMassPositionY()), (int)simEngine.getmass_xholdingpoint()+springWidth, (int)(simEngine.getmass_yholdingpoint()+0.6*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()+springWidth, (int)(simEngine.getmass_yholdingpoint()+0.6*simEngine.getMassPositionY()), (int)simEngine.getmass_xcoordinate()-springWidth, (int)(simEngine.getmass_yholdingpoint()+0.7*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()-springWidth, (int)(simEngine.getmass_yholdingpoint()+0.7*simEngine.getMassPositionY()), (int)simEngine.getmass_xholdingpoint()+springWidth, (int)(simEngine.getmass_yholdingpoint()+0.8*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()+springWidth, (int)(simEngine.getmass_yholdingpoint()+0.8*simEngine.getMassPositionY()), (int)simEngine.getmass_xcoordinate()-springWidth,  (int)(simEngine.getmass_yholdingpoint()+0.9*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()-springWidth, (int)(simEngine.getmass_yholdingpoint()+0.9*simEngine.getMassPositionY()), (int)simEngine.getmass_xcoordinate()+springWidth,(int)abs(simEngine.getmass_yholdingpoint() + 1* (int)abs(simEngine.getMassPositionY())));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()+springWidth, (int)(simEngine.getmass_yholdingpoint()+1*simEngine.getMassPositionY()), (int)simEngine.getmass_xholdingpoint()-springWidth, (int)(simEngine.getmass_yholdingpoint()+1.1*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()-springWidth, (int)(simEngine.getmass_yholdingpoint()+1.1*simEngine.getMassPositionY()), (int)simEngine.getmass_xcoordinate()+springWidth, (int)(simEngine.getmass_yholdingpoint()+1.2*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()+springWidth, (int)(simEngine.getmass_yholdingpoint()+1.2*simEngine.getMassPositionY()), (int)simEngine.getmass_xholdingpoint()-springWidth, (int)(simEngine.getmass_yholdingpoint()+1.3*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()-springWidth, (int)(simEngine.getmass_yholdingpoint()+1.3*simEngine.getMassPositionY()), (int)simEngine.getmass_xcoordinate()+springWidth,  (int)(simEngine.getmass_yholdingpoint()+1.4*simEngine.getMassPositionY()));
    	g.drawLine((int)simEngine.getmass_xholdingpoint()+springWidth, (int)(simEngine.getmass_yholdingpoint()+1.4*simEngine.getMassPositionY()), (int)simEngine.getmass_xcoordinate(),(int)abs(simEngine.getmass_yholdingpoint() +1.5* (int)abs(simEngine.getMassPositionY())));
		
    	//Creating mass
        g.setColor(Color.red);
        
        g.fillOval((int)simEngine.getMassPositionX() - 35, (int)abs(simEngine.getmass_yholdingpoint() +1.5*( (int)abs(simEngine.getMassPositionY())-10)),70,70);
	
        //Creating Vectors
        g.setColor(Color.MAGENTA);
        g.drawLine((int)simEngine.getMassPositionX(), (int)(1.5*simEngine.getMassPositionY()+35), (int)simEngine.getMassPositionX(), (int)(simEngine.getMass()*simEngine.getg())+(int)(simEngine.getMassPositionY()));
        g.drawLine((int)simEngine.getMassPositionX()-5, (int)(simEngine.getMass()*simEngine.getg())+(int)simEngine.getMassPositionY()-5, (int)simEngine.getMassPositionX(), (int)(simEngine.getMass()*simEngine.getg())+(int)simEngine.getMassPositionY());
        g.drawLine((int)simEngine.getMassPositionX()+5, (int)(simEngine.getMass()*simEngine.getg())+(int)simEngine.getMassPositionY()-5, (int)simEngine.getMassPositionX(), (int)(simEngine.getMass()*simEngine.getg())+(int)simEngine.getMassPositionY());
       g.drawString("Gravity Force = "+(int)(simEngine.getMass()*simEngine.getg()), (int)simEngine.getMassPositionX()-118, (int)(simEngine.getMass()*simEngine.getg())+(int)simEngine.getMassPositionY());
	
       g.setColor(Color.YELLOW);
       g.drawLine((int)simEngine.getMassPositionX()-5, (int)(1.5*simEngine.getMassPositionY())+25, (int)simEngine.getMassPositionX()-5, (int)(1.5*simEngine.getMassPositionY())+25-(int)(simEngine.getk()*simEngine.getMassPositionY()));
       g.drawLine((int)simEngine.getMassPositionX()-10,30 -(int)(simEngine.getk()*simEngine.getMassPositionY())+(int)(1.5*simEngine.getMassPositionY())+5, (int)simEngine.getMassPositionX()-5, -(int)(simEngine.getk()*simEngine.getMassPositionY())+(int)(1.5*simEngine.getMassPositionY())+25);
       g.drawLine((int)simEngine.getMassPositionX(),30 -(int)(simEngine.getk()*simEngine.getMassPositionY())+(int)(1.5*simEngine.getMassPositionY())+5, (int)simEngine.getMassPositionX()-5, -(int)(simEngine.getk()*simEngine.getMassPositionY())+(int)(1.5*simEngine.getMassPositionY())+25);
       g.drawString("Fs= " + (int)(simEngine.getk()*1.5*simEngine.getMassPositionY()), (int)simEngine.getMassPositionX()-65, -(int)(simEngine.getk()*simEngine.getMassPositionY())+(int)(1.5*simEngine.getMassPositionY()));
	
	
       g.setColor(Color.orange);
       g.drawLine((int)simEngine.getMassPositionX()+5, (int)(1.5*simEngine.getMassPositionY())+25, (int)simEngine.getMassPositionX()+5, -(int)(simEngine.getc()*(int)abs(simEngine.getmass_yspeed()))+(int)(1.5*simEngine.getMassPositionY()));
       g.drawLine((int)simEngine.getMassPositionX(), -(int)(simEngine.getc()*(int)abs(simEngine.getmass_yspeed()))+(int)(1.5*simEngine.getMassPositionY())+5, (int)simEngine.getMassPositionX()+5, -(int)(simEngine.getc()*(int)abs(simEngine.getmass_yspeed()))+(int)(1.5*simEngine.getMassPositionY()));
       g.drawLine((int)simEngine.getMassPositionX()+10, -(int)(simEngine.getc()*(int)abs(simEngine.getmass_yspeed()))+(int)(1.5*simEngine.getMassPositionY())+5, (int)simEngine.getMassPositionX()+5, -(int)(simEngine.getc()*(int)abs(simEngine.getmass_yspeed()))+(int)(1.5*simEngine.getMassPositionY()));
       g.drawString("Ft= " + (int)(simEngine.getc()*(int)abs(simEngine.getmass_yspeed())), (int)simEngine.getMassPositionX()+15, -(int)(simEngine.getc()*simEngine.getmass_yspeed())+(int)(1.5*simEngine.getMassPositionY()));
	
	
	
	
	
	
	
	}


}

	        