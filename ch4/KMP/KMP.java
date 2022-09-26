import java.lang.*;
public class KMP
{
	final static int MaxSize=100;
	public static void GetNext(String t,int next[])	//由模式串t求出next值
	{
		int j=0,k=-1;
		next[0]=-1;
		while (j<t.length()-1)
		{
			if (k==-1 || t.charAt(j)==t.charAt(k))	//k为-1或比较的字符相等时
			{	j++;k++;
				next[j]=k;
			}
			else k=next[k];							//k置为next[k]
		}
	}
	public static void GetNext1(String t,int next[])	//由模式串t求出next值
	{
		int j=0,k=-1;
		next[0]=-1;
		System.out.println("next[0]=-1");
		while (j<t.length()-1)
		{
			if (k==-1 || t.charAt(j)==t.charAt(k))	//k为-1或比较的字符相等时
			{
				System.out.printf("k=-1或者t[%d]=t[%d]\n",j,k);
				System.out.printf("执行j++,k++->j=%d,k=%d\n",j,k);
				j++;k++;
				next[j]=k;
				System.out.printf("置next[%d]=%d\n",j,k);
			}
			else
			{
				System.out.printf("**t[%d]!=t[%d]\n",j,k);				
				k=next[k];							//k置为next[k]
				System.out.printf("**置k=next[k]，即k=%d\n",k);
			}
		}
	}
	public static int KMPIndex(String s,String t)	//KMP算法
	{
		int [] next=new int[MaxSize];
		int i=0,j=0;
		GetNext(t,next);						//求next数组
		while (i<s.length() && j<t.length())
		{	if (j==-1 || s.charAt(i)==t.charAt(j))
			{
				i++; j++;						//i,j各增1
			}
			else j=next[j]; 					//i不变,j回退
		}
		if (j>=t.length())
			return(i-t.length());				//返回起始序号
		else
			return(-1);							//返回-1
	}
	public static void main(String[] args)
	{
		String t="aaaabaaaaabc";
		int [] next=new int[MaxSize];
		GetNext1(t,next);						//求next数组
	}
/*
	public static void main(String[] args)
	{
		String s="aaaaab";
		String t="aaab";
		int i=KMPIndex(s,t);
		if (i>=0)
			System.out.println("匹配成功 i="+i);
		else
			System.out.println("匹配失败");
	}
*/	
} 