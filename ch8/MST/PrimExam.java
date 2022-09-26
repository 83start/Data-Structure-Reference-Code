import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class PrimExam
{	final static int MAXV=100;							//表示最多顶点个数
	public static void Prim(MatGraphClass g,int v)		//输出最小生成树
	{
		int[] lowcost=new int[MAXV];			//建立数组lowcost
		int[] closest=new int[MAXV];			//建立数组closest
		int min,k;
		for (int i=0;i<g.n;i++)					//给lowcost[]和closest[]置初值
		{	lowcost[i]=g.edges[v][i];
			closest[i]=v;
		}
		for (int i=1;i<g.n;i++)					//找出最小生成树的n-1条边
		{	min=g.INF; k=-1;
			for (int j=0;j<g.n;j++)				//在(V-U)中找出离U最近的顶点k
				if (lowcost[j]!=0 && lowcost[j]<min)
				{	min=lowcost[j];
					k=j;						//k记录最小顶点的编号
				}
			System.out.print("("+closest[k]+","+k+"):"+min+"  "); //输出最小生成树的边
			lowcost[k]=0;						//将顶点k加入U中
			for (int j=0;j<g.n;j++)				//修改数组lowcost和closest
			if (lowcost[j]!=0 && g.edges[k][j]<lowcost[j])
			{	lowcost[j]=g.edges[k][j];
				closest[j]=k;
			}
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
		System.out.print("最小生成树: "); Prim(g,0);
		System.out.println("");
	}


}
