package facebook;

public class SuccessorInBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null)
            return null;
        if(p.right != null){
            TreeNode r = p.right;
            while(r.left != null)
                r = r.left;
            return r;
        } else{
            TreeNode r = root;
            TreeNode suc = null;
            while(r != p && r != null){
                if(r.val > p.val){
                    suc = r;
                    r = r.left;  
                } else{
                    r = r.right;
                }
            }
            if(r == null)
                return null;
            else
                return suc;
        }
    }

}
