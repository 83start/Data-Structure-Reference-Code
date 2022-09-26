public class Exam2_12
{
	public static void Delmaxnodes(LinkListClass<Integer> L) 	//例2.12的算法
	{
		Integer maxe;
		LinkNode<Integer> p=L.head.next,pre;		//p指向首结点
		maxe=p.data;								//maxe置为首结点值
		while (p.next!=null)						//查找最大结点值maxe
		{
			if (p.next.data>maxe)
				maxe=p.next.data;
			p=p.next;
		}
		pre=L.head;									//pre指向头结点
		p=pre.next;									//p指向pre的后继结点
		while (p!=null)								//p遍历所有结点
		{
			if (p.data==maxe)						//p结点为最大值结点
			{
				pre.next=p.next;					//删除p结点
				p=pre.next;							//让p指向pre的后继结点
			}
			else
			{
				pre=pre.next;						//pre后移一个结点
				p=pre.next;							//让p指向pre的后继结点
			}
		}
	}
   public static void main(String[] args)
   {
		Integer [] a={5,1,3,5,5};
		LinkListClass<Integer> L=new LinkListClass<Integer>();
		L.CreateListR(a);
		System.out.println("L: "+L.toString());
		System.out.println("删除所有最大值结点");
		Delmaxnodes(L);
		System.out.println("L: "+L.toString());
   }	   
}

 