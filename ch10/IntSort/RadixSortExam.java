public class RadixSortExam
{
	public static void main(String[] args)
	{
		int a[]={75,23,98,44,57,12,29,64,38,82};
		RadixSortClass s=new RadixSortClass();
		s.CreateList(a);
		System.out.print("R: ");s.Disp();
		System.out.println("排序结果");
		s.RadixSort(2,10);
		System.out.print("R: ");s.Disp();
	}
}
