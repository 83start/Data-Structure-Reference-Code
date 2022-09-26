public class Exam4_4
{
	public static boolean Replace(LinkStringClass s)
	{
		LinkNode p=s.head.next,q;
		boolean find=false;
		while (p.next!=null && !find)			//查找"ab"子串
		{
			if (p.data=='a' && p.next.data=='b')//找到了ab子串
			{
				p.data='x';p.next.data='z';		//替换为xyz
				q=new LinkNode('y');			//新建一个存放字符'y'的结点q
				q.next=p.next; p.next=q;
				find=true;
			}
			else p=p.next; 
		}
		return find;
	}
	public static void main(String[] args)
	{
		
		char [] cstr={'1','a','b','c'};
		LinkStringClass s=new LinkStringClass();
		s.StrAssign(cstr);
		System.out.println("s: "+s.toString());
		System.out.println("替换");
		Replace(s);
		System.out.println("s: "+s.toString());
	}	   
} 