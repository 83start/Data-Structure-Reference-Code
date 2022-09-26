public class Exam3_4
{
	public static boolean isMatch(String str)		//例3.4的算法
	{
		int i=0;
		char e,x;
		SqStackClass<Character> st=new SqStackClass<Character>();	//建立一个顺序栈
		while (i<str.length())
		{
			e=str.charAt(i);
			if (e=='(' || e=='[' || e=='{')
				st.push(e);								//将左括号进栈
			else
			{	if (e==')')
				{	if (st.empty()) return false;		//栈空返回false
					if (st.peek()!='(') return false;	//栈顶不是匹配的'('返回false
					st.pop();
				}
				if (e==']')
				{	if (st.empty()) return false;		//栈空返回false
					if (st.peek()!='[') return false;	//栈顶不是匹配的'['返回false
					st.pop();
				}
				if (e=='}')
				{	if (st.empty()) return false;		//栈空返回false
					if (st.peek()!='{') return false;	//栈顶不是匹配的'{'返回false
					st.pop();
				}
			}
			i++;										//继续遍历str
		}
		if (st.empty())
			return true;								//栈空返回true
		else
			return false;								//栈不空返回false
	}
	public static void main(String[] args)
	{
		System.out.println("测试1");
		String str="([)]";
		if (isMatch(str))
			System.out.println(str+"中括号是匹配的");
		else
			System.out.println(str+"中括号不匹配");

		System.out.println("测试2");
		str="([])";
		if (isMatch(str))
			System.out.println(str+"中括号是匹配的");
		else
			System.out.println(str+"中括号不匹配");

   }	   
} 