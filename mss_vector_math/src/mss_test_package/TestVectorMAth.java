package mss_test_package;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mss_vector_math.*;
public class TestVectorMAth {

	public static void main(String[] args) {
		
		
		
		try {
			switch (Integer.valueOf(args[0])){
			case 3:{
				double x = 0, y = 0, z = 0;
				List<String>input = FileToString.readTextFile(FileToString.FILE_NAME_3D);
				MSS_Vector_3D_Alg[] algs = new MSS_Vector_3D_Alg [input.size()];
				for (int i=0; i<input.size(); i++){
					String[] strComps = input.get(i).split(",");
					for (int j = 0; j<strComps.length; j++){
						switch (j){
						case 0: x = Double.valueOf(strComps[j]);break;
						case 1: y = Double.valueOf(strComps[j]);break;
						case 2: z = Double.valueOf(strComps[j]);break;
						}
					}
					algs[i] = new MSS_Vector_3D_Alg(x,y,z);
				}
				List<String> output = new ArrayList<String>();;
				//1 add i + j + k = 1.0, 1.0, 1.0
				output.add(MSS_Vector_Math.add(algs).toString());
				//2 scalar multiply  -i = -1.0, 0.0, 0.0
				output.add(MSS_Vector_Math.scalarMultiply(algs[0], -1).toString());
				//3 subtract i-j = 1.0, -1.0, 0.0
				MSS_Vector_3D_Alg[] ij = {algs[0],MSS_Vector_Math.scalarMultiply(algs[1], -1)};
				output.add(MSS_Vector_Math.add(ij).toString());
				//4 convert to polar i = 1, 0.0, 90.0, 90.0
				output.add(MSS_Vector_Math.algToPol(algs[0]).toString());
				//5 convert polar to algebraic 2.0, 2.0, 2.0 = 3.46, 55.0, 55.0, 55.0
				output.add(MSS_Vector_Math.algToPol(
						MSS_Vector_Math.scalarMultiply(
								MSS_Vector_Math.add(
										algs),2)).toString());
				//6 dot muliply i o i = 1.00
				output.add(Double.toString(MSS_Vector_Math.dotMultiply(algs[0], algs[0])));
				//7 cross multiply i x j = k = 0.0, 0.0, 1.0
				output.add(MSS_Vector_Math.crossMultiply(algs[0], algs[1]).toString());
				FileToString.writeTextFile(output, FileToString.OUTPUT_FILE_NAME);
				System.out.print(FileToString.mark(FileToString.OUTPUT_FILE_NAME, FileToString.OUTPUT_FILE_BASE_NAME_3D));


			} break;
			case 2:{
				double x = 0, y = 0;
				List<String>input = FileToString.readTextFile(FileToString.FILE_NAME_2D);
				MSS_Vector_2D_Alg[] algs = new MSS_Vector_2D_Alg [input.size()];
				for (int i=0; i<input.size(); i++){
					String[] strComps = input.get(i).split(",");
					for (int j = 0; j<strComps.length; j++){
						switch (j){
						case 0: x = Double.valueOf(strComps[j]);break;
						case 1: y = Double.valueOf(strComps[j]);break;
						}
					}
					algs[i] = new MSS_Vector_2D_Alg(x,y);
				}

				List<String> output = new ArrayList<String>();;
				//1 add i + j + k = 1.0,1.0
				output.add(MSS_Vector_Math.add(algs).toString());
				//2 scalar multiply  -i = -1.0,0.0
				output.add(MSS_Vector_Math.scalarMultiply(algs[0], -1).toString());
				//3 subtract i-j = 1.0,-1.0
				MSS_Vector_2D_Alg[] ij = {algs[0],MSS_Vector_Math.scalarMultiply(algs[1], -1)};
				output.add(MSS_Vector_Math.add(ij).toString());
				//4 convert to polar j = 1,90.0
				output.add(MSS_Vector_Math.algToPol(algs[1]).toString());
				//5 convert algebraic to polar  2.0, 2.0 = 2.8,45.0
				output.add(MSS_Vector_Math.algToPol(
						MSS_Vector_Math.scalarMultiply(
								MSS_Vector_Math.add(
										algs),2)).toString());
				//6 dot muliply i o i = 1.00
				output.add(Double.toString(MSS_Vector_Math.dotMultiply(algs[0], algs[0])));
				FileToString.writeTextFile(output, FileToString.OUTPUT_FILE_NAME);
				System.out.print(FileToString.mark(FileToString.OUTPUT_FILE_NAME, FileToString.OUTPUT_FILE_BASE_NAME_2D));
				

			}break;
			case 1:{
				double x = 0;
				List<String>input = FileToString.readTextFile(FileToString.FILE_NAME_1D);
				MSS_Vector_1D_Alg[] algs = new MSS_Vector_1D_Alg [input.size()];
				for (int i=0; i<input.size(); i++){
					String[] strComps = input.get(i).split(",");
					for (int j = 0; j<strComps.length; j++){
						switch (j){
						case 0: x = Double.valueOf(strComps[j]);break;
						}
					}
					algs[i] = new MSS_Vector_1D_Alg(x);
				}

				List<String> output = new ArrayList<String>();;
				//1 add i + = 0.0
				output.add(MSS_Vector_Math.add(algs).toString());
				//2 scalar multiply  -i = -1.0
				output.add(MSS_Vector_Math.scalarMultiply(algs[0], -1).toString());
				//3 subtract i-j = 2.0
				MSS_Vector_1D_Alg[] ij = {algs[0],MSS_Vector_Math.scalarMultiply(algs[1], -1)};
				output.add(MSS_Vector_Math.add(ij).toString());
				//4 convert to polar j = 1.0,180.0
				output.add(MSS_Vector_Math.algToPol(algs[1]).toString());
				//5 convert algebraic to polar  2.0= 2.0,0.0
				output.add(MSS_Vector_Math.algToPol(
						MSS_Vector_Math.scalarMultiply(
								MSS_Vector_Math.add(
										algs),2)).toString());
				FileToString.writeTextFile(output, FileToString.OUTPUT_FILE_NAME);
				System.out.print(FileToString.mark(FileToString.OUTPUT_FILE_NAME, FileToString.OUTPUT_FILE_BASE_NAME_1D));
				

			}break;
			default:System.out.println("No valid selection");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException nfe) {
			// TODO Auto-generated catch block
			nfe.printStackTrace();
		}

	}

}