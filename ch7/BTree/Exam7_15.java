import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Exam7_15
{
	public static int KCount2(BTreeClass bt,int k)	//解法1：求二叉树第k层结点个数
	{
		int cnt=0;									//累计第k层结点个数
		class QNode
		{
			int lno;								//结点的层次
			BTNode<Character> node;					//结点
			public QNode(int l,BTNode<Character> no)	//构造方法
			{
				lno=l;
				node=no;
			}
		}
		Queue<QNode> qu=new LinkedList<QNode>();	//定义一个队列qu
		QNode p;
		qu.offer(new QNode(1,bt.b));				//根结点(层次为1)进队
		while (!qu.isEmpty())						//队不空循环
		{	p=qu.poll();							//出队一个结点
			if (p.lno>k)							//当前结点的层次大于k，返回
				return cnt;
			if (p.lno==k)
				cnt++;								//当前结点是第k层的结点,cnt增1
			else									//当前结点的层次小于k
			{
				if (p.node.lchild!=null)			//有左孩子时将其进队
					qu.offer(new QNode(p.lno+1,p.node.lchild));
				if (p.node.rchild!=null)			//有右孩子时将其进队
					qu.offer(new QNode(p.lno+1,p.node.rchild));
			}
		}
		return cnt;
	}
	
	public static int KCount3(BTreeClass bt,int k)	//解法2：求二叉树第k层结点个数
	{
		int cnt=0;									//累计第k层结点个数
		Queue<BTNode> qu=new LinkedList<BTNode>();	//定义一个队列qu
		BTNode<Character> p,q=null;
		int curl=1;									//当前层次,从1开始
		BTNode<Character> last;						//当前层中最右结点
		last=bt.b;									//第1层最右结点
		qu.offer(bt.b);								//根结点进队
		while (!qu.isEmpty())						//队不空循环
		{
			if (curl>k)							//当层号大于k时返回cnt,不再继续
				return cnt;
			p=qu.poll();							//出队一个结点
			if (curl==k)
				cnt++;								//当前结点是第k层的结点,cnt增1
			if (p.lchild!=null)						//有左孩子时将其进队
			{
				q=p.lchild;
				qu.offer(q);
			}
			if (p.rchild!=null)						//有右孩子时将其进队
			{
				q=p.rchild;
				qu.offer(q);
			}
			if (p==last)							//当前层的所有结点处理完毕
			{
				last=q;								//让last指向下一层的最右结点
				curl++;
			}
		}
		return cnt;
	}
	public static int KCount4(BTreeClass bt,int k)	//解法3：求二叉树第k层结点个数
	{
		if (k<1)									//k<1返回0
			return 0;
		Queue<BTNode> qu=new LinkedList<BTNode>();	//定义一个队列qu
		BTNode<Character> p,q=null;
		int curl=1;									//当前层次,从1开始
		qu.offer(bt.b);								//根结点进队
		while (!qu.isEmpty())						//队不空循环
		{
			if (curl==k)							//当前层为第k层，返回队中元素个数
				return qu.size();
			int n=qu.size();						//求出当前层结点个数
			for (int i=1;i<=n;i++)					//出队当前层的n个结点
			{
				p=qu.poll();						//出队一个结点
				if (p.lchild!=null)					//有左孩子时将其进队
					qu.offer(p.lchild);
				if (p.rchild!=null)					//有右孩子时将其进队
					qu.offer(p.rchild);
			}
			curl++;									//转向下一层
		}
		return 0;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		//int i=3;
		//System.out.printf("第%d层结点个数: %d\n",i,KCount4(bt,i));

		for (int i=0;i<=5;i++)
			System.out.printf("第%d层结点个数: %d\n",i,KCount4(bt,i));
	}
}
