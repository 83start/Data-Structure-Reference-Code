@SuppressWarnings("unchecked")
public class Exam6_3
{
	static int N=4;
	public static void Trans(int[][]a)	//转置算法
	{
		int tmp;
		for (int i=0;i<a.length;i++)
			for (int j=0;j<i;j++)
			{
				tmp=a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=tmp;
			}
	}
	public static void disp(int a[][])
	{
		for (int i=0;i<N;i++)
		{
			for (int j=0;j<N;j++)
				System.out.printf("%4d",a[i][j]);
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		int [][] a=new int[N][N];
		int d=1;
		for (int i=0;i<N;i++)
			for (int j=0;j<N;j++)
				a[i][j]=d++;
		System.out.println("二维数组a");
		disp(a);
		System.out.println("转置a");
		Trans(a);
		System.out.println("转置后a");
		disp(a);
	}	   
} 