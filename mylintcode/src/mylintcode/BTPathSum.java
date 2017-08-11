package mylintcode;

import java.util.ArrayList;
import java.util.List;

public class BTPathSum {
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
		if(root == null)
			return new ArrayList<List<Integer>>();
		List<List<Integer>> allPaths = new ArrayList<List<Integer>>();
		Path currentPath = new Path();
		helper(root, target, currentPath, allPaths);
		return allPaths;
	}
	
	public class Path{
		List<Integer> p;
		int sum;
		public Path(){
			p = new ArrayList<Integer>();
			sum = 0;
		}
	}
	
	public void helper(TreeNode root, int target, Path curp, List<List<Integer>> ret){
		if(root == null)
			return;
		if(root.left == null && root.right == null){
			if(curp.sum + root.val == target){
				curp.p.add(root.val);
				ret.add(curp.p);
			}
			return;
		}
		curp.sum += root.val;
		curp.p.add(root.val);
		Path leftp = new Path();
		
		leftp.sum = curp.sum;
		leftp.p.addAll(curp.p);
		helper(root.left, target, leftp, ret);
		
		Path rightp = new Path();
		rightp.sum = curp.sum;
		rightp.p.addAll(curp.p);
		helper(root.right, target, rightp, ret);
		
		return;
	}
	
	
	 public List<List<Integer>> method2(TreeNode root, int target) {
	        if(root==null)
	            return new ArrayList<List<Integer>>();
	        ans = new ArrayList<List<Integer>>();
	        List<Integer> path = new ArrayList<Integer>();
	        helper2(root, target, path);
	        return ans;
	        
    }
    List<List<Integer>> ans;
    
    public void helper2(TreeNode root, int target, List<Integer> path){
        if(root.left==null && root.right==null && target==root.val){
            List<Integer> pathCopy = new ArrayList<Integer>(path);
            pathCopy.add(root.val);
            ans.add(pathCopy);
            return;
        }
        path.add(root.val);
        if(root.left!=null)
            helper2(root.left, target-root.val, path);
        if(root.right!=null)
            helper2(root.right, target-root.val, path);
        path.remove(path.size()-1);
        return;
    }

}
