package google;

class FindModeInBST{
  public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[0];
        ArrayList<Integer> res = new ArrayList<Integer>();
        int maxfreq = 0;
        int preval = 0;
        int prefreq = 0;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode r = root;
        while(true){
            while(r != null){
                s.push(r);
                r = r.left;
            }
            if(s.isEmpty ())
                break;
            r = s.pop();
            if(prefreq !=0 && preval == r.val){
                prefreq++;
            }else{
                prefreq = 1;
                preval = r.val;
            }
            if(res.isEmpty()){
                maxfreq = prefreq;
                res.add(preval);
            }else if(maxfreq == prefreq){
                res.add(preval);
            }else if(maxfreq < prefreq){
                res.clear();
                res.add(preval);
                maxfreq = prefreq;
            }
            r = r.right;
        }
        int[] res2 = new int[res.size()];
        for(int i=0; i<res.size(); i++)
            res2[i] = res.get(i);
        return res2;
    }
}
