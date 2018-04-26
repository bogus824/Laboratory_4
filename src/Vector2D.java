public class Vector2D {
	
	public double x;
	public double y;
	public double cnst;
	
	/**
	 * Constructor with default parameters
	 */
	Vector2D()
	{
		x = 0;
		y = 0;
		
	}
	
	/**
	 * Constructor with specific parameters
	 * @param tempx - temporary variable whose aim is to move the data from the initializing to the x_coordinate variable
	 * @param tempy - temporary variable whose aim is to move the data from the initializing to the y_coordinate variable
	 */
	Vector2D(double tempx, double tempy)
	{
		x = tempx;
		y = tempy;
	}
	
	/**
	 * Getter type method whose aim is to return x coordinate
	 * @return
	 */
	public double getX()
	{
		return x;
	}
	
	/**
	 * Getter type method whose aim is to return y coordinate
	 * @return
	 */
	public double getY()
	{
		return y;
	}
	
	/**
	 * Method whose aim is to return whole object which is the result of adding two beforedeclared vectors 
	 * @param vector
	 * @return
	 */
	Vector2D AddVectors(Vector2D vector)
	{
		double sumx;
		double sumy;
		
		sumx = vector.getX() + getX();
		sumy = vector.getY() + getY();
		
		Vector2D temp = new Vector2D(sumx,sumy);
		
		return temp;
	}
	
	/**
	 * Method whose aim is to return whole object which is the result of subtracting two beforedeclared vectors 
	 * @param vector
	 * @return
	 */
	Vector2D SubtractVectors(Vector2D vector)
	{
		double subx;
		double suby;
		
		subx = getX() - vector.getX();
		suby = getY() - vector.getY();
		
		Vector2D temp = new Vector2D(subx,suby);
		
		return temp;
	}
	
	/**
	 * Method whose aim is to return whole object which is the result of multiplying vector by some constance value 
	 * @param vector
	 * @return
	 */
	Vector2D MultipleVectors(double constance)
	{
		double multx;
		double multy;
		cnst = constance;
		
		multx = cnst * getX();
		multy = cnst * getY();
		
		Vector2D tempmult = new Vector2D(multx,multy);
		
		return tempmult;
	}
	
	/**
	 * Getter type method whose aim is to return the constance value
	 * @return
	 */
	public double getCnst()
	{
		return cnst;
	}
	
	/**
	 * Getter type method whose aim is to return the length of the vector
	 * @return
	 */
	public double getLength()
	{
		double length;
		length = Math.sqrt(getX()*getX()+getY()*getY());
		return length;
	}
	
	/**
	 * Method whose aim is to return whole object which is the result of the normalized vector  
	 * @param vector
	 * @return
	 */
	Vector2D NormalVector()
	{
		
		double normalx = (getX())/(getLength());
		double normaly = (getY())/(getLength());
		
		Vector2D tempnormal = new Vector2D(normalx,normaly);
		
		return tempnormal;
	}
	
	/**
	 * Getter type method whose aim is to return x coordinate of the normalized vector
	 * @return
	 */
	public double getnormalX()
	{
		double normalx = (getX())/(getLength());
		return normalx;
	}
	
	/**
	 * Getter type method whose aim is to return y coordinate of the normalized vector
	 * @return
	 */
	public double getnormalY()
	{
		double normaly = (getY())/(getLength());
		return normaly;
	}
	
	/**
	 * Method whose aim is to display basic info about vector you created
	 */
	public void Show_Info()
	{
		System.out.println("Vector you created is [" + getX() + "," + getY() + "]" );
		System.out.println("The length of the vector above is " + getLength());
		System.out.println("New vector which is a normalised vector above is [" + getnormalX() + "," + getnormalY() + "]");
		System.out.println("Length of the normalised vector above is" + NormalVector().getLength());
		
	}
}