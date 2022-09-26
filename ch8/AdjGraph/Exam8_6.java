//import java.lang.*;
import java.util.*;
public class Exam8_6
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//全局变量数组
	public static boolean HasPath(AdjGraphClass G,int u,int v)	//判断u到v是否有简单路径
	{
		Arrays.fill(visited,0);						//初始化
		return HasPath1(G,u,v);
	}
	private static boolean HasPath1(AdjGraphClass G,int u,int v)	//被HasPath函数调用
	{
		ArcNode p;
		int w;
		visited[u]=1;
		p=G.adjlist[u].firstarc;	//p指向u的第一个相邻点
		while (p!=null)
		{	w=p.adjvex;				  //w是得到u的相邻点
			if (w==v)				    //找到目标顶点后返回
				return true;		  //表示u到v有路径
			if (visited[w]==0)
				 if (HasPath1(G,w,v)) return true;
			p=p.nextarc;			//p指向下一个相邻点
		}
		return false;
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
		System.out.println("求解结果");
		System.out.printf("  %d到%d路径:%s \n",u,v,(HasPath(G,u,v)?"有":"没有"));
		u=0; v=2;
		System.out.printf("  %d到%d路径:%s \n",u,v,(HasPath(G,u,v)?"有":"没有"));

	}
}
