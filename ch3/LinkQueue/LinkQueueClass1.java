//package Link;
import java.util.*;
@SuppressWarnings("unchecked")
class LinkNode<E>								//链队结点泛型类
{
	E data;
	LinkNode<E> next;
	public LinkNode()							//构造方法
	{
		next=null;
	}
	public LinkNode(E d)						//重载构造方法
	{
		data=d;
		next=null;
	}
}
public class LinkQueueClass1<E>					//链队泛型类
{
	LinkNode<E> rear;							//尾结点指针
	public LinkQueueClass1()						//构造方法
	{
		rear=null;
	}
	//队列的基本运算算法	
	public boolean empty()						//判断队是否为空
	{
		return rear==null;
	}
	public void push(E e)						//元素e进队
	{
		LinkNode<E> s=new LinkNode(e);			//创建新结点s
		if (rear==null)							//原链队为空
		{	s.next=s;							//构成循环单链表
			rear=s;
		}
		else
		{	s.next=rear.next;					//将s结点插入到rear结点之后
			rear.next=s;
			rear=s;								//让rear指向s结点
		}
	}
	public E pop()								//出队操作
	{
		E e;
		if (empty())							//原链队不空
			throw new IllegalArgumentException("队空");
		if (rear.next==rear)					//原链队只有一个结点
		{
			e=(E)rear.data;						//取该结点值
			rear=null;							//置为空队
		}
		else									//原链队有多个结点
		{	
			e=(E)rear.next.data;				//取队头结点值
			rear.next=rear.next.next;			//删除队头结点
		}
		return e;
	}
	public E peek()								//取队顶元素操作
	{
		E e;
		if (empty())							//原链队不空
			throw new IllegalArgumentException("队空");
		if (rear.next==rear)					//原链队只有一个结点
			e=(E)rear.data;						//取该结点值
		else									//原链队有多个结点
			e=(E)rear.next.data;				//取队头结点值
		return e;
	}
	public String toString()					//将队转换为字符串,不是基本运算，仅仅调试用
	{
		String ans="";
		if (rear.next==rear)					//原链队只有一个结点
			ans+=rear.data;						//取该结点值
		else									//原链队有多个结点
		{	
			LinkNode<E> p=rear.next;
			while (true)
			{
				ans+=p.data+" ";
				p=p.next;
				if (p==rear)
					break;
			}
		}			
		return ans;
	}
}