public class SqStringClass				//顺序串类
{
	final int MaxSize=100;
	char [] data;					//存放串中字符
	int size;       				//串中字符个数
	public SqStringClass()			//构造方法
	{
		data=new char[MaxSize];
		size=0;
	}
	//串的基本运算算法
	public void StrAssign(char [] cstr)		//创建一个串
	{
		for (int i=0;i<cstr.length;i++)
			data[i]=cstr[i];
		size=cstr.length;
	}
	public SqStringClass StrCopy()			//串复制
	{
		SqStringClass s=new SqStringClass();
		for (int i=0;i<size;i++)
			s.data[i]=data[i];
		s.size=size;
		return s;
	}
	public int size()						//求串长
	{
		return size;
	}
	public char geti(int i)					//取序号i的字符
	{
		if (i<0 || i>size-1)
			throw new IllegalArgumentException("参数错误");
		return data[i];
	}
	public void seti(int i,char x)				//设置序号i的字符为x。
	{
		if (i<0 || i>size-1)
			throw new IllegalArgumentException("参数错误");
		data[i]=x;
	}
	public SqStringClass Concat(SqStringClass t) 	//串连接
	{
		SqStringClass s=new SqStringClass();	//新建一个空串
		s.size=size+t.size;
		for (int i=0;i<size;i++)				//将当前串data[0..str.size-1]→s
			s.data[i]=data[i];
		for (int i=0;i<t.size;i++)				//将t.data[0..t.size-1]→s
			s.data[size+i]=t.data[i];
		return s;								//返回新串s
	}
	public SqStringClass SubStr(int i,int j)	//求子串
	{
		SqStringClass s=new SqStringClass();	//新建一个空串
		if (i<0 || i>=size || j<0 || i+j>size)
			return s;							//参数不正确时返回空串
		for (int k=i;k<=i+j;k++)				//将data[i..i+j-1]→s
			s.data[k-i]=data[k];
		s.size=j;
		return s;								//返回新建的顺序串
	}
	public SqStringClass InsStr(int i,SqStringClass t)	//串插入
	{
		SqStringClass s=new SqStringClass();	//新建一个空串
		if (i<0 || i>size)						//参数不正确时返回空串
			return s;
		for (int j=0;j<i;j++)					//将当前串data[0..i-2]→s
			s.data[j]=data[j];
		for (int j=0;j<t.size;j++)				//将t.data[0..t.size-1]→s
			s.data[i+j]=t.data[j];
		for (int j=i;j<size;j++)				//将当前串data[i-1..size-1]→s
			s.data[t.size+j]=data[j];
		s.size=size+t.size;
		return s;								//返回新建的顺序串
	}
	public SqStringClass DelStr(int i,int j)	//串删除
	{
		SqStringClass s=new SqStringClass();	//新建一个空串
		if (i<0 || i>size || i+j>size)			//参数不正确时返回空串
			return s;
		for (int k=0;k<i;k++)					//将当前串data[0..i-2]ès
			s.data[k]=data[k];	
		for (int k=i+j;k<size;k++)				//将当前串data[i+j-1..size-1]→s
			s.data[k-j]=data[k];
		s.size=size-j;
		return s;								//返回新建的顺序串
	}
	public SqStringClass RepStr(int i,int j,SqStringClass t)	//串替换
	{
		SqStringClass s=new SqStringClass();	//新建一个空串
		if (i<0 || i>size || i+j>size)			//参数不正确时返回空串
			return s;
		for (int k=0;k<i;k++)					//将当前串data[0..i-2]ès
			s.data[k]=data[k];
		for (int k=0;k<t.size;k++)				//将s.data[0..s.size-1]→s
			s.data[i+k]=t.data[k];
		for (int k=i+j;k<size;k++)				//将当前串data[i+j-1..size-1]→s
			s.data[t.size+k-j]=data[k];
		s.size=size-j+t.size;
		return s;								//返回新建的顺序串
	}
	public String toString()					//将串转换为字符串。
	{
		String ans="";
		for (int i=0;i<size;i++)
			ans+=data[i];
		return ans;
	}
}
