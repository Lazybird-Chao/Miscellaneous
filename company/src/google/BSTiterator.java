package google;

public class BSTiterator {
	public class BSTIterator {

	    Stack<TreeNode> path;
	    TreeNode root;
	    public BSTIterator(TreeNode root) {
	        this.root = root;
	        path = new Stack<TreeNode>();
	        TreeNode p = root;
	        while(p != null){
	            path.push(p);
	            p = p.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        if(!path.isEmpty())
	            return true;
	        else
	            return false;
	    }

	    /** @return the next smallest number */
	    public int next() {
	        TreeNode cur = path.pop();
	        int ret = cur.val;
	        if(cur.right != null){
	            cur = cur.right;
	            while(cur != null){
	                path.push(cur);
	                cur = cur.left;
	            }
	        }
	        return ret;
	    }
	}

}
