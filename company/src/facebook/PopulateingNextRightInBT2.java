package facebook;

public class PopulateingNextRightInBT2 {
	 public void connect(TreeLinkNode root) {
	        if(root == null)
	            return;
	        TreeLinkNode levelHead = root;
	        TreeLinkNode p = levelHead;
	        TreeLinkNode pre = null;
	        while(levelHead != null){
	            p = levelHead;
	            pre = null;
	            levelHead = null;
	            while(p != null){
	                if(p.left != null){
	                    if(pre != null)
	                        pre.next = p.left;
	                    if(levelHead == null)
	                        levelHead = p.left;
	                    pre = p.left;
	                }
	                if(p.right != null){
	                    if(pre != null)
	                        pre.next = p.right;
	                    if(levelHead == null)
	                        levelHead = p.right;
	                    pre = p.right;
	                }
	                p = p.next;
	            }
	        }
	        return;
	    }

}
