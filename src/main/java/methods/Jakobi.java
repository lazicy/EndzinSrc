package methods;

public class Jakobi {

	int[] racunaj(int A[][],int b[], int x0[], int itMax, int errMax)
	{
		int n = A.length;
		int[] x = new int[n];  //inicijalizacija od n clanova, nznm kako ide 
		
		for(int it=0;it<itMax;it++)
		{
			int err=0;
			for(int i=0;i<n;i++)
			{
				int sum = 0;
				for(int j=0;j<n;j++)
				{
					if(j==i) continue;
					sum = sum + A[i][j]*x0[j];	
				}
				
				x[i] = (b[i]-sum)/A[i][i];
				
				err = err+(x[i]-x0[i])^2;
			}
			
			for(int i=0;i<n;i++)
			{
				x0[i] = x[i];
			}
			
			if(err < errMax)
				return x;
			
		}
		
		for(int i=0;i<n;i++)
			x[i] = 0;
		return x;
	}
}