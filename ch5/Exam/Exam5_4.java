@SuppressWarnings("unchecked")
public class Exam5_4
{
	static int cnt=0;
	public static double pow(double x,int n)
	{
		cnt++;
		if (n==0) return 1;
		double p=pow(x,n/2);
		if (n%2==1)				//n为奇数
			return x*p*p;
		else					//n为偶数
			return p*p;
			
	}
	public static double pow1(double x,int n)
	{
		double ans=1.0,base=x;
		cnt=0;
		while (n!=0)
		{
			cnt++;
			if ((n&1)==1)
				ans*=base;
            base*=base;
            n >>= 1;
		}
		return ans;
	}
	public static double pow21(double x,int n)
	{
		double ans=1.0,base=x;
		cnt=0;
		while (n!=0)
		{
			cnt++;
			if ((n&1)==1)
			{
				ans*=base;
				base*=base;
			}
			else
				base*=base;
            n >>= 1;
		}
		return ans;
	}
	public static void main(String[] args)
	{
		int n=13;
		double x=2;
		System.out.println("  递归: "+pow(x,n));
		System.out.println("  递归调用次数: "+cnt);
		System.out.println("非递归: "+pow1(x,n));
		System.out.println("  循环次数: "+cnt);
		System.out.println("非递归: "+pow21(x,n));
		System.out.println("  循环次数: "+cnt);
	}	   
} 