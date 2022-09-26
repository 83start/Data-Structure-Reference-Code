import java.lang.*;
import java.util.*;
public class Exam8_13
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//访问标志数组
	public static int Maxdist(AdjGraphClass G,int v)	//图G从顶点v出发的广度优先遍历
	{	ArcNode p;
		Queue<Integer> qu=new LinkedList<Integer>(); //定义一个队列
		visited[v]=1;								//置已访问标记
		qu.offer(v);								//v进队
		while (!qu.isEmpty())						//队列不空循环
		{
			v=qu.poll();							//出队顶点v
			p=G.adjlist[v].firstarc;				//找顶点v的第一个邻接点
			while (p!=null)
			{
				int w=p.adjvex;
				if (visited[w]== 0)					//若v的邻接点w未访问
				{
					visited[w]=1;					//置已访问标记
					qu.offer(w);					//w进队
				}
				p=p.nextarc;						//找下一个邻接顶点
			}
		}
		return v;
	}
	public static void main(String[] args)
	{
		AdjGraphClass G=new AdjGraphClass();
		int n=6,e=9;
		int[][] a={{0,1,0,1,0,0},{0,0,0,0,0,1},{0,1,0,0,0,1},
		{0,1,0,0,1,0},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		G.CreateAdjGraph(a,n,e);
		System.out.println("图G");
		G.DispAdjGraph();
		int v=0;
		Arrays.fill(visited,0);					//初始化所有元素为0
		System.out.print("距离"+v+"最远的顶点:"+Maxdist(G,v));
	}
}
