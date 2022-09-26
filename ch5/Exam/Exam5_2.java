@SuppressWarnings("unchecked")
public class Exam5_2
{
	public static int Min(int [] a,int i)
	{
		if (i==0)						//递归出口
			return a[0];
		else							//递归体
		{	int min=Min(a,i-1);
			if (min>a[i]) return(a[i]);
			else return min;
		}
	}
	public static void main(String[] args)
	{
		int [] a={3,1,2,4,5};
		System.out.printf("Min: "+Min(a,a.length-1));
	}	   
} 