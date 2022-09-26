import java.util.*;
@SuppressWarnings("unchecked")
class Order
{
	public void PreOrder2(BTreeClass bt)			//先序遍历的非递归算法1
	{
		PreOrder21(bt.b);
	}
	private void PreOrder21(BTNode<Character> t)	//被PreOrder2函数调用
	{
		Stack<BTNode> st=new Stack<BTNode>();		//定义一个栈
		BTNode<Character> p;
		st.push(t);									//根结点t进栈
		while (!st.empty())							//栈不为空时循环
		{
			p=st.pop();								//出栈结点p
			System.out.print(p.data+" ");			//访问p结点
			if (p.rchild!=null)						//p结点有右孩子时将右孩子进栈
				st.push(p.rchild);
			if (p.lchild!=null)						//p结点有左孩子时将左孩子进栈
				st.push(p.lchild);
		}
	}
	public void PreOrder3(BTreeClass bt)			//先序遍历的非递归算法2
	{
		PreOrder31(bt.b);
	}
	private void PreOrder31(BTNode<Character> t)	//被PreOder3函数调用
	{
		Stack<BTNode> st=new Stack<BTNode>();		//定义一个栈
		BTNode<Character> p=t;
		while (!st.empty() || p!=null)				//栈不空或者p不空时循环
		{
			while (p!=null)							//访问根结点及其所有左下结点并进栈
			{	System.out.print(p.data+" ");		//访问p结点
				st.push(p);
				p=p.lchild;
			}
			if (!st.empty())						//若栈不空
			{	p=st.pop();							//出栈p结点
				p=p.rchild;							//转向处理其右子树
			}
		}
	}
	public void InOrder2(BTreeClass bt)				//中序遍历的非递归算法
	{
		InOrder21(bt.b);
	}
	private void InOrder21(BTNode<Character> t)		//被InOrder2函数调用
	{
		Stack<BTNode> st=new Stack<BTNode>();		//定义一个栈
		BTNode<Character> p=t;
		while (!st.empty() || p!=null)				//栈不空或者p不空时循环
		{
			while (p!=null) 						//扫描p的所有左结点并进栈
			{
				st.push(p);
				p=p.lchild;
			}
			if (!st.empty())						//若栈不空
			{
				p=st.pop();							//出栈p结点
				System.out.print(p.data+" ");		//访问p结点
				p=p.rchild;							//转向处理右子树
			}
		}
	}
	public void PostOrder2(BTreeClass bt)		//后序遍历的非递归算法
	{
		PostOrder21(bt.b);
	}
	private void PostOrder21(BTNode<Character> t)	//被PostOder2函数调用
	{
		Stack<BTNode> st=new Stack<BTNode>();		//定义一个栈
		BTNode<Character> p=t,q;
		boolean flag;
		do
		{
			while (p!=null)							//将p结点及其所有左下结点进栈
			{
				st.push(p);
				p=p.lchild;
			}
			q=null;									//q指向前一个刚刚访问的结点或为空
			flag=true;								//表示在处理栈顶结点
			while (!st.empty() && flag)
			{	p=st.peek();						//取当前栈顶结点
				if (p.rchild==q)					//若p结点右子树已访问或为空
				{
					System.out.print(p.data+" ");	//访问p结点
					st.pop();						//结点访问后退栈
					q=p;							//让q指向则被访问的结点
				}
				else								//若p结点右子树没有遍历
				{	p=p.rchild;						//转向处理其右子树
					flag=false;						//退出栈顶结点的处理，转向p结点的右子树
				}
			}
		} while (!st.empty());
	}
}
public class BTreeOrder1
{
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		Order o=new Order();
		System.out.print("非递归先序遍历序列1: ");o.PreOrder2(bt);
		System.out.println();
		System.out.print("非递归先序遍历序列2: ");o.PreOrder3(bt);
		System.out.println();
		System.out.print(" 非递归中序遍历序列: ");o.InOrder2(bt);
		System.out.println();
		System.out.print(" 非递归后序遍历序列: ");o.PostOrder2(bt);
		System.out.println();
	}
}
