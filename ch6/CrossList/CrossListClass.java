import java.util.*;
@SuppressWarnings("unchecked")
class CNode 					//十字链表结点类
{	int i;						//行号
	int j;						//列号
	CNode right,down;			//向右和向下的指针
	boolean tag;				//tag为true表示头结点，为false为元素结点
	int value;					//存放非零元素值
	CNode link;					//头结点指针
	public CNode(int i1,int j1,boolean tag1)
	{
		i=i1;
		j=j1;
		tag=tag1;
		right=down=link=null;
	}
}
public class CrossListClass
{
}