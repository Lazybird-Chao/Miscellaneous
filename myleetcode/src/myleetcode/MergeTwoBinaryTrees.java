package myleetcode;

public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
		TreeNode merged;
		if(t1==null)
			return t2;
		else if(t2==null)
			return t1;
		else{
			t1.val += t2.val;
			merged = t1;
		}
		
		merged.left = mergeTrees(t1.left, t2.left);
		merged.right = mergeTrees(t1.right, t2.right);
		
		return merged;
		
	}
	

}
