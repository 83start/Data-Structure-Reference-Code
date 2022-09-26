@SuppressWarnings("unchecked")
public class SqQueueExam
{
   public static void main(String[] args)
   {
		//测试1
		System.out.println("*******测试1****************");
		Integer [] a={1,2,3,4,5};
		SqQueueClass<Integer> qu1=new SqQueueClass<Integer>();
		for (int i=0;i<a.length;i++)
		{
			qu1.push(a[i]);
			System.out.println("进队元素: "+a[i]);
		}
		System.out.println("qu1为空: "+qu1.empty());
		System.out.println("qu1: "+qu1.toString());	
		System.out.println("队头元素: "+qu1.peek());	
		Integer e;
		while (!qu1.empty())
		{
			e=qu1.pop();
			System.out.println("出队元素: "+e);
		}
		System.out.println("qu1: "+qu1.toString());	
		System.out.println("qu1为空: "+qu1.empty());

		//测试2
		System.out.println("*******测试2****************");
		String [] b={"a","b","c","d"};
		SqQueueClass<String> qu2=new SqQueueClass<String>();
		for (int i=0;i<b.length;i++)
		{
			qu2.push(b[i]);
			System.out.println("进队元素: "+b[i]);
		}
		System.out.println("qu2为空: "+qu2.empty());
		System.out.println("qu2: "+qu2.toString());	
		String x;
		while (!qu2.empty())
		{
			x=qu2.pop();
			System.out.println("出队元素: "+x);
		}
		System.out.println("qu2: "+qu2.toString());	
		System.out.println("qu2为空: "+qu2.empty());
   }	   
}

 