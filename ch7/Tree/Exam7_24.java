import java.util.*;
import java.util.Scanner;
public class Main
{
	final static int MAXN=10005;
	static int [] parent=new int[MAXN];	//树的双亲存储结构
	public static int Level(int x)		//求x结点的层次
	{
		int cnt=0;
		while(x!=-1)					//找到根为止
		{	x=parent[x];
			cnt++;  
		}
		return cnt;
	}
	public static int solve(int x,int y)	//求x和y结点的最近公共祖先结点 
	{
		int lx=Level(x);				//求x结点的层次lx
		int ly=Level(y);				//求y结点的层次ly
		while (lx>ly)					//将较高层次的x结点上移
		{	x=parent[x];
			lx--;
		}
		while (ly>lx)					//将较高层次的y结点上移
		{	y=parent[y];
			ly--;
		}
		while (x!=y)					//当x和y移到相同层次，再找LCA
		{	x=parent[x];
			y=parent[y];
		}
		return x;
	}
@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		Scanner fin = new Scanner(System.in);
		int T,N,a,b,x,y;
		T=fin.nextInt();
		while (T-->0)
		{
			N=fin.nextInt();
			for (int i=0;i<=N;i++)		//初始化N个结点的双亲为-1
				parent[i]=-1;
			for (int i=1;i<N;i++)		//输入N-1条边,创建树的双亲存储结构
			{
				a=fin.nextInt();		//输入一条边
				b=fin.nextInt();
				parent[b]=a;
			}
			x=fin.nextInt();			//输入查询
			y=fin.nextInt();
			int ans=solve(x,y);			//求LCA
			System.out.println(ans);	//输出结果
		}			
	}
}
