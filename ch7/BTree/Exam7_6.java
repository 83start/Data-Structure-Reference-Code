import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Exam7_6
{

	public static int NodeCount1(BTreeClass bt)		//基于先序遍历求结点个数
	{
		return NodeCount11(bt.b);
	}
	private static int NodeCount11(BTNode<Character> t)
	{	int m,n,k;
		if (t==null)							//空树结点个数为0
			return 0;
		k=1;							//根结点计数1，相当于访问根结点
		m=NodeCount11(t.lchild);			//遍历求左子树的结点个数
		n=NodeCount11(t.rchild);			//遍历求右子树的结点个数
		return k+m+n;
	}
	public static int NodeCount2(BTreeClass bt)  //基于中序遍历求结点个数
	{
		return NodeCount21(bt.b);
	}
	private static int NodeCount21(BTNode<Character> t)
	{	int m,n,k;
		if (t==null)						//空树结点个数为0
			return 0;
		m=NodeCount21(t.lchild);			//遍历求左子树的结点个数
		k=1;							//根结点计数1，相当于访问根结点
		n=NodeCount21(t.rchild);			//遍历求右子树的结点个数
		return k+m+n;
	}
	public static int NodeCount3(BTreeClass bt)	//基于后序遍历求结点个数
	{
		return NodeCount31(bt.b);
	}
	private static int NodeCount31(BTNode<Character> t)
	{	int m,n,k;
		if (t==null)						//空树结点个数为0
			return 0;
		m=NodeCount31(t.lchild);			//遍历求左子树的结点个数
		n=NodeCount31(t.rchild);			//遍历求右子树的结点个数
		k=1;								//根结点计数1，相当于访问根结点
		return k+m+n;
	}
	public static int NodeCount4(BTreeClass bt)			//递归求解
	{
		return NodeCount41(bt.b);
	}
	private static int NodeCount41(BTNode<Character> t)
	{	if (t==null)
			return 0;		//空树结点个数为0
		else
			return(NodeCount41(t.lchild)+NodeCount41(t.rchild)+1);
	}

	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		System.out.println("NodeCount1求出结点个数: "+NodeCount1(bt));
		System.out.println("NodeCount2求出结点个数: "+NodeCount2(bt));
		System.out.println("NodeCount3求出结点个数: "+NodeCount3(bt));		
		System.out.println("NodeCount4求出结点个数: "+NodeCount4(bt));		
	}
}
