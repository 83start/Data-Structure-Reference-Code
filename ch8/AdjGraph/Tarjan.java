import java.lang.*;
import java.util.*;
public class Tarjan
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//全局变量数组
	static int[] DFN=new int[MAXV];
	static int[] LOW=new int[MAXV];
	static Stack<Integer> st=new Stack<Integer>();	//定义一个栈
	static int[] flag=new int[MAXV];				//标记顶点是否在栈中
	static int Index=0;								//搜索次序号
	public static void Tarjan(AdjGraphClass G,int u)
	{
		int v;
		DFN[u]=LOW[u]=++Index; 					//次序从1开始，初始时默认DFN[u]和LOW[u]都置为次序号
    	visited[u]=1;							//设置顶点u的访问标志
		st.push(u);								//将顶点u进栈
		flag[u]=1;								//表示顶点u在栈中
		ArcNode p=G.adjlist[u].firstarc;
		while (p!=null)							//处理顶点u的所有出边(u,v)
		{
			v=p.adjvex;
			if(visited[v]==0)					//顶点v没有访问过
			{
				Tarjan(G,v);			 		//继续向下找
				LOW[u]=Math.min(LOW[u],LOW[v]);	//在遍历返回时，若顶点v下存在子树，更新LOW[u]
			}
			else if(flag[v]==1)					//顶点v已访问且在栈中，说明当前路径上存在环，更新LOW[u]
				LOW[u]=Math.min(LOW[u],DFN[v]);
			p=p.nextarc;						//继续处理顶点u的出边(u,v)
		}
		if(DFN[u]==LOW[u])						//顶点u是强连通分量的最小根
		{
			System.out.print("  一个以"+u+"为根的强连通分量: ");
			do
			{
				v=st.pop();
				System.out.print(v+" ");
				flag[v]=0;
			} while(v!=u);
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		AdjGraphClass G=new AdjGraphClass();
		int n=5,e=6;
		int[][] a={	{0,1,0,0,0},
					{0,0,1,1,0},
					{1,0,0,0,0},
					{0,0,1,0,1},
					{0,0,0,0,0} };
		G.CreateAdjGraph(a,n,e);
		System.out.println("求解结果");
		Arrays.fill(visited,0);					//初始化所有元素为0
		Tarjan(G,0);
		System.out.println();
	}
}
