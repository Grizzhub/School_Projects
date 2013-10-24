
public class BinaryNode {
	public int data;
	BinaryNode left, right;

	BinaryNode(int data)
	{
		this(data, null, null);
	}
	
	public BinaryNode(int num, BinaryNode ln, BinaryNode rn)
	{
		data = num;
		left = ln;
		right = rn;
	}
	
	public int getData(){
		return data;
	}
	
	static int nodeCount(BinaryNode n)
	{
		if(n==null) return 0;
		else
			return 1+nodeCount(n.left)+nodeCount(n.right);
	}
	
	static int height(BinaryNode n)
	{
		if(n==null) return -1;
		else
			return 1+Math.max(height(n.left), height(n.right));
	}

}
