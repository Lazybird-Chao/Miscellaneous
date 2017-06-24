package myleetcode;

public class ConvertSortedArray2BST {
	public TreeNode sortedArrayToBST(int[] nums){
		if(nums==null || nums.length==0)
			return null;
		int start =0;
		int end = nums.length -1;
		return helper(nums, start, end); 
	}
	
	TreeNode helper(int[] nums, int start, int end){
		if(start>end)
			return null;
		int mid = start+(end-start)/2;
		TreeNode root = new TreeNode(nums[mid]);
		TreeNode left = helper(nums, start, mid-1);
		TreeNode right = helper(nums, mid+1, end);
		root.left = left;
		root.right = right;
		return root;
	}

}
