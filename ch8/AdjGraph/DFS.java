import java.lang.*;
import java.util.*;
public class DFS
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//全局变量数组
	public static void DFS(AdjGraphClass G,int v)	//图G从顶点v出发的深度优先遍历
	{
		int w;
		ArcNode p;
		System.out.print(v+" ");				//访问顶点v
		visited[v]=1;							//置已访问标记
		p=G.adjlist[v].firstarc;				//p指向顶点v的第一个邻接点
		while (p!=null)
		{	w=p.adjvex;
			if (visited[w]==0)
				DFS(G,w);						//若w顶点未访问,递归访问它
			p=p.nextarc;						//p置为下一个邻接点
		}
	}
	public static void main(String[] args)
	{
		AdjGraphClass G=new AdjGraphClass();
		int n=6,e=7;
		int[][] a={	{0,1,1,0,0,0},
					{0,0,0,0,0,1},
					{0,0,0,1,1,1},
					{0,0,0,0,0,0},
					{0,0,0,1,0,0},
					{0,0,0,0,0,0}
				  };
		G.CreateAdjGraph(a,n,e);
		System.out.println("图G");
		G.DispAdjGraph();
		System.out.print("DFS: ");
		Arrays.fill(visited,0);					//初始化所有元素为0
		DFS(G,0);		
		System.out.println();
		for(int i=0;i<G.n;i++)
			System.out.println("visited["+i+"]="+visited[i]);
	}
}
