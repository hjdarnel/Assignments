import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

//@author Henry Darnell
//ID 010646670
//Algorithms - Beavers

public class Assignment1B {
final static boolean DEBUG = false;
final static int THRESHOLD = 64;
static double[][] lhs;
static double[][] rhs;
static double[][] result;

			
	private static double[][] add(double[][] a, double[][] b){
		double[][] c = new double[a.length][a.length];
		
		for (int x = 0; x < a.length; x++){
			for (int y = 0; y < a.length; y++){
				c[x][y] = a[x][y] + b[x][y];
			}
		}
			
		return c;
	}
	
	private static double[][] sub(double[][] a, double[][] b){
		double[][] c = new double[a.length][a.length];
		
		for (int x = 0; x < a.length; x++){
			for (int y = 0; y < a.length; y++){
				c[x][y] = a[x][y] - b[x][y];
			}
		}
		
		return c;
	}
		
	private static void getInput() throws IOException{
		Scanner in = new Scanner(new File("input.txt"));
		int size = in.nextInt();
		
		if (lhs == null && rhs == null){
			lhs = new double[size][size];
			rhs = new double[size][size];
			result = new double[size][size];
		}
		
		if (DEBUG)
			System.out.println("Input size is: " + size);
				
		for (int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				lhs[x][y] = in.nextInt();
			}
		}
		for (int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				rhs[x][y] = in.nextInt();
			}
		}
		
		if (DEBUG){
			System.out.println("lhs is: " + Arrays.deepToString(lhs));
			System.out.println("rhs is: " + Arrays.deepToString(rhs));
		}
		in.close();
	}
	
	private static void writeOutput() throws FileNotFoundException{
		PrintWriter wr = new PrintWriter("output.txt");
		
		for (int x = 0; x < result.length; x++){
			for(int y = 0; y < result.length; y++){
				wr.print(result[x][y] + " ");
							
			}
			wr.println("");
		}
		
		wr.close();
		
	}

	private static double[][] classicMult(double[][] a, double[][] b){
		int n = a.length;
		double[][] c = new double[n][n];
		
		for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
		
		return c;
	}
	
	private static double[][] multiply(double[][] a, double[][] b){
		int n = a.length;
		double[][] result = new double[n][n];
		int halfSize = n / 2;
		
		if(n < THRESHOLD){
			result = classicMult(a, b);
		}
		else{			
	        double[][] a11 = new double[halfSize][halfSize];
	        double[][] a12 = new double[halfSize][halfSize];
	        double[][] a21 = new double[halfSize][halfSize];
	        double[][] a22 = new double[halfSize][halfSize];
	        double[][] b11 = new double[halfSize][halfSize];
	        double[][] b12 = new double[halfSize][halfSize];
	        double[][] b21 = new double[halfSize][halfSize];
	        double[][] b22 = new double[halfSize][halfSize];

	        double[][] aResult = new double[halfSize][halfSize];
	        double[][] bResult = new double[halfSize][halfSize];
	        
	      
	        for (int i = 0; i<halfSize; i++) {
	            for (int j = 0; j<halfSize; j++) {
	                a11[i][j] = a[i][j];
	                a12[i][j] = a[i][j + halfSize];
	                a21[i][j] = a[i + halfSize][j];
	                a22[i][j] = a[i + halfSize][j + halfSize];

	                b11[i][j] = b[i][j];
	                b12[i][j] = b[i][j + halfSize];
	                b21[i][j] = b[i + halfSize][j];
	                b22[i][j] = b[i + halfSize][j + halfSize];
	            }
	        }
	        
	        
	        //Calculate m1 through m7
	        //m1 = (a11+a22)(b11+b22)
	        aResult = add(a11, a22);
	        bResult = add(b11, b22);
	        double[][] m1 = multiply(aResult, bResult);
	        
	        //m2 = (a21+a22)b11
	        aResult = add(a21, a22);
	        double[][] m2 = multiply(aResult, b11);
	        
	        //m3 = a11(b12 - b22)
	        bResult = sub(b12, b22);
	        double[][] m3 = multiply(a11, bResult);
	        
	        //m4 = a22(b21-b11)
	        bResult = sub(b21, b11);
	        double[][] m4 = multiply(a22, bResult);
	        
	        //m5 = (a11+a12)b22
	        aResult = add(a11, a12);
	        double[][] m5 = multiply(aResult, b22);
	        
	        //m6 = (a21-a11)(b11+b12)
	        aResult = sub(a21, a11);
	        bResult = add(b11, b12);
	        double[][] m6 = multiply(aResult, bResult);
	        
	        //m7 = (a12-a22)(b21+b22)
	        aResult = sub(a12, a22);
	        bResult = add(b21, b22);
	        double[][] m7 = multiply(aResult, bResult);
	        
	        //c11 = m1 + m4 + m7 - m5
	        aResult = add(m1, m4);
	        bResult = add(aResult, m7);
	        double[][] c11 = sub(bResult, m5);
	        		
	        //c12 = m3 + m5
	        double[][] c12 = add(m3, m5);
	        
	        //c21 = m2 + m4
	        double[][] c21 = add(m2, m4);
	        
	        //c22 = m1 + m3 + m6 - m2
	        aResult = add(m1, m3);
	        bResult = add(aResult, m6);
	        double[][] c22 = sub(bResult, m2);
				
	        System.out.println(Arrays.deepToString(c11));
	        System.out.println(Arrays.deepToString(c12));
	        System.out.println(Arrays.deepToString(c21));
	        System.out.println(Arrays.deepToString(c22));
	        
	        
	        //combine the 4 subparts into 1 result
			for (int i = 0; i < halfSize; i++){
				for (int j = 0; j < halfSize; j++){
					result[i][j] = c11[i][j];
					result[i][j + halfSize] = c12[i][j];
					result[i + halfSize][j] = c21[i][j];
					result[i + halfSize][j + halfSize] = c22[i][j];
				}
			}
			return result;
		}
		return result;
	}

	public static void main(String[] args) {
		
		try {
			getInput();
		} catch (IOException e) {
			System.out.println("Input file not found");
			e.printStackTrace();
		}
		
		result = multiply(lhs, rhs);
		
		try {
			writeOutput();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to write to result file.");
			e.printStackTrace();
		}
	}
}
