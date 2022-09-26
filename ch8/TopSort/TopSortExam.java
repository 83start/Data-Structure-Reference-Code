import java.lang.*;
import java.util.*;
public class TopSortExam
{
	static final int MAXV=100;					//表示最多顶点个数
	public static void TopSort(AdjGraphClass G)	//拓扑排序
	{
		int[] ind=new int[MAXV];				//记录每个顶点的入度
		Arrays.fill(ind,0);						//初始化ind数组
		ArcNode p;
		for (int i=0;i<G.n;i++)					//求顶点i的入度
		{
			p=G.adjlist[i].firstarc;
			while (p!=null)
			{
				int j=p.adjvex;
				ind[j]++;						//有边<i,j>，顶点j的入度增1
				p=p.nextarc;
			}
		}
		Stack<Integer> st=new Stack<Integer>();		//定义一个栈
		for (int i=0;i<G.n;i++)					//所有入度为0的顶点进栈
			if (ind[i]==0)
				st.push(i);
		while (!st.empty())						//栈不为空时循环
		{
			int i=st.pop();							//出栈一个顶点i
			System.out.print(i+" ");			//输出顶点i
			p=G.adjlist[i].firstarc;			//找第一个邻接点
			while (p!=null)
			{
				int j=p.adjvex;
				ind[j]--;						//顶点j的入度减1
				if (ind[j]==0)					//入度为0的邻接点进栈
					st.push(j);
				p=p.nextarc;					//找下一个邻接点
			}
		}			
	}

	public static void TopSort1(AdjGraphClass G)	//拓扑排序
	{
		int[] ind=new int[MAXV];				//记录每个顶点的入度
		Arrays.fill(ind,0);						//初始化ind数组
		ArcNode p;
		for (int i=0;i<G.n;i++)					//求顶点i的入度
		{
			p=G.adjlist[i].firstarc;
			while (p!=null)
			{
				int j=p.adjvex;
				ind[j]++;						//有边<i,j>，顶点j的入度增1
				p=p.nextarc;
			}
		}
		Queue<Integer> qu=new LinkedList<Integer>();	//定义一个队列
		for (int i=0;i<G.n;i++)					//所有入度为0的顶点进队
			if (ind[i]==0)
				qu.offer(i);
		while (!qu.isEmpty())						//队列不为空时循环
		{
			int i=qu.poll();						//出队一个顶点i
			System.out.print(i+" ");				//输出顶点i
			p=G.adjlist[i].firstarc;				//找第一个邻接点
			while (p!=null)
			{
				int j=p.adjvex;
				ind[j]--;							//顶点j的入度减1
				if (ind[j]==0)						//入度为0的邻接点进队
					qu.offer(j);
				p=p.nextarc;						//找下一个邻接点
			}
		}
				
	}
	public static void main(String[] args)
	{
		AdjGraphClass G=new AdjGraphClass();
		int n=6,e=6;
		int[][] a=new int[MAXV][MAXV];
		a[0][1]=1;
		a[4][1]=1;
		a[1][2]=1;
		a[4][5]=1;
		a[5][3]=1;
		a[2][3]=1;
		G.CreateAdjGraph(a,n,e);
		G.DispAdjGraph();
		System.out.print("拓扑序列: ");
		TopSort1(G);
		System.out.println();
	}
}
