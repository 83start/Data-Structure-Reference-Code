public class Exam2_13
{
	public static void Reverse(LinkListClass<Integer> L) 	//例2.13的算法
	{
		LinkNode<Integer> p=L.head.next,q;	//p指向首结点
		L.head.next=null;					//将L置为一个空表
		while (p!=null)
		{
			q=p.next;						//q临时保存p结点的后继结点
			p.next=L.head.next;				//将p结点插入到表头
			L.head.next=p;
			p=q;
		}
	}
   public static void main(String[] args)
   {
		Integer [] a={1,2,3,4,5};
		LinkListClass<Integer> L=new LinkListClass<Integer>();
		L.CreateListR(a);
		System.out.println("L: "+L.toString());
		System.out.println("逆置");
		Reverse(L);
		System.out.println("L: "+L.toString());
   }	   
}

 