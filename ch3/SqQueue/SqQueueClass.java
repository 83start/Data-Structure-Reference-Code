@SuppressWarnings("unchecked")
class SqQueueClass<E>								//非循环队列泛型类
{
	final int MaxSize=100;							//假设容量为100
	private E [] data;								//存放队列中的元素
	private int front,rear;							//队头队尾指针
	public SqQueueClass()							//构造方法
	{
		data = (E[])new Object[MaxSize];
		front=-1;
		rear=-1;
	}
	//队列的基本运算算法
	public boolean empty()							//判断队列是否为空
	{
		return front==rear;
	}
	public void push(E e)							//元素no进队
	{
		if (rear==MaxSize-1)						//队满
			throw new IllegalArgumentException("队满");
		rear++;
		data[rear]=e;
	}
	public E pop()									//出队元素
	{
		if (empty())								//队空
			throw new IllegalArgumentException("队空");
		front++;
		return (E)data[front];
	}	
	public E peek()									//取队头元素
	{
		if (empty())								//队空
			throw new IllegalArgumentException("队空");
		return (E)data[front+1];
	}
	public String toString()						//非基本运算，调试用
	{
		String ans="";
		if (!empty())
		{
			int p=front;
			while (true)
			{
				p++;
				ans+=data[p]+" ";
				if (p==rear) break;
			}
		}
		return ans;			
	}
}
