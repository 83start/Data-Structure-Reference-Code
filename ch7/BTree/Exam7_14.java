import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Exam7_14
{
	static String ans;										//存放x结点的所有祖先结点
	public static String Ancestor4(BTreeClass bt,char x)
	{
		ans="";
		Ancestor41(bt.b,x);
		return ans;
	}
	private static void Ancestor41(BTNode<Character> t,Character x)	
	{
		Stack<BTNode> st=new Stack<BTNode>();	//定义一个栈
		BTNode<Character> p=t,q;
		boolean flag;
		do
		{	while (p!=null)							//p及其所有左下结点并进栈
			{	st.push(p);
				p=p.lchild;
			}
			q=null;								//q指向前一个刚刚访问的结点或为空
			flag=true;							//表示在处理栈顶结点
			while (!st.empty() && flag)
			{	p=st.peek();					//取当前栈顶结点
				if (p.rchild==q)				//若p结点右子树已访问或为空
				{
					if (p.data==x)				//当前访问的结点的值为x
					{
						st.pop();				//出栈x结点
						while(!st.empty())		//出栈其他所有祖先并存放到ans中
							ans+=String.valueOf(st.pop().data)+" ";
						return;					//结束
					}
					else						//当前访问的结点的值不为x
					{	st.pop();				//结点访问后退栈
						q=p;					//让q指向则被访问的结点
					}
				}
				else							//若p结点右子树没有遍历
				{	p=p.rchild;					//转向处理其右子树
					flag=false;					//退出栈顶结点的处理，转向p结点的右子树
				}
			}
		} while (!st.empty());					//栈空结束
	}
	public static void solve(BTreeClass bt,char x)
	{
		String s;
		s=Ancestor4(bt,x);
		if (s.isEmpty())
			System.out.println(x+"结点不存在或它没有祖先");
		else
			System.out.println("结点"+x+"的祖先: "+s);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		solve(bt,'A');
		solve(bt,'X');
		solve(bt,'D');
		solve(bt,'G');
		solve(bt,'F');
	}
}
