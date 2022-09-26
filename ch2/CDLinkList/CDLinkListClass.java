import java.util.*;
@SuppressWarnings("unchecked")
class DLinkNode<E>								//循环双链表结点泛型类
{
	E data;
	DLinkNode<E> prior;							//前驱结点指针
	DLinkNode<E> next;							//后继结点指针
	public DLinkNode()							//构造方法
	{	
		prior=null;
		next=null;
	}
	public DLinkNode(E d)						//重载构造方法
	{
		data=d;
		prior=null;
		next=null;
	}
}
	
public class CDLinkListClass<E>					//循环双链表泛型类
{
	DLinkNode<E> dhead;							//存放头结点
	public CDLinkListClass()					//构造方法
	{
		dhead=new DLinkNode<E>();				//创建头结点
		dhead.prior=dhead;						//构成空的循环双链表
		dhead.next=dhead;
	}
	private DLinkNode<E> geti(int i)			//返回序号为i的结点
	{
		DLinkNode<E> p=dhead;
		int j=-1;
		while (j<i)
		{
			j++;
			p=p.next;
		}
		return p;
	}
	//线性表的基本运算算法	
	public void CreateListF(E[] a)				//头插法：由数组a整体建立循环双链表
	{
		DLinkNode<E> s;
		for (int i=0;i<a.length;i++)			//循环建立数据结点s
		{
			s=new DLinkNode<E>(a[i]);			//新建存放a[i]元素的结点s
			s.next=dhead.next;					//修改s结点的next字段
			dhead.next.prior=s;
			dhead.next=s;						//修改头结点的next字段
			s.prior=dhead;						//修改s结点的prior字段
		}
	}

	public void CreateListR(E[] a)				//尾插法：由数组a整体建立循环双链表
	{
		DLinkNode<E> s,t;
		t=dhead;								//t始终指向尾结点,开始时指向头结点
		for (int i=0;i<a.length;i++)			//循环建立数据结点s
		{	s=new DLinkNode<E>(a[i]);			//新建存放a[i]元素的结点s
			t.next=s;							//将s结点插入t结点之后
			s.prior=t; t=s;
		}
		t.next=dhead;							//将尾结点的next字段置为head
		dhead.prior=t;							//将头结点的prior字段置为t
	}

	public void Add(E e)						//在线性表的末尾添加一个元素e
	{
		DLinkNode<E> s=new DLinkNode<E>(e);		//新建结点s
		DLinkNode<E> p=dhead;
		while (p.next!=dhead)					//查找尾结点p
			p=p.next;
		p.next=s;								//在尾结点p之后插入结点s
		s.prior=p;
		s.next=dhead;
		dhead.prior=s;		
	}

	public int size()							//求线性表长度
	{
		DLinkNode<E> p=dhead;
		int cnt=0;
		while (p.next!=dhead)					//找到尾结点为止
		{
			cnt++;
			p=p.next;
		}
		return cnt;
	}
	public void Setsize(int nlen)				//设置线性表的长度
	{
		int len=size();
		if (nlen<0 || nlen>len)
			throw new IllegalArgumentException("设置长度:n不在有效范围内");
		if (nlen==len) return;
		DLinkNode<E> p=geti(nlen-1);			//找到序号为nlen-1的结点p
		p.next=dhead;							//将结点p置为尾结点
		dhead.prior=p;
	}

	public E GetElem(int i)						//返回线性表中序号为i的元素
	{
		int len=size();
		if (i<0 || i>len-1)
			throw new IllegalArgumentException("查找:位置i不在有效范围内");
		DLinkNode<E> p=geti(i);					//找到序号为i的结点p
		return (E)p.data;
	}

	public void SetElem(int i,E e)				//设置序号i的元素为e
	{
		if (i<0 || i>size()-1)
			throw new IllegalArgumentException("设置:位置i不在有效范围内");
		DLinkNode<E> p=geti(i);					//找到序号为i的结点p
		p.data=e;
	}

	public int GetNo(E e)						//查找第一个为e的元素的序号
	{
		int j=0;
		DLinkNode<E> p=dhead.next;	
		while (p!=dhead && !p.data.equals(e))
		{
			j++;								//查找元素e
			p=p.next;
		}
		if (p==dhead)							//未找到时返回-1
			return -1;
		else
			return j;							//找到后返回其序号
	}

	public void Insert(int i, E e)				//在线性表中序号i位置插入元素e
	{
		if (i<0 || i>size())					//参数错误抛出异常
			throw new IllegalArgumentException("插入:位置i不在有效范围内");
		DLinkNode<E> s=new DLinkNode<E>(e);		//建立新结点s	
		DLinkNode<E> p=dhead=geti(i-1);			//找到序号为i-1的结点p,其后插入s结点
		
		s.next=p.next;							//修改s结点的next字段
		p.next.prior=s;
		p.next=s;								//修改p结点的next字段
		s.prior=p;								//修改s结点的prior字段
	}

	public void Delete(int i) 					//在线性表中删除序号i位置的元素
	{
		if (i<0 || i>size()-1)					//参数错误抛出异常
			throw new IllegalArgumentException("删除:位置i不在有效范围内");
		DLinkNode<E> p=geti(i);					//找到序号为i的结点p,删除该结点
		p.prior.next=p.next;					//修改p结点的前驱结点的next字段
		p.next.prior=p.prior;
	}
	public String toString()					//将线性表转换为字符串
	{
		String ans="";
		DLinkNode<E> p=dhead.next;
		while (p!=dhead)
		{
			ans+=p.data+" ";
			p=p.next;
		}
		return ans;
	}
}
