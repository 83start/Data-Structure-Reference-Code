class RecType										//顺序表元素类型
{	int key;										//存放关键字，假设关键字为int类型
	String data;									//存放其他数据，假设为String类型
	public RecType(int d)							//构造方法
	{	key=d;  }
}
public class SqListSortClass						//顺序表排序类
{
	final int MAXN=100;								//表示最多元素个数
	RecType[] R; 									//存放排序的元素
	int n;											//实际元素个数
	public void swap(int i,int j)					//交换R[i]和R[j]
	{
		RecType tmp=R[i];
		R[i]=R[j]; R[j]=tmp;
	}
	public void CreateR(int[] a)					//由关键字序列a构造顺序表R[0..n-1]
	{	R=new RecType[MAXN]; 
		for (int i=0;i<a.length;i++)
			R[i]=new RecType(a[i]);
		n=a.length;
	}
	public void Disp()								//输出顺序表R[0..n-1]
	{
		for (int i=0;i<n;i++)
			System.out.print(R[i].key+" ");
		System.out.println();
	}
	public void CreateR1(int[] a)					//由关键字序列a构造顺序表R[1..n]
	{	R=new RecType[MAXN]; 
		for (int i=0;i<a.length;i++)
			R[i+1]=new RecType(a[i]);
		n=a.length;
	}
	public void Disp1()								//输出顺序表R[1..n]
	{
		for (int i=1;i<=n;i++)
			System.out.print(R[i].key+" ");
		System.out.println();
	}

