package mss_vector_math;

/**
 * All 2D polar vectors will be an instance of this class
 * This class allows the user to get, print, and set the alpha angle and magnitude of the vector as well as construct new vectors
 * This class keeps angles in radians but accepts angles in degrees as parameters in constructor.
 * 
 * @author newton
 * @version 3.0
 */
/* comment changes
 * was
 * line 101: String alpha = String.valueOf(Math.round(this.alpha * 100) / 100);
 * is 
 * lines 101-107: String alpha = String.valueOf(Math.round(this.alpha * 100));
		          if (this.alpha == 0){
			      	  return ("0.00");
		          }
		          else{
			    	  return (alpha.substring(0, alpha.length() - 2) + "." + alpha.substring(alpha.length() - 2, alpha.length()));
		          }
 * reason: The program must return two decimal places no matter what, so this algorithm was created. The value is multiplied by 100, rounded,
 * then converted to a string. Then a '.' is placed at the 2nd last index of the string which creates a string of the original number rounded to
 * two decimal places even if the last decimal is a zero.
 * date: March 21, 2015
 * author: newton
 */
/* comment changes
 * was
 * line 114: String r = String.valueOf(Math.round(this.r * 100) / 100);
 * is 
 * lines 114-120: String r = String.valueOf(Math.round(this.r * 100));
		          if (this.r == 0){
			    	  return ("0.00");
		          }
		          else{
			    	  return (r.substring(0, r.length() - 2) + "." + r.substring(r.length() - 2, r.length()));
		          }
 * reason: The program must return two decimal places no matter what, so this algorithm was created. The value is multiplied by 100, rounded,
 * then converted to a string. Then a '.' is placed at the 2nd last index of the string which creates a string of the original number rounded to
 * two decimal places even if the last decimal is a zero.
 * date: March 21, 2015
 * author: newton
 */
public class MSS_Vector_2D_Pol {

	private double r; //magnitude
	private double alpha; //alpha angle in radians
	
	/**
	 * 2D polar vector constructor
	 * @param r
	 * @param alpha
	 */
	public MSS_Vector_2D_Pol(double r, double alpha){
		this.r = Math.abs(r); //cannot have negative magnitude
		this.alpha = Math.toRadians(alpha);
	}
	
	/**
	 * sets alpha angle
	 * @param alpha
	 */
	public void setAlpha(double alpha){ //takes alpha in degrees
		this.alpha = Math.toRadians(alpha); //converts to radians before setting
	}
	/**
	 * gets alpha angle in radians
	 * @return double alpha
	 */
	public double getAlpha(){
		return this.alpha;
	}
	
	/**
	 * sets magnitude
	 * @param r
	 */
	public void setR(double r){
		this.r = r;
	}
	/**
	 * gets magnitude
	 * @return double r
	 */
	public double getR(){
		return this.r;
	}
	
	/**
	 * returns a string of magnitude and alpha angle
	 * @return String
	 */
	public String toString(){
		return (rToString() + "," + alphaToString());
	}
	/**
	 * returns a string of angle alpha
	 * @return String
	 */
	public String alphaToString(){
		String alpha = String.valueOf(Math.round(Math.toDegrees(this.alpha) * 100)); //multiplies number by 100 and converts to string
		if (this.alpha == 0){
			return ("0.00");
		}
		else{
			return alpha.substring(0, alpha.length() - 2) + "." + alpha.substring(alpha.length() - 2, alpha.length());//puts a '.' at the appropriate spot
		}
	}
	/**
	 * returns a string of magnitude
	 * @return String
	 */
	public String rToString(){
		String r = String.valueOf(Math.round(this.r * 100)); //multiplies number by 100 and converts to string
		if (this.r == 0){
			return ("0.00");
		}
		else{
			return r.substring(0, r.length() - 2) + "." + r.substring(r.length() - 2, r.length());//puts a '.' at the appropriate spot
		}
	}
}
