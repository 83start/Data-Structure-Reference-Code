//import java.lang.*;
import java.util.*;
public class Exam8_9
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//全局变量数组
	public static void FindallLengthPath(AdjGraphClass G,int u,int v,int l)	//求u到v的所有长度为l的简单路径
	{
		int[] path=new int[MAXV];
		int d=-1;									//path[0..d]存放一条路径
		Arrays.fill(visited,0);						//visited数组元素置初值0
		FindallLengthPath1(G,u,v,l,path,d);
	}
	private static void FindallLengthPath1(AdjGraphClass G,int u,int v,int l,int[] path,int d)
	{
		ArcNode p;
		visited[u]=1;
		d++; path[d]=u;						//顶点u加入到路径中
		if (u==v && d==l)					//找到一条路径后输出
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
				FindallLengthPath1(G,w,v,l,path,d);	//递归调用
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
		int u=0,v=5,l=3;
		System.out.printf("  顶点%d到顶点%d长度为%d的所有路径\n",u,v,l);
		FindallLengthPath(G,u,v,l);
	}
}
