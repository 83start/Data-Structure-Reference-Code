@SuppressWarnings("unchecked")
public class dg
{
	public static int Sum(LinkNode<Integer> p)
	{
		if (p==null)
			return 0;
		else
			return(p.data+Sum(p.next));
	}
	public static void main(String[] args)
	{
		System.out.println("*******测试****************“");
		Integer [] a={1,2,3,4,5};
		LinkListClass<Integer> L=new LinkListClass<Integer>();
		L.CreateListR(a);
		System.out.println("L: "+L.toString());
		System.out.println("所有结点值之和: "+Sum(L.head.next));		
	}	   
}

 