package mylintcode;

public class KthSmallestNumbers {
	public int kthSmallest(int k, int[] nums) {
		if(nums==null || nums.length==0)
			return -1;
		
		return helper(nums, 0, nums.length-1, k-1);
	}
	
	public int helper(int[] nums, int start, int end, int k) {
		int pivot = nums[end];
		int i,j;
		i=j=start;
		while(j<end) {
			if(nums[j]<pivot) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				++i;
				++j;
			}
			else
				++j;
		}
		int tmp = nums[end];
		nums[end] = nums[i];
		nums[i] = tmp;
		
		if(i>k)
			return helper(nums, start, i-1, k);
		else if(i<k)
			return helper(nums, i, end, k);
		else
			return nums[i];
	}
	
	public int helper2(int[] nums, int start, int end, int k) {
		int pivot = nums[start+(end-start)/2];
		int i, j;
		i=start;
		j=end;
		while(i<=j) {
			while(i<=j && nums[i]<pivot)
				i++;
			while(i<=j && nums[j]>pivot)
				j--;
			if(i<=j) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
				j--;
			}
		}
		if(j>=k)
			return helper(nums, start, j, k);
		else if(i<=k)
			return helper(nums, i, end, k);
		else
			return nums[k];
	}

}
