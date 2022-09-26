//import Link.*;
public class Exam2_20
{
	public static int Count(CLinkListClass<Integer> L,Integer x) 	//例2.20的算法
	{
		int cnt=0;							//cnt置为0
		LinkNode<Integer> p=L.head.next;	//p指向首结点
		while (p!=L.head)					//遍历循环单链表
		{	if (p.data==x)
				cnt++;						//找到一个值为x的结点cnt增1
			p=p.next;						//p后移一个结点
		}
		return cnt;
	}
   public static void main(String[] args)
   {
		Integer [] a={1,5,3,5,5};
		CLinkListClass<Integer> L=new CLinkListClass<Integer>();
		L.CreateListR(a);
		System.out.println("L: "+L.toString());
		Integer x=5;
		System.out.println("值为"+x+"的结点个数= "+Count(L,x));
   }	   
}

 