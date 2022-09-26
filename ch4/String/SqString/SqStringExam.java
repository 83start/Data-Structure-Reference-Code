public class SqStringExam
{
	public static void main(String[] args)
	{  
		
		char [] cstr1={'a','b','c','d'};
		char [] cstr2={'1','2','3'};
		SqStringClass s1=new SqStringClass();
		s1.StrAssign(cstr1);
		System.out.println("s1: "+s1.toString());
		System.out.println("s1的长度: "+ s1.size());
		SqStringClass s2=new SqStringClass();
		s2.StrAssign(cstr2);
		System.out.println("s2: "+s2.toString());
		System.out.println("s2的长度: "+ s2.size());
		SqStringClass s3;
		System.out.println("s1=>s3");
		s3=s1.StrCopy();
		System.out.println("s3: "+s3.toString());
		SqStringClass s4;
		System.out.println("s1和s2连接=>s4");
		s4=s1.Concat(s2);
		System.out.println("s4: "+s4.toString());
		SqStringClass s5;
		System.out.println("s4[2..5]=>s5");
		s5=s4.SubStr(2,5);
		System.out.println("s5: "+s5.toString());
		SqStringClass s6;
		System.out.println("s4中序号2位置插入s2=>s6");		
		s6=s4.InsStr(2,s2);
		System.out.println("s6: "+s6.toString());

		SqStringClass s7;
		System.out.println("s6中删除[2,3]=>s7");		
		s7=s6.DelStr(2,3);
		System.out.println("s7: "+s7.toString());


		SqStringClass s8;
		System.out.println("s6中[2,3]替换为s1=>s8");		
		s8=s6.RepStr(2,3,s1);
		System.out.println("s8: "+s8.toString());

/*
		s5=s3.SubStr(2,4);
		System.out.println( << "s5:"; s5.DispStr();
		System.out.println( << "从s3中删除s3[3..6]字符=>s6\n";
		s6=s3.DelStr(3,4);
		System.out.println( << "s6:"; s6.DispStr();
		System.out.println( << "将s4[2..4]替换成s1=>s7\n";
		s7=s4.RepStr(2,3,s1);
		System.out.println( << "s7:"; s7.DispStr();
		System.out.println( << "main函数结束,销毁所有的串对象" << endl;
		*/
	}
}