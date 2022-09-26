import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
class PolyNode						//单链表结点类型
{	public double coef;				//系数
	public int exp;					//指数
	public PolyNode next;			//指针字段
	PolyNode()						//构造方法
	{
		next=null;
	}
	PolyNode(double c,int e)		//重载构造方法
	{
		coef=c;
		exp=e;
		next=null;
	}
}
class PolyClass						//多项式单链表类
{	PolyNode head;					//存放多项式单链表头结点
	public PolyClass()				//构造方法
	{
		head=new PolyNode();		//建立头结点head	
	}
	public void CreatePoly(double[] a,int[] b,int n) //采用尾插法建立多项式单链表
	{
		PolyNode s,t;
		t=head;								//t始终指向尾结点,开始时指向头结点
		for (int i=0;i<n;i++)
		{	s=new PolyNode(a[i],b[i]);		//创建新结点s
			t.next=s;						//在t结点之后插入s结点
			t=s;
		}
		t.next=null;						//尾结点next域置为null
	}
	public void Sort()						//对多项式单链表按exp域递减排序
	{
		PolyNode p,pre,q;
		q=head.next;						//q指向开始结点
		if (q==null) return;				//原单链表空返回
		p=head.next.next;					//p指向q结点的后继结点
		if (p==null) return;				//原单链表只有一个数据结点返回
		q.next=null;						//构造只含一个数据结点的有序单链表
		while (p!=null)
		{	q=p.next;						//q用于临时保存p结点后继结点
			pre=head;						//从有序表开头比较,pre指向插入结点p的前驱结点
			while (pre.next!=null && pre.next.exp>p.exp)
				pre=pre.next;				//在有序表中找插入结点p的前驱结点pre
			p.next=pre.next;				//将pre结点之后插入p结点
			pre.next=p;
			p=q;							//扫描原单链表余下的结点
		}
	}
	public void DispPoly()					//输出多项式单链表
	{	boolean first=true;					//first为true表示是第一项
		PolyNode p=head.next;
		while (p!=null)
		{
			if (first) first=false;
			else if (p.coef>0) System.out.print("+");
			if (p.exp==0)					//指数为0时不输出'x'
				System.out.print(p.coef);
			else if (p.exp==1)				//指数为1时不输出指数
				System.out.print(p.coef+"x");
			else
				System.out.print(p.coef+"x^"+p.exp);
			p=p.next;
		}
		System.out.println();
	}
}
public class PolyTest2
{
	public static PolyClass Add(PolyClass L1,PolyClass L2)  //两个多项式相加运算
	{	PolyNode p,q,s,t;									//t始终指向L3的尾结点
		double c;
		PolyClass L3=new PolyClass();
		t=L3.head;
		p=L1.head.next;
		q=L2.head.next;
		while (p!=null && q!=null)
		{	if (p.exp>q.exp)								//L1的结点的指数较大
			{
				s=new PolyNode(p.coef,p.exp);
				t.next=s; t=s;
				p=p.next;
			}
			else if (p.exp<q.exp)							//L2的结点的指数较大
			{
				s=new PolyNode(q.coef,q.exp);
				t.next=s; t=s;
				q=q.next;
			}
			else											//两结点的指数相等
			{	c=p.coef+q.coef;							//求两指数相等结点的系数和c
				if (c!=0)									//系数和c不为0时复制
				{
					s=new PolyNode(c,p.exp);
					t.next=s; t=s;
				}
				p=p.next; q=q.next;
			}
		}
		t.next=null;										//尾结点next置为null
		if (p!=null) t.next=p;
		if (q!=null) t.next=q;
		return L3;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
        System.setIn(new FileInputStream("abc.in"));	//将标准输入流重定向至abc.in
        Scanner fin = new Scanner(System.in);
		PolyClass L1=new PolyClass();
		PolyClass L2=new PolyClass();
		PolyClass L3;
		double[] a=new double[100];
		int[] b=new int[100];
		int n;
		n = fin.nextInt();								//输入第1个多项式的n
		for (int i=0;i<n;i++) {							//输入第1个多项式系数数组a
			a[i]=fin.nextDouble();
		}
		for (int i=0;i<n;i++) {							//输入第1个多项式指数数组b
			b[i]=fin.nextInt();
		}
		L1.CreatePoly(a,b,n);							//创建第1个多项式单链表
		System.out.print("第1个多项式:  "); L1.DispPoly();
		L1.Sort(); 										//第1个多项式按指数递减排序
		System.out.print("排序后结果:   "); L1.DispPoly();
		n = fin.nextInt();								//输入第2个多项式的n
		for (int i=0;i<n;i++) {							//输入第2个多项式系数数组a
			a[i]=fin.nextDouble();
		}
		for (int i=0;i<n;i++) {							//输入第2个多项式指数数组b
			b[i]=fin.nextInt();
		}
		L2.CreatePoly(a,b,n);							//创建第2个多项式单链表
		System.out.print("第2个多项式:  "); L2.DispPoly();
		L2.Sort();										//第2个多项式按指数递减排序
		System.out.print("排序后结果:   "); L2.DispPoly();
		L3=Add(L1,L2);									//两多项式相加
		System.out.print("相加后多项式: "); L3.DispPoly();
	}
}
