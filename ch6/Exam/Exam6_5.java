import java.util.*;
@SuppressWarnings("unchecked")
public class Exam6_5
{
	public static int mind(int [] a)
	{
		int n=a.length;
		Arrays.sort(a);			//递增排序
		int d=a[n-1]-a[0];		//置最大差
		for (int i=1;i<n;i++)
			if (a[i]-a[i-1]<d)
				d=a[i]-a[i-1];
		return d;
	}
	public static void main(String[] args)
	{
		int [] a={1,-2,-3,4,5};
		System.out.println("最小差的绝对值:"+mind(a));		
	}
} 