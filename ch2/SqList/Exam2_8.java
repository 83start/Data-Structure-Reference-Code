import java.util.*;
public class Exam2_8
{
	public static ArrayList<Integer> Merge2(ArrayList<Integer> A,ArrayList<Integer> B) { //例2.8的算法
		ArrayList<Integer> C=new ArrayList<Integer>();
		int i=0,j=0;						//i用于遍历A,j用于遍历B
		while (i<A.size() && j<B.size()) {	//两个表均没有遍历完毕
			if (A.get(i)<B.get(j)) {
				C.add(A.get(i));		//将较小的A中元素添加到C中
				i++;
			}
			else {
				C.add(B.get(j));		//将较小的B中元素添加到C中
				j++;
			}
		}
		while (i<A.size()) {				//若A没有遍历完毕
			C.add(A.get(i));
			i++;
		}
		while (j<B.size()) {				//若B没有遍历完毕
			C.add(B.get(j));
			j++;
		}
		return C;
	}

   public static void main(String[] args)
   {
		Integer [] a={1,3,5,7};
		ArrayList<Integer> A=new ArrayList<Integer>(Arrays.asList(a));
		System.out.println("A: "+A);
		Integer [] b={1,2,5,7,9,10,20};
		ArrayList<Integer> B=new ArrayList<Integer>(Arrays.asList(b));
		System.out.println("B: "+B);
		System.out.println("二路归并");
		ArrayList<Integer> C;
		C=Merge2(A,B);
		System.out.println("C: "+C);
   }	   
} 