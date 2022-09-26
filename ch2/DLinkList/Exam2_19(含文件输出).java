import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

@SuppressWarnings("unchecked")
class DLinkNode1<E>								//双链表结点泛型类
{
	E data;										//结点中
	int freq;									//结点访问频度		
	DLinkNode1<E> prior;						//前驱结点指针
	DLinkNode1<E> next;							//后继结点指针
	public DLinkNode1()							//构造方法
	{	
		freq=0;
		prior=null;
		next=null;
	}
	public DLinkNode1(E d)						//重载构造方法
	{
		freq=0;
		data=d;
		prior=null;
		next=null;
	}
}
class DLinkListClass1<E>						//双链表泛型类
{
	DLinkNode1<E> dhead;						//存放头结点
	public DLinkListClass1()					//构造方法
	{
		dhead=new DLinkNode1<E>();				//创建头结点
		dhead.prior=null;
		dhead.next=null;
	}
	//线性表的基本运算算法	
	public void CreateListR(E[] a)				//尾插法：由数组a整体建立双链表
	{
		DLinkNode1<E> s,t;
		t=dhead;								//t始终指向尾结点,开始时指向头结点
		for (int i=0;i<a.length;i++)			//循环建立数据结点s
		{	s=new DLinkNode1<E>(a[i]);			//新建存放a[i]元素的结点s
			t.next=s;							//将s结点插入t结点之后
			s.prior=t; t=s;
		}
		t.next=null;							//将尾结点的next字段置为null
	}

	public String toString()					//将线性表转换为字符串
	{
		String ans="";
		DLinkNode1<E> p=dhead.next;
		while (p!=null)
		{
			ans+=p.data+"["+p.freq+"] ";
			p=p.next;
		}
		return ans;
	}
}
public class Exam2_19
{
	public static boolean LocateElem(DLinkListClass1<Integer> L,Integer x)	//查找值为x的结点
	{
		Integer tmpd;
		int tmpf;
		DLinkNode1<Integer> p,pre;
		p=L.dhead.next;							//p指向开始结点
		while (p!=null && !p.data.equals(x))
			p=p.next;
		if (p==null)
			return false;						//未找到值为x的结点返回false
		p.freq++;								//找到值为x的结点p
		pre=p.prior;
		while (pre!=L.dhead && pre.freq<p.freq)	//若p结点的freq比前驱结点大,两者值交换
		{	tmpd=pre.data; pre.data=p.data; p.data=tmpd;
			tmpf=pre.freq; pre.freq=p.freq; p.freq=tmpf;
			p=pre; pre=p.prior;					//p、pre同步前移
		}
		return true;							//成功找到值为x的结点返回true
	}
	public static void Find(DLinkListClass1<Integer> L,Integer x)	//测试算法
	{
		System.out.println("查找值为"+x+"的结点");
		if (LocateElem(L,x))
			System.out.println("  查找成功,双链表L: "+L.toString());
		else
			System.out.println("  查找失败");
	}
	public static void main(String[] args) throws FileNotFoundException
	{
        System.setOut(new PrintStream("abc.out"));		//将标准输出流重定向至abc.out
		
		Integer [] a={1,2,3,4,5};
		DLinkListClass1<Integer> L=new DLinkListClass1<Integer>();
		L.CreateListR(a);
		System.out.println("L: "+L.toString());
		Find(L,5);
		Find(L,1);
		Find(L,4);
		Find(L,5);
		Find(L,2);
		Find(L,4);
		Find(L,5);
   }   
}

 