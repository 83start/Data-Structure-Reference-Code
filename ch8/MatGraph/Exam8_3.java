@SuppressWarnings("unchecked")
public class Exam8_3
{
	public static int Degree1(MatGraphClass g,int v)	//通过无向图的邻接矩阵求顶点v的度
	{	int d=0;
		for (int j=0;j<g.n;j++)							//统计第v行的非0元素个数
			if (g.edges[v][j]!=0 && g.edges[v][j]!=g.INF)
				d++;
		return d;
	}
	public static int[] Degree2(MatGraphClass g,int v) //通过有向图的邻接矩阵求顶点v的出度和入度
	{
		int[] ans=new int[2];
		ans[0]=0;
		for (int j=0;j<g.n;j++)				//统计第v行的非0元素个数为出度
			if (g.edges[v][j]!=0 && g.edges[v][j]!=g.INF)
				ans[0]++;
		ans[1]=0;
		for (int i=0;i<g.n;i++)				//统计第v列的非0元素个数为入度
			if (g.edges[i][v]!=0 && g.edges[i][v]!=g.INF)
				ans[1]++;;
		return ans;
	}

	public static void main(String[] args)
	{
		MatGraphClass g=new MatGraphClass();
		int n=5,e=8;
		int[][] a={{0,1,0,1,1},{1,0,1,1,0},{0,1,0,1,1},{1,1,1,0,1},{1,0,1,1,0}};
		g.CreateMatGraph(a,n,e);
		System.out.println("图G1");
		g.DispMatGraph();
		System.out.println("求解结果");
		for (int i=0;i<g.n;i++)
			System.out.println("  顶点"+i+"的度: "+ Degree1(g,i));
		
		n=5; e=8;
		int[][] b={{0,1,0,1,0},{0,0,1,1,0},{0,0,0,1,1},{0,0,0,0,0},{1,0,0,1,0}};
		g.CreateMatGraph(b,n,e);
		System.out.println("图G2");
		g.DispMatGraph();
		System.out.println("求解结果");
		int[] ans=new int[2];
		for (int i=0;i<g.n;i++)
		{
			ans=Degree2(g,i);
			System.out.println("  顶点"+i+"的出度: "+ ans[0]+" 入度: "+ans[1]);
		}
	}
}
