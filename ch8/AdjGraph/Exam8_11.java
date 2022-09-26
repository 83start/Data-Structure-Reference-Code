//import java.lang.*;
import java.util.*;
public class Exam8_11
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//全局变量数组
	static Stack<Integer> st=new Stack<Integer>();	//定义一个栈
	static int[] flag=new int[MAXV];				//标记顶点是否在栈中
	//例8-11解法1：适合无向图和有向图
	public static boolean Cycle1(AdjGraphClass G)	//解法1：判断有向图G中是否有回路
	{
		for (int i=0;i<G.n;i++)
		{
			Arrays.fill(visited,0);				//visited初始化
			if (Cycle11(G,i,i,-1))				//从顶点v出发搜索成功返回true
				return true;
		}
		return false;
	}
	private static boolean Cycle11(AdjGraphClass G,int u,int v,int d)	//经过顶点v的回路判断算法
	{	ArcNode p;
		boolean flag;
		visited[u]=1; d++;					//置已访问标记
		p=G.adjlist[u].firstarc;			//p指向顶点u的第一个邻接点
		while (p!=null)
		{	int w=p.adjvex;
			if (visited[w]==0)				//若顶点w未访问,递归调用
			{	flag=Cycle11(G,w,v,d);		//从顶点w出发搜索
				if (flag)					//找到v后返回true
					return true;
			}
			else if (w==v && d>1)			//搜索到顶点v并且环长度大于1
				return true;
			p=p.nextarc;					//找下一个邻接点
		}
		return false;
	}
	/*
	//例8-10解法2：仅仅适合无向图
	static boolean has;								//是否有回路
	public static boolean Cycle2(AdjGraphClass G)	//判断图G中是否有回路
	{
		for (int i=0;i<G.n;i++)
		{
			Arrays.fill(visited,0);			//visited初始化
			has=false;
			Cycle21(G,i,-1);					//从顶点i出发搜索是否有回路
			if (has)						//有回路返回true
			{
				System.out.println(i+"遍历返回true");
				return true;
			}
		}
		return false;
	}
	private static void Cycle21(AdjGraphClass G,int u,int pre)	//从顶点u出发判断是否有回路的算法
	{
		ArcNode p;
		visited[u]=1;						//置已访问标记
		System.out.println("访问"+u);
		if (has) return;					//找到回路后直接返回
		p=G.adjlist[u].firstarc;			//p指向顶点u的第一个邻接点
		while (p!=null)
		{	int w=p.adjvex;
			if (visited[w]==0)				//若顶点w未访问,递归调用
				Cycle21(G,w,u);				//从顶点w出发搜索
			else if (w!=pre)				//搜索到已访问的顶点且不是w
			{
				System.out.println("u="+u+",pre="+pre+",w="+w+",返回true");
				has=true;					//说明有回路
				return;
			}
			p=p.nextarc;					//找下一个邻接点
		}
	}
	*/
	//例8-11解法2：适合有向图
	public static boolean Cycle2(AdjGraphClass G)	//判断有向图G中是否有回路
	{	int[] path=new int[MAXV];
		int d;										//path[0..d]出发路径
		for (int i=0;i<G.n;i++)
		{
			d=-1;
			Arrays.fill(visited,0);					//visited初始化
			if (Cycle21(G,i,path,d))				//从顶点v出发搜索
				return true;
		}
		return false;
	}
	private static boolean inpath(int[] path,int d,int w)	//判断w是否在path[0..d]中
	{
		for (int i=0;i<=d;i++)
			if (path[i]==w)
				return true;
		return false;
	}
	private static boolean Cycle21(AdjGraphClass G,int u,int[] path,int d)	//从顶点u出发搜索是否存在回路的算法
	{	ArcNode p;
		visited[u]=1; 						//置已访问标记
		d++; path[d]=u;						//将顶点u添加到路径中
		p=G.adjlist[u].firstarc;			//p指向顶点u的第一个邻接点
		while (p!=null)
		{	int w=p.adjvex;
			if (visited[w]==0)				//若顶点w未访问
			{
				if (Cycle21(G,w,path,d))	//从顶点w出发搜索存在回路
					return true;
			}
			else if(inpath(path,d,w))		//顶点w没有访问但在路径中
				return true;				//找到回路返回true
			p=p.nextarc;					//找下一个邻接点
		}
		return false;
	}

	//例8-11解法3：适合有向图
	public static boolean Cycle3(AdjGraphClass G)	//判断有向图G中是否有回路
	{	for (int i=0;i<G.n;i++)
		{
			Arrays.fill(visited,0);					//visited初始化
			if (Cycle31(G,i))						//从顶点v出发搜索
				return true;
		}
		return false;
	}
	private static boolean Cycle31(AdjGraphClass G,int u)	//从顶点u出发搜索是否存在回路的算法
	{	ArcNode p;
		visited[u]=1; 						//置已访问标记
		st.push(u);							//将顶点u进栈
		flag[u]=1;							//表示顶点u在栈中	
		p=G.adjlist[u].firstarc;			//p指向顶点u的第一个邻接点
		while (p!=null)
		{	int w=p.adjvex;
			if (visited[w]==0)				//若顶点w未访问
			{
				if (Cycle31(G,w))			//从顶点w出发搜索存在回路
					return true;
				else						//从w回退,出栈w,置flag[w]=0
				{
					st.pop();
					flag[w]=0;
				}
			}
			else if(flag[w]==1)				//顶点v已访问且在栈中，返回true
				return true;
			p=p.nextarc;					//找下一个邻接点
		}
		return false;
	}

	public static void main(String[] args)
	{
		AdjGraphClass G1=new AdjGraphClass();
		int n=4,e=4;
		int [][] a={{0,1,1,0},{0,0,1,0},{0,0,0,1},{0,0,0,0}};	
		G1.CreateAdjGraph(a,n,e);
		System.out.println("图G1");	G1.DispAdjGraph();
		System.out.println("求解结果");
		System.out.printf("    解法1：图G1中是否有回路: %s\n",Cycle1(G1)==true?"有":"没有");
		System.out.printf("    解法2：图G1中是否有回路: %s\n",Cycle2(G1)==true?"有":"没有");
		System.out.printf("    解法3：图G1中是否有回路: %s\n",Cycle3(G1)==true?"有":"没有");
		

		AdjGraphClass G2=new AdjGraphClass();
		n=4;e=4;
		int [][] b={{0,1,0,0},{0,0,1,1},{0,0,0,0},{1,0,0,0}};	
		G2.CreateAdjGraph(b,n,e);
		System.out.println("图G2");	G2.DispAdjGraph();
		System.out.println("求解结果");
		System.out.printf("    解法1：图G2中是否有回路: %s\n",Cycle1(G2)==true?"有":"没有");
		System.out.printf("    解法2：图G2中是否有回路: %s\n",Cycle2(G2)==true?"有":"没有");
		System.out.printf("    解法3：图G2中是否有回路: %s\n",Cycle3(G2)==true?"有":"没有");
	}
}
