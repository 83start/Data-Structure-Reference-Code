import java.util.*;
public class Exam10_11
{
	static int MAXN=1005;
	static int ans;							//相邻整数的最小交换数量
	static int[] a=new int[MAXN];			//存放整数序列
	static void Merge(int low,int mid,int high) //两个相邻有序段归并
	{	int i=low;
		int j=mid+1;
		int k=0;
		int[] b=new int[high-low+1];		//开辟临时空间
		while(i<=mid && j<=high) 			//二路归并：a[low..mid]、a[mid+1..high]=>b
		{	if(a[i]>a[j])
			{	b[k++]=a[j++];
				ans+=mid-i+1;				//累计逆序数
				
			}
			else b[k++]=a[i++];
		}
		while(i<=mid) b[k++]=a[i++];
		while(j<=high) b[k++]=a[j++];
		for(int k1=0;k1<k;k1++)				//b[0..k-1]=>a[low..high]
			a[low+k1]=b[k1];
	}
	static void MergeSort(int s,int t)		//二路归并排序
	{	if(s>=t) return;					//R[s..t]的长度为0或者1时返回
		int m=(s+t)/2;						//取中间位置m
		MergeSort(s,m);						//对前子表排序
		MergeSort(m+1,t);					//对后子表排序
		Merge(s,m,t);						//将两个有序子表合并成一个有序表
	}
	
	public static void main(String[] args)
	{
		Scanner fin=new Scanner(System.in);
		int m,n;
		m=fin.nextInt();					//场景个数
		for (int cas=1;cas<=m;cas++)
		{
			n=fin.nextInt();
			for (int i=0;i<n;i++)
				a[i]=fin.nextInt();
			ans=0;
			MergeSort(0,n-1);
			System.out.printf("Scenario #%d:\n%d\n\n",cas,ans);
		}		
	}
}
