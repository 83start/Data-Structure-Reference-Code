import java.lang.*;
@SuppressWarnings("unchecked")
public class Exam2_16
{
	public static LinkListClass<Integer> Merge2(LinkListClass<Integer> A,LinkListClass<Integer> B) //例2.16的算法
	{
		LinkNode<Integer> p=A.head.next;			//p指向A的首结点
		LinkNode<Integer> q=B.head.next;			//q指向B的首结点
		LinkListClass<Integer> C=new LinkListClass<Integer>();
		LinkNode<Integer> t=C.head;
		while (p!=null && q!=null)
		{
			if (p.data<q.data)
			{
				t.next=p; t=p;
				p=p.next;
			}
			else
			{
				t.next=q; t=q;
				q=q.next;
			}
		}				
		t.next=null;								//尾结点next置空
		if (p!=null) t.next=p;
		if (q!=null) t.next=q;
		return C;
	}
   public static void main(String[] args)
   {
		Integer [] a={1,3,5,7};
		LinkListClass<Integer> A=new LinkListClass<Integer>();
		A.CreateListR(a);
		System.out.println("A: "+A.toString());
		Integer [] b={1,2,5,7,9,10,20};
		LinkListClass<Integer> B=new LinkListClass<Integer>();
		B.CreateListR(b);
		System.out.println("B: "+B.toString());
		System.out.println("二路归并");
		LinkListClass<Integer> C;
		C=Merge2(A,B);
		System.out.println("C: "+C.toString());
   }	   
}

 