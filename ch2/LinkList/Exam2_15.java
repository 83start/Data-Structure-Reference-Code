import java.lang.*;
@SuppressWarnings("unchecked")
public class Exam2_15
{
	public static void Split(LinkListClass<Integer> L,LinkListClass<Integer> A,LinkListClass<Integer> B) //例2.15的算法
	{
		LinkNode<Integer> p=L.head.next;			//p指向L的首结点
		LinkNode<Integer> q=null,t;
		t=A.head;									//t始终指向A的尾结点
		while (p!=null)								//遍历L的所有数据结点
		{
			t.next=p; t=p;							//尾插法建立A
			p=p.next;								//p后移一个结点
			if (p!=null)
			{
				q=p.next;							//临时保存p结点的后继结点
				p.next=B.head.next;					//头插法建立B
				B.head.next=p;
				p=q;								//p指向q结点
			}
		}
		t.next=null;								//尾结点next置空
	}

	public static void main(String[] args)
	{
		Integer [] a={1,2,3,4,5,6,7,8};
		LinkListClass<Integer> L=new LinkListClass<Integer>();
		L.CreateListR(a);
		System.out.println("L: "+L.toString());
		LinkListClass<Integer> A,B;
		A=new LinkListClass<Integer>();
		B=new LinkListClass<Integer>();
		System.out.println("L拆分成两个单链表A和B");
		Split(L,A,B);
		System.out.println("A: "+A.toString());
		System.out.println("B: "+B.toString());
	}	   
}

 