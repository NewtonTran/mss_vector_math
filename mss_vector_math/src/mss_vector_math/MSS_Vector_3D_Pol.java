package mss_vector_math;

/**
 * All 3D polar vectors will be an instance of this class
 * This class allows the user to get, print, and set the angles and magnitude of the vector as well as construct new vectors
 * This class keeps angles in radians but accepts angles in degrees as parameters in constructor.
 * 
 * @author newton
 * @version 3.0
 */
/* comment changes
 * was
 * line 166: String alpha = String.valueOf(Math.round(this.alpha * 100) / 100);
 * is 
 * lines 166-172: String alpha = String.valueOf(Math.round(this.alpha * 100));
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
 * line 179: String beta = String.valueOf(Math.round(this.beta * 100) / 100);
 * is 
 * lines 179-185: String beta = String.valueOf(Math.round(this.beta * 100));
		          if (this.beta == 0){
			      	  return ("0.00");
		          }
		          else{
			    	  return (beta.substring(0, beta.length() - 2) + "." + beta.substring(beta.length() - 2, beta.length()));
		          }
 * reason: The program must return two decimal places no matter what, so this algorithm was created. The value is multiplied by 100, rounded,
 * then converted to a string. Then a '.' is placed at the 2nd last index of the string which creates a string of the original number rounded to
 * two decimal places even if the last decimal is a zero.
 * date: March 21, 2015
 * author: newton
 */
/* comment changes
 * was
 * line 192: String gamma = String.valueOf(Math.round(this.gamma * 100) / 100);
 * is 
 * lines 192-198: String gamma = String.valueOf(Math.round(this.gamma * 100));
		          if (this.gamma == 0){
			      	  return ("0.00");
		          }
		          else{
			    	  return (gamma.substring(0, gamma.length() - 2) + "." + gamma.substring(gamma.length() - 2, gamma.length()));
		          }
 * reason: The program must return two decimal places no matter what, so this algorithm was created. The value is multiplied by 100, rounded,
 * then converted to a string. Then a '.' is placed at the 2nd last index of the string which creates a string of the original number rounded to
 * two decimal places even if the last decimal is a zero.
 * date: March 21, 2015
 * author: newton
 */
/* comment changes
 * was
 * line 205: String r = String.valueOf(Math.round(this.r * 100) / 100);
 * is 
 * lines 205-211: String r = String.valueOf(Math.round(this.r * 100));
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
public class MSS_Vector_3D_Pol {

	private double r; //magnitude
	private double alpha;
	private double beta;
	private double gamma; //angles in radians
	
	/**
	 * 3D polar vector constructor
	 * @param r
	 * @param alpha
	 * @param beta
	 * @param gamma
	 */
	public MSS_Vector_3D_Pol(double r, double alpha, double beta, double gamma){
		if ((double) Math.round(Math.sqrt(
				Math.pow(Math.cos(Math.toRadians(alpha)), 2) +
				Math.pow(Math.cos(Math.toRadians(beta)), 2) +
				Math.pow(Math.cos(Math.toRadians(gamma)), 2)) * 100) / 100
				== 1.0){ //angles must satisfy this condition to be mathematically valid
			this.r = Math.abs(r);
			this.alpha = Math.toRadians(alpha);
			this.beta = Math.toRadians(beta);
			this.gamma = Math.toRadians(gamma); //convert angles to radians because java works with radians
		}
		else{ //if the angles dont satisfy the condition above, create a zero vector with all angles equal to zero
			this.r = 0;
			this.alpha = 0;
			this.beta = 0;
			this.gamma = 0;
		}
	}
	
	public boolean setAngles(double alpha, double beta, double gamma){
		if ((double) Math.round(Math.sqrt(
				Math.pow(Math.cos(Math.toRadians(alpha)), 2) +
				Math.pow(Math.cos(Math.toRadians(beta)), 2) +
				Math.pow(Math.cos(Math.toRadians(gamma)), 2)) * 100) / 100
				== 1.0){ //angles must satisfy this condition
			this.alpha = Math.toRadians(alpha);
			this.beta = Math.toRadians(beta);
			this.gamma = Math.toRadians(gamma);
			return true; //return true if the angle set was successful
		}
		return false; //return false if the angles were invalid
	}
	
	/**
	 * gets r value
	 * @return double r
	 */
	public double getR(){
		return this.r;
	}
	/**
	 * gets alpha angle in radians
	 * @return double alpha
	 */
	public double getAlpha(){
		return this.alpha;
	}
	/**
	 * gets beta angle in radians
	 * @return double beta
	 */
	public double getBeta(){
		return this.beta;
	}
	/**
	 * gets gamma angle in radians
	 * @return double gamma
	 */
	public double getGamma(){
		return this.gamma;
	}
	
	/**
	 * returns a string of magnitude and all angles
	 * @return String
	 */
	public String toString(){
		return rToString() + "," + alphaToString() + "," + betaToString() + "," + gammaToString();
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
	 * returns a string of angle beta
	 * @return String
	 */
	public String betaToString(){
		String beta = String.valueOf(Math.round(Math.toDegrees(this.beta) * 100)); //multiplies number by 100 and converts to string
		if (this.beta == 0){
			return ("0.00");
		}
		else{
			return beta.substring(0, beta.length() - 2) + "." + beta.substring(beta.length() - 2, beta.length());//puts a '.' at the appropriate spot
		}
	}
	/**
	 * returns a string of angle gamma
	 * @return String
	 */
	public String gammaToString(){
		String gamma = String.valueOf(Math.round(Math.toDegrees(this.gamma) * 100)); //multiplies number by 100 and converts to string
		if (this.gamma == 0){
			return ("0.00");
		}
		else{
			return gamma.substring(0, gamma.length() - 2) + "." + gamma.substring(gamma.length() - 2, gamma.length());//puts a '.' at the appropriate spot
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
