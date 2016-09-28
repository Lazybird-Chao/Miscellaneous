package myleetcode;
import myleetcode.MaxDepthOfBtree.TreeNode;

public class LowestCommonAncestorOfBST {
	public TreeNode LowestCommonAncestor(TreeNode root,
										TreeNode p,
										TreeNode q){
		TreeNode small, large;
		if(p.val < q.val){
			small = p;
			large = q;
		}
		else{
			small = q;
			large = p;
		}
		
		TreeNode commNode = root;
		while(commNode != null){
			if(commNode == large ||
					commNode == small)
				break;
			if(commNode.val >= large.val)
				commNode = commNode.left;
			else if(commNode.val <= small.val)
				commNode = commNode.right;
			else
				break;
		}
		return commNode;
		
	}
}
