class Person
{
	public String name;					//姓名
	public String gender;				//性别
	public void disp()					//输出信息
	{
		System.out.print(", 姓名:"+name+", 性别:"+gender);
	}
}
class Teacher extends Person			//教师类
{
	public String no;					//编号
	public String job;					//职称
	public void Teaching()				//授课方法
	{
		System.out.println("给学生授课");
	}		
	public void research()				//科研方法
	{
		System.out.println("做科研");
	}
	public void disp()					//输出教师信息
	{
		System.out.println("输出一个教师信息");
		System.out.print("  编号:"+no);
		super.disp();
		System.out.println(", 职称:"+job);
	}
}
class Student extends Person			//学生类
{
	public String id;					//学号
	public String profession;			//专业
	public double fraction;				//分数
	public void Leaning()				//上课方法
	{
		System.out.println("上课");
	}		
	public void disp()					//输出学生信息
	{
		System.out.println("输出一个学生信息");
		System.out.print("  学号:"+id);
		super.disp();
		System.out.println(", 专业:"+profession+", 分数:"+fraction);
	}
}
public class Extends
{	public static void main(String[] args)
	{	
		Teacher t=new Teacher();
		t.no="0020012";
		t.name="王华";
		t.gender="女";
		t.job="副教授";
		t.disp();
		Student s=new Student();
		s.id="2019002";
		s.name="陈晶";
		s.gender="男";
		s.profession="计算机";
		s.fraction=86.5;
		s.disp();
		
	}
}
