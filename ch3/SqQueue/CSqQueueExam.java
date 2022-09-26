@SuppressWarnings("unchecked")
public class CSqQueueExam
{
   public static void main(String[] args)
   {
		Integer [] a={1,2,3,4,5};
		CSqQueueClass<Integer> qu1=new CSqQueueClass<Integer>();
		for (int i=0;i<a.length;i++)
		{
			qu1.push(a[i]);
			System.out.println("进队元素: "+a[i]);
			System.out.println("队头元素: "+qu1.peek());			
		}
		System.out.println("qu1为空: "+qu1.empty());
		System.out.println("qu1: "+qu1.toString());	
		System.out.println("出队操作");	
		Integer e;
		while (!qu1.empty())
		{
			System.out.println("队头元素: "+qu1.peek());			
			e=qu1.pop();
			System.out.println("出队元素: "+e);
		}
		System.out.println("qu1: "+qu1.toString());	
		System.out.println("qu1为空: "+qu1.empty());

   }	   
}

 