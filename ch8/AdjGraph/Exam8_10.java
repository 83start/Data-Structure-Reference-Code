//import java.lang.*;
import java.util.*;
public class Exam8_10
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//全局变量数组
	//解法1：适合无向图和有向图
	public static boolean Cycle1(AdjGraphClass G)	//解法1：判断无向图G中是否有回路
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
		visited[u]=1;						//置已访问标记
		d++;								//路径长度增加1
		p=G.adjlist[u].firstarc;			//p指向顶点u的第一个邻接点
		while (p!=null)
		{	int w=p.adjvex;
			if (visited[w]==0)				//若顶点w未访问,递归调用
			{	if (Cycle11(G,w,v,d))		//从顶点w出发找到v后返回true
					return true;
			}
			else if (w==v && d>1)			//搜索到顶点v并且环长度大于1
				return true;
			p=p.nextarc;					//找下一个邻接点
		}
		return false;
	}
	//解法2：适合无向图
	static boolean has;								//是否有回路
	public static boolean Cycle2(AdjGraphClass G)	//解法2：判断无向图G中是否有回路
	{
		for (int i=0;i<G.n;i++)
		{
			Arrays.fill(visited,0);			//visited初始化
			has=false;
			Cycle21(G,i,-1);				//从顶点i出发搜索是否有回路
			if (has)						//有回路返回true
				return true;
		}
		return false;
	}
	private static void Cycle21(AdjGraphClass G,int u,int pre)	//从顶点u出发判断是否有回路的算法
	{
		ArcNode p;
		visited[u]=1;						//置已访问标记
		if (has) return;					//找到回路后直接返回
		p=G.adjlist[u].firstarc;			//p指向顶点u的第一个邻接点
		while (p!=null)
		{	int w=p.adjvex;
			if (visited[w]==0)				//若顶点w未访问,递归调用
				Cycle21(G,w,u);				//从顶点w出发搜索
			else if (w!=pre)				//搜索到已访问的顶点且不是w
			{
				has=true;					//说明有回路
				return;
			}
			p=p.nextarc;					//找下一个邻接点
		}
	}
	public static void main(String[] args)
	{
		AdjGraphClass G1=new AdjGraphClass();
		int n=3,e=2;
		int[][] a={{0,1,0},{1,0,1},{0,1,0}};
		G1.CreateAdjGraph(a,n,e);
		System.out.println("图G1");	G1.DispAdjGraph();
		System.out.println("求解结果");
		System.out.printf("    解法1：图G1中是否有回路: %s\n",Cycle1(G1)==true?"有":"没有");
		System.out.printf("    解法2：图G1中是否有回路: %s\n",Cycle2(G1)==true?"有":"没有");
		
		AdjGraphClass G2=new AdjGraphClass();
		n=3; e=3;
		int[][] b={{0,1,1},{1,0,1},{1,1,0}};
		G2.CreateAdjGraph(b,n,e);
		System.out.println("图G2");	G2.DispAdjGraph();
		System.out.println("求解结果");
		System.out.printf("    解法1：图G2中是否有回路: %s\n",Cycle1(G2)==true?"有":"没有");
		System.out.printf("    解法2：图G2中是否有回路: %s\n",Cycle2(G2)==true?"有":"没有");
		
	}
}
