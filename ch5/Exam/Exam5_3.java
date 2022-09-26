//@SuppressWarnings("unchecked")
public class Exam5_3
{
	public static void Positive(LinkNode<Integer> p)
	{
		if (p==null)
			return;
		else
		{
			System.out.print(p.data+" ");
			Positive(p.next);
		}
	}
	public static void Reverse(LinkNode<Integer> p)
	{
		if (p==null)
			return;
		else
		{
			Reverse(p.next);
			System.out.print(p.data+" ");
		}
	}

	public static void main(String[] args)
	{
		System.out.println("*******测试****************“");
		Integer [] a={1,2,3,4,5};
		LinkListClass<Integer> L=new LinkListClass<Integer>();
		L.CreateListR(a);
		System.out.println("L: "+L.toString());
		System.out.print("正向输出: ");		
		Positive(L.head.next);
		System.out.println();
		
		System.out.println("L: "+L.toString());
		System.out.print("反向输出: ");		
		Reverse(L.head.next);
		System.out.println();

	}	   
}

 