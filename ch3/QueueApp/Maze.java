import java.util.*;

class Box						//方块结构体类型
{	int i;						//方块的行号
	int j;						//方块的列号
	Box pre;					//前驱方块
	public Box(int i1,int j1)	//构造方法
	{
		i=i1;
		j=j1;
		pre=null;
	}
}

class MazeClass						//用队列求解一条迷宫路径类
{
	final int MaxSize=20;
	int [][] mg;					//迷宫数组
	int m,n;						//迷宫行列数
	Queue<Box> qu;					//队列
	public MazeClass(int m1,int n1)
	{
		m=m1;
		n=n1;
		mg=new int[MaxSize][MaxSize];
		qu=new LinkedList<Box>();	//创建一个空队qu
	}
	public void Setmg(int [][] a)	//数组迷宫数组
	{
		for (int i=0;i<m;i++)
			for (int j=0;j<n;j++)
				mg[i][j]=a[i][j];		
	}
	public void disppath(Box p)				//从p出发找一条迷宫路径
	{	int cnt=1;
		while (p!=null)						//找到入口为止
		{
			System.out.print("["+p.i+","+p.j+"]  ");
			if (cnt%5==0)					//每行输出5个方块
				System.out.println();
			cnt++;
			p=p.pre;
		}
		System.out.println();
	}
	boolean mgpath(int xi,int yi,int xe,int ye)	//求(xi,yi)到(xe,ye)的一条迷宫路径
	{
		int i,j,i1=0,j1=0;
		Box b,b1;
		b=new Box(xi,yi);					//建立入口结点b
		qu.offer(b);						//结点b进队
		mg[xi][yi]=-1;						//进队方块mg值置为-1
		while (!qu.isEmpty())				//队不空时循环
		{
			b=qu.poll();					//出队一个方块b
			if (b.i==xe && b.j==ye)			//找到了出口,输出路径
			{	disppath(b);				//从b出发回推导出迷宫路径并输出
				return true;				//找到一条路径时返回true
			}
			i=b.i; j=b.j;
			for (int di=0;di<4;di++)		//循环扫描每个方位,把每个可走的方块进队
			{
				switch(di)
				{
				case 0:i1=i-1; j1=j;   break;
				case 1:i1=i;   j1=j+1; break;
				case 2:i1=i+1; j1=j;   break;
				case 3:i1=i;   j1=j-1; break;
				}
				if (i1>=0 && i1<m && j1>=0 && j1<n && mg[i1][j1]==0)//找到一个相邻可走方块
				{
					b1=new Box(i1,j1);		//建立后继方块结点b1
					b1.pre=b;				//设置其前驱方块为b
					qu.offer(b1);			//b1进队
					mg[i1][j1]=-1;			//进队的方块置为-1
				}
			}
		}
		return false;						//未找到任何路径时返回false
	}
}

public class Maze
{
	public static void main(String[] args)
	{
		int [][] a= { {1,1,1,1,1,1},{1,0,1,0,0,1},
						{1,0,0,1,1,1},{1,0,1,0,0,1},
						{1,0,0,0,0,1},{1,1,1,1,1,1} };			
		MazeClass mz=new MazeClass(6,6);
		mz.Setmg(a);
		if (!mz.mgpath(1,1,4,4))
			System.out.println("不存在迷宫路径");
   }	   
} 