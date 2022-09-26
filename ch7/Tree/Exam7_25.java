import java.util.*;
import java.util.Scanner;
public class Exam7_25
{
	final static int MAXN=1005;
	static int[] parent=new int[MAXN];		//并查集存储结构
	static int[] rank=new int[MAXN];		//存储结点的秩
	static int n;							//n个城镇 
	static int m;							//m条道路

	public static void Init()				//并查集初始化 
	{
		for (int i=1;i<=n;i++)
		{	parent[i]=i;
			rank[i]=0;
		}
	}
	public static int Find(int x)			//并查集中查找x结点的根结点 
	{
		if(x!=parent[x])
			parent[x]= Find(parent[x]);		//路径压缩 
		return parent[x];
	}
	public static void Union(int x,int y)					//并查集中x和y的两个集合的合并
	{
		int rx=Find(x);
		int ry=Find(y);
		if (rx==ry)							//x和y属于同一棵树的情况 
			return;
		if(rank[rx]<rank[ry])
			parent[rx]=ry;					//rx结点作为ry的孩子 
		else
		{	if(rank[rx]==rank[ry])			//秩相同，合并后rx的秩增1
				rank[rx]++;
			parent[ry]=rx;					//ry结点作为rx的孩子  
		}
	}
	public static void main(String[] args)
	{
		Scanner fin = new Scanner(System.in);
		while (fin.hasNext())
		{
			n=fin.nextInt();				//输入一个测试用例
			if (n==0) break;				//n=0结束
			m=fin.nextInt();
			Init();							//初始化
			int a,b;
			for(int i=1;i<=m;i++)			//输入m条边
			{
				a=fin.nextInt();
				b=fin.nextInt();
				Union(a,b);
			}
			int ans=0;
			for (int i=1;i<=n;i++)			//求子树个数ans
				if (parent[i]==i)
					ans++;
			System.out.println(ans-1);		//结果为ans-1
		}
	}
}
