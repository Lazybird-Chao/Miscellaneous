package mylintcode;

public class PartitionArray {
	public int partitionArray(int[] nums, int k) {
		if(nums == null || nums.length ==0)
			return 0;
		
		int i,j;
		i = 0;
		j = nums.length-1;
		while(i<=j){
			while(i<=j && nums[i]<k)
				i++;
			while(i<=j && nums[j]>=k)
				j--;
			if(i<=j){
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
				j--;
			}
		}
		if(i<nums.length)
			return i;
		else
			return nums.length;
	}

}
