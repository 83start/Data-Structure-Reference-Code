//import java.lang.*;
import java.util.*;
public class Exam8_8
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//全局变量数组

/*
	public static void FindallPath(AdjGraphClass G,int u,int v)	//求u到v的所有简单路径
	{
		Arrays.fill(visited,0);						//visited数组元素置初值0
		FindallPath1(G,u,v);
	}
	private static void FindallPath1(AdjGraphClass G,int u,int v) //被Findapath函数调用
	{
		ArcNode p;
		visited[u]=1;
		if (u==v)							//找到一条路径后输出
		{	for (int i=0;i<G.n;i++)
				if (visited[i]==1)
					System.out.print(i+" ");
			System.out.println();
      visited[u]=0;
      return;
		}
    p=G.adjlist[u].firstarc;			//p指向u的第一个邻接点
    while (p!=null)
    {	int w=p.adjvex;					//w为邻接点
      if (visited[w]==0)				//w没有访问过
        FindallPath1(G,w,v);		//递归调用
      p=p.nextarc;					//p指向下一个邻接点
    }
    visited[u]=0;						//回溯,重置visited[u]为0
	}

*/
	public static void FindallPath(AdjGraphClass G,int u,int v)	//求u到v的所有简单路径
	{
		int[] path=new int[MAXV];
		int d=-1;									//path[0..d]存放一条路径
		Arrays.fill(visited,0);						//visited数组元素置初值0
		FindallPath1(G,u,v,path,d);
	}
			

	private static void FindallPath1(AdjGraphClass G,int u,int v,int[] path,int d) //被Findapath函数调用
	{
		ArcNode p;
		visited[u]=1;
		d++; path[d]=u;						//顶点u加入到路径中
		if (u==v)							//找到一条路径后输出
		{	for (int i=0;i<=d;i++)
				System.out.print("   "+path[i]);
			System.out.println();
      visited[u]=0;
      return;
		}
		p=G.adjlist[u].firstarc;			//p指向u的第一个邻接点
		while (p!=null)
		{	int w=p.adjvex;					//w为邻接点
			if (visited[w]==0)				//w没有访问过
				FindallPath1(G,w,v,path,d);	//递归调用
			p=p.nextarc;					//p指向下一个邻接点
		}
		visited[u]=0;						//回溯,重置visited[u]为0
	}


	public static void main(String[] args)
	{
		AdjGraphClass G=new AdjGraphClass();
		int n=6,e=9;
		int[][] a={{0,1,0,1,0,0},{0,0,0,0,0,1},{0,1,0,0,0,1},
		{0,1,0,0,1,0},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		G.CreateAdjGraph(a,n,e);
		System.out.println("图G");	G.DispAdjGraph();
		System.out.println("求解结果");
		int u=0,v=5;
		System.out.printf("  顶点%d到顶点%d所有路径\n",u,v);
		FindallPath(G,u,v);
	}
}
