import java.util.*;
@SuppressWarnings("unchecked")
public class Exam6_4
{
	static int MOD=111;
	
	public static int [][] mult(int [][] a,int [][] b)	//返回矩阵a和b相乘的矩阵
	{
		int n=a.length;
		int [][] c=new int[n][n];
		for (int i=0;i<n;i++)
			for (int j=0;j<n;j++)
			{
				for (int k=0;k<n;k++)
					c[i][j] += (a[i][k]*b[k][j]) % MOD;
				c[i][j] %= MOD;
			}
		return c;
	}
	public static int [][] pow(int [][] a,int k)	//返回a^k的矩阵
	{
		int n=a.length;
		int [][] ans=new int[n][n];		//建立ans矩阵
		for (int i=0;i<n;i++)			//置ans为单位矩阵
			ans[i][i]=1;
		int [][] base=new int[n][n];	//建立base矩阵
		for (int i=0;i<n;i++)			//置base=a
			for (int j=0;j<n;j++)
				base[i][j]=a[i][j];
		while(k!=0)
		{
			if ((k&1)==1)				//k为奇数时
				ans=mult(ans,base);
			base=mult(base,base);
			k >>= 1;
		}
		return ans;
	}

	public static void disp(int [][] a)
	{
		for (int i=0;i<a.length;i++)
		{
			for (int j=0;j<a.length;j++)
				System.out.printf("%4d",a[i][j]);
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		int n=3;
		int [][] a={{1,2,1},{0,2,3},{1,0,1}};
		System.out.println("a:"); disp(a);
		int [][] b=new int[n][n];
		int k=2;
		b=pow(a,k);
		System.out.printf("b=a^%d\n",k);
		System.out.println("b:"); disp(b);
		k=5;
		b=pow(a,k);
		System.out.printf("b=a^%d\n",k);
		System.out.println("b:"); disp(b);
	}		
} 