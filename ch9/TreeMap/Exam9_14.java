import java.util.*;
public class Exam9_14
{	
	static void Count(int[] a,TreeMap<Integer,Integer> map)	//求各整数出现的次数
	{
		for (int i=0;i<a.length;i++)
		{
			if (map.containsKey(a[i]))
				map.put(a[i],map.get(a[i])+1);
			else
				map.put(a[i],1);
		}		
	}
	static void disp(TreeMap<Integer,Integer> map)		//输出结果
	{
		Iterator it=map.keySet().iterator();  
		while (it.hasNext())
		{  
			int key=(int)it.next();  					//获取key
			int value=(int)map.get(key);  				//根据key获取value
			System.out.println("  整数"+key+"出现"+value+"次");
		}
	}

	
    public static void main(String[] args)
	{
		int a[]={5,1,6,3,2,6,3,1,2,4,1};
        TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		Count(a,map);
		System.out.println("求解结果");
		disp(map);
    }
}
