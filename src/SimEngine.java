import java.util.Scanner;


public class SimEngine {
	
	private double mass;
	private double k;
	private double c;
	private double lo;
	private double mass_xcoordinate;
	private double mass_ycoordinate;
	private double mass_xspeed;
	private double mass_yspeed;
	private double mass_xholdingpoint;
	private double mass_yholdingpoint;
	private static double g = 9.81f;
	
	public double ay;
	public double time;
	public double temp;
	
	//setter section
	public void control(double parameter)
	{
		while(temp < 0)
		{
			System.out.println("You chose a wrong number. Check datas");
			Scanner input = new Scanner(System.in);
			parameter = input.nextDouble();
			System.out.println("\n");
			
		}
	}
	
	public void setMass(double m)
	{
		control(m);
		this.mass = m;
	}
	
	public void setc(double c)
	{
		control(c);
		this.c = c;
	}
	
	public void setk(double K)
	{
		control(K);
		this.k = K;
	}
	
	public void setlo(double Lo)
	{
		control(Lo);
		this.lo = Lo;
	}
	
	public void setmass_xcoordinate(double mx)
	{
		control(mx);
		this.mass_xcoordinate = mx;
	}
	
	public void setmass_ycoordinate(double my)
	{
		control(my);
		this.mass_ycoordinate = my;
	}
	
	public void setmass_xspeed(double vx)
	{
		control(vx);
		this.mass_xspeed = vx;
		
	}
	
	public void setmass_yspeed(double vy)
	{
		control(vy);
		this.mass_yspeed = vy;
		
	}
	
	public void setmass_xholdingpoint(double mhpx)
	{
		control(mhpx);
		this.mass_xholdingpoint = mhpx;
		
	}
	
	public void setmass_yholdingpoint(float mhpy)
	{
		control(mhpy);
		this.mass_yholdingpoint = mhpy;
		
	}
	
	//getter section
	public double getMass()
	{
		return mass;
	}
	
	public double  getc()
	{
		return c;
		
	}
	
	public static double getg()
	{
		return g;
	}
	
	public double  getk()
	{
		return k;
	}
	
	public double getlo()
	{
		return lo;
	}
	
	public double  getmass_xcoordinate()
	{
		return mass_xcoordinate;
	}
	
	public double  getmass_ycoordinate()
	{
		return mass_ycoordinate;
	}
	
	public double  getmass_xspeed()
	{
		return mass_xspeed;
		
	}
	
	public double getmass_yspeed()
	{
		return mass_yspeed;
		
	}
	
	public double getmass_xholdingpoint()
	{
		return mass_xholdingpoint;
		
	}
	
	public double getmass_yholdingpoint()
	{
		return mass_yholdingpoint;
		
	}
	

	private Vector2D massPosition;
	
	private Vector2D SpringPosition;
	
	//constructor with parameter 
	public SimEngine(double M,double K, double C, double Lo, double mass_xcoordinate, double mass_ycoordinate, double holdingpointx, double holdingpointy  )
	{
		control(M);
		control(K);
		control(C);
		control(Lo);
		control(mass_xcoordinate);
		control(mass_ycoordinate);
		control(holdingpointx);
		control(holdingpointy);
		this.mass = M;
		this.k = K;
		this.c = C;
		this.lo = Lo;
		this.mass_xcoordinate = mass_xcoordinate;
		this.mass_ycoordinate = mass_ycoordinate;
		this.mass_xholdingpoint = holdingpointx;
		this.mass_yholdingpoint = holdingpointy;
		this.mass_xspeed = 0;
		this.mass_yspeed = 0;
		this.ay = 0;
		this.time = 0;
		
		
		massPosition = new Vector2D(mass_xcoordinate,mass_ycoordinate);
		SpringPosition = new Vector2D(mass_xholdingpoint,mass_yholdingpoint);
		
		
	}
	
	public double getMassPositionY() {
        System.out.println(massPosition.y);
        return massPosition.y;
    }
    
	public double getMassPositionX() {

        return massPosition.x;
    }
	
	//method which is responsible for simulating
	public void Simulate(double stepTime)
	    {
	    	time=stepTime;
	    	
	       
	        ay = (mass*g - k*massPosition.y - c*mass_yspeed)/mass;
	        mass_yspeed = mass_yspeed + ay*stepTime;
	        massPosition.y = massPosition.y + (mass_yspeed*stepTime + ay*stepTime*stepTime/2);
	   
	    }
	
	//method which restarts functioning of the program (set speeds to zero)
	public void Restart()
	{
		this.mass_yspeed = 0;
	}
	
	
	
	

}
