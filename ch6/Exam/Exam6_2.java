import java.util.*;
@SuppressWarnings("unchecked")
public class Exam6_2
{
	public static void main(String[] args)
	{
		int[] a={6,2,1,9,5,7,4,3,8};
        System.out.print("增序排序: ");
        Arrays.sort(a);
        for (int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");		
        System.out.print("\n减序排序: ");				//需要使用包装类型
        Integer[] b={6,2,1,9,5,7,4,3,8};
        Arrays.sort(b, new Comparator<Integer>()
        {
            public int compare(Integer o1, Integer o2) //返回值>0时进行交换
            {
                return o2-o1;
            }
        });
        for (Integer x:b)
            System.out.print(x+" ");
        System.out.print("\n部分排序: ");
        int[] c={6,2,1,9,5,7,4,3,8};  				//对数组的[2,6)区间进行排序
        Arrays.sort(c,2,6);
        for (int i=0;i<c.length;i++)
            System.out.print(c[i]+" ");
	}
} 