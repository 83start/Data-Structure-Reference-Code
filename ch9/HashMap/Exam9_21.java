import java.util.*;
public class Exam9_21
{	
	static boolean unique(String s)			//判断s中所有字母是否都唯一
	{
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		for (int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if (map.containsKey(c))			//字母c不唯一返回false
				return false;
			else
				map.put(c,1);
		}
		return true;						//所有字母唯一返回true
	}
    public static void main(String[] args)
	{
		Scanner fin=new Scanner(System.in);
		String s;
		s=fin.next();
		if (unique(s))
			System.out.println(s+": Yes");
		else
			System.out.println(s+": No");
    }
}
