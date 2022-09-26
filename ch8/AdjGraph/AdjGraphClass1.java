import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
class ENode									//边结点类		
{
	int v;									//邻接点
	int w;									//边权值
	int next;								//下一条边
	public ENode(int v,int w)				//构造方法
	{
		this.v=v;
		this.w=w;
	}
}

public class AdjGraphClass1						//图简化邻接表类
{	final int MAXV=100;							//表示最多顶点个数
	final int MAXE=300;							//表示最多边数
	final int INF=0x3f3f3f3f;					//表示∞
	int[] head;									//邻接表头结点数组
	ENode [] edge;								//边数组
	int n,e;									//图中顶点数n和边数e
	int toll;									//边数组下标
	public AdjGraphClass1()						//构造方法
	{	head=new int[MAXV];						//创建头结点数组
		Arrays.fill(head,-1);					//head所有元素初始化为-1
		edge=new ENode[MAXE];					//创建边结点数组
		toll=0;									//edge数组下标从0开始
	}
	
    public void addEdge(int u,int v,int w)		//图中增加边<u,v,w>
	{
        edge[toll]=new ENode(v,w);
        edge[toll].next=head[u];
        head[u]=toll++;
    }

	public void CreateAdjGraph(int[][] a)			//通过边数组a建立图的简化邻接表
	{	n=a.length; e=0;							//初始化顶点数和边数
		for (int i=0;i<n;i++)						//检查边数组a中每个元素
		{	for (int j=1;j<n;j++)
				if (a[i][j]!=0 && a[i][j]!=INF)		//存在一条边
				{
					addEdge(i,j,a[i][j]);
					e++;							//边数增1
				}
		}
	}
	public void DispAdjGraph()						//输出图的邻接表
	{	for (int i=0;i<n;i++)
		{	System.out.printf("  [%d]",i);
			 for (int e=head[i];e!=-1; e=edge[e].next)
				System.out.printf("->(%d,%d)",edge[e].v,edge[e].w);
			System.out.println("->∧");
		}
	}
}
