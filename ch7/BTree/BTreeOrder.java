@SuppressWarnings("unchecked")
class Order
{
	public void PreOrder1(BTreeClass bt)		//先序遍历的递归算法	
	{
		PreOrder11(bt.b);
	}
	private void PreOrder11(BTNode<Character> t) //被PreOrder1方法调用
	{	if (t!=null)
		{	System.out.print(t.data+ " ");		//访问根结点
			PreOrder11(t.lchild);				//先序遍历左子树
			PreOrder11(t.rchild);				//先序遍历右子树
		}
	}
	public void InOrder1(BTreeClass bt)			//中序遍历的递归算法	
	{
		InOrder11(bt.b);
	}
	private void InOrder11(BTNode<Character> t) //被InOrder1方法调用
	{	if (t!=null)
		{	InOrder11(t.lchild);				//中序遍历左子树
			System.out.print(t.data+ " ");		//访问根结点
			InOrder11(t.rchild);				//中序遍历右子树
		}
	}
	public void PostOrder1(BTreeClass bt)		//后序遍历的递归算法	
	{
		PostOrder11(bt.b);
	}
	private void PostOrder11(BTNode<Character> t) //被PostOrder1方法调用
	{	if (t!=null)
		{	PostOrder11(t.lchild);				//后序遍历左子树
			PostOrder11(t.rchild);				//后序遍历右子树
			System.out.print(t.data+ " ");		//访问根结点
		}
	}
}
public class BTreeOrder
{
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		Order o=new Order();
		System.out.print("递归先序遍历序列: ");o.PreOrder1(bt);
		System.out.println();
		System.out.print("递归中序遍历序列: ");o.InOrder1(bt);
		System.out.println();
		System.out.print("递归后序遍历序列: ");o.PostOrder1(bt);
		System.out.println();
	}
}
