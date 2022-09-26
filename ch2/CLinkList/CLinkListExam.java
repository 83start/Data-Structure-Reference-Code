@SuppressWarnings("unchecked")
public class CLinkListExam
{
   public static void main(String[] args)
   {
		//测试1
		System.out.println("*******测试1****************“");
		Integer [] a={1,2,3,4,5};
		CLinkListClass<Integer> L1=new CLinkListClass<Integer>();
		L1.CreateListR(a);
		System.out.println("L1: "+L1.toString());
		System.out.println("L1长度="+L1.size());
		System.out.println("末尾添加10");
		L1.Add(10);
		System.out.println("L1: "+L1.toString());
		System.out.println("求每个序号的元素值");
		for (int i=0;i<L1.size();i++)
			System.out.println("  序号"+i+"的元素值:"+L1.GetElem(i));
		System.out.println("重新置长度为5");
		L1.Setsize(5);
		System.out.println("L1: "+L1.toString());
		int i=1;
		Integer x=20;
		System.out.println("在序号"+i+"位置插入"+x);
		L1.SetElem(i,x);
		System.out.println("L1: "+L1.toString());
		i=3;
		System.out.println("删除序号"+i+"的元素");
		L1.Delete(i);
		System.out.println("L1: "+L1.toString());
		i=2; x=16;
		System.out.println("设置序号"+i+"的元素值为"+x);
		L1.SetElem(i,x);
		System.out.println("L1: "+L1.toString());
		x=5;
		System.out.println("值为"+x+"的元素序号为"+L1.GetNo(x));


		//测试2
		System.out.println();
		System.out.println("*******测试2****************");
		Character [] b={'a','b','c','d','e','f'};
		CLinkListClass<Character> L2=new CLinkListClass<Character>();
		L2.CreateListR(b);
		System.out.println("L2: "+L2.toString());
		System.out.println("L2长度="+L2.size());
		L2.Add('x');
		System.out.println("L2: "+L2.toString());
		System.out.println("求每个序号的元素值");
		for (i=0;i<L2.size();i++)
			System.out.println("  序号"+i+"的元素值:"+L2.GetElem(i));
		System.out.println("重新置长度为5");
		L2.Setsize(5);
		System.out.println("L2: "+L2.toString());
		i=1;
		Character y='y';
		System.out.println("在序号"+i+"位置插入"+y);
		L2.SetElem(i,y);
		System.out.println("L2: "+L2.toString());
		i=3;
		System.out.println("删除序号"+i+"的元素");
		L2.Delete(i);
		System.out.println("L2: "+L2.toString());
		i=2; y='z';
		System.out.println("设置序号"+i+"的元素值为"+y);
		L2.SetElem(i,y);
		System.out.println("L2: "+L2.toString());
		y='d';
		System.out.println("值为"+y+"的元素序号为"+L2.GetNo(y));

   }	   
}

 