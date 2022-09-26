import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Exam10_8
{
	
	static void Sort1(int[] a)				//将a递增排序
	{
		PriorityQueue<Integer> qu=new PriorityQueue<>();
		for (int i=0;i<a.length;i++)
			qu.offer(a[i]);
		for (int i=0;i<a.length;i++)
			a[i]=qu.poll();
	}
	static void Sort2(int[] a)				//将a递减排序
	{
		PriorityQueue<Integer> qu 
		= new PriorityQueue<Integer>(new Comparator<Integer>() 
		{	public int compare(Integer o1,Integer o2)
			{
				return o2-o1;
			}
		});
		for (int i=0;i<a.length;i++)
			qu.offer(a[i]);
		for (int i=0;i<a.length;i++)
			a[i]=qu.poll();
	}
	static void Disp(int[] a)
	{
		for (int i=0;i<a.length;i++)
			System.out.print(" "+a[i]);
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		int[] a={5,2,1,4,3};
		System.out.print("初始排列序列:");Disp(a);
		System.out.print("递增排序结果:");
		Sort1(a); Disp(a);

		int[] b={5,2,1,4,3};
		System.out.print("初始排列序列:");Disp(b);
		System.out.print("递减排序结果:");
		Sort2(b); Disp(b);
	}
}
