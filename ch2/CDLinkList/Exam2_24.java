public class Exam2_24
{
	public static boolean Symm(CDLinkListClass<Integer> L)		//例2.24的算法
	{
		boolean flag=true;						//flag表示L是否对称，初始时为真
		DLinkNode<Integer> p=L.dhead.next;		//p指向首结点
		DLinkNode<Integer> q=L.dhead.prior;		//q指向尾结点
		while (flag)
		{
			if (p.data!=q.data)					//对应结点值不相同，置flag为假
				flag=false;
			else
			{	if (p==q || p==q.prior) break;
				q=q.prior;						//q前移一个结点 
				p=p.next;						//p后移一个结点
			}
		} 
		return flag;
	}

	public static void main(String[] args)
	{
		Integer [] a={1,2,2,1};
		CDLinkListClass<Integer> A=new CDLinkListClass<Integer>();
		A.CreateListR(a);
		System.out.println("A: "+A.toString());
		System.out.println("A的对称性:  "+Symm(A));
		
		
		Integer [] b={1,2,1};
		CDLinkListClass<Integer> B=new CDLinkListClass<Integer>();
		B.CreateListR(b);
		System.out.println("B: "+B.toString());
		System.out.println("B的对称性:  "+Symm(B));
   }	   
}

 