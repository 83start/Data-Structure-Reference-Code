public class Exam2_18
{
	public static void Delx(DLinkListClass<Integer> L,Integer x) 	//例2.18的算法
	{
		DLinkNode<Integer> p=L.dhead.next;		//p指向首结点
		while (p!=null && p.data!=x)			//查找第一个值为x的结点p
			p=p.next;
		if (p!=null)							//找到值为x的结点p
		{
			if (p.next!=null)
				p.next.prior=p.prior; 			//删除p结点
			p.prior.next=p.next;
		}
	}
   public static void main(String[] args)
   {
		Integer [] a={5,1,3,5,5};
		DLinkListClass<Integer> L=new DLinkListClass<Integer>();
		L.CreateListR(a);
		System.out.println("L: "+L.toString());
		System.out.println("删除第一个值为x的结点");
		Delx(L,5);
		System.out.println("L: "+L.toString());
   }	   
}

 