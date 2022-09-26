import java.util.*;
public class Exam3_11
{
	
	public static boolean pushk(CSqQueueClass<Integer> qu,int k,Integer e) //进队第k个元素e
	{
		Integer x;
		int i=1,n=qu.size();
		if (k<1 || k>n+1)
			return false;					//参数k错误返回false
		if (k<=n)
		{
			for (i=1;i<=n;i++)				//循环处理队中所有元素
			{	if (i==k)
					qu.push(e);				//将e元素进队到第k个位置
				x=qu.pop();					//出队元素x
				qu.push(x);					//进队元素x
			}
		}
		else qu.push(e);					//k=n+1时直接进队e
		return true;
	}
	public static Integer popk(CSqQueueClass<Integer> qu,int k)	//出队第k个元素
	{
		Integer x,e=0;
		int i=1,n=qu.size();
		if (k<1 || k>n)						//参数k错误
			throw new IllegalArgumentException("参数错误");
		for (i=1;i<=n;i++)					//循环处理队中所有元素
		{
			x=qu.pop();						//出队元素x
			if (i!=k)
				qu.push(x);					//将非第k个元素进队
			else e=x;						//取第k个出队的元素
		}
		return e;
	}
	public static void main(String[] args)
	{		
		int [] a={1,2,3,4,5,6};
		CSqQueueClass<Integer> qu=new CSqQueueClass<Integer>();
		for (int i=0;i<a.length;i++)
		{
			qu.push(a[i]);
			System.out.println("进队元素: "+a[i]);
		}
		System.out.println("qu: "+qu.toString());	
		int k=2,e=20;
		System.out.println("进队第"+k+"个元素"+e);
		pushk(qu,k,e);
		System.out.println("qu: "+qu.toString());
		k=6;
		e=popk(qu,k);		
		System.out.println("出队第"+k+"个元素"+e);
		System.out.println("qu: "+qu.toString());	

		

	}
}
