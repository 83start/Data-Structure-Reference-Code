import java.util.*;
@SuppressWarnings("unchecked")
class LinkNode<E>							//链栈结点泛型类
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
class LinkStackClass1<E>					//链栈泛型类
{
	LinkNode<E> head;							//存放首结点
	public LinkStackClass1()					//构造方法
	{
		head=null;
	}
	//栈的基本运算算法	
	public boolean empty()						//判断栈是否为空
	{
		return head==null;
	}
	public void push(E e)						//元素e进栈
	{
		LinkNode<E> s=new LinkNode<E>(e);		//新建结点s
		s.next=head;							//将结点s插入到表头
		head=s;
	}
	public E pop()								//出栈操作
	{
		if (empty())
			throw new IllegalArgumentException("栈空");
		E e=(E)head.data;						//取首结点值
		head=head.next;							//删除原首结点
		return e;
	}
	public E peek()								//取栈顶元素操作
	{
		if (empty())
			throw new IllegalArgumentException("栈空");
		E e=(E)head.data;						//取首结点值
		return e;
	}
	public String toString()					//将栈转换为字符串,不是基本运算，仅仅调试用
	{
		String ans="";
		LinkNode<E> p=head;
		while (p!=null)
		{
			ans+=p.data.toString()+" ";
			p=p.next;
		}
		return ans;
	}

}
public class Exam3_9
{
   public static void main(String[] args)
   {
		//测试1
		System.out.println("*******测试1****************");
		Integer [] a={1,2,3,4,5};
		LinkStackClass1<Integer> st1=new LinkStackClass1<Integer>();
		for (int i=0;i<a.length;i++)
		{
			st1.push(a[i]);
			System.out.println("进栈元素: "+a[i]);
		}
		System.out.println("st1为空: "+st1.empty());
		System.out.println("st1: "+st1.toString());	
		Integer e;
		while (!st1.empty())
		{
			e=st1.pop();
			System.out.println("出栈元素: "+e);
		}
		System.out.println("st1为空: "+st1.empty());

		//测试2
		System.out.println("*******测试2****************");
		String [] b={"a","b","c","d"};
		LinkStackClass1<String> st2=new LinkStackClass1<String>();
		for (int i=0;i<b.length;i++)
		{
			st2.push(b[i]);
			System.out.println("进栈元素: "+b[i]);
		}
		System.out.println("st2为空: "+st2.empty());
		System.out.println("st2: "+st2.toString());	
		String x;
		while (!st2.empty())
		{
			x=st2.pop();
			System.out.println("出栈元素: "+x);
		}
		System.out.println("st2为空: "+st2.empty());
   }	   
}
