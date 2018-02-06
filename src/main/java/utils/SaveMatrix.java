package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import base.PageRank;

public class SaveMatrix implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4710142960153185452L;

	public SaveMatrix() {
		
		
	}
	
	public void saveMatrix(PageRank H, String filename) {
		
		try {
			

			FileOutputStream fos = new FileOutputStream(filename + ".ha");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(H);
			oos.close();


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		System.out.println("Matrix saved as: " + filename + ".ha");
	}
	
	public PageRank openMatrix(String loc) {
		PageRank H = null;
		try {
	
			FileInputStream fis = new FileInputStream(loc);
			ObjectInputStream ois = new ObjectInputStream(fis);
			H = (PageRank) ois.readObject();
			ois.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		return H;

	}

}
