import java.lang.*;
import java.util.*;
class KeyNode										//关键活动类
{	int i;											//起点
	int j;											//终点
	public KeyNode(int i,int j)						//构造方法
	{
		this.i=i;
		this.j=j;
	}
}
public class KeypathExam
{
	static final int MAXV=100;							//表示最多顶点个数
	static int start;									//G的源点
	static int end;										//G的汇点
	static ArrayList<KeyNode> keys=new ArrayList<KeyNode>();	//图G的关键活动
	static ArrayList<Integer> top=new ArrayList<>();		//拓扑序列
	
	public static boolean KeyPath(AdjGraphClass G)		//求从源点start到汇点end的关键活动keynode
	{
		ArcNode p;
		TopSort(G);										//调用拓扑排序算法产生拓扑序列
		if (top.size()<G.n)
			return false;								//不能产生拓扑序列时返回false
		start=top.get(0);							//求出源点
		end=top.get(top.size()-1);				//求出汇点
		int[] ve=new int[MAXV];							//事件的最早开始时间
		int[] vl=new int[MAXV];							//事件的最迟开始时间
		Arrays.fill(ve,0);								//先将所有事件的ve置初值为0
		for (int i=0;i<G.n;i++)							//从左向右求所有事件的最早开始时间
		{	p=G.adjlist[i].firstarc;
			while (p!=null)								//遍历每一条边即活动
			{	int w=p.adjvex;
				if (ve[i]+p.weight>ve[w])				//求最大者即为最早开始时间
					ve[w]=ve[i]+p.weight;
				p=p.nextarc;
			}
		}
		Arrays.fill(vl,ve[end]);						//先将所有事件的vl值置为最大值
		for (int i=G.n-2;i>=0;i--)						//从右向左求所有事件的最迟开始时间
		{	p=G.adjlist[i].firstarc;
			while (p!=null)
			{	int w=p.adjvex;
				if (vl[w]-p.weight<vl[i])				//求最小者即为最迟开始时间
					vl[i]=vl[w]-p.weight; 
				p=p.nextarc;
			}
		}
		for (int i=0;i<G.n;i++)							//求所有的关键活动
		{	p=G.adjlist[i].firstarc;
			while (p!=null)
			{	int w=p.adjvex;
				if (ve[i]==vl[w]-p.weight)				//<i,w>是一个关键活动
					keys.add(new KeyNode(i,w));		//将该关键活动添加到keynode数组中
				p=p.nextarc;
			}
		}
		return true;									//能够产生拓扑序列返回true
	}
	public static void TopSort(AdjGraphClass G)			//拓扑排序
	{
		int[] ind=new int[MAXV];						//记录每个顶点的入度
		Arrays.fill(ind,0);								//初始化ind数组
		ArcNode p;
		for (int i=0;i<G.n;i++)							//求顶点i的入度
		{
			p=G.adjlist[i].firstarc;
			while (p!=null)
			{
				int j=p.adjvex;
				ind[j]++;								//有边<i,j>，顶点j的入度增1
				p=p.nextarc;
			}
		}
		Stack<Integer> st=new Stack<Integer>();	//定义一个栈
		for (int i=0;i<G.n;i++)					//所有入度为0的顶点进栈
			if (ind[i]==0)
				st.push(i);
		while (!st.empty())						//栈不为空时循环
		{
			int i=st.pop();						//出栈一个顶点i
			top.add(i);						//顶点i添加到拓扑序列中
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
	public static void DispKeynode(AdjGraphClass G)		//输出图的所有关键活动
	{
		if (KeyPath(G))
		{
			System.out.printf("  源点: %c\n",(char)(start+'A'));
			System.out.printf("  汇点: %c\n",(char)(end+'A'));
			System.out.print("  关键活动: ");
			for (int i=0;i<keys.size();i++)				//输出所有的关键活动
				System.out.printf("(%c,%c)  ",(char)(keys.get(i).i+'A'),(char)(keys.get(i).j+'A'));
			System.out.println();
		}
		else
			System.out.println("不能求关键活动");
	}
	public static void main(String[] args)
	{
		AdjGraphClass G=new AdjGraphClass();
		int n=9,e=11;
		int[][] a={
		{ 0,  6,  4,  5 ,G.INF,G.INF,G.INF,G.INF,G.INF},
		{G.INF, 0, G.INF,G.INF, 1 ,G.INF,G.INF,G.INF,G.INF},
		{G.INF,G.INF, 0 ,G.INF, 1 ,G.INF,G.INF,G.INF,G.INF},
		{G.INF,G.INF,G.INF, 0 ,G.INF,G.INF,G.INF, 2 ,G.INF},
		{G.INF,G.INF,G.INF,G.INF, 0 , 9 , 7 ,G.INF,G.INF},
		{G.INF,G.INF,G.INF,G.INF,G.INF, 0 ,G.INF,G.INF, 2 },
		{G.INF,G.INF,G.INF,G.INF,G.INF,G.INF, 0 ,G.INF, 4 },
		{G.INF,G.INF,G.INF,G.INF,G.INF,G.INF,G.INF, 0 , 4 },
		{G.INF,G.INF,G.INF,G.INF,G.INF,G.INF,G.INF,G.INF, 0 }};	//图8.47
		G.CreateAdjGraph(a,n,e);
		System.out.println("图G");
		G.DispAdjGraph();
		System.out.println("求解结果");
		DispKeynode(G);
		System.out.println();
	}
}
