@SuppressWarnings("unchecked")
public class MatGraphExam
{
	public static void main(String[] args)
	{
		MatGraphClass g=new MatGraphClass();
		int n=5,e=5;
		int[][] a={{0,8,g.INF,5,g.INF},{g.INF,0,3,g.INF,g.INF},
			{g.INF,g.INF,0,g.INF,16},{g.INF,9,g.INF,0,g.INF},{g.INF,g.INF,g.INF,g.INF,0}};
		g.CreateMatGraph(a,n,e);
		g.DispMatGraph();
	}
}
