public class Exam4_6
{
	public static int Index1(LinkStringClass s,LinkStringClass t)
	{
		LinkNode p=s.head.next,p1;	//p指向s串的首结点
		LinkNode q;
		int i=0;					//i为p指的首结点的序号为0
		while (p!=null)
		{
			p1=p;
			q=t.head.next;			//q指向t串的首结点
			while (p1!=null && q!=null && p1.data==q.data)
			{						//比较p1结点和q结点的字符,相等时同步后移
				p1=p1.next;
				q=q.next;
			}
			if (q==null)
				return i;			//t串比较完毕,返回i
			p=p.next;				//p移到s串的下一个结点
			i++;
		}
		return -1;					//串t不是串s的子串时返回-1
	}
	public static void main(String[] args)
	{
		
		char [] cstr1={'a','b','a','b','c','a','b','c','a','c','b','a','b'};
		char [] cstr2={'a','b','c','a','c'};
		LinkStringClass s=new LinkStringClass();
		s.StrAssign(cstr1);
		System.out.println("s: "+s.toString());
		LinkStringClass t=new LinkStringClass();
		t.StrAssign(cstr2);
		System.out.println("t: "+t.toString());
		System.out.println("匹配结果: "+Index1(s,t));
	}	   
} 