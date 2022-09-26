class BSTNode									//二叉排序树结点类
{	public int key;								//存放关键字,假设关键字为int类型
	public BSTNode lchild;						//存放左孩子指针
	public BSTNode rchild;						//存放右孩子指针
	BSTNode()									//构造方法
	{
		lchild=rchild=null;
	}
}
public class BSTClass							//二叉排序树类
{
	public BSTNode r;   						//二叉排序树根结点
	private BSTNode f;      					//用于存放待删除结点的双亲结点

	public BSTClass()							//构造方法
	{
		r=null;
	}
	//二叉排序树的基本运算算法	
	public void InsertBST(int k) 				//插入一个关键字为k的结点
	{
		InsertBST1(r,k);		
	}
	
	private BSTNode InsertBST1(BSTNode p,int k) //在以p为根的BST中插入关键字为k的结点
	{	if (p==null)							//原树为空,新插入的元素为根结点
		{	p=new BSTNode();
			p.key=k;
		}
		else if (k<p.key) 
			p.lchild=InsertBST1(p.lchild,k);	//插入到p的左子树中
		else if (k>p.key)
			p.rchild=InsertBST1(p.rchild,k);	//插入到p的右子树中
		return p;
	}
	public void CreateBST(int[] a)				//由关键字序列a创建一棵二叉排序树
	{
		r=new BSTNode();						//创建根结点
		r.key=a[0];
		for (int i=1;i<a.length;i++)			//创建其他结点
		{
			InsertBST1(r,a[i]);					//插入关键字a[i]
			System.out.print("插入"+a[i]+"，BST: "); DispBST(); System.out.println(); 
		}
	}
	public void DispBST()						//输出二叉排序树的括号表示串
	{
		DispBST1(r);
	}
	private void DispBST1(BSTNode p)			//被DispBST方法调用
	{	if (p!=null)
		{
			System.out.print(p.key);			//输出根结点值
			if (p.lchild!=null || p.rchild!=null)
			{	System.out.print("(");			//有孩子结点时才输出“(”
				DispBST1(p.lchild);				//递归处理左子树
				if (p.rchild!=null)
					System.out.print(",");		//有右孩子结点时才输出“,”
				DispBST1(p.rchild);				//递归处理右子树
				System.out.print(")");			//有孩子结点时才输出“)”
			}
		}
	}
	
	public BSTNode SearchBST(int k)				//在二叉排序树中查找关键字为k的结点
	{
		return SearchBST1(r,k);					//r为二叉排序树的根结点
	}
	private BSTNode SearchBST1(BSTNode p,int k)	//被SearchBST方法调用
	{
		if (p==null) return null;				//空树返回null
		if (p.key==k) return p;					//找到后返回p
		if (k<p.key)
			return SearchBST1(p.lchild,k);		//在左子树中递归查找
		else
			return SearchBST1(p.rchild,k);		//在右子树中递归查找
	}

	public boolean DeleteBST(int k)				//删除关键字为k的结点
	{
		f=null;
        return DeleteBST1(r,k,-1);						//r为二叉排序树的根结点
    }

    private boolean DeleteBST1(BSTNode p,int k,int flag)	//被DeleteBST方法调用，flag=0，p为双亲f的左孩子，flag=1，p为双亲f的右孩子
	{
		if (p==null)
			return false;						//空树返回false
		if (p.key==k)
			return DeleteNode(p,f,flag);		//找到后删除p结点
		if (k<p.key)
		{
			f=p;
			return DeleteBST1(p.lchild,k,0);	//在左子树中递归查找
		}
		else
		{
			f=p;
			return DeleteBST1(p.rchild,k,1);	//在右子树中递归查找
		}
	}

    private boolean DeleteNode(BSTNode p,BSTNode f,int flag)	//删除结点p（其双亲为f）
	{	
        if (p.rchild==null)						//结点p只有左孩子(含p为叶子的情况)：将p的左孩子替代p
		{
			if (flag==-1)						//结点p的双亲为空(p为根结点)
				r=p.lchild;						//修改根结点r为p的左孩子
            else if (flag==0)					//p为双亲f的左孩子
				f.lchild=p.lchild;				//将f的左孩子置为p的左孩子
			else								//p为双亲f的右孩子
				f.rchild=p.lchild;				//将f的右孩子置为p的左孩子
        }
        else if (p.lchild==null)				//结点p只有右孩子：将p的右孩子替代p
		{
			if (flag==-1)						//结点p的双亲为空(p为根结点)
				r=p.rchild;						//修改根结点r为p的右孩子
            else if (flag==0)					//p为双亲f的左孩子
				f.lchild=p.rchild;				//将f的左孩子置为p的左孩子
			else								//p为双亲f的右孩子
				f.rchild=p.rchild;				//将f的右孩子置为p的左孩子
        }
        else                            		//结点p有左右孩子
		{
            BSTNode f1=p;
            BSTNode q=p.lchild;             	//q转向结点p的左孩子
			if (q.rchild==null)					//若结点q没有右孩子
			{
				p.key=q.key;					//将被删结点p的值用q的值替代
				p.lchild=q.lchild;				//删除结点q
			}
			else								//若结点q有右孩子
			{		
				while (q.rchild!=null)   		//找到最右下结点q,其双亲结点为f1
				{
					f1=q;
					q=q.rchild;
				}
				p.key=q.key;					//将被删结点p的值用q的值替代
                f1.rchild=q.lchild;				//删除结点q
			}
        }
        return true;
    }
}