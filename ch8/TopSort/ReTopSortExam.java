import java.lang.*;
import java.util.*;
public class ReTopSortExam
{
	static final int MAXV=100;					//表示最多顶点个数
	static int[] visited=new int[MAXV];			//全局变量数组

	public static void DFS1(AdjGraphClass G,int v)	//非递归深度优先遍历算法
	{	ArcNode p;
		Stack<Integer> st=new Stack<Integer>();		//定义一个栈
		System.out.print(v+" ");					//访问顶点v
		visited[v]=1;								//置顶点v已访问
		st.push(v);									//将顶点v进栈
		while (!st.empty())							//栈不空循环
		{	int x=st.peek();						//取栈顶顶点x作为当前顶点
			p=G.adjlist[x].firstarc;				//找顶点x的第一个邻接点
			while (p!=null)
			{	int w=p.adjvex;						//x的邻接点为w
				if (visited[w]==0)					//若顶点w没有访问
				{	System.out.print(w+" ");		//访问顶点w
					visited[w]=1;					//置顶点w已访问
					st.push(w);						//将顶点w进栈
					break;							//退出循环，转向再处理栈顶的顶点(体现后进先出)
				}
				p=p.nextarc;						//找顶点x的下一个邻接点
			}
			if (p==null) st.pop();						//若顶点x再没有未访问的邻接点，将其退栈
		}
	}

	public static void ReTopSort(AdjGraphClass G,int v)	//求G中从v出发的逆拓扑序列
	{	ArcNode p;
		Arrays.fill(visited,0);
		Stack<Integer> st=new Stack<Integer>();		//定义一个栈
		visited[v]=1;								//置顶点v已访问
		st.push(v);									//将顶点v进栈
		while (!st.empty())							//栈不空循环
		{	int x=st.peek();							//取栈顶顶点x作为当前顶点
			p=G.adjlist[x].firstarc;				//找顶点x的第一个邻接点
			while (p!=null)
			{	int w=p.adjvex;						//x的邻接点为w
				if (visited[w]==0)					//若顶点w没有访问
				{	
					visited[w]=1;					//置顶点w已访问但不输出
					st.push(w);						//将顶点w进栈
					break;							//退出循环，转向再处理栈顶的顶点(体现后进先出)
				}
				p=p.nextarc;						//找顶点x的下一个邻接点
			}
			if (p==null)							//若顶点x再没有未访问的邻接点
			{
				System.out.print(x+" ");			//访问x
				st.pop();							//将其退栈
			}
		}
	}

	public static void main(String[] args)
	{
		AdjGraphClass G=new AdjGraphClass();
		int n=5,e=6;
		int[][] a={{0,1,1,1,0},{0,0,1,0,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
		//int n=6,e=6;
		//int[][] a=new int[MAXV][MAXV];
		//a[0][1]=1;
		//a[4][1]=1;
		//a[1][2]=1;
		//a[4][5]=1;
		//a[5][3]=1;
		//a[2][3]=1;

		G.CreateAdjGraph(a,n,e);
		G.DispAdjGraph();
		System.out.print("  逆拓扑序列: ");
		ReTopSort(G,0);
		Arrays.fill(visited,0);
		System.out.print("  DFS: ");
		DFS1(G,0);
		System.out.println();
	}
}
