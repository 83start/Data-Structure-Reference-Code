@SuppressWarnings("unchecked")
public class xt
{
	/*
	public static void  f(int n)
	{
		if (n==0)						//递归出口
			return;
		else							//递归体
		{
			
			System.out.println("Pre:  n="+n);
			System.out.printf("执行f(%d)\n",n-1);			
			f(n-1);
			System.out.println("Post: n="+n);
		}
	}
	*/
	public static int S(int n)
	{
		return (n<=0) ? 0 : S(n-1)+n;
	}
	public static void main(String[] args)
	{
		System.out.printf("%d\n",S(1)); 
	}	   
} 