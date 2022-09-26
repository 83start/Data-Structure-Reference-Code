import java.util.*;
@SuppressWarnings("unchecked")
public class Exam6_7
{
	public static TupClass Transpose(TupClass a)	//矩阵转置
	{
		TupClass b=new TupClass();					//新建空三元组表示b
		if (a.nums==0) return b;
		b.rows=a.cols;
		b.cols=a.rows;
		b.nums=a.nums;
		for (int v=0;v<a.cols;v++)					//按列号v查找
			for (int k=0;k<a.nums;k++)				//遍历data
				if (a.data.get(k).c==v)				//找到v列号的非0元素
				{
					TupElem p=new TupElem(a.data.get(k).c,a.data.get(k).r,a.data.get(k).d);
					b.data.add(p);					//新结点添加到b中
				}
		return b;
	}
	public static void main(String[] args)
	{
		int [][]A={ {0,0,1,0,0,0,0},
					{0,2,0,0,0,0,0},
					{3,0,0,0,0,0,0},
					{0,0,0,5,0,0,0},
					{0,0,0,0,6,0,0},
					{0,0,0,0,0,7,4}};
		int m=6,n=7; 
		TupClass a=new TupClass();
		TupClass b=new TupClass();
		a.CreateTup(A,m,n);
		System.out.println("a三元组表示"); a.DispTup();
		System.out.println("转置a->b");
		b=Transpose(a);
		System.out.println("b三元组表示"); b.DispTup();
	}
} 