import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class FloydExam
{
	static final int MAXV=100;					//表示最多顶点个数
	public static void Floyd(MatGraphClass g)	//输出所有两个顶点之间的最短路径
	{
		int[][] A=new int[MAXV][MAXV];			//建立A数组
		int[][] path=new int[MAXV][MAXV];		//建立path数组
		for (int i=0;i<g.n;i++)					//给数组A和path置初值即求A-1[i][j]
			for (int j=0;j<g.n;j++) 
			{
				A[i][j]=g.edges[i][j];
				if (i!=j && g.edges[i][j]<g.INF)
					path[i][j]=i;				//i和j顶点之间有边时
				else	
					path[i][j]=-1;				//i和j顶点之间没有边时
			}
		for (int k=0;k<g.n;k++)					//求Ak[i][j]
		{	for (int i=0;i<g.n;i++)
				for (int j=0;j<g.n;j++)
					if (A[i][j]>A[i][k]+A[k][j])
					{	A[i][j]=A[i][k]+A[k][j];
						path[i][j]= path[k][j];	//修改最短路径
					}
		}
		Dispath(A,path,g);						//生成最短路径和长度
	}
	public static void Dispath(int[][] A,int[][] path,MatGraphClass g)	//输出所有的最短路径和长度
	{
		int[] apath=new int[MAXV];
		int d;								//apath[0..d]存放一条最短路径(逆向)
		for (int i=0;i<g.n;i++)
			for (int j=0;j<g.n;j++)
			{	if (A[i][j]!=g.INF && i!=j)		//若顶点i和j之间存在路径
				{	System.out.print("  顶点"+i+"到"+j+"的最短路径长度:"+A[i][j]+"\t路径:");
					int k=path[i][j];
					d=0; apath[d]=j;			//路径上添加终点
					while (k!=-1 && k!=i)		//路径上添加中间点
					{	d++; apath[d]=k;		//顶点k加入到路径中
						k=path[i][k];
					}
					d++; apath[d]=i;			//路径上添加起点
					for (int s=d;s>=0;s--)		//输出最短路径
						System.out.print(" "+apath[s]); 
					System.out.println();
				}
			}
	}

	public static void main(String[] args)
	{
		MatGraphClass g=new MatGraphClass();
		int n=4,e=8;
		int[][] a={{0,5,g.INF,7},{g.INF,0,4,2},{3,3,0,2},{g.INF,g.INF,1,0}};

		g.CreateMatGraph(a,n,e);
		System.out.println("图g");
		g.DispMatGraph();
		System.out.println(" 最短路径");
		Floyd(g);
	}
}
