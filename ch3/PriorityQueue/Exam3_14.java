import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Stud								//学生类
{ 
    private int id;						//学号
    private String name;				//姓名
    public Stud(int id1,String na1)		//构造方法
	{
		id=id1;
        name=na1;
    }
     public int getid()					//id属性
	{
        return id;
    }
 
    public String getname()				//name属性
	{
        return name;
    }
}
public class Exam3_14
{
	
    
    public static Comparator<Stud> idComparator  	//定义idComparator
	= new Comparator<Stud>()
	 {
        public int compare(Stud o1,Stud o2)			//用于创建id大根堆
		{
            return (int)(o1.getid()-o2.getid());
        }
    };
    public static Comparator<Stud> nameComparator  //定义nameComparator
	= new Comparator<Stud>() 
	{
        public int compare(Stud o1,Stud o2)			//用于创建name大根堆
		{
            return (int)(o2.getname().compareTo(o1.getname()));
        }
    };
	public static void main(String[] args)
	{
		System.out.println("(1)创建intminqu队");
        PriorityQueue<Integer> intminqu = new PriorityQueue<>(7);
		System.out.println("   向intminqu队中依次插入3,1,2,5,4");
		intminqu.offer(3);
		intminqu.offer(1);
		intminqu.offer(2);
		intminqu.offer(5);
		intminqu.offer(4);
		System.out.print("   intminqu出队顺序: ");
		while (!intminqu.isEmpty())
			System.out.print(intminqu.poll()+" ");
		System.out.println();
			
		System.out.println("(2)创建intmaxqu队");
		PriorityQueue<Integer> intmaxqu = new PriorityQueue<Integer>(10, new Comparator<Integer>() 
		{  
			@Override  
			public int compare(Integer o1,Integer o2)
			{  
				return o2-o1;
			}
		});
		System.out.println("   向intmaxqu队中依次插入3,1,2,5,4");
		intmaxqu.offer(3);
		intmaxqu.offer(1);
		intmaxqu.offer(2);
		intmaxqu.offer(5);
		intmaxqu.offer(4);
		System.out.print("   intmaxqu出队顺序: ");
		while (!intmaxqu.isEmpty())
			System.out.print(intmaxqu.poll()+" ");
		System.out.println();
		
			
		System.out.println("(3)创建stidminqu队");
		PriorityQueue<Stud> stidminqu=new PriorityQueue<Stud>(10, idComparator);
		System.out.println("  向stidminqu队中依次插入4个对象");
		stidminqu.offer(new Stud(3,"Mary"));
		stidminqu.offer(new Stud(1,"David"));
		stidminqu.offer(new Stud(4,"Johm"));
		stidminqu.offer(new Stud(2,"Smith"));
		System.out.print("   stidminqu出队顺序: ");
		Stud e;
		while (!stidminqu.isEmpty())
		{
			e=stidminqu.poll();
			System.out.print("["+e.getid()+","+e.getname()+"]  ");
		}
		System.out.println();

		System.out.println("(4)创建stnamaxqu队");
		PriorityQueue<Stud> stnamaxqu=new PriorityQueue<Stud>(10, nameComparator);
		System.out.println("   向stnamaxqu队中依次插入4个对象");
		stnamaxqu.offer(new Stud(3,"Mary"));
		stnamaxqu.offer(new Stud(1,"David"));
		stnamaxqu.offer(new Stud(4,"Johm"));
		stnamaxqu.offer(new Stud(2,"Smith"));
		System.out.print("   stnamaxqu出队顺序: ");
		while (!stnamaxqu.isEmpty())
		{
			e=stnamaxqu.poll();
			System.out.print("["+e.getid()+","+e.getname()+"]  ");
		}
		System.out.println();
    }
}