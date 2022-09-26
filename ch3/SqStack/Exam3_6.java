import java.util.*;
public class Exam3_6
{
	static String op="";
	public static boolean isSerial(int[] b)			//例3.6的算法
	{
		int i,j,n=b.length;
		Integer e;
		int [] a=new int[n];
		SqStackClass<Integer> st=new SqStackClass<Integer>();	//建立一个顺序栈
		for (i=0;i<n;i++)
			a[i]=i+1;							//将1～n放入数组a中
		i=0; j=0;
		while (i<n && j<n)						//a和b均没有遍历完
		{
			if (st.empty() || (st.peek()!=b[j])) //栈空或者栈顶元素不是b[j]
			{
				st.push(a[i]);					//a[i]进栈
				op+="  元素"+a[i]+"进栈\n";
				i++;
			}
			else								//否则出栈
			{	e=st.pop();
				op+="  元素"+e+"出栈\n";			
				j++;
			}
		}
		while (!st.empty() && st.peek()==b[j])	//将栈中与b序列相同的元素出栈
		{	e=st.pop();
			j++;
		}
		if (j==n)
			return true;						//是出栈序列时返回true
		else
			return false;						//不是出栈序列时返回false
	}
	public static boolean isSerial1(int[] b)	//例3.6的简化算法
	{
		int i,j,n=b.length;
		Integer e;
		int [] a=new int[n];
		SqStackClass<Integer> st=new SqStackClass<Integer>();	//建立一个顺序栈
		for (i=0;i<n;i++)
			a[i]=i+1;							//将1～n放入数组a中
		i=0; j=0;
		while (i<n)								//a没有遍历完
		{
			st.push(a[i]);
			op+="  元素"+a[i]+"进栈\n";
			i++;
			while (!st.empty() && st.peek()==b[j])	//b[j]与栈顶匹配的情况
			{
				e=st.pop();
				op+="  元素"+e+"出栈\n";
				j++;
			}
		}
		return st.empty();						//栈空返回true;否则返回false
	}
	public static boolean isSerial2(int[] b)	//例3.6的算法（不使用a数组）
	{
		int i,j,n=b.length;
		Integer e;
		SqStackClass<Integer> st=new SqStackClass<Integer>();	//建立一个顺序栈
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
		while (!st.empty() && j<n && st.peek()==b[j])	//将栈中与b序列相同的元素出栈
		{	e=st.pop();
			op+="  元素"+e+"出栈\n";
			j++;
		}
		if (j==n)
			return true;						//是出栈序列时返回true
		else
			return false;						//不是出栈序列时返回false
	}
	
	public static void solve(int[] b)			//求解算法
	{
		for (int i=0;i<b.length;i++)
			System.out.print(" "+b[i]);
		if (isSerial2(b))
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
		int [] b={1,3,2,4};
		solve(b);

		System.out.println("测试2");
		int [] c={4,3,1,2};
		solve(c);

	}
}
