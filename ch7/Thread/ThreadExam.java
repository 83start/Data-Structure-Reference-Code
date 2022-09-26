@SuppressWarnings("unchecked")
public class ThreadExam
{
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		ThreadClass bt=new ThreadClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		bt.CreateThread();
		System.out.print("中序序列: ");
		bt.ThInOrder();
		System.out.println();
		
	}
}
