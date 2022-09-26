import java.util.*;
class ThNode						//线索二叉树结点类型
{	char data;						//存放结点值
	ThNode lchild,rchild;			//左、右孩子或线索的指针
	int ltag,rtag;					//左、右标志
	public ThNode()					//默认构造方法
	{
		lchild=rchild=null;
		ltag=rtag=0;
	}
	public ThNode(char d)			//重载构造方法
	{
		data=d;
		lchild=rchild=null;
		ltag=rtag=0;
	}
}

public class ThreadClass
{
	ThNode b;							//二叉树的根结点
	ThNode root;						//线索二叉树的头结点
	ThNode pre;							//用于中序线索化,指向中序前驱结点
	String bstr;
	public ThreadClass()
	{
		root=null;
	}
	//中序线索二叉树的基本运算
	public void CreateThread()			//建立以root为头结点的中序线索二叉树
	{
		root=new ThNode();				//创建头结点root
		root.ltag=0; root.rtag=1;		//头结点域置初值
		root.rchild=b;
		if (b==null)					//b为空树时
		{	root.ltag=0; root.lchild=root;
			root.rtag=1; root.rchild=null;
		}
		else							//b不为空树时
		{	root.lchild=b;
			pre=root;					//pre是p的前驱结点,用于线索化
			Thread(b);					//中序遍历线索化二叉树
			pre.rchild=root;			//最后处理,加入指向根结点的线索
			pre.rtag=1;
			root.rchild=pre;			//根结点右线索化
		}
	}
	private void Thread(ThNode p)			//对以p为根结点的二叉树进行中序线索化
	{
		if (p!=null)
		{
			Thread(p.lchild);				//左子树线索化
			if (p.lchild==null)				//前驱线索
			{	p.lchild=pre;				//给结点p添加前驱线索
				p.ltag=1;
			}
			else p.ltag=0;
			if (pre.rchild==null)
			{	pre.rchild=p;				//给结点pre添加后继线索
				pre.rtag=1;
			}
			else pre.rtag=0;
			pre=p;
			Thread(p.rchild);				//右子树线索化
		}
	}
	public void ThInOrder()						//中序线索二叉树的中序遍历
	{
		ThNode p=root.lchild;					//p指向根结点
		while (p!=root)
		{	while (p!=root && p.ltag==0)		//找中序开始结点
			p=p.lchild;
			System.out.print(p.data+" ");		//访问p结点
			while (p.rtag==1 && p.rchild!=root)
			{	p=p.rchild;						//如果是线索，一直找下去
				System.out.print(p.data+" ");	//访问p结点
			}
			p=p.rchild;							//如果不再是线索，转向其右子树
		}
	}

	//二叉树的基本运算
	public void CreateBTree(String str)			//创建以b为根结点的二叉链存储结构
	{
		Stack<ThNode> st=new Stack<ThNode>();	//建立一个栈
		ThNode p=null;
		boolean flag=true;
		char ch;
		int i=0;
		while (i<str.length())					//循环扫描str中每个字符
		{
			ch=str.charAt(i);
			switch(ch)
			{
			case '(':
					st.push(p);						//刚刚新建的结点有孩子,将其进栈
					flag=true;
					break;
			case ')':
					st.pop();						//栈顶结点的子树处理完，出栈
					break;
			case ',':
					flag=false;						//开始处理栈顶结点的右孩子
					break;
			default:
					p=new ThNode(ch);	//用ch值新建一个结点
					if (b==null)
						b=p;						//若尚未建立根结点,p作为根结点
					else							//已建立二叉树根结点
					{
						if (flag)					//新结点p作为栈顶结点的左孩子
						{
							if (!st.empty())
								st.peek().lchild=p;
						}
						else						//新结点p作为栈顶结点的右孩子
						{
							if (!st.empty())
								st.peek().rchild=p;
						}
					}
					break;
			}
			i++;								//继续遍历
		}
	}
	public String toString()					//返回二叉链的括号表示串
	{
		bstr="";
		toString1(b);
		return bstr;
	}
	private void toString1(ThNode t)		//被DispThNode方法调用
	{
		if (t!=null)
		{	bstr+=t.data;						//输出根结点值
			if (t.lchild!=null || t.rchild!=null)
			{
				bstr+="(";						//有孩子结点时输出"("
				toString1(t.lchild);			//递归输出左子树
				if (t.rchild!=null)
					bstr+=",";					//有右孩子结点时输出","
				toString1(t.rchild);			//递归输出右子树
				bstr+=")";						//输出")"
			}
		}
	}
}
