import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Exam7_13
{
	static int cnt;
	public static int KCount1(BTreeClass bt,int k)	//求二叉树第k层结点个数
	{
		cnt=0;
		KCount11(bt.b,1,k);
		return cnt;
	}
	private static void KCount11(BTNode<Character> t,int h,int k)
	{
		if (t==null)			//空树返回0
			return;
		if (h==k)				//当前层的结点在第k层，cnt增1
			cnt++;
		if (h<k)				//当前结点层小于k，递归处理左、右子树
		{
			KCount11(t.lchild,h+1,k);
			KCount11(t.rchild,h+1,k);
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		for (int i=0;i<=5;i++)
			System.out.printf("第%d层结点个数: %d\n",i,KCount1(bt,i));
	}
}
