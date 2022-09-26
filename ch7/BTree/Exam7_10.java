import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Exam7_10
{
	public static BTreeClass Trans(String sb)
	{
		BTreeClass bt=new BTreeClass();
		bt.b=Trans1(sb,1);
		return bt;
	}
	private static BTNode<Character> Trans1(String sb,int i) //被Trans函数调用
	{
		if (i<sb.length())
		{
			if (sb.charAt(i)!='#')
			{	BTNode<Character> t=new BTNode<Character>(sb.charAt(i)); //建立根结点
				t.lchild=Trans1(sb,2*i);		//递归转换左子树
				t.rchild=Trans1(sb,2*i+1);		//递归转换右子树
				return t;
			}
			else return null;					//'#'结点返回空
		}
		else return null;						//无效结点返回空
	}
		
@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		String s="#ABCDE#F##GH##I######";
		BTreeClass bt;
		bt=Trans(s);
		System.out.println("bt: "+bt.toString());
	}
}
