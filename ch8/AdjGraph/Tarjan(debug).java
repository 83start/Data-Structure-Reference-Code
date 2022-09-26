import java.lang.*;
import java.util.*;
public class Tarjan
{
	static final int MAXV=100;						//表示最多顶点个数
	static int[] visited=new int[MAXV];				//全局变量数组
	static int[] DFN=new int[MAXV];
	static int[] LOW=new int[MAXV];
	static int[] flag=new int[MAXV];
	static Stack<Integer> st=new Stack<Integer>();
	static int Index=0;
	public static void Tarjan(AdjGraphClass G,int u)
	{
		int v;
		DFN[u]=LOW[u]=++Index; 		//次序从1开始，初始时默认DFN[u]和LOW[u]都置为次序号
    	visited[u]=1;				//设置顶点u的访问标志
		System.out.println("****访问"+u+"并进栈,DFN="+DFN[u]+",LOW="+LOW[u]);
		st.push(u);					//将顶点u进栈
		flag[u]=1;					//表示顶点u在栈中

		//取u顶点的下一路径顶点v,当没有v可取时也说明深度搜索已经到达当前最底部，这是我们函数返回寻找另一条路径。
		ArcNode p=G.adjlist[u].firstarc;
		System.out.println("处理顶点u="+u);
		while (p!=null)				//处理顶点u的所有出边(u,v)
		{
			v=p.adjvex;
			System.out.println("  找到出边顶点v="+v);
			if(visited[v]==0)			//顶点v没有访问过
			{
				System.out.println("Tarjan(G,"+v+")");
				Tarjan(G,v);			 // 继续向下找
				int v1=v;
				LOW[u]=Math.min(LOW[u],LOW[v]);	//在遍历返回时，若顶点v下存在子树，更新LOW[u]
				System.out.printf("  回退，v=%d,修改LOW[%d]=min(LOW[%d],LOW[%d])=%d\n",v1,u,u,v,LOW[u]);
			}
			else if(flag[v]==1)		//顶点v已访问且在栈中，说明当前路径上存在环，更新LOW[u]
			{
				LOW[u]=Math.min(LOW[u],DFN[v]);
				System.out.printf("  顶点%d已访问并且在栈中,修改LOW[%d]=min(LOW[%d],DFN[%d])=%d\n",v,u,u,v,LOW[u]);
				
			}
			p=p.nextarc;				//继续处理顶点u的出边(u,v)
		}
		if(DFN[u]==LOW[u])					//顶点u是强连通分量的最小根
		{
			System.out.println(u+"是根,DFN=LOW="+DFN[u]);
			// 将栈中顶点弹出，并计数
			do
			{
				v=st.pop();
				System.out.println(v+"出栈 ");
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
		System.out.println("图G");
		G.DispAdjGraph();
		//System.out.print("DFS: ");
		Arrays.fill(visited,0);					//初始化所有元素为0
		Tarjan(G,0);
		System.out.println();
	}
}
