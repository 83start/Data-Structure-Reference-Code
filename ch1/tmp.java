import java.util.*;
public class tmp
{	public static void swap(String x,String y)  	//交换x和y
	{
		System.out.println("x="+x.hashCode()+",y="+y.hashCode());
		String tmp=x;
		x=y;
		y=tmp;
		System.out.printf("x=%s,y=%s\n",x,y);
		System.out.println("x="+x.hashCode()+",y="+y.hashCode());

	}
	public static void main(String[] args)
	{	String a="Hello";
		String b="World";
		System.out.println("a="+a.hashCode()+",b="+b.hashCode());
		System.out.printf("a=%s,b=%s\n",a,b);	//输出a=Hello,b=World
		swap(a,b);
		System.out.printf("a=%s,b=%s\n",a,b);	//输出a=Hello,b=World
		System.out.println("a="+a.hashCode()+",b="+b.hashCode());
	}
}
