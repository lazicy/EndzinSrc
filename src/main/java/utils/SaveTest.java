package utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class SaveTest {
   
   
   private static BufferedWriter out;
	
	
	public static void kreiraj()
	{
		try {
			out =  new BufferedWriter(new FileWriter("test.txt"));
		} catch (IOException e) {
			System.out.println("null kreiranje upisnog fajla: ");
			e.printStackTrace();
		}
	}
	

	
	
	public static void upisi(String s)
	{
		if(out==null)
			return;
		
		try {
			out.write(s);
		} catch (IOException e) {
			System.out.println("null upisivanje fajla: ");
			e.printStackTrace();
		}
	}
	
   
   
   
}
