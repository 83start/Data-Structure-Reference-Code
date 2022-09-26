public class Exam4_2
{
	public static int Strcmp(SqStringClass s,SqStringClass t)
	{
		int comlen;
		if (s.size()<t.size())
			comlen=s.size();					//求s和t的共同长度
		else
			comlen=t.size();
		for (int i=0;i<comlen;i++)				//在共同长度内逐个字符比较
			if (s.data[i]>t.data[i])
				return 1;
			else if (s.data[i]<t.data[i])
				return -1;
		if (s.size()==t.size())					//s==t
			return 0;
		else if (s.size()>t.size())				//s>t
			return 1;
		else  return -1;						//s<t
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