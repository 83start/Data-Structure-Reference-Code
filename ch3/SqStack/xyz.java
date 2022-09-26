import java.util.*;
public class xyz
{
	static String op="";
	static int cnt;
	public static boolean isSerial(int[] b)			//例3.6的算法
	{
		int i,j,n=b.length;
		Integer e;
		Stack<Integer> st=new Stack<Integer>();	//建立一个顺序栈
		i=1; j=0;
		while (i<=n && j<n)						//a和b均没有遍历完
		{
			if (st.empty() || (st.peek()!=b[j])) //栈空或者栈顶元素不是b[j]
			{
				st.push(i);					//a[i]进栈
				i++;
			}
			else								//否则出栈
			{	e=st.pop();
				j++;
			}
		}
		while (!st.empty() && st.peek()==b[j])	//将栈中与b序列相同的元素出栈
		{	e=st.pop();
			j++;
		}

		if (j==n)
			return true;				//是出栈序列时返回true
		else
			return false;				//不是出栈序列时返回false
	}

	public static boolean isSerial1(int[] b)	//例3.6的算法
	{
		int i,j,n=b.length;
		Integer e;
		Stack<Integer> st=new Stack<Integer>();	//建立一个顺序栈
		i=0; j=0;
		while (i<n && j<n)						//a和b均没有遍历完
		{
			if (st.empty() || (st.peek()!=b[j])) //栈空或者栈顶元素不是b[j]
			{
				st.push(i+1);					//a[i]进栈
				op+="  元素"+(i+1)+"进栈\n";
				i++;
			}
			else								//否则出栈
			{	e=st.pop();
				op+="  元素"+e+"出栈\n";			
				j++;
			}
		}
		/*
		while (!st.empty() && st.peek()==b[j])	//将栈中与b序列相同的元素出栈
		{	e=st.pop();
			op+="  元素"+e+"出栈\n";
			j++;
		}
		*/
		if (j==n)
			return true;						//是出栈序列时返回true
		else
			return false;						//不是出栈序列时返回false
	}
	public static void solve(int[] b)			//求解算法
	{
		for (int i=0;i<b.length;i++)
			System.out.print(" "+b[i]);
		if (isSerial(b))
		{
			System.out.println("是合法的出栈序列");
			System.out.println(op);
		}
		else
			System.out.println("不是合法的出栈序列");
	}
	public static void main(String[] args)
	{		
		System.out.println("测试1");
		int [] b={1,2,3,4,5};
		solve(b);
	}
}
