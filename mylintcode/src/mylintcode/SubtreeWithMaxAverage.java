package mylintcode;


public class SubtreeWithMaxAverage {
	public TreeNode findSubtree2(TreeNode root) {
		if(root == null)
			return null;
		retValue ret = helper(root);
		return ret.maxSubtree;
	}
	
	public class retValue{
		int sum;
		int nodes;
		TreeNode maxSubtree;
		int maxsum;
		int maxnodes;
		public retValue(int a, int b, TreeNode r, int s, int n){
			sum = a;
			nodes = b;
			maxSubtree = r;
			maxsum = s;
			maxnodes = n;
		}
	}
	
	public retValue helper(TreeNode root){
		if(root == null)
			return new retValue(0,0, null,0,0);
		retValue leftsum = helper(root.left);
		retValue rightsum = helper(root.right);
		retValue ret = new retValue(root.val, 1, root, 0, 0);
		ret.sum += leftsum.sum + rightsum.sum;
		ret.nodes += leftsum.nodes + rightsum.nodes;
		ret.maxSubtree = root;
		ret.maxsum = ret.sum;
		ret.maxnodes = ret.nodes;
		if(ret.maxsum * leftsum.maxnodes < leftsum.maxsum * ret.maxnodes){
			ret.maxsum = leftsum.maxsum;
			ret.maxnodes = leftsum.maxnodes;
			ret.maxSubtree = leftsum.maxSubtree;
		}
		if(ret.maxsum * rightsum.maxnodes < rightsum.maxsum * ret.maxnodes){
			ret.maxsum = rightsum.maxsum;
			ret.maxnodes = rightsum.maxnodes;
			ret.maxSubtree = rightsum.maxSubtree;
		}
		return ret;
	}

}
