import java.util.*;
//@SuppressWarnings("unchecked")
public class TupClassExam
{
	public static void main(String[] args)
	{
		int [][]A={ {0,0,1,0,0,0,0},
					{0,2,0,0,0,0,0},
					{3,0,0,0,0,0,0},
					{0,0,0,5,0,0,0},
					{0,0,0,0,6,0,0},
					{0,0,0,0,0,7,4}};
		int m=6,n=7; 
		TupClass smat=new TupClass();
		smat.CreateTup(A,m,n);
		System.out.println("三元组表示");
		smat.DispTup();
	}
} 