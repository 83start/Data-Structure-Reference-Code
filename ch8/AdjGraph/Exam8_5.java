import java.lang.*;
import java.util.*;
public class Exam8_5
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//全局变量数组
	public static void DFS1(AdjGraphClass G,int v)	//图G从v出发的深度优先遍历
	{	int w;
		ArcNode p;
		visited[v]=1;								//置已访问标记
		p=G.adjlist[v].firstarc;					//p指向顶点v的第一个邻接点
		while (p!=null)
		{	w=p.adjvex;
			if (visited[w]==0)
				DFS1(G,w);							//若w顶点未访问,递归访问它
			p=p.nextarc;							//p置为下一个邻接点
		}
	}
	public static boolean Connect(AdjGraphClass G)	//判断无向图G的连通性
	{
		boolean flag=true;
		Arrays.fill(visited,0);						//visited数组元素均置为0
		DFS1(G,0);									//调用DSF1算法,从0出发深度优先遍历
		for (int i=0;i<G.n;i++)
			if (visited[i]==0)
			{	flag=false;							//存在没有访问的顶点，则不连通
				break;
			}
		return flag;
	}
	public static void main(String[] args)
	{
		AdjGraphClass G1=new AdjGraphClass();
		int n=5,e=8;
		int[][] a={{0,1,0,1,1},{1,0,1,1,0},{0,1,0,1,1},{1,1,1,0,1},{1,0,1,1,0}};
		G1.CreateAdjGraph(a,n,e);
		System.out.println("图G1");	G1.DispAdjGraph();
		System.out.println("图G1的连通性: "+Connect(G1));
		
		AdjGraphClass G2=new AdjGraphClass();
		n=5;e=3;
		int[][] b={{0,1,1,0,0},{1,0,0,0,0},{1,0,0,0,0},{0,0,0,0,1},{0,0,0,1,0}};
		G2.CreateAdjGraph(b,n,e);
		System.out.println("图G2");	G2.DispAdjGraph();
		System.out.println("图G2的连通性: "+Connect(G2));

	}
}
