package facebook;

public class BTVerticalTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<List<Integer>>();
        
        Queue<TreeNode> qnode = new LinkedList<TreeNode>();
        Queue<Integer> qpivot = new LinkedList<Integer>();
        List<List<Integer>> neg = new ArrayList<List<Integer>>();
        List<List<Integer>> posi = new ArrayList<List<Integer>>();
        neg.add(new ArrayList<Integer>());
        posi.add(new ArrayList<Integer>());
        qnode.offer(root);
        qpivot.offer(0);
        while(!qnode.isEmpty()){
            TreeNode cur = qnode.poll();
            int curPivot = qpivot.poll();
            if(curPivot < 0){
                if(-curPivot >= neg.size())
                    neg.add(new ArrayList<Integer>());
                neg.get(-curPivot).add(cur.val);
            } else{
                if(curPivot >= posi.size())
                    posi.add(new ArrayList<Integer>());
                posi.get(curPivot).add(cur.val);
            }
            if(cur.left!=null){
                qnode.offer(cur.left);
                qpivot.offer(curPivot-1);
            }
            if(cur.right != null){
                qnode.offer(cur.right);
                qpivot.offer(curPivot+1);
            }
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i= neg.size()-1; i>0; i--)
            res.add(neg.get(i));
        for(int i=0; i<posi.size(); i++)
            res.add(posi.get(i));
        
        return res;
        
    }

}
