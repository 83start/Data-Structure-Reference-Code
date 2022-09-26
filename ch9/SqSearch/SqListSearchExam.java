public class SqListSearchExam
{
/*
	public static void main(String[] args)
	{
		int[] a={3,9,1,5,8,10,6,7,2,4};
		SqListSearchClass s=new SqListSearchClass();
		s.CreateR(a);
		System.out.print("R: ");s.Disp();
		int k=6;
		System.out.println("顺序表的顺序查找1: "+k+"     结果为"+s.SeqSearch1(k));
		System.out.println("顺序表的顺序查找2: "+k+"     结果为"+s.SeqSearch2(k));
		
		int b[]={12,14,16,18,20};
		s.CreateR(b);
		k=15;
		System.out.println("有序顺序表的顺序查找: "+k+" 结果为"+s.SeqSearch3(k));
		
		
	}

	public static void main(String[] args)
	{
		//int[] a={8,14,6,9,10,22,34,18,19,31,40,38,54,66,46,71,78,68,80,85,100,94,88,96,87};
		//int[] a={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	
		int[] a={1,2,2,5,5,5,6};
		SqListSearchClass s=new SqListSearchClass();
		s.CreateR(a);
		System.out.print("R: ");s.Disp();
		
		//IdxType[] I=new IdxType[100];
		//int b=7;
		//s.CreateI(I,b);									//创建索引表
		//System.out.println("索引表I:");
		//for (int i=0;i<b;i++)
		//	System.out.println("   link="+I[i].link+",key="+I[i].key);
		//int k=22;
		//System.out.println("  k="+k+"  结果为"+s.IdxSearch(I,b,k));
		
		
		int k=2;
		//System.out.println("第一个  "+k+"  结果为"+s.Firstequalsk(k));
		//System.out.println("最后一个"+k+"  结果为"+s.Lastequalsk(k));
		//int[] v=new int[2];
		//v=s.Intervalk(k);
		//System.out.println("k="+k+"  结果为["+v[0]+","+v[1]+"]");
		System.out.println("第一个大于或者等于k="+k+"的位置="+s.GOEk(k));
	}
	*/
	public static void main(String[] args)
	{
		int[] a={1,3,5};
		SqListSearchClass s=new SqListSearchClass();
		s.CreateR(a);
		System.out.print("R: ");s.Disp();
		int k=4;
		System.out.println("k="+k+" 结果:"+s.BSearch2(k));
	}

}
