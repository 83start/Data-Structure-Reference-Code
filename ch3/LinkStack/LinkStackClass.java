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
public class LinkStackClass<E>					//链栈泛型类
{	LinkNode<E> head;						//存放头结点
	public LinkStackClass()					//构造方法
	{	head=new LinkNode<E>();				//创建头结点
		head.next=null;						//设置为空栈
	}
	//栈的基本运算算法
	public boolean empty()						//判断栈是否为空
	{
		return head.next==null;
	}
	public void push(E e)							//元素e进栈
	{	LinkNode<E> s=new LinkNode<E>(e);			//新建结点s
		s.next=head.next;						//将结点s插入到表头
		head.next=s;
	}
	public E pop()								//出栈操作
	{	if (empty())
			throw new IllegalArgumentException("栈空");
		E e=(E)head.next.data;						//取首结点值
		head.next=head.next.next;					//删除原首结点
		return e;
	}
	public E peek()								//取栈顶元素操作
	{	if (empty())
			throw new IllegalArgumentException("栈空");
		E e=(E)head.next.data;						//取首结点值
		return e;
	}
	public String toString()
	{
		String ans="";
		if (!empty())
		{
			LinkNode<E> p=head.next;
			while (p!=null)
			{
				ans+=p.data+" ";
				p=p.next;
			}
		}
		return ans;
	}
}
