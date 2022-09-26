//@SuppressWarnings("unchecked")
public class Hanoi
{
	public static void Hanoi(int n,char X,char Y,char Z)
	{	if (n==1)				//只有一个盘片的情况
			System.out.printf("将第%d个盘片从%c移动到%c\n",n,X,Z);
		else					//有两个或多个盘片的情况
		{	Hanoi(n-1,X,Z,Y);
			System.out.printf("将第%d个盘片从%c移动到%c\n",n,X,Z);
			Hanoi(n-1,Y,X,Z);
		}
	}
	public static void main(String[] args)
	{
		Hanoi(3,'x','y','z');
	}	   
} 