package mylintcode;

public class LCA3 {
	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
		search(root, A, B);
		return lca;
	}
	
	TreeNode lca = null;
	public int search(TreeNode root, TreeNode A, TreeNode B){
		if(root== null)
			return 0;
		if(root ==A && root == B){
			lca = root;
			return 2;
		}
		else if(root == A || root == B){
			int findnodes = 1;
			findnodes += search(root.left, A, B);
			if(findnodes<2)
				findnodes += search(root.right, A, B);
			if(findnodes==2)
				lca = root;
			return findnodes;		
		}
		else{
			int findnodesL = 0;
			int findnodesR = 0;
			findnodesL += search(root.left, A, B);
			if(findnodesL <2){
				findnodesR += search(root.right, A, B);
			}
			if(findnodesL ==1 && findnodesR ==1)
				lca = root;
			return findnodesL+ findnodesR;
		}
		
	}

}
