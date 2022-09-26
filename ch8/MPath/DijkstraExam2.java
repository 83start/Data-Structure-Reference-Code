import java.lang.*;
import java.util.*;
class Node							//优先队列(小根堆)中结点类型
{	int i;							//顶点编号
    int dist;						//dist[i]值
	public Node(int i,int dist)		//构造方法
	{
		this.i=i;
		this.dist=dist;
	}
}
public class DijkstraExam2
{
	static final int MAXV=100;					//表示最多顶点个数
	public static void Dijkstra2(AdjGraphClass G,int v)	//求从v到其他顶点的最短路径
	{
		Comparator<Node> dComparator  	//定义dComparator
		= new Comparator<Node>()
		{	public int compare(Node o1,Node o2)			//用于创建dist小根堆
			{
				return (o2.dist-o1.dist);
        	}
    	};
		PriorityQueue<Node> pq=new PriorityQueue<Node>(MAXV,dComparator);
		int[] dist=new int[MAXV];				//建立dist数组
		int[] S=new int[MAXV];					//建立S数组
		Node e;
		ArcNode p;
		Arrays.fill(dist,G.INF);				//初始化dist[i]为∞
		p=G.adjlist[v].firstarc;
		while (p!=null)
		{	int w=p.adjvex;
			dist[w]=p.weight;					//距离初始化
			pq.offer(new Node(w,dist[w]));				//将v的出边顶点进队qu
			p=p.nextarc;
		}
		S[v]=1;									//源点v添加S中
		
		for (int i=0;i<G.n-1;i++)				//循环直到所有顶点的最短路径都求出
		{	e=pq.poll();						//出队e
			int u=e.i;							//选取具有最小最短路径长度的顶点u
			S[u]=1;								//顶点u加入S中
			p=G.adjlist[u].firstarc;
			while (p!=null)						//考察从顶点u出发的所有相邻点
			{	int w=p.adjvex;
				if (S[w]==0)						//考虑修改不在S中的顶点w的最短路径长度
					if (dist[u]+p.weight<dist[w])
					{	dist[w]=dist[u]+p.weight;	//修改最短路径长度
						pq.offer(new Node(w,dist[w]));		//修改最短路径长度的顶点进队
					}
				p=p.nextarc;
			}
		}
		System.out.printf("从%d顶点出发的最短路径长度如下:\n",v);
		for (int i=0;i<G.n;++i)
			if (i!=v)
				System.out.println("  到顶点"+i+"的最短路径长度:"+dist[i]);
	}
	public static void main(String[] args)
	{
		AdjGraphClass G=new AdjGraphClass();
		int n=7,e=12;
		int[][] a={
		{0,4,6,6,G.INF,G.INF,G.INF},
		{G.INF,0,1,G.INF,7,G.INF,G.INF},
		{G.INF,G.INF,0,G.INF,6,4,G.INF},
		{G.INF,G.INF,2,0,G.INF,5,G.INF},
		{G.INF,G.INF,G.INF,G.INF,0,G.INF,6},
		{G.INF,G.INF,G.INF,G.INF,1,0,8},
		{G.INF,G.INF,G.INF,G.INF,G.INF,G.INF,0}};
		G.CreateAdjGraph(a,n,e);
		System.out.println("图G");
		G.DispAdjGraph();
		Dijkstra2(G,0);
	}
}
