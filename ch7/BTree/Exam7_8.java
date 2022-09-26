import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Exam7_8
{
	public static BTreeClass CopyBTree1(BTreeClass bt1)
	{
		BTreeClass bt2=new BTreeClass();
		bt2.b=CopyBTree11(bt1.b);
		return bt2;
	}
	private static BTNode<Character>CopyBTree11(BTNode<Character> t1)	//由二叉树t1复制产生二叉树t2
	{
		if (t1!=null)
		{
			BTNode<Character> t2=new BTNode<Character>(t1.data);//复制根结点
			t2.lchild=CopyBTree11(t1.lchild);					//递归复制左子树
			t2.rchild=CopyBTree11(t1.rchild);					//递归复制左子树
			return t2;
		}
		return null;											//t1为空时返回null
	}

	public static BTreeClass CopyBTree2(BTreeClass bt1)
	{
		BTreeClass bt2=new BTreeClass();
		bt2.b=CopyBTree21(bt1.b);
		return bt2;
	}
	private static BTNode<Character>CopyBTree21(BTNode<Character> t1)	//由二叉树t1复制产生二叉树t2
	{
		if (t1!=null)
		{		
			BTNode<Character> l;
			BTNode<Character> r;
			l=CopyBTree21(t1.lchild);					//递归复制左子树
			r=CopyBTree21(t1.rchild);					//递归复制左子树
			BTNode<Character> t2=new BTNode<Character>(t1.data);//复制根结点
			t2.lchild=l;
			t2.rchild=r;
			return t2;
		}
		return null;											//t1为空时返回null
	}
	public static BTreeClass CopyBTree3(BTreeClass bt1)
	{
		BTreeClass bt2=new BTreeClass();
		bt2.b=CopyBTree31(bt1.b);
		return bt2;
	}
	private static BTNode<Character>CopyBTree31(BTNode<Character> t1) //由二叉树t1复制产生二叉树t2
	{
		if (t1!=null)
		{		
			BTNode<Character> l;
			BTNode<Character> r;
			l=CopyBTree31(t1.lchild);					//递归复制左子树
			BTNode<Character> t2=new BTNode<Character>(t1.data);//复制根结点
			t2.lchild=l;			
			r=CopyBTree31(t1.rchild);					//递归复制左子树
			t2.rchild=r;
			return t2;
		}
		return null;									//t1为空时返回null
	}

@SuppressWarnings("unchecked")

	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt1=new BTreeClass();
		BTreeClass bt2;
		bt1.CreateBTree(s);
		System.out.println("bt1: "+bt1.toString());
		System.out.println("bt1->bt2");
		bt2=CopyBTree3(bt1);
		System.out.println("bt2: "+bt2.toString());
	}
}
