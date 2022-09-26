import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class DijkstraExam1
{
	static final int MAXV=100;					//表示最多顶点个数
	public static void Dijkstra1(MatGraphClass g,int v)	//求从v到其他顶点的最短路径
	{
		int[] dist=new int[MAXV];				//建立dist数组
		int[] path=new int[MAXV];				//建立path数组
		int[] S=new int[MAXV];					//建立S数组
		for (int i=0;i<g.n;i++)
		{	dist[i]=g.edges[v][i];				//最短路径长度初始化
			S[i]=0;								//S[]置空
			if (g.edges[v][i]<g.INF)			//最短路径初始化
				path[i]=v;						//v到i有边，置路径上顶点i的前驱为v
			else								//v到i没边时，置路径上顶点i的前驱为-1
				path[i]=-1;
		}
		S[v]=1;									//源点v放入S中
		int u=-1;
		int mindis;
		for (int i=0;i<g.n-1;i++)				//循环向S中添加n-1个顶点
		{	mindis=g.INF;						//mindis置最小长度初值
			for (int j=0;j<g.n;j++)				//选取不在S中且具有最小距离的顶点u
				if (S[j]==0 && dist[j]<mindis) 
				{	u=j;
					mindis=dist[j];
				}
		S[u]=1;									//顶点u加入S中
		for (int j=0;j<g.n;j++)					//修改不在s中的顶点的距离
			if (S[j]==0)						//仅仅修改S中的顶点j
				if (g.edges[u][j]<g.INF && dist[u]+g.edges[u][j]<dist[j])
				{	dist[j]=dist[u]+g.edges[u][j];
					path[j]=u;
				}
		}
		DispAllPath(dist,path,S,v,g.n);			//输出所有最短路径及长度
	}
	private static void DispAllPath(int[] dist,int[] path,int[] S,int v,int n)  //输出从顶点v出发的所有最短路径
	{
		int[] apath=new int [MAXV];
		int d;									//path[0..d]存放一条最短路径(逆向)
		for (int i=0;i<n;i++)					//循环输出从顶点v到i的路径
			if (S[i]==1 && i!=v)
			{
				System.out.printf("  从%d到%d最短路径长度: %d \t路径:",v,i,dist[i]);
				d=0; apath[d]=i;				//添加路径上的终点
				int k=path[i];
				if (k==-1)						//没有路径的情况
					System.out.println("无路径");
					else							//存在路径时输出该路径
					{	while (k!=v)
						{	d++; apath[d]=k;		//顶点k加入到路径中
							k=path[k];
						}
						d++; apath[d]=v;			//添加路径上的起点
						for (int j=d;j>=0;j--)		//输出最短路径
							System.out.print(apath[j]+" ");
						System.out.println();
					}
			}
	}

	public static void main(String[] args)
	{
		MatGraphClass g=new MatGraphClass();
		int n=7,e=12;
		int[][] a={
		{0,4,6,6,g.INF,g.INF,g.INF},
		{g.INF,0,1,g.INF,7,g.INF,g.INF},
		{g.INF,g.INF,0,g.INF,6,4,g.INF},
		{g.INF,g.INF,2,0,g.INF,5,g.INF},
		{g.INF,g.INF,g.INF,g.INF,0,g.INF,6},
		{g.INF,g.INF,g.INF,g.INF,1,0,8},
		{g.INF,g.INF,g.INF,g.INF,g.INF,g.INF,0}};
		g.CreateMatGraph(a,n,e);
		System.out.println("图g");
		g.DispMatGraph();
		System.out.println(" 最短路径");
		Dijkstra1(g,0);
	}
}
