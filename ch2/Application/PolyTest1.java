import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
class PolyElem								//多项式顺序表元素类型
{	double coef;							//系数
	int exp;								//指数
	PolyElem(double c,int e)				//构造方法
	{
		coef=c;
		exp=e;
	}
	public int getexp()						//用于按exp递减排序
	{
		return exp;
	}
}
class PolyClass								//多项式顺序表类
{	ArrayList<PolyElem> poly;				//存放多项式顺序表
	public PolyClass()						//构造方法
	{
		poly=new ArrayList<PolyElem>();		//分配顺序表的data空间
	}
	public void Add(PolyElem p)				//末尾添加一个多项式项
	{
		poly.add(p);
	}
	public void CreatePoly(double[] a,int[] b,int n) //建立多项式顺序表
	{
		for (int i=0;i<n;i++)
			poly.add(new PolyElem(a[i],b[i]));
	}
	public void Sort()		//对多项式顺序表按exp域递减排序
	{
		poly.sort(Comparator.comparing(PolyElem::getexp).reversed());		//comparingInt
	}
	public void DispPoly()						//输出多项式顺序表
	{	boolean first=true;						//first为true表示是第一项
		int i=0;
		while (i<poly.size())
		{
			PolyElem p=(PolyElem)poly.get(i); 
			if (first) first=false;
			else if (p.coef>0) System.out.print("+");
			if (p.exp==0)				//指数为0时不输出'x'
				System.out.print(p.coef);
			else if (p.exp==1)			//指数为1时不输出指数
				System.out.print(p.coef+"x");
			else
				System.out.print(p.coef+"x^"+p.exp);
			i++;
		}
		System.out.println();
	}
}
public class PolyTest1 {
	public static PolyClass Add(PolyClass L1,PolyClass L2)  				//两个多项式相加运算
	{	int i=0,j=0;
		double c;
		PolyClass L3=new PolyClass();
		while (i<L1.poly.size() && j<L2.poly.size())
		{	if (L1.poly.get(i).exp>L2.poly.get(j).exp)							//L1的元素的指数较大
			{
				L3.Add(new PolyElem(L1.poly.get(i).coef,L1.poly.get(i).exp));	//新建L3的元素
				i++;
			}
			else if (L1.poly.get(i).exp<L2.poly.get(j).exp)						//L2的元素的指数较大
			{
				L3.Add(new PolyElem(L2.poly.get(j).coef,L2.poly.get(j).exp));	//新建L3的元素
				j++;
			}
			else																//两元素的指数相等
			{	c=L1.poly.get(i).coef+L2.poly.get(j).coef;						//求两指数相等元素的系数和
				if (c!=0)														//系数和c不为0时复制
					L3.Add(new PolyElem(c,L1.poly.get(i).exp));					//新建L3的元素
				i++; j++;
			}
		}
		while (i<L1.poly.size())												//复制poly1余下的元素
		{
			L3.Add(new PolyElem(L1.poly.get(i).coef,L1.poly.get(i).exp));		//新建L3的元素
			i++;
		}
		while (j<L2.poly.size())												//复制poly2余下的元素
		{
			L3.Add(new PolyElem(L2.poly.get(j).coef,L2.poly.get(j).exp));		//新建L3的元素
			j++;
		}
		return L3;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
        System.setIn(new FileInputStream("abc.in"));	//将标准输入流重定向至abc.in
        Scanner fin = new Scanner(System.in);
        System.setOut(new PrintStream("abc.out"));		//将标准输出流重定向至abc.out
		PolyClass L1=new PolyClass();
		PolyClass L2=new PolyClass();
		PolyClass L3;									//建立3个多项式顺序表对象
		double[] a=new double[100];
		int[] b=new int[100];
		int n;
		n = fin.nextInt();								//输入n
		for (int i=0;i<n;i++)							//输入a
			a[i]=fin.nextDouble();
		for (int i=0;i<n;i++) 							//输入b
			b[i]=fin.nextInt();
		L1.CreatePoly(a,b,n);							//创建第1个多项式顺序表
		System.out.print("第1个多项式:  "); L1.DispPoly();
		L1.Sort(); 										//排序
		System.out.print("排序后结果:   "); L1.DispPoly();
		n = fin.nextInt();								//输入n
		for (int i=0;i<n;i++)							//输入a
			a[i]=fin.nextDouble();
		for (int i=0;i<n;i++)							//输入b
			b[i]=fin.nextInt();
		L2.CreatePoly(a,b,n);							//创建第2个多项式顺序表
		System.out.print("第2个多项式:  "); L2.DispPoly();
		L2.Sort();										//排序
		System.out.print("排序后结果:   "); L2.DispPoly();
		L3=Add(L1,L2);									//两多项式相加
		System.out.print("相加后多项式: "); L3.DispPoly();
	}
}