	public void InsertSort() 					//对R[0..n-1]按递增有序进行直接插入排序
	{
		RecType tmp;
		int j;
		for (int i=1;i<n;i++)					//从第2个元素即R[1]开始
		{	
			if (R[i].key<R[i-1].key)			//反序时
			{
				tmp=R[i];						//取出无序区的第一个元素
				j=i-1;							//在有序区R[0..i-1]中从右向左找R[i]的插入位置
				do
				{	R[j+1]=R[j];				//将关键字大于tmp.key的元素后移
					j--;						//继续向前比较
				} while (j>=0 && R[j].key>tmp.key);
				R[j+1]=tmp;							//在j+1处插入R[i]
			}
		}
	}
	public void BinInsertSort()					//对R[0..n-1]按递增有序进行折半插入排序
	{	int low,high,mid;
		RecType tmp;
		for (int i=1;i<n;i++)
		{
			if (R[i].key<R[i-1].key)			//反序时
			{	tmp=R[i];						//将R[i]保存到tmp中
				low=0;high=i-1;
				while (low<=high)				//在R[low..high]中折半查找插入位置high+1
				{	mid=(low+high)/2;			//取中间位置
					if (tmp.key<R[mid].key)
						high=mid-1;				//插入点在左区间
					else
						low=mid+1;				//插入点在右区间
				}
				for (int j=i-1;j>=high+1;j--)	//元素集中后移
					R[j+1]=R[j];
				R[high+1]=tmp;					//插入原来的R[i]
			}
		}
	}
	public void ShellSort()					//对R[0..n-1]按递增有序进行希尔排序
	{
		RecType tmp;
		int d=n/2;							//增量置初值
		while (d>0)
		{	for (int i=d;i<n;i++)			//对所有相隔d位置的元素组采用直接插入排序
			{	tmp=R[i];
				int j=i-d;
				while (j>=0 && tmp.key<R[j].key) //对相隔d位置的元素组排序
				{	R[j+d]=R[j];
					j=j-d;
				}
				R[j+d]=tmp;
			}
			d=d/2;							//递减增量
		}
	}
	public void BubbleSort()				//对R[0..n-1]按递增有序进行冒泡排序
	{
		boolean exchange=false;
		for (int i=0;i<n-1;i++) 
		{	exchange=false;					//本趟前将exchange置为false
			for (int j=n-1;j>i;j--)			//一趟中找出最小的元素
				if (R[j].key<R[j-1].key)	//反序时交换
				{	swap(j,j-1);			//R[j]和R[j-1]交换,将最小元素前移
					exchange=true;			//本趟发生交换置exchange为true
				}
			System.out.print("i="+i+" ");Disp();
			if (!exchange)					//本趟没有发生交换，中途结束算法
				return;
		}
	}
/*
	public void Disp2(int base,int s,int t,int n)		//输出快速排序结果
	{
		System.out.print("base="+base+"  ");
		for (int i=0;i<s;i++)
			System.out.print(R[i].key+" ");
		System.out.print("[");
		for (int i=s;i<=t;i++)
			System.out.print(R[i].key+" ");
		System.out.print("]");
		for (int i=t+1;i<n;i++)
			System.out.print(R[i].key+" ");
		
		System.out.println();
	}

	public int Partition1(int s,int t)		//算法(第4版）的算法
	{
		RecType base=R[s],tmp;				//以表首元素为基准
		int i=s,j=t+1;
		while (true)						//从表两端交替向中间遍历,直至i=j为止
		{
			while (R[++i].key<=base.key)
				if (i==t) break;			//从前向后遍历,找一个大于等于基准的R[i]
			while (base.key<R[--j].key)
				if (j==s) break;			//从后向前遍历,找一个小于等于基准的R[j]
			if (i>=j) break;				//i>=j结束
			tmp=R[i];						//将R[i]和R[j]进行交换
			R[i]=R[j]; R[j]=tmp;
		}
		tmp=R[s];							//将基准R[s]和R[i]进行交换
		R[s]=R[j]; R[j]=tmp;
		return j;
	}
*/
	int cnt; 
	public int Partition1(int s,int t)		//划分算法1
	{
		RecType base=R[s];					//以表首元素为基准
		int i=s,j=t;
		while (i<j)							//从表两端交替向中间遍历,直至i=j为止
		{	while (i<j && R[j].key>=base.key)
			{
				cnt++;
				j--;						//从后向前遍历,找一个小于基准的R[j]
			}
			while (i<j && R[i].key<=base.key)
			{
				cnt++;
				i++;						//从前向后遍历,找一个大于基准的R[i]
			}
			if (i<j)
				swap(i,j);					//将R[i]和R[j]进行交换
		}
		swap(s,i);							//将基准R[s]和R[i]进行交换
		return i;
	}
	private int Partition2(int s,int t)		//按表首元素为基准进行划分
	{
		int i=s,j=t;
		RecType base=R[s];					//以表首元素为基准
		while (i!=j)						//从表两端交替向中间遍历,直至i=j为止
		{
			if (j>i) cnt++;
			while (j>i && R[j].key>=base.key)
			{
				if (j>i) cnt++;
				j--;						//从后向前遍历,找一个小于基准的R[j]
			}
			if (j>i)
			{	R[i]=R[j];					//R[j]前移覆盖R[i]			
				i++;
			}
			if (i<j) cnt++;
			while (i<j && R[i].key<=base.key)
			{
				if (i<j) cnt++;
				i++;						//从前向后遍历,找一个大于基准的R[i]
			}
			if (i<j)
			{	R[j]=R[i];					//R[i]后移覆盖R[j]
				j--;
			}
		}
		R[i]=base;							//基准归位
		System.out.println("cnt="+cnt);
		return i;							//返回归位的位置		
	}

	public int Partition3(int s,int t) 		//利用例2.4的算法3思路
	{	int i=s,j=s+1;
		RecType base=R[s];					//以表首元素为基准
		while (j<=t)						//j从s+1开始遍历其他元素
		{	if (R[j].key<=base.key)			//找到小于等于基准的元素a[j]
			{
				i++;						//扩大小于等于base的元素区间
				if (i!=j)
					swap(i,j);				//将R[i]与R[j]交换
			}
			j++;							//继续扫描
		}
		swap(s,i);							//将基准R[s]和R[i]进行交换
		return i;
	}
	public void QuickSort()					//对R[0..n-1]的元素按递增进行快速排序
	{
		QuickSort2(0,n-1);
	}

