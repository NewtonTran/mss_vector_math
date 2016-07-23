package mss_vector_math;

/**
 * All 1D algebraic vectors will be an instance of this class
 * This class allows the user to get, print, and set the x value of the vector as well as construct new vectors
 * 
 * @author newton
 * @version 3.0
 */
/* comment changes
 * was
 * line 66: public String ToString(){
 * is 
 * line 66: public String toString(){
 * reason: the 'to' in the method name was accidentally capitalized in the previous version. The method name was changed to 'toString()'.
 * date: March 21, 2015
 * author: newton
 */
/* comment changes
 * was
 * line 67: String coordinate = String.valueOf(Math.round(this.coordinate * 100) / 100);
 * is 
 * lines 67-73: String coordinate = String.valueOf(Math.round(this.coordinate * 100));
		        if (this.coordinate == 0){
			    	return ("0.00");
		        }
		        else{
			    	return (coordinate.substring(0, coordinate.length() - 2) + "." + coordinate.substring(coordinate.length() - 2, coordinate.length()));
		        }
 * reason: The program must return two decimal places no matter what, so this algorithm was created. The value is multiplied by 100, rounded,
 * then converted to a string. Then a '.' is placed at the 2nd last index of the string which creates a string of the original number rounded to
 * two decimal places even if the last decimal is a zero.
 * date: March 21, 2015
 * author: newton
 */
public class MSS_Vector_1D_Alg {

	private double coordinate; //x value
	
	/**
	 * 1D algebraic vector constructor
	 * @param value
	 */
	public MSS_Vector_1D_Alg(double value){
		this.coordinate = value; //takes in the x comp of the vector and assigns it to coordinate
	}
	
	/**
	 * gets x coordinate
	 * @return double coordinate
	 */
	public double getValue(){
		return this.coordinate;
	}
	/**
	 * sets x coordinate
	 * @param value
	 */
	public void setValue(double value){
		this.coordinate = value;
	}
	
	/**
	 * returns a string of x coordinate
	 * @return String
	 */
	public String toString(){
		String coordinate = String.valueOf(Math.round(this.coordinate * 100)); //multiplies the number by 100 and converts to a string
		if (this.coordinate == 0){
			return ("0.00");
		}
		else{
			return (coordinate.substring(0, coordinate.length() - 2) + "." + coordinate.substring(coordinate.length() - 2, coordinate.length())); //puts a '.' at the appropriate spot
		}
	}
}
