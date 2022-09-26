import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Exam7_12
{
	final static int MaxLevel=100;			//最大层次
	static int[] w=new int[MaxLevel];		//存放每一层结点个数
	public static int Width(BTreeClass bt)	//求二叉树的宽度
	{
		Width1(bt.b,1);
		int ans=0;
		for (int i=1;i<MaxLevel;i++)
			if (ans<w[i])
				ans=w[i];
		return ans;
	}
	private static void Width1(BTNode<Character> t,int h)	//被Width1方法调用
	{
		if (t==null) return;
		w[h]++;								//第h层的结点个数增1
		Width1(t.lchild,h+1);				//遍历左子树
		Width1(t.rchild,h+1);				//遍历右子树
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		System.out.printf("bt的宽度=%d\n",Width(bt));
	}
}
