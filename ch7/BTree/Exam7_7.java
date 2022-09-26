import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Exam7_7
{

	public static void displeaf1(BTreeClass bt)	 	//基于先序遍历输出叶子结点
	{
		displeaf11(bt.b);
	}
	private static void displeaf11(BTNode<Character> t)
	{	if (t!=null)
		{
			if (t.lchild==null && t.rchild==null)
				System.out.print(t.data+" ");		//输出叶子结点
			displeaf11(t.lchild);					//遍历左子树
			displeaf11(t.rchild);					//遍历右子树
		}
	}
	public static void displeaf2(BTreeClass bt)  	//基于中序遍历输出叶子结点
	{
		displeaf21(bt.b);
	}
	private static void displeaf21(BTNode<Character> t)
	{	if (t!=null)
		{
			displeaf11(t.lchild);					//遍历左子树
			if (t.lchild==null && t.rchild==null)
				System.out.print(t.data+" ");		//输出叶子结点
			displeaf11(t.rchild);					//遍历右子树
		}
	}
	public static void displeaf3(BTreeClass bt)		//基于后序遍历输出叶子结点
	{
		displeaf31(bt.b);
	}
	private static void displeaf31(BTNode<Character> t)
	{	if (t!=null)
		{
			displeaf11(t.lchild);					//遍历左子树
			displeaf11(t.rchild);					//遍历右子树
			if (t.lchild==null && t.rchild==null)
				System.out.print(t.data+" ");		//输出叶子结点
		}
	}
	public static void displeaf4(BTreeClass bt)		//基于递归算法思路
	{
		displeaf41(bt.b);
	}
	private static void displeaf41(BTNode<Character> t)
	{	if (t!=null)
		{
			if (t.lchild==null && t.rchild==null)
				System.out.print(t.data+" ");		//输出叶子结点
			else
			{
				displeaf41(t.lchild);				//遍历左子树
				displeaf41(t.rchild);				//遍历右子树
			}
		}
	}
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		System.out.print("displeaf1: ");
		displeaf1(bt); System.out.println();
		System.out.print("displeaf2: ");
		displeaf2(bt); System.out.println();
		System.out.print("displeaf3: ");
		displeaf3(bt);	 System.out.println();	
		System.out.print("displeaf4: ");
		displeaf4(bt);	 System.out.println();	
	}
}
