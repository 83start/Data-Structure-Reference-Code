import java.util.*;
@SuppressWarnings("unchecked")
class LOrder
{
	public void LevelOrder(BTreeClass bt)		//层次遍历的算法	
	{
		BTNode<Character> p;
		Queue<BTNode> qu=new LinkedList<BTNode>();	//定义一个队列qu
		qu.offer(bt.b);							//根结点进队
		while (!qu.isEmpty())					//队不空循环
		{
			p=qu.poll();						//出队一个结点
			System.out.print(p.data+" ");		//访问p结点
			if (p.lchild!=null)					//有左孩子时将其进队
				qu.offer(p.lchild);
			if (p.rchild!=null)					//有右孩子时将其进队
				qu.offer(p.rchild);
		}
	}
}
public class LevelOrder
{
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		LOrder o=new LOrder();
		System.out.print("层次遍历序列: ");o.LevelOrder(bt);
		System.out.println();
	}
}
