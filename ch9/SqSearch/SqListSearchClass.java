class RecType										//顺序表元素类型
{	int key;										//存放关键字，假设关键字为int类型
	String data;									//存放其他数据，假设为String类型
	public RecType(int d)							//构造方法
	{	key=d;  }
}
class IdxType										//索引表类型
{	int key;										//关键字
	int link;										//该索引块在数据表中的起始下标
}

public class SqListSearchClass						//顺序表查找类
{
	final int MAXN=100;								//表示最多元素个数
	RecType[] R; 									//存放查找表的数组，R[0..n-1]表示查找表
	int n;											//实际元素个数
	public void CreateR(int[] a)					//由关键字序列a构造顺序表R
	{	R=new RecType[MAXN]; 
		for (int i=0;i<a.length;i++)
			R[i]=new RecType(a[i]);
		n=a.length;
	}
	public void Disp()								//输出顺序表
	{
		for (int i=0;i<n;i++)
			System.out.print(R[i].key+" ");
		System.out.println();
	}
	//顺序查找
	public int SeqSearch1(int k)					//顺序查找算法1
	{	int i=0;
		while (i<n && R[i].key!=k) i++;				//从表头往后找
		if (i>=n) return -1;						//未找到返回-1
		else return i;								//找到后返回其序号i
	}
	public int SeqSearch2(int k)					//顺序查找算法2
	{	R[n]=new RecType(k);						//添加哨兵
		int i=0;
		while (R[i].key!=k) i++;					//从表头往后找
		if (i==n) return -1;						//未找到返回-1
		else return i;								//找到后返回其序号i
	}
	public int SeqSearch3(int k)					//有序表的顺序查找算法
	{	int i=0;
		while (i<n)
		{
			if (R[i].key==k)						//找到k，返回i
				return i;
			else if (k>R[i].key)					//k大于R[i].key，继续查找
				i++;
			else 									//k小于R[i].key，查找失败
				return -1;
		}
		return -1;
	}
	//基本的折半查找
	public int BinSearch1(int k)					//拆半查找非递归算法
	{	int low=0,high=n-1,mid;
		while (low<=high)							//当前区间非空时
		{	mid=(low+high)/2;						//求查找区间的中间位置
			if (k==R[mid].key)						//查找成功返回其序号mid
				return mid;
			if (k<R[mid].key)						//继续在R[low..mid-1]中查找
				high=mid-1;
			else									//k>R[mid].key
				low=mid+1;							//继续在R[mid+1..high]中查找
		}
		return -1;									//当前查找区间空时返回-1
	}
	public int BinSearch2(int k)				 	//拆半查找递归算法
	{
		return BinSearch21(0,n-1,k);
	}
	private int BinSearch21(int low,int high,int k)	//被BinSearch1方法调用
	{	if (low<=high)						 		//当前查找区间非空时
		{	int mid=(low+high)/2;					//求查找区间的中间位置
			if (k==R[mid].key)						//查找成功返回其序号mid
				return mid;
			if (k<R[mid].key)						//递归在左区间中查找
				return BinSearch21(low,mid-1,k);
			else									//k>R[mid].key,递归在右区间中查找
				return BinSearch21(mid+1,high,k);
		}
		else return -1;								//当前查找区间空时返回-1
	}
	//折半查找的扩展
	
	public int GOEk(int k)							//查找第一个大于或者等于k的元素序号
	{	int low=0,high=n-1,mid;
		while (low<=high)							//当前区间非空时
		{	mid=(low+high)/2;						//求查找区间的中间位置
			if (k<=R[mid].key)						//继续在R[low..mid-1]中查找
				high=mid-1;
			else									//k>R[mid].key
				low=mid+1;							//继续在R[mid+1..high]中查找
		}
		System.out.println("low="+low+",high="+high);
		return high+1;								//当前查找区间空时返回high+1
	}
	
	public int Firstequalsk(int k)					//查找第一个等于k的元素序号
	{	int mid,low=0,high=n-1;
		while(low<high)
		{	mid=(low+high)/2;
			if(k<=R[mid].key)
				high=mid;
			else
				low=mid+1;
		}
		if(k==R[low].key) return low;
		else return -1;
	}
	public int Lastequalsk(int k)					//查找最后一个等于k的元素序号
	{	int mid,low=0,high=n-1;
		while(low<high)
		{	//mid=low+(high-low+1)/2;
			mid=(low+high+1)/2;
			if(k>=R[mid].key)
				low=mid;
			else
				high=mid-1;
		}
		if(k==R[low].key) return low;
		else return -1;
	}
	public int[] Intervalk(int k)					//查找为k的元素区间[v[0]，v[1]]
	{	int[] v=new int[2];
		v[0]=Firstequalsk(k);
		v[1]=Lastequalsk(k);
		return v;
	}
	//分块查找
	public void CreateI(IdxType[] I,int b)			//构造索引表
	{
		int s=(n+b-1)/b;							//每块的元素个数
		int j=0,jmax=R[j].key;
		for(int i=0;i<b;i++)						//构造b块
		{
			I[i]=new IdxType();
			I[i].link=j;
			while (j<=(i+1)*s-1 && j<=n-1)			//j遍历一个块，查找其中最大关键字jmax
			{
				if(R[j].key>jmax)
					jmax=R[j].key;
				j++;
			}
			I[i].key=jmax;
			if (j<=n-1)								//j没有遍历完，jmax置为下一个块首元素关键字					
				jmax=R[j].key;
		}	
	}
	public int IdxSearch(IdxType[] I,int b,int k)	//在顺序表R[0..n-1]和索引表I[0..b-1]中查找k
	{
		int low=0,high=b-1,mid;
		while (low<=high)							//在索引表中折半查找,找到的位置为high+1
		{	mid=(low+high)/2;
			if (k<=I[mid].key)
				high=mid-1;
			else 
				low=mid+1;
		}
		if (high+1>=b) return -1;					//块号超界，查找失败，返回-1
		int i=I[high+1].link;						//所在块的起始位置
		int s=(n+b-1)/b;							//每块的元素个数
		if (i==b-1)									//第i块是最后块，元素个数可能少于s
			s=n-s*(b-1);
		while (i<=I[high+1].link+s-1 && R[i].key!=k)
			i++;
		if (i<=I[high+1].link+s-1)
			return i;								//查找成功,返回该元素的序号
		else
			return -1;								//查找失败,返回-1
	}
	//例9.3
	public int BSearch1(int k)
	{
		int low=0,high=n-1,mid;
		while (low<=high)
		{
			mid=(low+high)/2;
			if (k==R[mid].key)
				return mid;
			if (k<R[mid].key)
				high=mid-1;
			else
				low=mid;
		}
		return -1;
	}
	public int BSearch2(int k)
	{	int low=0,high=n-1,mid;
		while (low<high)
		{	mid=(low+high)/2;
			if (k==R[mid].key)
				return mid;
			if (k<R[mid].key)
				high=mid-1;
			else
				low=mid+1;
		}
		if (R[low].key==k)
			return low;
		else
			return -1;
	}

}
