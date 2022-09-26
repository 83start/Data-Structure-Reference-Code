public class tmp
{
	public static void resize(int [] a) {		//例2.1的算法
		int b=a.length;
	}
	public static void disp(int [] a)
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public static void main(String[] args)
	{
		int [] a={1,2,3};
		disp(a);
		resize(a);
		disp(a);
	}	   
} 