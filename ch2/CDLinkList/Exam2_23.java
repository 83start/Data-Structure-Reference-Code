public class Exam2_23
{
	public static CDLinkListClass<Integer> Comb(CDLinkListClass<Integer> A,CDLinkListClass<Integer> B) 	//例2.21的算法
	{
		DLinkNode<Integer> ta=A.dhead.prior;	//ta指向A的尾结点
		DLinkNode<Integer> tb=B.dhead.prior;	//tb指向B的尾结点
		ta.next=B.dhead.next;					//尾首相连
		B.dhead.next.prior=ta;
		tb.next=A.dhead;
		A.dhead.prior=tb;
		return A;
	}

	public static void main(String[] args)
	{
		Integer [] a={1,2,3,4};
		CDLinkListClass<Integer> A=new CDLinkListClass<Integer>();
		A.CreateListR(a);
		System.out.println("A: "+A.toString());
		
		Integer [] b={10,20,30};
		CDLinkListClass<Integer> B=new CDLinkListClass<Integer>();
		B.CreateListR(b);
		System.out.println("B: "+B.toString());
		System.out.println("将B链接到A的尾部");
		A=Comb(A,B);
		System.out.println("A: "+A.toString());
   }	   
}

 