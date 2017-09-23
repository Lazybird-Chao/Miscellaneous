package facebook;

public class BSTIterator {
	public class BSTIterator {

	    Stack<TreeNode> s;
	    TreeNode nextnode;
	    public BSTIterator(TreeNode root) {
	        s = new Stack<TreeNode>();
	        while(root != null){
	            s.push(root);
	            root = root.left;
	        }
	        nextnode = s.isEmpty() ? null : s.pop();
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return nextnode != null;
	        
	    }
	    
	    /** @return the next smallest number */
	    public int next() {
	        TreeNode tmp = nextnode.right;
	        while(tmp != null){
	            s.push(tmp);
	            tmp = tmp.left;
	        }
	        tmp = nextnode;
	        nextnode = s.isEmpty() ? null : s.pop();
	        return tmp.val;
	    }
	}


}
