//import java.lang.*;
import java.util.*;
public class Exam8_12
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//全局变量数组
	
	public static void ShortPath(AdjGraphClass G,int u,int v)
	{	
		class QNode									//队列元素类型
		{	int no;									//顶点编号
			QNode parent;							//前一个顶点
		}
		Queue<QNode> qu=new LinkedList<QNode>(); 	//定义一个队列
		QNode e,e1;
		ArcNode p;
		e=new QNode();
		e.no=u; e.parent=null;						//初始点对应队列元素的前驱为空
		qu.offer(e);								//u进队
		visited[u]=1;								//置已访问标记
		while (!qu.isEmpty())						//队列不空循环
		{
			e=qu.poll();							//出队元素e
			if (e.no==v)							//找到v时输出路径之逆并退出
			{
				int[] path=new int[MAXV];				//path[0..d]存放逆路径
				int d=-1;
				QNode f=e;							//通过队列输出逆路径
				while (f!=null)
				{
					d++; path[d]=f.no;
					f=f.parent;
				}
				for (int i=d;i>=0;i--)
					System.out.print(path[i]+" ");
				System.out.println();
				return;								//找到路径后返回
			}
			p=G.adjlist[e.no].firstarc;				//找e对应顶点的第一个邻接点
			while (p!=null)
			{
				int w=p.adjvex;
				if (visited[w]==0)					//若u的邻接点w未访问
				{
					e1=new QNode();					//建立队列元素
					e1.no=w; e1.parent=e;			//其前驱为e
					visited[w]=1;					//置已访问标记
					qu.offer(e1);					//e1进队
				}
				p=p.nextarc;						//找下一个邻接顶点
			}
		}
	}
	
	
	public static void BFS(AdjGraphClass G,int v)	//产生图的广度优先生成树
	{	ArcNode p;
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
				int w=p.adjvex;
				if (visited[w]==0)					//若v的邻接点w未访问
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
		int n=6,e=9;
		int[][] a={{0,1,0,1,0,0},{0,0,0,0,0,1},{0,1,0,0,0,1},
		{0,1,0,0,1,0},{0,1,0,0,0,1},{0,0,0,0,0,0}};

		G.CreateAdjGraph(a,n,e);
		System.out.println("图G");	G.DispAdjGraph();
		int u=0,v=5;
		System.out.println(u+"到"+v+"的一条最短路径");
		ShortPath(G,u,v);	
		
	}
}
