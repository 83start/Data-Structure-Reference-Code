//import Link.*;
public class Exam2_11
{
	public static int Maxcount(LinkListClass<Integer> L) 	//例2.11的算法
	{
		int cnt=1;
		Integer maxe;
		LinkNode<Integer> p=L.head.next;	//p指向首结点
		maxe=p.data;						//maxe置为首结点值
		while (p.next!=null)				//循环到p结点为尾结点
		{
			if (p.next.data>maxe)			//找到更大的结点
			{
				maxe=p.next.data;
				cnt=1;
			}
			else if (p.next.data==maxe)		//p结点为当前最大值结点
				cnt++;
			p=p.next;
		}
		return cnt;
	}
   public static void main(String[] args)
   {
		Integer [] a={1,5,3,5,5};
		LinkListClass<Integer> L=new LinkListClass<Integer>();
		L.CreateListR(a);
		System.out.println("L: "+L.toString());
		System.out.println("最大值结点个数= "+Maxcount(L));
   }	   
}

 