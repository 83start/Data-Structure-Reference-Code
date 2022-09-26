import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
class Edge							//边数组元素类
{	int u;							//边的起始顶点
	int v;							//边的终止顶点
	int w;							//边的权值
	public Edge(int u,int v,int w)	//构造方法
	{
		this.u=u;
		this.v=v;
		this.w=w;
	}
}
public class KruskalExam
{	final static int MAXV=100;						//表示最多顶点个数
	final static int MAXE=100;						//表示最多边数
	public static void Kruskal1(MatGraphClass g)	//输出最小生成树
	{
		int[] vset=new int[MAXV];					//建立数组vset
		Edge[] E=new Edge[MAXE];					//建立存放所有边的数组E
		int k=0;									//E数组下标从0开始
		for (int i=0;i<g.n;i++)						//由邻接矩阵g产生的边集数组E
			for (int j=0;j<i;j++)					//对于无向图仅考虑下三角部分的边
				if (g.edges[i][j]!=0 && g.edges[i][j]!=g.INF)
				{
					E[k]=new Edge(i,j,g.edges[i][j]);
					k++;
				}
		Arrays.sort(E,0,k,new Comparator<Edge>()	//E数组按w递增排序
        	{	public int compare(Edge o1,Edge o2) //返回值>0时进行交换
            	{   return o1.w-o2.w; }
        	});

		for (int i=0;i<g.n;i++) vset[i]=i;			//初始化辅助数组
		int cnt=1;									//cnt表示当前构造生成树的第几条边,初值为1
		int j=0;									//取E中边的下标,初值为0
		while (cnt<g.n)								//生成的边数小于n时循环
		{
			int u1=E[j].u; int v1=E[j].v;			//取一条边的头尾顶点
			int sn1=vset[u1];
			int sn2=vset[v1];						//分别得到两个顶点所属的集合编号
			if (sn1!=sn2)							//两顶点属于不同的集合,加入不会构成回路
			{
				System.out.print("("+u1+","+v1+"):"+E[j].w+"  "); //输出最小生成树的边
				cnt++;								//生成边数增1
				for (int i=0;i<g.n;i++)				//两个集合统一编号
					if (vset[i]==sn2)				//集合编号为sn2的改为sn1
						vset[i]=sn1;
			}
			j++;									//继续取E的下一条边
		}
	}
//***********************************************************************************	
	static int[] parent=new int[MAXV];				//并查集存储结构
	static int[] rank=new int[MAXV];				//存储结点的秩
	public static void Init(int n)					//并查集初始化 
	{	for (int i=0;i<n;i++)						//顶点编号为0～n-1
		{	parent[i]=i;
			rank[i]=0;
		}
	}
	public static int Find(int x)				//并查集中查找x结点的根结点 
	{	if(x!=parent[x])
			parent[x]= Find(parent[x]);			//路径压缩 
		return parent[x];
	}
	public static void Union(int x,int y)		//并查集中x和y的两个集合的合并
	{	int rx=Find(x);
		int ry=Find(y);
		if (rx==ry)								//x和y属于同一棵树的情况 
			return;
		if(rank[rx]<rank[ry])
			parent[rx]=ry;						//rx结点作为ry的孩子 
		else
		{	if(rank[rx]==rank[ry])				//秩相同，合并后rx的秩增1
				rank[rx]++;
			parent[ry]=rx;						//ry结点作为rx的孩子  
		}
	}

	public static void Kruskal2(MatGraphClass g)	//输出最小生成树
	{
		Edge[] E=new Edge[MAXE];					//建立存放所有边的数组E
		int k=0;									//E数组下标从0开始
		for (int i=0;i<g.n;i++)						//由邻接矩阵g产生的边集数组E
			for (int j=0;j<i;j++)					//对于无向图仅考虑下三角部分的边
				if (g.edges[i][j]!=0 && g.edges[i][j]!=g.INF)
				{
					E[k]=new Edge(i,j,g.edges[i][j]);
					k++;
				}
		Arrays.sort(E,0,k,new Comparator<Edge>()	//E数组按w递增排序
        	{	public int compare(Edge o1,Edge o2) //返回值>0时进行交换
            	{   return o1.w-o2.w; }
        	});
		Init(g.n);
		int cnt=1;									//cnt表示当前构造生成树的第几条边,初值为1
		int j=0;									//取E中边的下标,初值为0
		while (cnt<g.n)								//生成的边数小于n时循环
		{
			int u1=E[j].u; int v1=E[j].v;			//取一条边的头尾顶点
			int sn1=Find(u1);
			int sn2=Find(v1);						//分别得到两个顶点所属的集合编号
			if (sn1!=sn2)							//两顶点属于不同的集合,加入不会构成回路
			{
				System.out.print("("+u1+","+v1+"):"+E[j].w+"  "); //输出最小生成树的边
				cnt++;								//生成边数增1
				Union(u1,v1);						//合并
			}
			j++;									//继续取E的下一条边
		}
	}
	
	public static void main(String[] args)
	{
		MatGraphClass g=new MatGraphClass();
		int n=6,e=10;
		int[][] a={{0,6,1,5,g.INF,g.INF}, {6,0,5,g.INF,3,g.INF}, {1,5,0,5,6,4}, 
		{5,g.INF,5,0,g.INF,2}, {g.INF,3,6,g.INF,0,6}, {g.INF,g.INF,4,2,6,0}};  //图7.21(a)的边数组
		g.CreateMatGraph(a,n,e);
		System.out.println("图g");
		g.DispMatGraph();
		System.out.print("Kruskal1: "); Kruskal1(g);
		System.out.println("");
		System.out.print("Kruskal2: "); Kruskal2(g);
		System.out.println("");
	}
}
