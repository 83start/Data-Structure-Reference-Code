import java.util.Scanner;
public class Exam7_5_1
{
	public static void main(String[] args)
	{
		int m, n;
		Scanner fin=new Scanner(System.in);
		while (fin.hasNext())
		{
			m=fin.nextInt();
			n=fin.nextInt();
			if (m==0 && n==0) break;
			int dep1 = (int)(Math.log(m)/Math.log(2))+1;	//m结点的层次
			int dep2 = (int)(Math.log(n)/Math.log(2))+1;	//n结点的层次
			int d=dep2-dep1;								//求出层次差
			int ans;
			int h=1;										//子树高度为h
			int start=m;
			while (start*2<=n)
			{
				start=2*start;
				h++;
			}
			//System.out.println("h="+h);
			if (h==d)										//子树是高度为d的满二叉树
				ans=(int)Math.pow(2.0,h)-1;
			else											//子树的高度为d+1
			{
				int k=(int)Math.pow(2.0,d);					//满二叉树中第d+1层的结点个数
				int end=start+k;
				if (end<=n)									//子树为d+1层的满二叉树
					ans=(int)Math.pow(2.0,h)-1;
				else										//子树为d+1层的完全二叉树
                    ans=(int)Math.pow(2.0,h-1)-1+(n-start+1);
            }
			System.out.println(ans);
		}
	}
}
