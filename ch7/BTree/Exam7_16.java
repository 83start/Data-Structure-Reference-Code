import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Exam7_16
{
	static String ans;									//存放x结点的所有祖先结点
	public static String Ancestor4(BTreeClass bt,char x)	//返回x结点的祖先
	{
		ans="";
		class QNode										//队列元素类（内部类）
		{	
			BTNode<Character> node;						//当前结点
			QNode pre;									//当前结点双亲结点
			public QNode(BTNode<Character> no,QNode p)	//构造方法
			{	node=no;
				pre=p;
			}
		}
		Queue<QNode> qu=new LinkedList<QNode>();	//定义一个队列qu
		QNode p;
		qu.offer(new QNode(bt.b,null));				//根结点(双亲为null)进队
		while (!qu.isEmpty())						//队不空循环
		{	p=qu.poll();							//出队一个结点
			if (p.node.data==x)						//当前结点p为x结点
			{
				QNode q=p.pre;
				while (q!=null)						//找到根结点为止
				{
					ans+=q.node.data+" ";
					q=q.pre;
				}
				return ans;
			}
			if (p.node.lchild!=null)				//有左孩子时将其进队
				qu.offer(new QNode(p.node.lchild,p));
			if (p.node.rchild!=null)				//有右孩子时将其进队
				qu.offer(new QNode(p.node.rchild,p));
		}
		return ans;
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
		solve(bt,'E');
		solve(bt,'D');
		solve(bt,'G');
		solve(bt,'F');
	}
}
