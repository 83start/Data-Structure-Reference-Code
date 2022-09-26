class Stud1
{
	int no;					//存放学号
	String name;			//存放姓名
	int score; 				//存放分数
	public Stud1(int no1,String name1,int score1)
	{
		no=no1; name=name1; score=score1;
	}
	public void disp()
	{
	   System.out.println(no+" "+name+" "+score);
	}
}
public class Store1
{
	public static int Findi(Stud1[] st,int i)//求序号为i的学生分数
	{
		if (i<0 || i>st.length)			//i错误时抛出异常
			throw new IllegalArgumentException("参数i错误");
		else							//i正确时返回分数
			return st[i].score;
	}
	public static void main(String[] args)
	{
	   Stud1[] st=new Stud1[7];
	   st[0]=new Stud1(2018001,"王华",90);
	   st[1]=new Stud1(2018010,"刘丽",62);
	   st[2]=new Stud1(2018006,"陈明",54);
	   st[3]=new Stud1(2018009,"张强",95);
	   st[4]=new Stud1(2018007,"许兵",76);
	   st[5]=new Stud1(2018012,"李萍",88);
	   st[6]=new Stud1(2018005,"李英",82);
	   for (int i=0;i<7;i++)
		   st[i].disp();
	   int i=2;
	   System.out.printf("序号为%d的学生分数=%d\n",i,Findi(st,i));
	}	   
}

 