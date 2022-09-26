@SuppressWarnings("unchecked")
public class BTreeExam
{
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		char x='X';
		if (bt.FindNode(x)!=null)
			System.out.printf("找到值为%c的结点\n",x);
		else
			System.out.printf("没有找到值为%c的结点\n",x);
		System.out.printf("bt的高度=%d\n",bt.Height());
	}
}
