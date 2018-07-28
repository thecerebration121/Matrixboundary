package submatrix;


import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String args[])
	{
		int i=0 , j=0;
		int subsize=0;
		int rows=0;
		int cols=0;
	
		System.out.println("Enter matrix rows/length :");
		Scanner in = new Scanner(System.in);
		rows= in.nextInt();
		System.out.println("Enter matrix columns/width :");
		cols= in.nextInt();
		
		int[][] matrixInput = new int[rows][cols];

		System.out.println("enter matrix :");
	
		for(i=0;i<rows;i++)
		{
			for(j=0;j<cols;j++)
			{
				matrixInput[i][j]=in.nextInt();
			}
		}
		printMatrix(matrixInput , rows , cols);
		
		System.out.println("enter square sub matrix size :");
		subsize=in.nextInt();

		findSubmatrix(matrixInput , rows , cols ,subsize);
		//System.out.println(sumCalculate(matrixInput , rows ,cols));
	
	}
	
	public static int findSubmatrix(int[][] matrix , int rows , int cols , int subsize)
	{
		int i=0 , j=0 , k=0 , l=0;
		int m=0,n=0;
		HashMap<Integer[][] , Integer> hs = new HashMap<Integer[][] , Integer>();

	int[][] input= new int[subsize][subsize];
		
		for(i=0;i<rows;i++)
		{
			if( (rows-i) < subsize)
				break;
			
			for(j=0;j<cols;j++)
			{
				if((cols-j) < subsize )
					break;
				else
				{
					for(k=i; k<i+subsize; k++)
					{
						for(l=j;l<j+subsize;l++)
						{
							
							input[m][n]=matrix[k][l];

							n++;
						}
						m++;
						n=0;
						
					}
					int sum = sumCalculate(input , subsize ,subsize);
					hs.put(convert(input  , subsize) , Integer.valueOf(sum) );
					m=0;
					n=0;
					printMatrix(input , subsize , subsize);							
				}
			}
			
		}
		
	//	System.out.println("now that all the square matrices from the input are in the hashmap , lets retrieve the one with highest sum");
		
		printAns(hs , subsize);
		return 0;
	}

	public static void printAns(HashMap<Integer[][] , Integer> hs , int subsize )
	{
		Integer[][] result= new Integer[subsize][subsize];
		Integer max=0;
		
	/*	for(Integer[][] i : hs.keySet())
		{
			result = i;
			for(int l=0;l<subsize;l++)
			{
				for(int j=0;j<subsize;j++)
				{
					System.out.print(result[l][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		*/
		
		for(Integer[][] i : hs.keySet())
		{
			if( hs.get(i) > max)
				max = hs.get(i);
		}
		for(Integer[][] i : hs.keySet())
		{
			if( hs.get(i) == max)
				result = i;
		}
		
		System.out.println("output is : ");
		for(int i=0;i<subsize;i++)
		{
			for(int j=0;j<subsize;j++)
			{
				System.out.print(result[i][j]);
			}
			System.out.println();
			
		}
		System.out.println("the sum is : " +hs.get(result));

	}
	public static Integer[][] convert(int[][] matrix , int subsize)
	{
		Integer[][] ret = new Integer[subsize][subsize];
		for(int i=0;i<subsize;i++)
		{
			for(int j=0; j<subsize;j++)
			{
				ret[i][j]=Integer.valueOf(matrix[i][j]);
			}
		}
		return ret;
	}
	
	public static void printMatrix(int[][] matrix , int rows , int cols)
	{
		int i=0 , j=0;
		for(i=0;i<rows;i++)
		{
			for(j=0;j<cols;j++)
			{
				System.out.print(" "+matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int sumCalculate(int[][] matrix , int rows ,int cols)
	{
		int sum=0 , i=0 , j=0;
		for(i=0;i<rows;i++)
		{
			for(j=0;j<cols;j++)
			{
				if(( (rows-1)-i)!=0 && ((rows-1)-i)!=(rows - 1) )
				{
					sum+=matrix[i][0];
					sum+=matrix[i][rows-1];
					break;
				}
				else
				{
					sum+=matrix[i][j];
				}
			}
		}
	
		return sum;
	}
	
	
	
}


