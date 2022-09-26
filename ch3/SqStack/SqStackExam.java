@SuppressWarnings("unchecked")
public class SqStackExam
{
   public static void main(String[] args)
   {
		//测试1
		System.out.println("*******测试1****************");
		Integer [] a={1,2,3,4,5};
		SqStackClass<Integer> st1=new SqStackClass<Integer>();
		for (int i=0;i<a.length;i++)
		{
			st1.push(a[i]);
			System.out.println("进栈元素: "+a[i]);
		}
		System.out.println("st1为空: "+st1.empty());
		Integer e;
		while (!st1.empty())
		{
			e=st1.pop();
			System.out.println("出栈元素: "+e);
		}
		System.out.println("st1: "+st1.toString());	
		System.out.println("st1为空: "+st1.empty());

		//测试2
		System.out.println("*******测试2****************");
		String [] b={"a","b","c","d"};
		SqStackClass<String> st2=new SqStackClass<String>();
		for (int i=0;i<b.length;i++)
		{
			st2.push(b[i]);
			System.out.println("进栈元素: "+b[i]);
		}
		System.out.println("st2为空: "+st2.empty());
		String x;
		while (!st2.empty())
		{
			x=st2.pop();
			System.out.println("出栈元素: "+x);
		}
		System.out.println("st2: "+st2.toString());	
		System.out.println("st2为空: "+st2.empty());
   }	   
}

 