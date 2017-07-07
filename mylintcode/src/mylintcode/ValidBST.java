package mylintcode;

public class ValidBST {
	public boolean isValidBST(TreeNode root) {
		helper(root);
		return isBST;
	}
	
	boolean isBST = true;
	public class retValue{
		int max;
		int min;
		public retValue(int a, int b){
			max =a;
			min = b;
		}
	}
	public retValue helper(TreeNode root){
		if(root == null)
			return new retValue(Integer.MIN_VALUE, Integer.MAX_VALUE);
		retValue left = helper(root.left);
		retValue right = helper(root.right);
		if(root.left != null && left.max >= root.val) 
			isBST = false;
		if(root.right != null && right.min <= root.val)
			isBST = false;
		int max, min;
		max = min = root.val;
		max = Math.max(max, Math.max(left.max, right.max));
		min = Math.min(min, Math.min(left.min, right.min));
		return new retValue(max, min);
	}

}
