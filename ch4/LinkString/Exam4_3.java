public class Exam4_3
{
	public static boolean StrEqueal(LinkStringClass s,LinkStringClass t)
	{
		if (s.size()!=t.size())
			return false;
		LinkNode p=s.head.next;
		LinkNode q=t.head.next;
		while (p!=null && q!=null)
		{	if (p.data!=q.data)
				return false;
			p=p.next;
			q=q.next;
		}
		return true;
	}
	public static void main(String[] args)
	{
		
		char [] cstr1={'a','b','c'};
		char [] cstr2={'a','b','c'};
		LinkStringClass s1=new LinkStringClass();
		s1.StrAssign(cstr1);
		System.out.println("s1: "+s1.toString());
		LinkStringClass s2=new LinkStringClass();
		s2.StrAssign(cstr2);
		System.out.println("s2: "+s2.toString());
		if (StrEqueal(s1,s2))
			System.out.println("s1==s2");
		else
			System.out.println("s1!=2");

   }	   
} 