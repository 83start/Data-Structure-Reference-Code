public class tmp
{
	static int geti(int key,int r,int i)	//求基数为r的正整数key的第i位
	{
		int k=0;
		for (int j=0;j<=i;j++)
		{
			k=key%r;
			key=key/r;
		}
		return k;
	}
			
		
	public static void main(String[] args)
	{
		int key=1234;
		System.out.println(geti(key,10,2));
	}

	
}
