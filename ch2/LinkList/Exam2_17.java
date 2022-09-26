import java.lang.*;
@SuppressWarnings("unchecked")
public class Exam2_17
{
	public static LinkListClass<Integer> Commnodes(LinkListClass<Integer> A,LinkListClass<Integer> B) 
													//例2.16的算法
	{	LinkNode<Integer> p=A.head.next;			//p指向A的首结点
		LinkNode<Integer> q=B.head.next;			//q指向B的首结点
		LinkListClass<Integer> C=new LinkListClass<Integer>();
		LinkNode<Integer> t=C.head,s;				//t为C的尾结点
		while (p!=null && q!=null)					//两个单链表都没有遍历完
		{	if (p.data<q.data)						//跳过较小的p结点p链接到C的末尾
				p=p.next;
			else if (q.data<p.data)					//将较小结点q链接到C的末尾
				q=q.next;
			else									//p结点和q结点值相同
			{
				s=new LinkNode<Integer>(p.data);	//新建s结点
				t.next=s; t=s;						//将s结点链接到C的末尾
				p=p.next;
				q=q.next;
			}
		}
		t.next=null;								//尾结点next置空
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
		System.out.println("建立相同值结点的单链表C");
		LinkListClass<Integer> C;
		C=Commnodes(A,B);
		System.out.println("C: "+C.toString());
   }	   
}

 