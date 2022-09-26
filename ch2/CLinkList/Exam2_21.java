public class Exam2_21
{
	public static CLinkListClass<Integer> Comb(CLinkListClass<Integer> A,CLinkListClass<Integer> B) 	//例2.21的算法
	{
		LinkNode<Integer> ta=A.head,tb=B.head;
		while (ta.next!=A.head)			//ta指向A的尾结点
			ta=ta.next;
		ta.next=B.head.next;			//A和B尾首相连
		while (tb.next!=B.head)			//tb指向B的尾结点
			tb=tb.next;
		tb.next=A.head;					//ta的next指向A的头结点
		return A;
	}

	public static void main(String[] args)
	{
		Integer [] a={1,2,3,4};
		CLinkListClass<Integer> A=new CLinkListClass<Integer>();
		A.CreateListR(a);
		System.out.println("A: "+A.toString());
		
		Integer [] b={10,20,30};
		CLinkListClass<Integer> B=new CLinkListClass<Integer>();
		B.CreateListR(b);
		System.out.println("B: "+B.toString());
		System.out.println("将B链接到A的尾部");
		A=Comb(A,B);
		System.out.println("A: "+A.toString());
   }	   
}

 