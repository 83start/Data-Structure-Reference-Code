import java.util.*;
class mycompare implements Comparator
{
    public int compare(Object o1,Object o2)				//比较器，递减顺序
    {
        int i1=(int)o1;
        int i2=(int)o2;
        return i2-i1;
    }
}
//@SuppressWarnings("unchecked")

public class Exam9_13
{	
	static void disp1(TreeMap<Integer,String> map)		//使用entrySet方法
	{
		Iterator it=map.entrySet().iterator();  
		while (it.hasNext())
		{  
			Map.Entry entry=(Map.Entry)it.next();
			int key=(int)entry.getKey();  				//获取key
			String value=(String)entry.getValue();  	//获取value
			System.out.print("  ["+key+","+value+"]");
		}
		System.out.println();
	}
	
	static void disp2(TreeMap<Integer,String> map)		//使用keySet方法
	{
		Iterator it=map.keySet().iterator();  
		while (it.hasNext())
		{  
			int key=(int)it.next();  					//获取key
			String value=(String)map.get(key);  		//根据key获取value
			System.out.print("  ["+key+","+value+"]");
		}
		System.out.println();
	}
    public static void main(String[] args)
	{
        TreeMap<Integer,String> map=new TreeMap<Integer,String>(new mycompare());
        map.put(1,"李君");
        map.put(3,"陈斌");
        map.put(2,"王林");
		System.out.println("使用entrySet方法遍历"); disp1(map);
		System.out.println("使用keySet方法遍历"); disp2(map);
    }
}
