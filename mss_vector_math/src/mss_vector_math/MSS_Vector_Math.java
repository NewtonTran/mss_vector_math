package mss_vector_math;

/**
 * This class contains various methods for vector calculations for 1D, 2D and 3D vectors.
 * different operations within this class include conversion between algebraic and polar, vector addition, scalar multiplication, dot product and cross product.
 * 
 * @author newton
 */
/* comment changes
 * was
 * line 290: return (double) Math.round(A.getx() * B.getx() + A.gety() * B.gety() * 100) / 100;
 * is
 * line 290: return (double) Math.round((A.getx() * B.getx() + A.gety() * B.gety()) * 100) / 100;
 * reason: Rounding error. Only the last term (A.gety() * B.gety()) was multiplied by 100 instead of the entire expression. Brackets were added around the main dot product equation.
 * date: March 21, 2015
 * author: newton
 */
/* comment changes
 * was
 * line 302: return (double) Math.round(C.getx() * D.getx() + C.gety() * D.gety() * 100) / 100;
 * is
 * line 302: return (double) Math.round((C.getx() * D.getx() + C.gety() * D.gety()) * 100) / 100;
 * reason: Rounding error. Only the last term (C.gety() * D.gety()) was multiplied by 100 instead of the entire expression. Brackets were added around the main dot product equation.
 * date: March 21, 2015
 * author: newton
 */
/* comment changes
 * was
 * line 311: return (double) Math.round(A.getx() * B.getx() + A.gety() * B.gety() + A.getz() * B.getz() * 100) / 100;
 * is
 * line 311: return (double) Math.round((A.getx() * B.getx() + A.gety() * B.gety() + A.getz() * B.getz()) * 100) / 100;
 * reason: Rounding error. Only the last term (A.getz() * B.getz()) was multiplied by 100 instead of the entire expression. Brackets were added around the main dot product equation.
 * date: March 21, 2015
 * author: newton
 */
/* comment changes
 * was
 * line 323: return (double) Math.round(C.getx() * D.getx() + C.gety() * D.gety() + C.getz() * D.getz() * 100) / 100;
 * is
 * line 323: return (double) Math.round((C.getx() * D.getx() + C.gety() * D.gety() + C.getz() * D.getz()) * 100) / 100;
 * reason: Rounding error. Only the last term (C.getz() * D.getz()) was multiplied by 100 instead of the entire expression. Brackets were added around the main dot product equation.
 * date: March 21, 2015
 * author: newton
 */
public class MSS_Vector_Math {

