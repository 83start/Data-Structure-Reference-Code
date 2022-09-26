//import java.lang.*;
import java.util.*;
public class Exam8_7
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//全局变量数组
	public static void FindaPath1(AdjGraphClass G,int u,int v)	//求u到v的一条简单路径
	{
		int[] path=new int[MAXV];
		int d=-1;									//path[0..d]存放一条路径
		Arrays.fill(visited,0);						//visited数组元素置初值0
		FindaPath11(G,u,v,path,d);
	}
	private static void FindaPath11(AdjGraphClass G,int u,int v,int[] path,int d) //被Findapath函数调用
	{
		ArcNode p;
		visited[u]=1;
		d++; path[d]=u;						//顶点u加入到路径中
		if (u==v)							//找到一条路径后输出并返回
		{	for (int i=0;i<=d;i++)
				System.out.print(path[i]+" ");
			System.out.println();
			return;
		}
		p=G.adjlist[u].firstarc;			//p指向u的第一个邻接点
		while (p!=null)
		{	int w=p.adjvex;						//w为邻接点
			if (visited[w]==0)				//w没有访问过
				FindaPath11(G,w,v,path,d);	//递归调用
			p=p.nextarc;						//p指向下一个邻接点
		}
	}

	public static void FindaPath2(AdjGraphClass G,int u,int v)	//求u到v的一条简单路径
	{
		ArrayList<Integer> path=new ArrayList<Integer>();
		FindaPath21(G,u,v,path);
	}
	private static void FindaPath21(AdjGraphClass G,int u,int v,ArrayList<Integer> path)
	{
		ArcNode p;
		visited[u]=1;
		path.add(u);						//顶点u加入到路径中
		if (u==v)							//找到一条路径后输出并返回
		{
			System.out.println(path);
			return;
		}
		p=G.adjlist[u].firstarc;			//p指向u的第一个邻接点
		while (p!=null)
		{	int w=p.adjvex;						//w为邻接点
			if (visited[w]==0)				//w没有访问过
				FindaPath21(G,w,v,path);	//递归调用
			p=p.nextarc;						//p指向下一个邻接点
		}
	}

	public static void FindaPath3(AdjGraphClass G,int u,int v)	//求u到v的一条简单路径
	{
		ArrayList<Integer> path=new ArrayList<Integer>();
		FindaPath31(G,u,v,path);
	}
	private static void FindaPath31(AdjGraphClass G,int u,int v,ArrayList<Integer> path)
	{
		ArcNode p;
		visited[u]=1;
		path.add(u);						//顶点u加入到路径中
		if (u==v)							//找到一条路径后输出并返回
		{
			System.out.println(path);
			return;
		}
		p=G.adjlist[u].firstarc;			//p指向u的第一个邻接点
		while (p!=null)
		{	int w=p.adjvex;						//w为邻接点
			if (visited[w]==0)				//w没有访问过
				FindaPath31(G,w,v,path);	//递归调用
			p=p.nextarc;						//p指向下一个邻接点
		}
		path.remove(path.size()-1);
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
		System.out.printf("  顶点%d到顶点%d路径:",u,v);
		FindaPath1(G,u,v);
	}
}
