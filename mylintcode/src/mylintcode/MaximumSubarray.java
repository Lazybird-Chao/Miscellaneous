package mylintcode;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if(nums==null || nums.length ==0)
			return 0;
		retValue res=helper(nums, 0, nums.length-1);
		return Math.max(res.max, Math.max(res.left, res.right));
		
	}
	
	public class retValue{
		int left;
		int right;
		int sum;
		int max;
		retValue(int l, int r, int s, int m){
			left = l;
			right = r;
			sum = s;
			max = m;
		}
	}
	
	public retValue helper(int[] nums, int start, int end){
		if(start == end){
			return new retValue(nums[start], nums[start], nums[start], nums[start]);
		}
		int mid = start+(end-start)/2;
		retValue leftR = helper(nums, start, mid);
		retValue rightR = helper(nums, mid+1, end);
		int left =  Math.max(leftR.left, leftR.sum+rightR.left);
		int right = Math.max(rightR.right, rightR.max+leftR.right);
		int sum = leftR.sum + rightR.sum;
		int max = Math.max(leftR.max, rightR.max);
		max = Math.max(max, leftR.right+rightR.left);
		return new retValue(left, right, sum, max);
	}
	
	
	public int method2(int[] nums){ 
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
	}
	
	public int method3(int[] nums){
		if (nums == null || nums.length == 0){
            return 0;
        }
		int max= nums[0];
		int sum = 0;
		for(int i=0; i<nums.length; i++){
			sum += nums[i];
			max = Math.max(max, sum);
			if(sum<0)
				sum = 0;
		}
		return max;
	}
    
}
	

