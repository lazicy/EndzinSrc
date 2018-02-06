package base;




import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import utils.SaveMatrix;

public class PageRank  implements Serializable{
	
	private double H[][];
	
	
	public PageRank() {
		
	}
	
	public static void printAll(DBCollection coll) {
		DBCursor cursor =  coll.find();
		try {
			while(cursor.hasNext()) 
		       System.out.println(cursor.next());
		    
		} finally {
		   
		}
		
	}
	
	public static double[][] opetConnectionMatrix(String loc) {
		PageRank o = new PageRank();
		SaveMatrix s = new SaveMatrix();
		o = s.openMatrix(loc); 
		return o.H;
	}
	
	public static void makeConnectionMatrix(DBCollection coll) {
		DBCursor cursor =  coll.find();
		//int n = cursor.count();
		int n = 10500;
		System.out.println("N[CursorCount] = " + n);
		
		DBObject query;
		double matrix[][] = new double[n][n];
		
		BasicDBObject keys = new BasicDBObject();
		
		keys.put("vodiNa", true);
		keys.put("_id", false);
		final DBCursor usersCursor = coll.find(new BasicDBObject(), keys);
		
		double[] provera = new double[n];
		int i = 0;
		while(usersCursor.hasNext() && i < n) {
			
			ArrayList<Integer> vodiNaList = (ArrayList<Integer>) usersCursor.next().get("vodiNa");
			ArrayList<Integer> list = new ArrayList<>();
			long start = System.currentTimeMillis();
			double sum = 0;
			for (int j = 0; j < n; j++) {
				//System.out.println("i: "+ i + " \\ j: " + j);
				
				if (vodiNaList.contains(j)) {
					sum += 1;
					matrix[j][i] = 1;
					list.add(j);
				}
				
				
			}
			double pr = 0;
			for (int k : list) {
				//System.out.println("Lista[" + k + "]= " + list.get(k));
				
				matrix[k][i] = 1.00/sum;
				pr += matrix[k][i];
				
			
			}
			provera[i] = pr;
			long end = System.currentTimeMillis();
			System.out.println("Time consumed [" + i + "] iteration: " + (end-start));
			System.out.println("List size: " + list.size() + " || 1/Suma: " + (1.0/sum));
			
			++i;
			
			
		}
		
		System.out.println("provera[0]" + provera[0] );
		
		System.out.println("provera[23]" + provera[23] );
		
		System.out.println("provera[28]" + provera[28] );
		
		System.out.println("provera[100]" + provera[28] );
		
		System.out.println("provera[205]" + provera[28] );
		
		System.out.println("provera[354]" + provera[28] );
		
		System.out.println("provera[499]" + provera[28] );
		
		System.out.println("provera[528]" + provera[528] );
		
		System.out.println("provera[913]" + provera[913] );
		
		System.out.println("provera[921]" + provera[921] );
		
		/*System.out.println("provera[12000]" + provera[12000] );
		
		System.out.println("provera[13405]" + provera[13405] );
		
		System.out.println("provera[14236]" + provera[14236] );
		
		System.out.println("provera[15936]" + provera[15936] );
		
		System.out.println("provera[15936]" + provera[15936] );
		
		System.out.println("provera[16854]" + provera[16854] );
		
		System.out.println("provera[17213]" + provera[17213] );
		
		System.out.println("provera[21213]" + provera[21213] );
		
		System.out.println("provera[22213]" + provera[22213] );
		
		System.out.println("provera[30513]" + provera[30513] );
		
		System.out.println("provera[32514]" + provera[32514] );
		
		System.out.println("provera[5]" + provera[5] );
		
		System.out.println("provera[34568]" + provera[34568] );
		
		System.out.println("provera[36000]" + provera[36000] );
		*/
		PageRank p = new PageRank();
		p.setH(matrix);
		
		SaveMatrix s = new SaveMatrix();
		s.saveMatrix(p, "D:\\mongodb\\matrix");
		
		//print2D(matrix);
		
		
		
		//System.out.println(Arrays.deepToString(matrix));
	}
		
		
	 public static void print2D(double mat[][]){
	       
	        for (double[] row : mat)
	            System.out.println(Arrays.toString(row));
	 }
	 
	 private void setH(double mat[][]) {
		 this.H = mat;
	 }

}