	/**
	 * algToPol for 1D
	 * @param alg
	 * @return MSS_Vector_1D_Pol
	 */
	public static MSS_Vector_1D_Pol algToPol(MSS_Vector_1D_Alg alg){
		if (alg.getValue() >= 0){ //if x is positive
			return new MSS_Vector_1D_Pol(alg.getValue(), 0); //magnitude of vector will be magnitude of x, and alpha will be 0
		}
		else{ //if x is negative
			return new MSS_Vector_1D_Pol(Math.abs(alg.getValue()), 180); //magnitude of vector will be magnitude of x, and alpha will be pi
		} 
	}
	/**
	 * algToPol for 2D
	 * @param alg
	 * @return MSS_Vector_2D_Pol
	 */
	public static MSS_Vector_2D_Pol algToPol(MSS_Vector_2D_Alg alg){
		double r, alpha, x, y;
		x = alg.getx();
		y = alg.gety();
		r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)); //formula for magnitude of 2d vector
		if (r != 0){ //if magnitude is not zero
			if (y < 0){ //if y is negative
				if (x < 0){ //if x is negative
					alpha = Math.toDegrees(Math.abs(Math.asin(y/r)) + Math.PI); //alpha will be sin^-1 of y/r + pi
				}
				else{ // if x in positive
					alpha = Math.toDegrees(2 * Math.PI + Math.asin(y/r)); //alpha will be sin^-1 of y/r + 2pi
				}
			}
			else{ //if y is positive
				if (x < 0){ //if x is negative
					alpha = Math.toDegrees(Math.PI - Math.asin(y/r)); //alpha will be pi - sin^-1 of y/r
				}
				else{ //if x is positive
					alpha = Math.toDegrees(Math.asin(y/r)); //alpha will be sin^-1 of y/r
				}
			}
		}
		else{ // if magnitude is 0, return a 0 vector with an alpha of 0
			alpha = 0;
		}
		return new MSS_Vector_2D_Pol(r, alpha); //return a 2D vector with the specifications above
	}
	/**
	 * algToPol for 3D
	 * @param alg
	 * @return MSS_Vector_3D_Pol
	 */
	public static MSS_Vector_3D_Pol algToPol(MSS_Vector_3D_Alg alg){
		double r, alpha, beta, gamma;
		r = Math.sqrt(Math.pow(alg.getx(), 2) + Math.pow(alg.gety(), 2) + Math.pow(alg.getz(), 2)); //formula for magnitude
		alpha = Math.toDegrees(Math.acos(alg.getx()/r)); //formula for alpha
		beta = Math.toDegrees(Math.acos(alg.gety()/r)); //formula for beta
		gamma = Math.toDegrees(Math.acos(alg.getz()/r)); //formula for gamma
		return new MSS_Vector_3D_Pol(r, alpha, beta, gamma); //return a 3D vector with the specifications above
	}
	
	/**
	 * polToAlg for 1D
	 * @param pol
	 * @return MSS_Vector_1D_Alg
	 */
	public static MSS_Vector_1D_Alg polToAlg(MSS_Vector_1D_Pol pol){
		double value;
		value = (pol.getR() * Math.cos(pol.getAlpha())); //formula for x comp
		return new MSS_Vector_1D_Alg(value); //return a 1D vector with the specifications above
	}
	/**
	 * polToAlg for 2D
	 * @param pol
	 * @return MSS_Vector_2D_Alg
	 */
	public static MSS_Vector_2D_Alg polToAlg(MSS_Vector_2D_Pol pol){
		double x, y;
		x = (pol.getR() * Math.cos(pol.getAlpha())); //formula for x comp
		y = (pol.getR() * Math.sin(pol.getAlpha())); //formula for y comp
		return new MSS_Vector_2D_Alg(x, y); //return a 2D vector with the specifications above
	}
	/**
	 * polToAlg for 3D
	 * @param pol
	 * @return MSS_Vector_3D_Alg
	 */
	public static MSS_Vector_3D_Alg polToAlg(MSS_Vector_3D_Pol pol){
		double x, y, z;
		x = (pol.getR() * Math.cos(pol.getAlpha())); //formula for x comp
		y = (pol.getR() * Math.cos(pol.getBeta())); //formula for y comp
		z = (pol.getR() * Math.cos(pol.getGamma())); //formula for z comp
		return new MSS_Vector_3D_Alg(x, y, z); //return a 3D vector with the specifications above
	}
	
	/**
	 * scalarMultiply for 1D algebraic vectors
	 * @param alg
	 * @param scalar
	 * @return MSS_Vector_1D_Alg
	 */
	public static MSS_Vector_1D_Alg scalarMultiply (MSS_Vector_1D_Alg alg, double scalar){
		return new MSS_Vector_1D_Alg(scalar * alg.getValue()); //returns the 1d vector given, multiplied by the scalar provided.
	}
	/**
	 * scalarMultiply for 2D algebraic vectors
	 * @param alg
	 * @param scalar
	 * @return MSS_Vector_2D_Alg
	 */
	public static MSS_Vector_2D_Alg scalarMultiply (MSS_Vector_2D_Alg alg, double scalar){
		return new MSS_Vector_2D_Alg(scalar * alg.getx(), scalar * alg.gety()); //returns the 2d vector given, multiplied by the scalar provided.
	}
	/**
	 * scalarMultiply for 3D algebraic vectors
	 * @param alg
	 * @param scalar
	 * @return MSS_Vector_3D_Alg
	 */
	public static MSS_Vector_3D_Alg scalarMultiply (MSS_Vector_3D_Alg alg, double scalar){
		return new MSS_Vector_3D_Alg(scalar * alg.getx(), scalar * alg.gety(), scalar * alg.getz()); //returns the 3d vector given, multiplied by the scalar provided.
	}
	
	/**
	 * scalarMultiply for 1D polar vectors
	 * @param pol
	 * @param scalar
	 * @return MSS_Vector_1D_Pol
	 */
	public static MSS_Vector_1D_Pol scalarMultiply (MSS_Vector_1D_Pol pol, double scalar){
		return algToPol(scalarMultiply(polToAlg(pol), scalar)); //uses alg scalar multiplication method then converts back to polar
	}
	/**
	 * scalarMultiply for 2D polar vectors
	 * @param pol
	 * @param scalar
	 * @return MSS_Vector_2D_Pol
	 */
	public static MSS_Vector_2D_Pol scalarMultiply (MSS_Vector_2D_Pol pol, double scalar){
		return algToPol(scalarMultiply(polToAlg(pol), scalar)); //uses alg scalar multiplication method then converts back to polar
	}
	/**
	 * scalarMultiply for 3D polar vectors
	 * @param pol
	 * @param scalar
	 * @return MSS_Vector_3D_Pol
	 */
	public static MSS_Vector_3D_Pol scalarMultiply (MSS_Vector_3D_Pol pol, double scalar){
		return algToPol(scalarMultiply(polToAlg(pol), scalar)); //uses alg scalar multiplication method then converts back to polar
	}
	
	/**
	 * vector addition for 1D algebraic vectors
	 * @param algs
	 * @return MSS_Vector_1D_Alg
	 */
	public static MSS_Vector_1D_Alg add(MSS_Vector_1D_Alg[] algs){
		double x;
		x = 0;
		for(int i=0;i <= algs.length - 1;i++){ //for each vector in the list given
			x = x + algs[i].getValue(); //add the x value of the vector in the list to the resultant vector's x value
		}
		return new MSS_Vector_1D_Alg(x); //return a vector with the new x value
	}
	/**
	 * vector addition for 2D algebraic vectors
	 * @param algs
	 * @return MSS_Vector_2D_Alg
	 */
	public static MSS_Vector_2D_Alg add(MSS_Vector_2D_Alg[] algs){
		double x, y;
		x = 0;
		y = 0;
		for(int i=0;i <= algs.length - 1;i++){ //for each vector in the list given
			x = x + algs[i].getx(); //add the x and y comps of the vector in the list to the resultant vector's comps
			y = y + algs[i].gety();
		}
		return new MSS_Vector_2D_Alg(x, y); //return a vector with the resultant comps
	}
	/**
	 * vector addition for 3D algebraic vectors
	 * @param algs
	 * @return MSS_Vector_3D_Alg
	 */
	public static MSS_Vector_3D_Alg add(MSS_Vector_3D_Alg[] algs){
		double x, y, z;
		x = 0;
		y = 0;
		z = 0;
		for(int i=0;i <= algs.length - 1;i++){ //for each vector in the list given
			x = x + algs[i].getx(); //add the x, y and z comps of the vector in the list to the resultant vector's comps
			y = y + algs[i].gety();
			z = z + algs[i].getz();
		}
		return new MSS_Vector_3D_Alg(x, y, z); //return a vector with the resultant comps
	}
	
	/**
	 * vector addition for 1D polar vectors
	 * @param pols
	 * @return MSS_Vector_1D_Pol
	 */
	public static MSS_Vector_1D_Pol add(MSS_Vector_1D_Pol[] pols){
		MSS_Vector_1D_Alg algs[]; //new array of alg vectors
		algs = new MSS_Vector_1D_Alg[pols.length];
		for(int i=0;i < pols.length;i++){ //add converted vectors to the new array
			algs[i] = polToAlg(pols[i]);
		}
		return algToPol(add(algs)); //uses alg add method then converts back to polar
	}
	/**
	 * vector addition for 2D polar vectors
	 * @param pols
	 * @return MSS_Vector_2D_Pol
	 */
	public static MSS_Vector_2D_Pol add(MSS_Vector_2D_Pol[] pols){
		MSS_Vector_2D_Alg algs[]; //new array of alg vectors
		algs = new MSS_Vector_2D_Alg[pols.length];
		for(int i=0;i < pols.length;i++){ //add converted vectors to the new array
			algs[i] = polToAlg(pols[i]);
		}
		return algToPol(add(algs)); //uses alg add method then converts back to polar
	}
	/**
	 * vector addition for 3D polar vectors
	 * @param pols
	 * @return MSS_Vector_3D_Pol
	 */
	public static MSS_Vector_3D_Pol add(MSS_Vector_3D_Pol[] pols){
		MSS_Vector_3D_Alg algs[];
		algs = new MSS_Vector_3D_Alg[pols.length]; //new array of alg vectors
		for(int i=0;i <= pols.length - 1;i++){
			algs[i] = polToAlg(pols[i]); //add converted vectors to the new array
		}
		return algToPol(add(algs)); //uses alg add method then converts back to polar
	}
	
	/**
	 * dotMultiply for 2D algebraic vectors
	 * @param A
	 * @param B
	 * @return double dotProduct
	 */
	public static double dotMultiply (MSS_Vector_2D_Alg A, MSS_Vector_2D_Alg B){
		return (double) Math.round((A.getx() * B.getx() + A.gety() * B.gety()) * 100) / 100; //formula for dot product (rounded to 2 decimal places)
	}//A bracket was added to this method because of an error with rounding.
	/**
	 * dotMultiply for 2D polar vectors
	 * @param A
	 * @param B
	 * @return double dotProduct
	 */
	public static double dotMultiply (MSS_Vector_2D_Pol A, MSS_Vector_2D_Pol B){
		MSS_Vector_2D_Alg C, D;
		C = polToAlg(A); //conversions to alg
		D = polToAlg(B);
		return (double) Math.round((C.getx() * D.getx() + C.gety() * D.gety()) * 100) / 100; //formula for dot product (rounded to 2 decimal places)
	}//A bracket was added to this method because of an error with rounding.
	/**
	 * dotMultiply for 3D algebraic vectors
	 * @param A
	 * @param B
	 * @return double dotProduct
	 */
	public static double dotMultiply (MSS_Vector_3D_Alg A, MSS_Vector_3D_Alg B){
		return (double) Math.round((A.getx() * B.getx() + A.gety() * B.gety() + A.getz() * B.getz()) * 100) / 100; //formula for dot product (rounded to 2 decimal places)
	}//A bracket was added to this method because of an error with rounding.
	/**
	 * dotMultiply for 3D polar vectors
	 * @param A
	 * @param B
	 * @return double dotProduct
	 */
	public static double dotMultiply (MSS_Vector_3D_Pol A, MSS_Vector_3D_Pol B){
		MSS_Vector_3D_Alg C, D;
		C = polToAlg(A); //conversions to alg
		D = polToAlg(B);
		return (double) Math.round((C.getx() * D.getx() + C.gety() * D.gety() + C.getz() * D.getz()) * 100) / 100; //formula for dot product (rounded to 2 decimal places)
	} //A bracket was added to this method because of an error with rounding.
	
	/**
	 * crossMultiply for algebraic 3D vectors
	 * @param A
	 * @param B
	 * @return MSS_Vector_3D_Alg
	 */
	public static MSS_Vector_3D_Alg crossMultiply (MSS_Vector_3D_Alg A, MSS_Vector_3D_Alg B){
		double x, y, z;
		x = A.gety() * B.getz() - A.getz() * B.gety();
		y = A.getz() * B.getx() - A.getx() * B.getz();
		z = A.getx() * B.gety() - A.gety() * B.getx(); //formula for cross product
		return new MSS_Vector_3D_Alg(x, y, z);
	}
	/**
	 * crossMultiply for polar 3D vectors
	 * @param A
	 * @param B
	 * @return MSS_Vector_3D_Pol
	 */
	public static MSS_Vector_3D_Pol crossMultiply (MSS_Vector_3D_Pol A, MSS_Vector_3D_Pol B){
		MSS_Vector_3D_Alg C, D;
		C = polToAlg(A); //conversions to alg
		D = polToAlg(B);
		return algToPol(crossMultiply(C, D)); // uses alg cross product method then converts back to pol
	}
}
