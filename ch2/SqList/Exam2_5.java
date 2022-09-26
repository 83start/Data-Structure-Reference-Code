public class Exam2_5
{
	public static void Delsame(SqListClass<Integer> L) {	//例2.5的算法
		int i,k=1;
		for (i=1;i<L.size();i++)
			if (L.GetElem(i)!=L.GetElem(k-1))					//将不相邻重复的元素插入
			{	L.SetElem(k,L.GetElem(i));
				k++;
			}
		L.Setsize(k);										//重置长度
	}

   public static void main(String[] args)
   {
		//测试1
		Integer [] a={1,2,2,2,1};
		SqListClass<Integer> L1=new SqListClass<Integer>();
		L1.CreateList(a);
		System.out.println("L1: "+L1.toString());
		System.out.println("删除所有相邻重复的元素");
		Delsame(L1);
		System.out.println("L1: "+L1.toString());
		//测试2
		Integer [] b={1,1,1,2,1,1,1,2,2};
		SqListClass<Integer> L2=new SqListClass<Integer>();
		L2.CreateList(b);
		System.out.println("L2: "+L2.toString());
		System.out.println("删除所有相邻重复的元素");
		Delsame(L2);
		System.out.println("L2: "+L2.toString());
   }	   
} 