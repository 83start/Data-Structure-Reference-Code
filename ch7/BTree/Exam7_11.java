import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Exam7_11
{
	static String ans;										//存放x结点的所有祖先结点
	public static String Ancestor1(BTreeClass bt,char x)	//返回x结点的祖先
	{
		ans="";
		Ancestor11(bt.b,x);
		return ans;
	}
	private static boolean Ancestor11(BTNode<Character> t,Character x)	//被Ancestor1方法调用
	{
		if (t==null)
			return false;
		if (t.lchild!=null)
		{
			if(t.lchild.data==x)
			{
				ans+=t.data +" ";		//t结点是x结点的祖先
				return true;
			}
		}
		if(t.rchild!=null)
		{
			if (t.rchild.data==x)
			{
				ans+=t.data +" ";		//t结点是x结点的祖先
				return true;
			}
		}
		if(Ancestor11(t.lchild,x) || Ancestor11(t.rchild,x))
		{
			ans+=t.data +" ";			//祖先的祖先是祖先
			return true;
		}
		return false;					//其他情况返回false
	}
	public static String Ancestor2(BTreeClass bt,char x)	//返回x结点的祖先
	{
		ArrayList<Character> path=new ArrayList<Character>(); //存放轨迹
		ans="";
		Ancestor21(bt.b,x,path);
		return ans;
	}
	private static void Ancestor21(BTNode<Character> t,Character x,ArrayList<Character> path) //被Ancestor2方法调用
	{
		if (t==null) return;
		path.add(t.data);
		if (t.data==x)
		{
			path.remove(path.size()-1);		//删除x结点
			ans=path.toString();
			return;
		}
		Ancestor21(t.lchild,x,path);
		Ancestor21(t.rchild,x,path);
		path.remove(path.size()-1);			//从path中删除t结点,回退
	}


	public static String Ancestor3(BTreeClass bt,char x)	//返回x结点的祖先
	{
		char [] path=new char[100]; 
		int d=-1;							//path[0..d-1]存放根到x结点的路径
		ans="";
		Ancestor31(bt.b,x,path,d);
		return ans;
	}
	private static void Ancestor31(BTNode<Character> t,Character x,char[] path,int d) //被Ancestor3方法调用
	{
		if (t==null) return;
		d++; path[d]=t.data;
		if (t.data==x)
		{
			for (int i=0;i<d;i++)
				ans+=String.valueOf(path[i])+" ";
			return;
		}
		Ancestor31(t.lchild,x,path,d);
		Ancestor31(t.rchild,x,path,d);
	}

	public static void solve(BTreeClass bt,char x)
	{
		String s;
		s=Ancestor3(bt,x);
		if (s.isEmpty())
			System.out.println(x+"结点不存在或它没有祖先");
		else
			System.out.println("结点"+x+"的祖先: "+s);
	}
	

@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		//solve(bt,'A');
		//solve(bt,'X');
		//solve(bt,'D');
		//solve(bt,'F');
		solve(bt,'F');
	}
}
