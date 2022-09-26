import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class MatGraphClass				//图邻接矩阵类
{	final int MAXV=100;					//表示最多顶点个数
	final int INF=Integer.MAX_VALUE;	//表示∞	
	int[][] edges;						//邻接矩阵的边数组，假设元素为int类型
	int n,e;							//顶点数，边数
	String[] vexs;						//存放顶点信息
	public MatGraphClass()				//构造方法
	{
		edges=new int[MAXV][MAXV];
		vexs=new String[MAXV];
	}
	public void CreateMatGraph(int[][] a,int n,int e)	//通过边数组a、顶点数n和边数e来建立图的邻接矩阵
	{
		this.n=n; this.e=e;					//置顶点数和边数
		for (int i=0;i<n;i++)
		{
			edges[i]=new int[n];
			for (int j=0;j<n;j++)
				edges[i][j]=a[i][j];
		}
	}
	public void DispMatGraph()				//输出图的邻接矩阵
	{
		for (int i=0;i<n;i++)
		{	for (int j=0;j<n;j++)
				if (edges[i][j]==INF)
					System.out.printf("%4s","∞");
				else
					System.out.printf("%5d",edges[i][j]);
			System.out.println();
		}
	}
}
