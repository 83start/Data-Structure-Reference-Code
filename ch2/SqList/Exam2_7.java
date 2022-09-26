public class Exam2_7
{
	public static int Middle(SqListClass<Integer> A,SqListClass<Integer> B) {	//例2.7的算法
		int i=0, j=0, k=0;
		while (i<A.size() && j<B.size()) {		//两个有序顺序表均没有扫描完
			k++;								//当前归并的元素个数增1
			if (A.GetElem(i)<B.GetElem(j)) {	//归并A中较小的元素
				if (k==A.size())				//若当前归并的元素是第n个元素
					return A.GetElem(i);		//返回A中的当前元素
				i++;
			}
			else {								//归并B中较小的元素
				if (k==B.size())				//若当前归并的元素是第n个元素
				return B.GetElem(j);			//返回B中的当前元素
				j++; 
			}
		}
		return 0;
	}

   public static void main(String[] args)
   {
		Integer [] a={11,13,15,17,19};
		SqListClass<Integer> A=new SqListClass<Integer>();
		A.CreateList(a);
		System.out.println("A: "+A.toString());
		Integer [] b={2,4,6,8,20};
		SqListClass<Integer> B=new SqListClass<Integer>();
		B.CreateList(b);
		System.out.println("B: "+B.toString());
		System.out.println("求中位数x");
		Integer x=Middle(A,B);
		System.out.println("x="+x);
   }	   
} 