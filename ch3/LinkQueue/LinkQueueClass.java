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
public class LinkQueueClass<E>					//链队泛型类
{
	LinkNode<E> front;							//首结点指针
	LinkNode<E> rear;							//尾结点指针
	public LinkQueueClass()						//构造方法
	{
		front=null;
		rear=null;
	}
	//队列的基本运算算法	
	public boolean empty()						//判断队是否为空
	{
		return front==null;
	}
	public void push(E e)						//元素e进队
	{
		LinkNode<E> s=new LinkNode<E>(e);		//新建结点s
		if (empty())							//原链队为空
			front=rear=s;
		else									//原链队不空
		{
			rear.next=s;						//将s结点链接到rear结点后面
			rear=s;
		}
	}
	public E pop()								//出队操作
	{
		E e;
		if (empty())							//原链队不空
			throw new IllegalArgumentException("队空");
		if (front==rear)						//原链队只有一个结点
		{
			e=(E)front.data;					//取首结点值
			front=rear=null;					//置为空
		}
		else									//原链队有多个结点
		{
			e=(E)front.data;					//取首结点值
			front=front.next;					//front指向下一个结点
		}	
		return e;
	}
	public E peek()								//取队顶元素操作
	{
		if (empty())
			throw new IllegalArgumentException("队空");
		E e=(E)front.data;						//取首结点值
		return e;
	}
	public String toString()					//将队转换为字符串,不是基本运算，仅仅调试用
	{
		String ans="";
		if (!empty())
		{
			LinkNode<E> p=front;
			while (p!=null)
			{
				ans+=p.data.toString()+" ";
				p=p.next;
			}
		}
		return ans;
	}
}