public class Exam2_1
{
	public static void Reverse(SqListClass<Integer> L)		//例2.1的算法
	{
		int i=0,j=L.size()-1;
		while (i<j)
		{
			L.swap(i,j);
			i++; j--;
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		Integer [] a={1,2,3,4,5};
		SqListClass<Integer> L=new SqListClass<Integer>();
		L.CreateList(a);
		System.out.println("L: "+L.toString());
		System.out.println("将L的所有元素逆置");
		Reverse(L);
		System.out.println("L: "+L.toString());
	}	   
} 