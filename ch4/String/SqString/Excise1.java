public class Excise1
{
	public static int maxcnt(SqStringClass s)
	{
		int mcnt=0;
		char mch=s[0];
	}
	public static void main(String[] args)
	{
		
		char [] cstr1={'a','b','c'};
		char [] cstr2={'a','b','c'};
		SqStringClass s1=new SqStringClass();
		s1.StrAssign(cstr1);
		System.out.println("s1: "+s1.toString());
		SqStringClass s2=new SqStringClass();
		s2.StrAssign(cstr2);
		System.out.println("s2: "+s2.toString());
		int ans=Strcmp(s1,s2);
		if (ans==1)
			System.out.println("s1>s2");
		else if (ans==0)
			System.out.println("s1==s2");
		else
			System.out.println("s1<s2");

   }	   
} 