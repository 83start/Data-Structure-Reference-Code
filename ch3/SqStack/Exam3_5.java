public class Exam3_5
{
	public static boolean isPalindrome(String str)		//例3.5的算法
	{
		SqStackClass<Character> st=new SqStackClass();	//建立一个顺序栈
		int n=str.length();
		int i=0;
		while (i<n/2)					//将str前半字符进栈
		{
			st.push(str.charAt(i));
			i++;						//继续遍历str
		}
		if (n%2==1)						//n为奇数时
			i++;						//跳过中间的字符
		while (i<n)						//遍历str的后半字符
		{
			if (st.pop()!=str.charAt(i))
				return false;			//若str[i]不等于出栈字符返回false
			i++;
		}
		return true;					//是回文返回true
	}
	public static void main(String[] args)
	{
		System.out.println("测试1");
		String str="abcba";
		if (isPalindrome(str))
			System.out.println(str+"是回文");
		else
			System.out.println(str+"不是回文");

		System.out.println("测试2");
		str="1221";
		if (isPalindrome(str))
			System.out.println(str+"是回文");
		else
			System.out.println(str+"不是回文");
	}
}
