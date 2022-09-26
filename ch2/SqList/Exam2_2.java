public class Exam2_2
{
	public static void Swapmaxmin(SqListClass<Integer> L) {	//例2.2的算法
		int maxi,mini;
		maxi=mini=0;
		for (int i=1;i<L.size();i++)
			if (L.GetElem(i)>L.GetElem(maxi))
				maxi=i;
			else if (L.GetElem(i)<L.GetElem(mini))
				mini=i;
		L.swap(maxi,mini);
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		Integer [] a={1,2,3,4,5};
		SqListClass<Integer> L=new SqListClass<Integer>();
		L.CreateList(a);
		System.out.println("L: "+L.toString());
		System.out.println("将L中最大最小元素交换");
		Swapmaxmin(L);
		System.out.println("L: "+L.toString());
	}	   
}

 