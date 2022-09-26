import java.util.*;
@SuppressWarnings("unchecked")
public class Exam6_6
{
	public static void disp(int [][] A)		//输出二维数组A
	{
		int n=A.length;
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
				System.out.printf("%4d",A[i][j]);
			System.out.println();
		}
	}				
	public static void compression(int [][] A,int[] a)	//将A压缩存储到a中
	{
		for(int i=0;i<A.length;i++)
			for(int j=0;j<=i;j++)
			{
				int k=i*(i+1)/2+j;
				a[k]=A[i][j];
			}
	}
	public static int getk(int i,int j)		//由i、j求压缩存储中的k下标
	{	if (i>=j)
			return (i*(i+1)/2+j);
		else
			return (j*(j+1)/2+i);
	} 	
	public static void Mult(int []a,int[] b,int [][] C,int n)	//矩阵乘法
	{
		for (int i=0;i<n;i++)
			for (int j=0;j<n;j++)
			{	int s=0;
				for (int k=0;k<n;k++)
				{	int k1=getk(i,k);
					int k2=getk(k,j);
					s+=a[k1]*b[k2];
				}
				C[i][j]=s;
			}
	}
	public static void main(String[] args)
	{
		int n=3;
		int m=n*(n+1)/2;
		int [][] A={{1,2,3},{2,4,5},{3,5,6}};
		int [][] B={{2,1,3},{1,5,2},{3,2,4}};
		int [][] C=new int[n][n];
		int [] a= new int[m];
		int [] b= new int[m];
		System.out.println("A:"); disp(A);
		System.out.println("A压缩存储到a中");
		compression(A,a);
		System.out.print("a:");
		for (int i=0;i<m;i++)
			System.out.printf(" %d",a[i]);
		System.out.println();
		System.out.println("B:"); disp(B);
		System.out.println("B压缩存储到b中");
		compression(B,b);
		System.out.print("b:");
		for (int i=0;i<m;i++)
			System.out.printf(" %d",b[i]);
		System.out.println();
		
		System.out.println("C=A*B");
		Mult(a,b,C,n);
		System.out.println("C:"); disp(C);		
	}
} 