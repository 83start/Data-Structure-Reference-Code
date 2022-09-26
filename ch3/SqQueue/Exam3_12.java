import java.util.*;
@SuppressWarnings("unchecked")

class CSqQueueClass1<E>								//循环队列泛型类
{
	final int MaxSize=100;							//假设容量为100
	private E [] data;								//存放队列中的元素
	private int front;								//队头指针
	private int count;								//元素个数	
	public CSqQueueClass1()							//构造方法
	{
		data = (E[])new Object[MaxSize];
		front=0;
		count=0;
	}
	//队列的基本运算算法
	public boolean empty()							//判断队列是否为空
	{
		return count==0;
	}
	public void push(E e)							//元素e进队
	{
		int rear1;
		rear1=(front+count)%MaxSize;
		if (count==MaxSize)//队满
			throw new IllegalArgumentException("队满");
		rear1=(rear1+1) % MaxSize;
		data[rear1]=e;
		count++;									//元素个数增1
	}
	public E pop()									//出队元素
	{
		if (empty())								//队空
			throw new IllegalArgumentException("队空");
		count--;									//元素个数减1
		front=(front+1)%MaxSize;
		return (E)data[front];
	}	
	public E peek()									//取队头元素
	{
		if (empty())								//队空
			throw new IllegalArgumentException("队空");
		return (E)data[(front+1)%MaxSize];
	}
}

public class Exam3_12
{
	
   public static void main(String[] args)
   {
		//测试1
		System.out.println("*******测试1****************");
		Integer [] a={1,2,3,4,5};
		CSqQueueClass1<Integer> qu1=new CSqQueueClass1<Integer>();
		for (int i=0;i<a.length;i++)
		{
			qu1.push(a[i]);
			System.out.println("进队元素: "+a[i]);
		}
		System.out.println("qu1为空: "+qu1.empty());
		System.out.println("队头元素: "+qu1.peek());	
		Integer e;
		while (!qu1.empty())
		{
			e=qu1.pop();
			System.out.println("出队元素: "+e);
		}
		System.out.println("qu1为空: "+qu1.empty());

		//测试2
		System.out.println("*******测试2****************");
		String [] b={"a","b","c","d"};
		CSqQueueClass1<String> qu2=new CSqQueueClass1<String>();
		for (int i=0;i<b.length;i++)
		{
			qu2.push(b[i]);
			System.out.println("进队元素: "+b[i]);
		}
		System.out.println("qu2为空: "+qu2.empty());
		String x;
		while (!qu2.empty())
		{
			x=qu2.pop();
			System.out.println("出队元素: "+x);
		}
		System.out.println("qu2为空: "+qu2.empty());
	}
}
