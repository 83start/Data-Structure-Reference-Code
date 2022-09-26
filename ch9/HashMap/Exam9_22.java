import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
@SuppressWarnings("unchecked")
public class Exam9_22 
{	
	static HashMap<String,TreeSet<Integer>> map=new HashMap();
	static void insertmap(String s,int d)				//将成绩插入到map
	{
		map.computeIfAbsent(s,z->new TreeSet()).add(d);
	}
	static void dispmap()								//输出成绩map
	{
		Iterator it=map.keySet().iterator();  
		while (it.hasNext())
		{	String key=(String)it.next();  				//获取key(姓名)
			System.out.print(key+":");
			TreeSet value=(TreeSet)map.get(key);  	//根据key获取value
			for (Object e:value)
				System.out.print(" "+e);
			System.out.println();		
		}

	}
    public static void main(String[] args) throws FileNotFoundException
	{
        System.setIn(new FileInputStream("abc.in"));	//将标准输入流重定向至abc.in
        Scanner fin=new Scanner(System.in);
        System.setOut(new PrintStream("abc.out"));		//将标准输出流重定向至abc.out
		String s;
		int d;
		while (fin.hasNext())						//读文件
		{
			s=fin.next();
			d=fin.nextInt();
			System.out.println(s+","+d);
			insertmap(s,d);							//向map中插入
		}
		dispmap();									//向abc.out文件输出结果
    }
}
