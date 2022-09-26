import java.lang.*;
import java.util.*;
public class BFS
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//访问标志数组
	public static void BFS(AdjGraphClass G,int v)	//图G从顶点v出发的广度优先遍历
	{	ArcNode p;
		int w;
		Queue<Integer> qu=new LinkedList<Integer>(); //定义一个队列
		System.out.print(v+" ");					//访问顶点v
		visited[v]=1;								//置已访问标记
		qu.offer(v);								//v进队
		while (!qu.isEmpty())						//队列不空循环
		{
			v=qu.poll();							//出队顶点v
			p=G.adjlist[v].firstarc;				//找顶点v的第一个邻接点
			while (p!=null)
			{
				w=p.adjvex;
				if (visited[w]== 0)					//若v的邻接点w未访问
				{
					System.out.print(w+" ");		//访问顶点w
					visited[w]=1;					//置已访问标记
					qu.offer(w);					//w进队
				}
				p=p.nextarc;						//找下一个邻接顶点
			}
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
		System.out.print("BFS: ");
		Arrays.fill(visited,0);					//初始化所有元素为0
		BFS(G,0);
		System.out.println();
	}
}
