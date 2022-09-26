import java.util.*;
public class Serialize
{
	static int i;
	public static String PreOrderSeq(BTreeClass bt) //由二叉链产生先序序列化序列str
	{
		return PreOrderSeq1(bt.b);
	}		
	private static String PreOrderSeq1(BTNode<Character> t)
	{
		String s="",s1,s2;
		if (t==null)
			return "#";
		s+=String.valueOf(t.data);		//构造只有根结点字符的串s
		s1=PreOrderSeq1(t.lchild);		//产生左子树的序列化序列s1
		s+=s1;
		s2=PreOrderSeq1(t.rchild);		//产生右子树的序列化序列s2
		s+=s2;
		return s;
	}

	public static BTreeClass CreateBT3(String s) 	//由序列化序列s创建二叉链
	{	BTreeClass bt=new BTreeClass();
		i=0;
		bt.b=CreateBT31(s);
		return bt;
	}
	private static BTNode<Character> CreateBT31(String s)
	{	BTNode<Character> t;
		char ch;
		if (i>=s.length())					//i超界返回空
			return null;
		ch=s.charAt(i);i++;					//从s中取出一个字符ch
		if (ch=='#')						//若ch为'#'，返回空
			return null;
		t=new BTNode<Character>(ch);		//创建根结点(结点值为ch)
		t.lchild=CreateBT31(s);				//递归构造左子树
		t.rchild=CreateBT31(s);				//递归构造右子树
		return t;							//返回根结点
	}


@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		String str=PreOrderSeq(bt);
		System.out.println("序列化序列: "+str);
		BTreeClass bt1;
		bt1=CreateBT3(str);
		System.out.println("bt1: "+bt1.toString());
		
	}
}
