package mss_vector_math;

/**
 * All 2D algebraic vectors will be an instance of this class
 * This class allows the user to get, print, and set the x and y components of the vector as well as construct new vectors
 * 
 * @author newton
 * @version 3.0
 */
/* comment changes
 * was
 * line 101: String x = String.valueOf(Math.round(this.x * 100) / 100);
 * is 
 * lines 101-107: String x = String.valueOf(Math.round(this.x * 100));
		          if (this.x == 0){
			    	  return ("0.00");
		          }
		          else{
			    	  return (x.substring(0, x.length() - 2) + "." + x.substring(x.length() - 2, x.length()));
		          }
 * reason: The program must return two decimal places no matter what, so this algorithm was created. The value is multiplied by 100, rounded,
 * then converted to a string. Then a '.' is placed at the 2nd last index of the string which creates a string of the original number rounded to
 * two decimal places even if the last decimal is a zero.
 * date: March 21, 2015
 * author: newton
 */
/* comment changes
 * was
 * line 115: String y = String.valueOf(Math.round(this.y * 100) / 100);
 * is 
 * lines 115-121: String y = String.valueOf(Math.round(this.y * 100));
		          if (this.y == 0){
			    	  return ("0.00");
		          }
		          else{
			    	  return (y.substring(0, y.length() - 2) + "." + y.substring(y.length() - 2, y.length()));
		          }
 * reason: The program must return two decimal places no matter what, so this algorithm was created. The value is multiplied by 100, rounded,
 * then converted to a string. Then a '.' is placed at the 2nd last index of the string which creates a string of the original number rounded to
 * two decimal places even if the last decimal is a zero.
 * date: March 21, 2015
 * author: newton
 */
public class MSS_Vector_2D_Alg {
	
	private double x;
	private double y; ////variables represent the x and y comps of a 2D vector
	
	/**
	 * 2D algebraic vector constructor
	 * @param x
	 * @param y
	 */
	public MSS_Vector_2D_Alg(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * gets x value
	 * @return double x
	 */
	public double getx(){
		return this.x;
	}
	/**
	 * gets y value
	 * @return double y
	 */
	public double gety(){
		return this.y;
	}
	
	/**
	 * sets x value
	 * @param x
	 */
	public void setx(double x){
		this.x = x;
	}
	/**
	 * sets y value
	 * @param y
	 */
	public void sety(double y){
		this.y = y;
	}
	
	/**
	 * returns a string of x and y components
	 * @return String
	 */
	public String toString(){
		return xToString() + "," + yToString();
	}
	
	/**
	 * returns a string of x component
	 * @return String
	 */
	public String xToString(){
		String x = String.valueOf(Math.round(this.x * 100)); //multiplies number by 100 and converts to string
		if (this.x == 0){
			return ("0.00");
		}
		else{
			return x.substring(0, x.length() - 2) + "." + x.substring(x.length() - 2, x.length());//puts a '.' at the appropriate spot
		}
	}
	
	/**
	 * returns a string of y component
	 * @return String
	 */
	public String yToString(){
		String y = String.valueOf(Math.round(this.y * 100));//multiplies number by 100 and converts to string
		if (this.y == 0){
			return ("0.00");
		}
		else{
			return y.substring(0, y.length() - 2) + "." + y.substring(y.length() - 2, y.length());//puts a '.' at the appropriate spot
		}
	}
}
