import java.util.*;
class Box						//方块结构体类型
{	int i;						//方块的行号
	int j;						//方块的列号
	int di;						//di是下一可走相邻方位的方位号
	public Box(int i1,int j1,int di1)	//构造方法	
	{
		i=i1;
		j=j1;
		di=di1;
	}	
}
class MazeClass							//用栈求解一条迷宫路径类
{	final int MaxSize=20;
	int [][] mg;							//迷宫数组
	int m,n;							//迷宫行列数
	public MazeClass(int m1,int n1)			//构造方法
	{	m=m1;
		n=n1;
		mg=new int[MaxSize][MaxSize];
	}
	public void Setmg(int [][] a)				//设置迷宫数组
	{	for (int i=0;i<m;i++)
			for (int j=0;j<n;j++)
				mg[i][j]=a[i][j];
	}
	boolean mgpath(int xi,int yi,int xe,int ye)	//求一条从(xi,yi)到(xe,ye)的迷宫路径
	{	int i,j,di,i1=0,j1=0;
		boolean find;
		Box box,e;
		Stack<Box> st=new Stack<Box>();	//建立一个空栈
		st.push(new Box(xi,yi,-1));			//入口方块进栈
		mg[xi][yi]=-1;					//为避免来回找相邻方块,将进栈的方块置为-1
		while (!st.empty())				//栈不空时循环
		{	box=st.peek();				//取栈顶方块,称为当前方块
			i=box.i; j=box.j; di=box.di;
			if (i==xe && j==ye)			//找到了出口,输出栈中所有方块构成一条路径
			{	int cnt=1;
				while (!st.empty())
				{	e=st.pop();
					System.out.print("["+e.i+","+e.j+"]  ");
					if (cnt%5==0)			//每行输出5个方块
						System.out.println();
					cnt++;
				}
				System.out.println();
				return true;				//找到一条路径后返回true
			}
			find=false;						//否则继续找路径
			while (di<4 && !find)			//找下一个相邻可走方块
			{	di++;						//找下一个方位的相邻方块
				switch(di)
				{
				case 0:i1=i-1; j1=j;    break;
				case 1:i1=i;   j1=j+1;  break;
				case 2:i1=i+1; j1=j;    break;
				case 3:i1=i;   j1=j-1;  break;
				}
				if (mg[i1][j1]==0)
					find=true;			//找到下一个可走相邻方块(i1,j1)
			}
			if (find)					//找到了下一个可走方块
			{	e=st.pop();
				e.di=di;
				st.push(e);				//修改栈顶元素的di字段为di
				st.push(new Box(i1,j1,-1));	//下一个可走方块进栈
				mg[i1][j1]=-1;			//为避免来回找相邻方块,将进栈的方块置为-1
			}
			else						//没有路径可走,则退栈
			{	mg[i][j]=0;				//恢复当前方块的迷宫值
				st.pop();				//将栈顶方块退栈
			}
		}
		return false;					//没有找到迷宫路径,返回false
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