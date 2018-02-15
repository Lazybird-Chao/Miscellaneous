package google;

public class FindDuplicateSubtree {
	 public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	        if(root == null)
	            return new ArrayList<TreeNode>();
	        Map<String, TreeNode> subtrees = new HashMap<String, TreeNode>();
	        Map<String, TreeNode> duptrees = new HashMap<String, TreeNode>();
	        helper(root, subtrees, duptrees);
	        List<TreeNode> res = new ArrayList<TreeNode>();
	        for(String k : duptrees.keySet())
	            res.add(duptrees.get(k));
	        return res;
	    }
	    
	    String helper(TreeNode root, Map<String, TreeNode> subtrees, Map<String, TreeNode> duptrees){
	        if(root == null)
	            return "";
	        String cur = "";
	        cur = String.valueOf(root.val) + "(" + helper(root.left, subtrees, duptrees) + ","
	                                    + helper(root.right, subtrees, duptrees) + ")";
	        if(subtrees.containsKey(cur)){
	            duptrees.put(cur, subtrees.get(cur));
	        }else
	            subtrees.put(cur, root);
	        return cur;
	    }

}
