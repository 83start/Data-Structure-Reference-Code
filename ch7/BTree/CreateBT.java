import java.util.*;
public class CreateBT
{
	public static BTreeClass CreateBT1(String pre,String in) //由先序序列pre和中序序列in构造二叉链
	{
		BTreeClass bt=new BTreeClass();
		bt.b=CreateBT11(pre,0,in,0,pre.length());
		return bt;
	}
	private static BTNode<Character> CreateBT11(String pre,int i,String in,int j,int n)
	{
		BTNode<Character> t;
		char ch;
		int p,k;
		if (n<=0) return null;
		ch=pre.charAt(i);
		t=new BTNode<Character>(ch);		//创建根结点(结点值为ch)
		p=j;								//p指中序序列的开始元素
		while (p<j+n)						//在中序序列中找等于ch的位置k
		{	if (in.charAt(p)==ch)
				break;						//在in中找到后退出循环
			p++;
		}
		k=p-j;										//确定根结点在in中的位置p
		t.lchild=CreateBT11(pre,i+1,in,j,k);		//递归构造左子树
		t.rchild=CreateBT11(pre,i+k+1,in,p+1,n-k-1);	//递归构造右子树
		return t;
	}
	
	public static BTreeClass CreateBT2(String post,String in) //由后序序列post和中序序列in构造二叉链
	{
		BTreeClass bt=new BTreeClass();
		bt.b=CreateBT22(post,0,in,0,post.length());
		return bt;
	}
	private static BTNode<Character> CreateBT22(String post,int i,String in,int j,int n)
	{
		BTNode<Character> t;
		char ch;
		int p,k;
		if (n<=0) return null;
		ch=post.charAt(i+n-1);						//取后序序列尾元素
		t=new BTNode<Character>(ch);				//创建根结点(结点值为ch)
		p=j;										//p指中序序列的开始元素
		while (p<j+n)								//在中序序列中找根位置p
		{	if (in.charAt(p)==ch)
				break;								//在in中找到根后退出循环
			p++;
		}
		k=p-j;										//确定根结点在in中的位置
		t.lchild=CreateBT22(post,i,in,j,k);			//递归构造左子树
		t.rchild=CreateBT22(post,i+k,in,p+1,n-k-1);	//递归构造右子树
		return t;
	}

@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		String pre="ABDGCEF";
		String in="DGBAECF";
		String post="GDBEFCA";
		BTreeClass bt=new BTreeClass();
		bt=CreateBT2(post,in);
		System.out.println("bt: "+bt.toString());
	}
}
