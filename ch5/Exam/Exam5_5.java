//@SuppressWarnings("unchecked")
public class Exam5_5
{
	static int N=15;
	static int [][] s=new int[N][N];
	static int n;
	public static void Spiral(int x,int y,int start,int n)	//递归创建螺旋矩阵
	{
		if (n<=0)							//递归结束条件
			return;
		if (n==1)							//矩阵大小为1时
		{	s[x][y]=start;
			return;
		}
		for (int j=x;j<x+n-1;j++)			//上一行
			s[y][j]=start++;
		for (int i=y;i<y+n-1;i++)			//右一列
			s[i][x+n-1]= start++;
		for (int j=x+n-1;j>x;j--)			//下一行
			s[y+n-1][j]= start++;
		for (int i=y+n-1;i>y; i--)			//左一列
			s[i][x]=start++;
		Spiral(x+1,y+1,start,n-2);			//递归调用
	}
	public static void Display()						//输出螺旋矩阵
	{
		for (int i=0;i<n;i++)
		{	for (int j=0;j<n;j++)
				System.out.printf("%4d",s[i][j]);
			System.out.println("");
		}
	}
	public static void main(String[] args)
	{
		n=5;
		Spiral(0,0,1,n);
		Display();
	}	   
}

 