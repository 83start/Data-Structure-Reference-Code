@SuppressWarnings("unchecked")
public class AdjGraphExam1
{
	public static void main(String[] args)
	{
		AdjGraphClass1 G=new AdjGraphClass1();
		int[][] a={{0,8,G.INF,5,G.INF},
				{G.INF,0,3,G.INF,G.INF},
				{G.INF,G.INF,0,G.INF,6},
				{G.INF,G.INF,9,0,G.INF},
				{G.INF,G.INF,G.INF,G.INF,0}};
		G.CreateAdjGraph(a);
		G.DispAdjGraph();
	}
}
