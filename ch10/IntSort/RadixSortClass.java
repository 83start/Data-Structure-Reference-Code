class LinkNode								//单链表结点类型
{	int key;								//存放关键字
	String data;							//存放其他数据,假设为String类型
	LinkNode next;							//下一个结点指针
	public LinkNode(int d)					//构造方法
	{
		key=d;
		next=null;
	}
}
public class RadixSortClass						//基数排序类
{
	LinkNode h=null;						//单链表首结点
	public void CreateList(int[] a)			//由关键字序列a构造单链表
	{
		LinkNode s,t;
		h=new LinkNode(a[0]);				//创建首结点
		t=h;
		for (int i=1;i<a.length;i++)
		{
			s=new LinkNode(a[i]);
			t.next=s; t=s;
		}
		t.next=null;
	}
	public void Disp()						//输出单链表
	{
		LinkNode p=h;
		while (p!=null)
		{
			System.out.print(" "+p.key);
			p=p.next;
		}
		System.out.println();
	}
	private int geti(int key,int r,int i)	//求基数为r的正整数key的第i位
	{
		int k=0;
		for (int j=0;j<=i;j++)
		{
			k=key%r;
			key=key/r;
		}
		return k;
	}

	public void RadixSort(int d,int r)		//最低位优先基数排序算法
	{
		LinkNode p,t=null;
		LinkNode[] head=new LinkNode[r];	//建立链队队头数组
		LinkNode[] tail=new LinkNode[r];	//建立链队队尾数组
		for (int i=0;i<d;i++)				//从低位到高位循环
		{
			for (int j=0;j<r;j++) 			//初始化各链队首、尾指针
				head[j]=tail[j]=null;
			p=h;
			while (p!=null)					//分配：对于原链表中每个结点循环
			{
				int k=geti(p.key,r,i);		//提取结点关键字的第i个位k
				if (head[k]==null)			//第k个链队空时，队头队尾均指向p结点
				{	head[k]=p;
					tail[k]=p;
				}
				else						//第k个链队非空时，p结点进队
				{	tail[k].next=p;
					tail[k]=p;
				}
				p=p.next;					//取下一个结点
			}
			h=null;							//重新用h来收集所有结点
			for (int j=0;j<r;j++)			//收集：对于每一个链队循环
				if (head[j]!=null)			//若第j个链队是第一个非空链队
				{	if (h==null)
					{	h=head[j];
						t=tail[j];
					}
					else					//若第j个链队是其他非空链队
					{	t.next=head[j];
						t=tail[j];
					}
				}
			t.next=null;					//尾结点的next置空
			System.out.print("第"+(i+1)+"趟h: "); Disp();
		}
	}
}
