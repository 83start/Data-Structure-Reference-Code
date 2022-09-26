public class SqListSortExam
{
	/*
	public static void main(String[] args)
	{
		//int[] a={3,5,1,2,4};
		int a[]={3,8,7,6,5,4,3,2,1,0,3};
		//int a[]={8,9,10,4,5,6,20,1,2};
		int n=a.length;
		SqListSortClass s=new SqListSortClass();
		s.CreateR(a);
		System.out.print("R:  ");s.Disp();
		System.out.println("排序结果");
		//s.BubbleSort();
		//s.QuickSort();
		s.SelectSort();
		System.out.print("R:  ");s.Disp();
	}
	*/




	public static void main(String[] args)
	{
		//int[] a={9,8,7,6,5,4,3,2,1,0};
		int a[]={3,5,1,2,4};
		SqListSortClass s=new SqListSortClass();
		s.CreateR1(a);
		System.out.print("R: ");s.Disp1();
		System.out.println("排序结果");
		s.HeapSort();
		System.out.print("R: ");s.Disp1();
	}

}