	public void QuickSort1(int s,int t)	//对R[s..t]的元素进行快速排序
	{
		if (s<t) 				 			//表中至少存在两个元素的情况
		{
			cnt=0;
			int i=Partition3(s,t);
			QuickSort1(s,i-1);				//对左子表递归排序
			QuickSort1(i+1,t);				//对右子表递归排序
		}
	}
	private void QuickSort2(int s,int t)	//例10.5
	{
		if (s<t) 				 			//表中至少存在两个元素的情况
		{
			int mid=(s+t)/2;
			swap(s,mid);					//R[s]与R[mid]交换
			int i=Partition1(s,t);
			QuickSort2(s,i-1);				//对左子表递归排序
			QuickSort2(i+1,t);				//对右子表递归排序
		}
	}
	public void SelectSort()				//对R[0..n-1]元素进行简单选择排序
	{
		for (int i=0;i<n-1;i++)				//做第i趟排序
		{	int minj=i;
			for (int j=i+1;j<n;j++)			//在无序区R[i..n-1]中选最小元素的R[minj]
				if (R[j].key<R[minj].key)
					minj=j;
			if (minj!=i)					//R[minj]不是无序区首元素
				swap(i,minj);				//交换R[i]和R[minj]
		}
	}
	private void sift(int low,int high)			//对R[low..high]进行筛选
	{	int i=low,j=2*i;						//R[j]是R[i]的左孩子
		RecType tmp=R[i];						//tmp临时保存根结点
		while (j<=high)							//只对R[low..high]的元素进行筛选
		{	if (j<high && R[j].key<R[j+1].key) 	
				j++;							//若右孩子较大,把j指向右孩子
			if (tmp.key<R[j].key) 				//tmp的孩子较大
			{	R[i]=R[j];						//将R[j]调整到双亲位置上
				i=j; j=2*i;						//修改i和j值,以便继续向下筛选
			}
			else break;							//若孩子较小，则筛选结束
		}
		R[i]=tmp;								//原根结点放入最终位置
	}
	public void HeapSort()						//对R[1..n]按递增进行堆排序
	{
		for (int i=n/2; i>=1;i--)				//循环建立初始堆
			sift(i,n);							//对R[i..n]进行筛选
		for (int i=n;i>=2;i--)					//进行n-1趟排序,每一趟排序的元素个数减1
		{	swap(1,i);							//将区间中最后一个元素与R[1]交换
			sift(1,i-1);						//从R[1]继续筛选,得到i-1个结点的堆
		}
	}
	//**********自底向上的二路归并
	private void Merge(int low,int mid,int high)	//R[low..mid]和R[mid+1..high]归并为R[low..high]
	{	RecType[] R1=new RecType[high-low+1];
		int i=low,j=mid+1,k=0;				//k是R1的下标,i、j分别为第1、2段的下标
		while (i<=mid && j<=high)			//在第1段和第2段均未扫描完时循环
			if (R[i].key<=R[j].key)			//将第1段中的元素放入R1中
			{	R1[k]=R[i];
				i++; k++;
			}
			else							//将第2段中的元素放入R1中
			{	R1[k]=R[j];
				j++; k++; 
			}
		while (i<=mid)						//将第1段余下部分复制到R1
		{	R1[k]=R[i];
			i++; k++;
		}
		while (j<=high)						//将第2段余下部分复制到R1
		{	R1[k]=R[j];
			j++; k++;
		}
		for (k=0,i=low;i<=high;k++,i++)		//将R1复制回R中
			R[i]=R1[k];
	}
	private void MergePass(int len)			//一趟二路归并排序
	{
		int i;
		for (i=0;i+2*len-1<n;i=i+2*len)		//归并len长的两相邻子表
			Merge(i,i+len-1,i+2*len-1);
		if (i+len<n)						//余下两个子表,后者长度小于len
			Merge(i,i+len-1,n-1);			//归并这两个子表
	}
	public void MergeSort1()				//对R[0..n-1]按递增进行二路归并算法
	{
		for (int len=1;len<n;len=2*len)		//进行log2n(取上界)趟归并
			MergePass(len);
	}
	//**********自顶向下的二路归并
	public void MergeSort2()				//对R[0..n-1]按递增进行二路归并算法
	{
		MergeSort21(0,n-1);
	}
	private void MergeSort21(int s,int t)	//被MergeSort2调用
	{
		if(s>=t) return;					//R[s..t]的长度为0或者1时返回
		int m=(s+t)/2;						//取中间位置m
		MergeSort21(s,m);					//对前子表排序
		MergeSort21(m+1,t);					//对后子表排序
		Merge(s,m,t);						//将两个有序子表合并成一个有序表
	}
		
			
	


	


	
}
