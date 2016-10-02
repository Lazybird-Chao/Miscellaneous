package myleetcode;
import myleetcode.InvertBtree.TreeNode;

public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root){
		if(root ==null)
			return 0;
		int sumInLeftChild = 0;
		int sumInRightChild = 0;
		if(root.left ==null)
			sumInLeftChild = 0;
		else if(root.left.left == null && 
				root.left.right== null)
			sumInLeftChild = root.left.val;
		else
			sumInLeftChild = sumOfLeftLeaves(root.left);
		
		if(root.right ==null)
			sumInRightChild = 0;
		else
			sumInRightChild = sumOfLeftLeaves(root.right);
		return sumInLeftChild + sumInRightChild;
	}

}
