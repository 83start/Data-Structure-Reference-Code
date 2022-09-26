import java.lang.*;
import java.util.*;
public class BFS
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//访问标志数组
	public static void BFS(MatGraphClass g,int v)	//邻接矩阵g中从顶点v出发的广度优先遍历
	{	Queue<Integer> qu=new LinkedList<Integer>(); //定义一个队列
		System.out.print(v+" ");					//访问顶点v
		visited[v]=1;								//置已访问标记
		qu.offer(v);								//v进队
		while (!qu.isEmpty())						//队列不空循环
		{
			v=qu.poll();							//出队顶点v
			for (int w=0;w<g.n;w++)
			{
				if (g.edges[v][w]!=0 &&g.edges[v][w]!=g.INF)	//存在边<v,w)
				{
					if (visited[w]==0)					//若v的邻接点w未访问
					{
						System.out.print(w+" ");		//访问顶点w
						visited[w]=1;					//置已访问标记
						qu.offer(w);					//w进队
					}
				}
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
		BFS(g,0);		
		System.out.println();
	}
}
