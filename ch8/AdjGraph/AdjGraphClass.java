import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
class ArcNode							//边结点类
{	int adjvex;							//该边的终点编号
	ArcNode nextarc;					//指向下一条边的指针
	int weight;							//该边的相关信息,如边的权值
}
class VNode								//表头结点类型
{	String[] data;						//顶点信息
	ArcNode firstarc;					//指向第一条边的相邻顶点
}
public class AdjGraphClass				//图邻接表类
{	final int MAXV=100;					//表示最多顶点个数
	final int INF=0x3f3f3f3f;			//表示∞	
	VNode[] adjlist;					//邻接表头数组
	int n,e;							//图中顶点数n和边数e
	public AdjGraphClass()				//构造方法
	{
		adjlist=new VNode[MAXV];
		for (int i=0;i<MAXV;i++)
			adjlist[i]=new VNode();
	}
	public void CreateAdjGraph(int[][] a,int n,int e)	//通过边数组a、顶点数n和边数e来建立图的邻接表
	{
		this.n=n; this.e=e;								//置顶点数和边数
		ArcNode p;
		for (int i=0;i<n;i++)							//给邻接表中所有头结点的指针置初值
			adjlist[i].firstarc=null;
		for (int i=0;i<n;i++)							//检查边数组a中每个元素
			for (int j=n-1;j>=0;j--)
				if (a[i][j]!=0 && a[i][j]!=INF)			//存在一条边
				{	p=new ArcNode();					//创建一个边结点p
					p.adjvex=j; p.weight=a[i][j]; 
					p.nextarc=adjlist[i].firstarc;		//采用头插法插入*p
					adjlist[i].firstarc=p;
				}
	}
	public void DispAdjGraph()				//输出图的邻接表
	{		ArcNode p;
		for (int i=0;i<n;i++)
		{
			System.out.printf("  [%d]",i);
			p=adjlist[i].firstarc;			//p指向第一个邻接点
			while (p!=null)
			{	
				System.out.printf("->(%d,%d)",p.adjvex,p.weight);
				p=p.nextarc;				//p移向下一个邻接点
			}
			System.out.println("->∧");
		}
	}
}
