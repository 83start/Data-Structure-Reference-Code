import java.util.*;
public class trans
{
	public static void main(String[] args)
	{
		ArrayList<String> myarrlist = new ArrayList<String>();  
		myarrlist.add("A");  
		myarrlist.add("B");  
		myarrlist.add("C");  
		myarrlist.add("D"); 
		System.out.println("ArrayList:  "+myarrlist);  
		System.out.println("ArrayList->LinkedList");
		LinkedList<String> mylinklist=new LinkedList<String>(myarrlist);  
		System.out.println("LinkedList: "+mylinklist); 
		
		System.out.println("清空LinkedList并添加1,2,3");  
		mylinklist.clear();
		mylinklist.add("1");
		mylinklist.add("2");
		mylinklist.add("3");
		System.out.println("LinkedList: "+mylinklist); 
		myarrlist=new ArrayList<String>(mylinklist);  
		System.out.println("LinkedList->ArrayList");
		System.out.println("ArrayList:  "+myarrlist);  		
	}  
}

 