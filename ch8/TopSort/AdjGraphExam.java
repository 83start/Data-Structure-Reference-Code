@SuppressWarnings("unchecked")
public class AdjGraphExam
{
	public static void main(String[] args)
	{
		AdjGraphClass G=new AdjGraphClass();
		int n=5,e=5;
		int[][] a={{0,8,G.INF,5,G.INF},
		{G.INF,0,3,G.INF,G.INF},
			{G.INF,G.INF,0,G.INF,16},
			{G.INF,G.INF,9,0,G.INF},
			{G.INF,G.INF,G.INF,G.INF,0}};
		G.CreateAdjGraph(a,n,e);
		G.DispAdjGraph();
	}
}
