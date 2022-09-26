import java.util.Scanner;
public class Exam7_5
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
			int ans,k;
			ans=(int)Math.pow(2.0,d)-1;						//高度为d的满二叉树结点个数
			k=(int)Math.pow(2.0,d);							//满二叉树中第d+1层的结点个数
			int start=m*k;									//子树最下层起始结点编号
			int end=start+k;								//子树最下层可能的终止结点编号
			if (end<=n)										//子树为d+1层的满二叉树
				ans+=k;
			else											//其他情况
            {	if (start<=n)								//子树高度为d+1层，其他为高度d的满二叉树
                    ans+=(n-start+1);
            }
			System.out.println(ans);
		}
	}
}
