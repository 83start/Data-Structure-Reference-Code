@SuppressWarnings("unchecked")
public class HuffmanExam
{
	public static void main(String[] args)
	{
		HuffmanClass hbt=new HuffmanClass();
		String str="abcd";
		double[] w={1,3,5,7};
		int n0=str.length();
		hbt.Setdata(n0,w,str);
		hbt.CreateHT();
		hbt.CreateHCode();
		hbt.DispHuffman();
	}
}
