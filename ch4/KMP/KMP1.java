import java.lang.*;
public class KMP1
{
	final static int MaxSize=100;
	public static void GetNextval(String t,int[] nextval) //由模式串t求出nextval值
	{
		int j=0,k=-1;
		nextval[0]=-1;
		while (j<t.length()-1)
		{
			if (k==-1 || t.charAt(j)==t.charAt(k))
			{	j++;k++;
				if (t.charAt(j)!=t.charAt(k))
					nextval[j]=k;
				else
					nextval[j]=nextval[k];
			}
			else k=nextval[k];
		}
	}
	public static int KMPIndex1(String s,String t)	//KMP算法
	{
		int [] nextval=new int[MaxSize];
		int i=0,j=0;
		GetNextval(t,nextval);					//求nextval数组
		while (i<s.length() && j<t.length())
		{	if (j==-1 || s.charAt(i)==t.charAt(j))
			{
				i++; j++;						//i,j各增1
			}
			else j=nextval[j]; 					//i不变,j回退
		}
		if (j>=t.length())
			return(i-t.length());				//返回起始序号
		else
			return(-1);							//返回-1
	}

	public static void main(String[] args)
	{
		String s="aaaaab";
		String t="aaab";
		int i=KMPIndex1(s,t);
		if (i>=0)
			System.out.println("匹配成功 i="+i);
		else
			System.out.println("匹配失败");
	}	   
} 