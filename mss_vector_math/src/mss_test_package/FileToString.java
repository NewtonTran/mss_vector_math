package mss_test_package;


//Include these libraries or others 
//that you may use for your File Reading/Writing algorithm

	import java.util.List;
	import java.io.IOException;
	import java.nio.charset.Charset;
	import java.nio.charset.StandardCharsets;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
/*
* FileInOut class is used to access small text files
* @Author
* @Since
* @Version	
*/
public class FileToString {
		  // these variables can have their values changed
		  // depending what files you will access ...
		
		  final static String FILE_NAME_1D = "input1.txt";
		  final static String FILE_NAME_2D = "input2.txt";
		  final static String FILE_NAME_3D = "input3.txt";
		  final static String OUTPUT_FILE_NAME = "output.txt";
		  final static String OUTPUT_FILE_BASE_NAME_3D = "outputcheck3.txt";
		  final static String OUTPUT_FILE_BASE_NAME_2D = "outputcheck2.txt";
		  final static String OUTPUT_FILE_BASE_NAME_1D = "outputcheck1.txt";
		  
		  final static Charset ENCODING = StandardCharsets.UTF_8;
		  
		  /*
		   * ReadTextFile method will accept a filename as a parameter
		   * It will access that file and return its content as a List
		   * Each element of the list is a line of the text file
		   * 
		   * @param String aFileName a string representing the file name to be accessed
		   * 
		   * @return List<String> returns a List of Strings representing the lines of the File 
		   */
		  public static List<String> readTextFile(String aFileName) throws IOException {
			  //Path is a ready made Java class that can get 
			  //the path of a file in a given operating system
			  
			  Path path = Paths.get(aFileName);
			  
			  //Read all lines from a file. This method ensures that 
			  //the file is closed when all bytes have been read or an I/O error, 
			  //or other runtime exception, is thrown. 
			  //Bytes from the file are decoded into characters using 
			  //the specified charset. 
		   
			  return Files.readAllLines(path, ENCODING);
		  }
		  
		  
		  /*
		   * WriteTextFile method will accept a filename as a parameter
		   * It will access that file and return its content as a List
		   * Each element of the list is a line of the text file
		   * 
		   * @param List<String> aLines is a list of strings representing lines to be written in a given file
		   * @param String aFileName a string representing the file name to be accessed for writing
		   * 
		   */ 
		 public static void writeTextFile(List<String> aLines, String aFileName) throws IOException {
		    Path path = Paths.get(aFileName);
		    Files.write(path, aLines, ENCODING);
		  }
		 
		  /*
		   * mark method will accept two filenames 
		   * representing two files that will be accessed 
		   * and evaluated how their content is similar/different 
		   * 
		   * @param String OUTPUT_FILE_NAME 
		   * @param String OUTPUT_FILE_BASE_NAME
		   * 
		   * @return String returns the mark and lines that are different between files
		   * as a string
		   */
		 public static String mark (String OUTPUT_FILE_NAME, String OUTPUT_FILE_BASE_NAME) throws IOException{
			 
			 float mark = 0;
			 
			 String line = "";
			 //read content of both files and get their content in two list<String>
			 
			 List<String> contentTest = readTextFile(OUTPUT_FILE_NAME);
			 List<String> contentCheck = readTextFile(OUTPUT_FILE_BASE_NAME);
			 //if content is not the same size then give a mark of 0%
			 if (contentTest.size()!=contentCheck.size())
				 return "Your mark is : "+ mark + "%\n the size of your output file did not match the expected file!";
			 
			 else {
				 // Check the content line by line
				 // If they match add the mark by one
				 // If they don't add the index of the line to report it as mistake
				 for (int i=0; i< contentTest.size();i++){
					 if (contentTest.get(i).equals(contentCheck.get(i)))
						 mark  = mark + 1;
					 else
						 line = line + ", " + (i+1) + " : " + contentTest.get(i);
				 }
			 }
			 if (mark/contentCheck.size() == 1)
				 line = "0";
			 //return a string representing the mark
			 return "Your mark is : "+ Math.round(mark/contentCheck.size()*100)*100.0/100 + "%\nYou hade line(s):" + line + " out of " + contentTest.size() + " that did not pass the test!";
		 }
}