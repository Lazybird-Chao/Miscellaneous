package mylintcode;

public class MinimumSubtree {
	public TreeNode findSubtree(TreeNode root) {
		retValue ret = helper(root);
		return ret.minTree;
	}
	
	public class retValue{
		int sum;
		int minsum;
		TreeNode minTree;
		public retValue(int a, int b, TreeNode r){
			sum = a;
			minsum =b;
			minTree = r;
		}
	}
	
	public retValue helper(TreeNode root){
		if(root==null)
			return new retValue(0, Integer.MAX_VALUE, null);
		retValue leftsum = helper(root.left);
		retValue rightsum = helper(root.right);
		retValue ret = new retValue(root.val, Integer.MAX_VALUE, null);
		ret.sum += leftsum.sum + rightsum.sum;
		ret.minsum = ret.sum;
		ret.minTree = root;
		if(ret.minsum > leftsum.minsum){
			ret.minsum = leftsum.minsum;
			ret.minTree = leftsum.minTree;
		}
		if(ret.minsum > rightsum.minsum){
			ret.minsum = rightsum.minsum;
			ret.minTree = rightsum.minTree;
		}
		return ret;
	}

}
