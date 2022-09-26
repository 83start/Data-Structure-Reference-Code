import java.util.*;
class Student implements Comparable<Student>
{
    int id;								//学号
	String name;						//姓名
    public Student(int id,String name)	//构造方法
	{
        this.id=id;
		this.name=name;
    }
    public String toString()
	{
        return "["+id+","+name+"]";
    }
    public int compareTo(Student o)		//实现比较器
	{
        return (this.id-o.id);
    }
}
public class Exam9_15
{
    public static void main(String[] args)
	{
        TreeSet<Student> set=new TreeSet<Student>();
        Student s1=new Student(1,"李君");
        Student s2=new Student(3,"陈斌");
        Student s3=new Student(2,"王林");
        set.add(s1);
        set.add(s2);
        set.add(s3);
        for (Student s:set)
            System.out.print(" "+s);
		System.out.println();
    }

}