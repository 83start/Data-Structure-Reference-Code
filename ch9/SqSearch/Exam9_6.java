import java.lang.*;
public class Exam9_5
{
	static int Closest(SqListSearchClass s,int k)
	{
		if (k<=s.R[0].key)
			return s.R[0].key;
		if (k>=s.R[s.n-1].key)
			return s.R[s.n-1].key;
		int j=s.GOEk(k);		//查找第一个大于或者等于k的序号
		int i=j-1;				//前一个元素的序号
		if (Math.abs(s.R[i].key-k)<Math.abs(s.R[j].key-k))
			return s.R[i].key;
		else
			return s.R[j].key;
	}

	public static void main(String[] args)
	{
		int[] a={1,3,8,8,12};
		SqListSearchClass s=new SqListSearchClass();
		s.CreateR(a);
		System.out.print("R: ");s.Disp();

		int k=13;
		System.out.println("k="+k+",结果为 "+Closest(s,k));
	}
}
