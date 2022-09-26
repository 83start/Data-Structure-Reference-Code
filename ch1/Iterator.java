interface Area
{
	final double PI=3.142;
	public void getarea();
}

class square implements Area			//正方形类
{
	public int x;						//长度
	public void getarea()				//求正方形面积
	{
		double area=x*x;
		System.out.println("正方形面积: "+area);
	}
}
class rectangle implements Area			//长方形类
{
	public int x;						//长度
	public int y;						//宽度
	public void getarea()				//求长方形面积
	{
		double area=x*y;
		System.out.println("长方形面积: "+area);
	}
}
class circle implements Area			//圆类
{
	public int r;						//半径
	public void getarea()				//求圆面积
	{
		double area=PI*r*r;
		System.out.println("圆面积: "+area);
	}
}
class others implements Area			//默认面积
{
	public void getarea()				//求长方形面积
	{
		double area=1;
		System.out.println("默认面积: "+area);
	}
}	
public class Interface
{	public static void main(String[] args)
	{	
		square s=new square();
		s.x=2;
		s.getarea();					//输出:4.0
		rectangle r=new rectangle();
		r.x=2;
		r.y=5;
		r.getarea();					//输出:10.0
		circle c=new circle();
		c.r=3;
		c.getarea();					//输出:28.278
		Area o=new others();
		o.getarea();					//输出:1.0
	}
}
