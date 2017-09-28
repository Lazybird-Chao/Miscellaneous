package facebook;

public class BTLevelOrderTraverse {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList<Integer>();
            for(int i= 0; i<size; i++){
                TreeNode cur = q.poll();
                l.add(cur.val);
                if(cur.left != null)
                    q.offer(cur.left);
                if(cur.right != null)
                    q.offer(cur.right);
            }
            res.add(l);
        }
        return res;
    }

}
