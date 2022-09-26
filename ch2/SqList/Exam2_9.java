import java.util.*;
class Stud implements Comparable<Stud> {
	private String name;						//姓名
    private Integer age;						//年龄
	public Stud(String na,int ag){				//构造方法
		name=na;
		age=ag;
	}
	public String toString()
	{
		String ans;
		ans="["+name+","+age+"]";
		return ans;
	}
	public String getname() {
		return name;
	}
	@Override
    public int compareTo(Stud o) {   						//用于按age递增排序
		return this.age.compareTo(o.age);
    }
}
public class Exam2_9
{
   public static void main(String[] args)
   {
		List<Stud> L = new ArrayList<Stud>();
        L.add(new Stud("John",18));
        L.add(new Stud("Mary",17));
        L.add(new Stud("Smith",20));
        L.add(new Stud("Tom",18));
		System.out.println("初始序列:\n  "+L);
		Collections.sort(L);									//排序方法1
		System.out.println("按年龄递增排序:\n  "+L);
		Collections.sort(L, new Comparator<Stud>() {			//排序方法2
			@Override
			public int compare(Stud o1,Stud o2) {				//用于按姓名递增排序
				return o1.getname().compareTo(o2.getname());
			}
		});
		System.out.println("按姓名递增排序:\n  "+L);
		L.sort(Comparator.comparing(Stud::getname).reversed());	//排序方法3
		System.out.println("按姓名递减排序:\n  "+L);
   }	   
} 