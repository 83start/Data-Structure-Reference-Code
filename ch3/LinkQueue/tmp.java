import java.lang.*;
import java.util.*;
public class tmp
{
	public static void main(String[] args)
	{
		Queue<Integer> qu=new LinkedList<Integer>();
		qu.offer(1);
		qu.offer(2);
		qu.offer(3);
		while (!qu.isEmpty())
			System.out.print(qu.poll()+" ");	//输出：1 2 3
		System.out.println();		
	}	   
}

 