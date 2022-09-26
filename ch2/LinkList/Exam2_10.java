//import Link.*;
public class Exam2_10
{
	public static int Middle1(LinkListClass<Integer> L) 	//例2.10的算法
	{
		int j=1,n=L.size();
		LinkNode<Integer> p=L.head.next;					//p指向首结点
		while (j<=(n-1)/2)									//找中间位置的p结点
		{
			j++;
			p=p.next;
		}
		return p.data;
	}
	public static int Middle2(LinkListClass<Integer> L) 	//例2.10的算法
	{
		LinkNode<Integer> slow=L.head.next;
		LinkNode<Integer> fast=L.head.next;					//均指向首结点
		while (fast.next!=null && fast.next.next!=null)		//找中间位置的p结点
		{
			slow=slow.next;									//慢指针每次后移1个结点
			fast=fast.next.next;							//快指针每次后移2个结点
		}
		return slow.data;
	}
	public static void main(String[] args)
	{
		Integer [] a={1,2,3};
		LinkListClass<Integer> L=new LinkListClass<Integer>();
		L.CreateListR(a);
		System.out.println("L: "+L.toString());
		System.out.println("中间位置的结点值: "+Middle1(L));
		System.out.println("中间位置的结点值: "+Middle2(L));
	}	   
}

 