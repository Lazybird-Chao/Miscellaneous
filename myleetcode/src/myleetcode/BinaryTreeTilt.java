package myleetcode;

public class BinaryTreeTilt {
	public class retValue{
		int sum;
		int tilt;
	}
	public int findTilt(TreeNode root){
		retValue s = sum(root);
		return s.tilt;
	}
	
	retValue sum(TreeNode root){
		retValue ret = new retValue();
		if(root==null){
			ret.sum = 0;
			ret.tilt = 0;
			return ret;
		}
		ret.sum = root.val;
		int leftsum=0, lefttilt=0;
		int rightsum=0, righttilt=0;
		if(root.left != null){
			retValue leftret= sum(root.left);
			leftsum = leftret.sum;
			lefttilt = leftret.tilt;
		}
		if(root.right != null){
			retValue rightret= sum(root.right);
			rightsum = rightret.sum;
			righttilt = rightret.tilt;
		}
		ret.sum += leftsum+rightsum;
		ret.tilt = Math.abs(leftsum-rightsum) + lefttilt + righttilt;	
		
		return ret;
	}

}
