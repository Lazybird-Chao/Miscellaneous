package myleetcode;


public class MiniAbsoluteDiffInBST {
	public int getMinimumDifference(TreeNode root){
		if(root == null)
			return 0;
		TreeNode lchild = root.left;
		int lmin = 0;
		if(lchild !=null){
			while(lchild.right!=null)
				lchild = lchild.right;
			lmin = root.val-lchild.val;
			if(lmin<0)
				lmin *= -1;
		}
		else
			lmin = -1;
		TreeNode rchild = root.right;
		int rmin = 0;
		if(rchild !=null){
			while(rchild.left!=null)
				rchild = rchild.left;
			rmin = root.val-rchild.val;
			if(rmin<0)
				rmin *= -1;
		}
		else
			rmin = -1;
		
		int min;
		if(lmin==-1 )
			min= rmin;
		else if(rmin==-1 )
			min= lmin;
		else
			min= lmin<rmin?lmin:rmin;
		
		if(root.left!=null)
			lmin = getMinimumDifference(root.left);
		if(root.right!=null)
			rmin = getMinimumDifference(root.right);
		if(lmin!=-1)
			min = min<lmin ? min:lmin;
		if(rmin!=-1)
			min = min<rmin ? min:rmin;
		return min;
		
	}
}
