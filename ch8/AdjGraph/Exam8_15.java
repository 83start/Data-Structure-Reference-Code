import java.lang.*;
import java.util.*;
public class Exam8_15
{
	static final int MAXV=100;							//表示最多顶点个数
	static int[] visited=new int[MAXV];					//访问标志数组
	public static void DFSTree(AdjGraphClass G,int v)	//产生图的深度优先生成树
	{
		ArcNode p;
		visited[v]=1;									//置已访问标记
		p=G.adjlist[v].firstarc;						//p指向顶点v的第一个邻接点
		while (p!=null)
		{	int w=p.adjvex;
			if (visited[w]==0)
			{
				System.out.print("("+v+","+w+")  ");	//输出生成树的一条边
				DFSTree(G,w);							//递归调用
			}
			p=p.nextarc;								//p置为下一个邻接点
		}
	}

	
	public static void BFSTree(AdjGraphClass G,int v)	//产生图的广度优先生成树
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
				if (visited[w]==0)					//若v的邻接点w未访问
				{
					System.out.print("("+v+","+w+")  ");	//输出生成树的一条边
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
		int n=10,e=12;
		int[][] a={
		{0,1,1,1,0,0,0,0,0,0},
		{1,0,0,0,1,1,0,0,0,0},
		{1,0,0,1,0,1,1,0,0,0},
		{1,0,1,0,0,0,0,1,0,0},
		{0,1,0,0,0,0,0,0,0,0},
		{0,1,1,0,0,0,0,0,0,0},
		{0,0,1,0,0,0,0,1,1,1},
		{0,0,0,1,0,0,1,0,0,0},
		{0,0,0,0,0,0,1,0,0,0},
		{0,0,0,0,0,0,1,0,0,0}};
		G.CreateAdjGraph(a,n,e);
		System.out.println("图G");
		G.DispAdjGraph();
		int v=0;
		System.out.print("从顶点"+v+"出发的深度优先生成树:");
		Arrays.fill(visited,0);
		DFSTree(G,v);
		System.out.println();
		
		System.out.print("从顶点"+v+"出发的广度优先生成树:");
		Arrays.fill(visited,0);
		BFSTree(G,v);
		System.out.println();
	}
}
