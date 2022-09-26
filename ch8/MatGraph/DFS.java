import java.lang.*;
import java.util.*;
public class DFS
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//全局变量数组
	public static void DFS(MatGraphClass g,int v)	//图G从顶点v出发的深度优先遍历
	{
		System.out.print(v+" ");				//访问顶点v
		visited[v]=1;							//置已访问标记
		for (int w=0;w<g.n;w++)
		{	
			if (g.edges[v][w]!=0 &&g.edges[v][w]!=g.INF)	//存在边<v,w)
			{
				if (visited[w]==0)
					DFS(g,w);						//若w顶点未访问,递归访问它
			}
		}
	}
	public static void main(String[] args)
	{
		MatGraphClass g=new MatGraphClass();
		int n=6,e=7;
		int[][] a={	{0,1,1,0,0,0},
					{0,0,0,0,0,1},
					{0,0,0,1,1,1},
					{0,0,0,0,0,0},
					{0,0,0,1,0,0},
					{0,0,0,0,0,0}
				  };
		g.CreateMatGraph(a,n,e);
		System.out.println("图g");
		g.DispMatGraph();
		System.out.print("DFS: ");
		Arrays.fill(visited,0);					//初始化所有元素为0
		DFS(g,0);		
		System.out.println();
	}
}
