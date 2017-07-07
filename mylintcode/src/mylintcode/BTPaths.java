package mylintcode;

import java.util.ArrayList;
import java.util.List;

public class BTPaths {
	public List<String> binaryTreePaths(TreeNode root) {
		if(root==null)
			return new ArrayList<String>();
		List<String> allPaths = new ArrayList<String>();
		String currentPath = "";
		helper(root, currentPath, allPaths);
		return allPaths;
		
	}
	
	public void helper(TreeNode root, String curP, List<String> allP){
		if(root == null)
			return;
		if(curP.isEmpty())
			curP = Integer.toString(root.val);
		else
			curP = curP + "->"+ Integer.toString(root.val);
		if(root.left ==null && root.right == null){
			allP.add(curP);
		}
		
		String leftp = new String(curP);
		helper(root.left, leftp, allP);
		String rightp = new String(curP);
		helper(root.right, rightp, allP);
		return;

	}

}
