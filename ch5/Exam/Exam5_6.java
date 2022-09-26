import java.lang.*;
import java.util.*;
class Box										//方块类
{	int i;										//方块的行号
	int j;										//方块的列号
	public Box(int i1,int j1)					//构造方法
	{
		i=i1;
		j=j1;
	}
}
class MazeClass									//求解迷宫路径类
{	final int MaxSize=20;
	int [][] mg;								//迷宫数组
	int m,n;									//迷宫行列数
	int cnt=0;									//累计迷宫路径数
	public MazeClass(int m1,int n1)				//构造方法
	{	m=m1;
		n=n1;
		mg=new int[MaxSize][MaxSize];
	}
	public void Setmg(int [][] a)				//设置迷宫数组
	{	for (int i=0;i<m;i++)
			for (int j=0;j<n;j++)
				mg[i][j]=a[i][j];
	}
	void mgpath(int xi,int yi,int xe,int ye,ArrayList<Box> path)  //求解迷宫路径为:(xi,yi)->(xe,ye)
	{
		Box b;
		int di,i=0,j=0;
		b=new Box(xi,yi);
		path.add(b);							//将(xi,yi)添加到path中
		mg[xi][yi]=-1;							//mg[xi][yi]=-1		
		if (xi==xe && yi==ye)					//找到了出口,输出一个迷宫路径
		{
			System.out.printf("迷宫路径%d:",++cnt);	//输出path中的迷宫路径
			for (int k=0;k<path.size();k++)
				System.out.printf("  (%d,%d)",path.get(k).i,path.get(k).j);
			System.out.println();
			mg[xi][yi]=0;						//恢复为0,否则别的路径找不到出口  
		}
		else									//(xi,yi)不是出口
		{
			di=0;
			while (di<4)						//处理(xi,yi)四周的每个相邻方块(i,j)
			{
				switch(di)
				{
				case 0:i=xi-1; j=yi;   break;
				case 1:i=xi;   j=yi+1; break;
				case 2:i=xi+1; j=yi;   break;
				case 3:i=xi;   j=yi-1; break;
				}
				if (mg[i][j]==0)				//(i,j)可走时
					mgpath(i,j,xe,ye,path);		//从(i,j)出发查找迷宫路径
				di++;							//继续处理(xi,yi)下一个相邻方块
			}
		}
		path.remove(path.size()-1);				//删除path末尾方格（回退一个方块）
		mg[xi][yi]=0;
	}
}
public class Exam5_6
{
	public static void main(String[] args)
	{
		int [][] a= { {1,1,1,1,1,1},{1,0,1,0,0,1},
					{1,0,0,1,1,1},{1,0,1,0,0,1},
					{1,0,0,0,0,1},{1,1,1,1,1,1} };	
		MazeClass mz=new MazeClass(6,6);
		ArrayList<Box> path=new ArrayList<Box>();
		mz.Setmg(a);
		mz.mgpath(1,1,4,4,path);
   }	   
}

 