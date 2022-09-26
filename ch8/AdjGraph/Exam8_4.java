@SuppressWarnings("unchecked")
public class Exam8_4
{
	public static int Degree1(AdjGraphClass G,int v)	//通过无向图的邻接表求顶点v的度
	{
		int d=0;
		ArcNode p;
		p=G.adjlist[v].firstarc;
		while (p!=null)
		{	d++;
			p=p.nextarc;
		}
		return d;
	}
	public static int[] Degree2(AdjGraphClass G,int v) //通过有向图的邻接表求顶点v的出度和入度
	{
		int[] ans=new int[2];
		ArcNode p;
		ans[0]=0;
		p=G.adjlist[v].firstarc;
		while(p!=null)				//统计第v个单链表中的边结点个数
		{
			ans[0]++;
			p=p.nextarc;
		}
		ans[1]=0;
		for (int i=0;i<G.n;i++)
		{
			p=G.adjlist[i].firstarc;
			while (p!=null)
			{
				if (p.adjvex==v)
				{	ans[1]++;
					break;			//每个单链表中至多只有一个这样的边结点
				}
				else p=p.nextarc;
			}
		}
		return ans;
	}
	public static void main(String[] args)
	{
		AdjGraphClass G=new AdjGraphClass();
		int n=5,e=8;
		int[][] a={{0,1,0,1,1},{1,0,1,1,0},{0,1,0,1,1},{1,1,1,0,1},{1,0,1,1,0}};
		G.CreateAdjGraph(a,n,e);
		System.out.println("图G1");
		G.DispAdjGraph();
		System.out.println("求解结果");
		for (int i=0;i<G.n;i++)
			System.out.println("  顶点"+i+"的度: "+ Degree1(G,i));
		
		n=5; e=8;
		int[][] b={{0,1,0,1,0},{0,0,1,1,0},{0,0,0,1,1},{0,0,0,0,0},{1,0,0,1,0}};
		G.CreateAdjGraph(b,n,e);
		System.out.println("图G2");
		G.DispAdjGraph();
		System.out.println("求解结果");
		int[] ans=new int[2];
		for (int i=0;i<G.n;i++)
		{
			ans=Degree2(G,i);
			System.out.println("  顶点"+i+"的出度: "+ ans[0]+" 入度: "+ans[1]);
		}
	}
}
