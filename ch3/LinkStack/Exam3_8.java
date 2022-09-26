public class Exam3_8
{
	final static int MaxSize=100;
	public static LinkStackClass<Integer> Reverse(LinkStackClass<Integer> st) 	//例3.8的算法
	{
		int [] a=new int[MaxSize];
		int i=0;
		while (!st.empty())					//将出栈的元素放到数组a中
		{
			a[i]=st.pop();
			i++;
		}
		for (int j=0;j<i;j++)				//将数组a的所有元素进出栈
			st.push(a[j]);
		return st;
	}
	public static void main(String[] args)
	{
		Integer [] a={1,2,3,4};
		LinkStackClass<Integer> st=new LinkStackClass<Integer>();
		for (int i=0;i<a.length;i++)
		{
			System.out.println("元素"+a[i]+"进栈");
			st.push(a[i]);
		}
		System.out.println("st: "+st.toString());
		System.out.println("逆置");
		st=Reverse(st);
		System.out.println("st: "+st.toString());		
	}	   
}

 