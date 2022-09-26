//import java.lang.*;
//import java.util.*;
public class Exam8_15
{
	static final int MAXV=100;							//表示最多顶点个数
	static int[][] A=new int[MAXV][MAXV];				//A数组
	static int[][] pcnt=new int[MAXV][MAXV];			//路径中顶点个数
	public static void Floyd(MatGraphClass g)			//Floyd算法
	{
		for (int i=0;i<g.n;i++)							//A和pcnt初始化
			for (int j=0;j<g.n;j++)
			{	A[i][j]=g.edges[i][j];
				if (A[i][j]!=0 && A[i][j]!=g.INF)		//有边
					pcnt[i][j]=2;						//<i,j>作为路径，含2个顶点
				else
					pcnt[i][j]=0;						//没有路径，顶点个数为0
			}
		for (int k=0;k<g.n;k++)							//依次考察所有顶点
		{	for (int i=0;i<g.n;i++)
				for (int j=0;j<g.n;j++)
					if (A[i][j]>A[i][k]+A[k][j])
					{	A[i][j]=A[i][k]+A[k][j];		//修改最短路径长度
						pcnt[i][j]=pcnt[i][k]+pcnt[k][j]-1;
					}
		}
	}
	public static int Mincycle(MatGraphClass g)			//找一个最小环长度
	{	int minlength=g.INF;
		Floyd(g);
		for (int i=0;i<g.n;i++)
			for (int j=0;j<g.n;j++)
				if (i!=j && A[i][j]<g.INF && pcnt[i][j]>2 && g.edges[j][i]<g.INF)
				{	if (A[i][j]+g.edges[j][i]<minlength)
						minlength=A[i][j]+g.edges[j][i];
				}
		return minlength;
	}
	public static void main(String[] args)
	{
		MatGraphClass g=new MatGraphClass();
		int n=5,e=10;
		int[][] a={	{0,13,g.INF,4,g.INF},{13,0,15,g.INF,5},
					{g.INF,g.INF,0,12,g.INF},{4,g.INF,12,0,g.INF},{g.INF,g.INF,6,3,0}};
		g.CreateMatGraph(a,n,e);
		System.out.println("图g");
		g.DispMatGraph();
		System.out.println("最小环长度="+Mincycle(g));
	}
}
