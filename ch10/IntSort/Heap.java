class RecType									//顺序表元素类型
{	int key;									//存放关键字，假设关键字为int类型
	String data;								//存放其他数据，假设为String类型
	public RecType() {}
	public RecType(int d)						//构造方法
	{	key=d;  }
}
class HeapClass									//堆类
{
	final int MAXN=100;							//表示最多元素个数
	RecType[] R=new RecType[MAXN]; 				//存放堆元素
	int n=0;									//堆中实际元素个数
	public void swap(int i,int j)				//交换R[i]和R[j]
	{
		RecType tmp=R[i];
		R[i]=R[j]; R[j]=tmp;
	}
	
	public void Disp()							//输出顺序表R[1..n]
	{
		for (int i=1;i<=n;i++)
			System.out.print(R[i].key+" ");
		System.out.println();
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

	public void push(RecType e)					//插入元素e
	{
		n++;									//堆中元素个数增1
		R[n]=e;									//将e添加到末尾
		System.out.printf("R[%d]=%d\n",n,R[n].key);
		if (n==1) return;						//e作为根结点的情况
		int j=n,i=j/2;							//i指向R[j]的双亲
		while (true)
		{
			if (R[j].key>R[i].key)				//若孩子较大
				swap(i,j);						//交换
			if (i==1) break;					//到达根结点时结束
			j=i; i=j/2;							//继续向上调整
		}
	}
	public RecType pop()						//删除堆顶元素
	{
		if (n==0) return null;
		RecType e=R[1];							//取出堆顶元素
		R[1]=R[n];								//用尾元素覆盖R[1]
		n--;									//元素个数减少1
		sift(1,n);								//筛选为一个堆
		return e;
	}
	public boolean empty()						//判断堆是否为空
	{
		return n==0;
	}
}
public class Heap
{
	public static void main(String[] args)
	{
		HeapClass hp=new HeapClass();
		System.out.printf("空否: %s\n",(hp.empty()?"空":"非空"));
		RecType e=new RecType();
		e.key=3;
		System.out.println("插入"+e.key);		
		hp.push(e);
		System.out.print("堆: ");hp.Disp();

		e=new RecType();
		e.key=6;
		System.out.println("插入"+e.key);		
		hp.push(e);
		System.out.print("堆: ");hp.Disp();

		e=new RecType();
		e.key=2;
		System.out.println("插入"+e.key);		
		hp.push(e);
		System.out.print("堆: ");hp.Disp();

		e=new RecType();
		e.key=8;
		System.out.println("插入"+e.key);		
		hp.push(e);
		System.out.print("堆: ");hp.Disp();

		e=new RecType();
		e.key=5;
		System.out.println("插入"+e.key);		
		hp.push(e);
		System.out.print("堆: ");hp.Disp();


		e=new RecType();
		e.key=9;
		System.out.println("插入"+e.key);		
		hp.push(e);
		System.out.print("堆: ");hp.Disp();


		e=new RecType();
		e.key=1;
		System.out.println("插入"+e.key);		
		hp.push(e);
		System.out.print("堆: ");hp.Disp();


		e=hp.pop();
		System.out.println("删除"+e.key);		
		System.out.print("堆: ");hp.Disp();


		e=new RecType();
		e.key=20;
		System.out.println("插入"+e.key);		
		hp.push(e);
		System.out.print("堆: ");hp.Disp();


		while (!hp.empty())
		{
			e=hp.pop();
			System.out.println("删除"+e.key);		
			System.out.print("堆: ");hp.Disp();
		}	


	}
}
