class Stud2
{
	public int no;					//存放学号
	public String name;				//存放姓名
	public int score; 				//存放分数
	public Stud2 next;
}
public class Store2
{
	public static int Findi(Stud2 head,int i)	//求序号为i的学生分数
	{
		int j=0;
		Stud2 p=head;				//p指向第一个结点
		while (j<i && p!=null)
		{	j++;
			p=p.next;
		}
		if (i<0 || p==null)			//i错误时抛出异常
			throw new IllegalArgumentException("参数i错误");
		else						//i正确时返回分数
			return p.score;
	}
	public static void main(String[] args)
	{
		Stud2 head;						//学生单链表开始结点
		Stud2 p1,p2,p3,p4,p5,p6,p7;
		p1=new Stud2();
		p1.no=2018001; p1.name="王华"; p1.score=90;
		p2=new Stud2();
		p2.no=2018010; p2.name="刘丽"; p2.score=62;
		p3=new Stud2();
		p3.no=2018006; p3.name="陈明"; p3.score=54;
		p4=new Stud2();
		p4.no=2018009; p4.name="张强"; p4.score=95;
		p5=new Stud2();
		p5.no=2018007; p5.name="许兵"; p5.score=76;
		p6=new Stud2();
		p6.no=2018012; p6.name="李萍"; p6.score=88;
		p7=new Stud2();
		p7.no=2018005; p7.name="李英"; p7.score=82;
		head=p1;						//建立结点之间的关系
		p1.next=p2;
		p2.next=p3;
		p3.next=p4;
		p4.next=p5;
		p5.next=p6;
		p6.next=p7;
		p7.next=null;
		Stud2 p=head;
		for (;p!=null;p=p.next)
			System.out.println(p.no+" "+p.name+" "+p.score);
	   int i=0;
	   System.out.printf("序号为%d的学生分数=%d\n",i,Findi(head,i));
	}	   
}

 