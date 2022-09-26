import java.lang.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Exam7_9
{
	public static int Level1(BTreeClass bt,char x)
	{
		return Level11(bt.b,x,1);
	}
	private static int Level11(BTNode<Character> t,char x,int h)
	//被Level1方法调用,t为根结点时,h置初值1
	{	if (t==null)
			return 0;							//空树不能找到该结点
		else if (t.data==x)
			return h;							//根结点即为所找,返回其层次
		else
		{	int l=Level11(t.lchild,x,h+1);				//在左子树中查找
			if (l!=0)
				return l;						//左子树中找到了,返回其层次
			else
				return (Level11(t.rchild,x,h+1));		//左子树中未找到,再在右子树中查找
		}
	}

	public static void solve(BTreeClass bt,char x)
	{
		int l=Level2(bt,x);
		if (l==0)
			System.out.println("没有找到"+x+"结点");
		else
			System.out.println("结点"+x+"的层次: "+l);
	}
	
	public static int Level2(BTreeClass bt,char x)
	{
		return Level21(bt.b,x);
	}
	private static int Level21(BTNode<Character> t,char x)
	{	
        if (t==null)
			return 0;
        if (t.data==x)						//根结点值为x
            return 1;
        int leftl=(t.lchild==null ? 0 : Level21(t.lchild,x));
        int rightl=(t.rchild==null ? 0 : Level21(t.rchild,x));
        if (leftl<1 && rightl<1)			//左右子树都没有找到，返回0
			return 0;
        return Math.max(leftl,rightl)+1;	//返回左右子树中最大层次+1	
    }
		
@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		String s="A(B(D(,G)),C(E,F))";
		BTreeClass bt=new BTreeClass();
		bt.CreateBTree(s);
		System.out.println("bt: "+bt.toString());
		solve(bt,'A');
		solve(bt,'G');
		solve(bt,'C');
		solve(bt,'X');
		solve(bt,'S');
	}
}
