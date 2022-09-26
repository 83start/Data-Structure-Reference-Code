public class Exam2_14
{
	public static LinkListClass<Integer> Comb(LinkListClass<Integer> A,LinkListClass<Integer> B) 	//例2.14的算法
	{
		LinkListClass<Integer> C=new LinkListClass<Integer>();
		LinkNode<Integer> p,q,t;
		p=A.head.next;					//p指向A的首结点
		q=B.head.next;					//q指向B的首结点
		t=C.head;						//t始终指向C的尾结点
		while (p!=null && q!=null)		//当两个表均未遍历完
		{
			t.next=p; t=p;				//将p结点插入到C的末尾
			p=p.next;					//p后移一个结点
			t.next=q; t=q;				//将q结点插入到C的末尾
			q=q.next;					//q后移一个结点
		}
		t.next=null;					//置尾结点的next为空
		if (p!=null) t.next=p;			//A未遍历完，将余下结点链接到C的尾部
		if (q!=null) t.next=q;			//B未遍历完，将余下结点链接到C的尾部
		return C;
	}
	public static void main(String[] args)
	{
		Integer [] a={1,2,3,4,5};
		LinkListClass<Integer> A=new LinkListClass<Integer>();
		A.CreateListR(a);
		System.out.println("A: "+A.toString());
		
		Integer [] b={10,20,30,40,50,60,70};
		LinkListClass<Integer> B=new LinkListClass<Integer>();
		B.CreateListR(b);
		System.out.println("B: "+B.toString());
		System.out.println("合并");
		LinkListClass C;
		C=Comb(A,B);
		System.out.println("C: "+C.toString());
	}	   
}

 