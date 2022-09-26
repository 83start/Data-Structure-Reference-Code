import java.lang.*;
public class BF
{
	public static int Index(String s,String t)
	{
		int i=0, j=0;
		while (i<s.length() && j<t.length())		//两串未遍历完时循环
		{
			if (s.charAt(i)==t.charAt(j))			//继续匹配下一个字符
			{
				i++;								//主串和子串依次匹配下一个字符
				j++;
			}
			else									//主串、子串指针回溯重新开始下一次匹配
			{	i=i-j+1;							//主串从下一个位置开始匹配
				j=0; 								//子串从头开始匹配
			}
		}
		if (j>=t.length())
			return (i-t.length());					//返回匹配的第一个字符序号
		else
			return (-1);							//模式匹配不成功
	}

	public static void main(String[] args)
	{
		String s="aaaaab";
		String t="aaab";
		int i=Index(s,t);
		if (i>=0)
			System.out.println("匹配成功 i="+i);
		else
			System.out.println("匹配失败");
	}	   
} 