package mylintcode;

public class SortColors {
	public void sortColors(int[] nums) {
		if(nums==null || nums.length==0)
			return;
		
		int i, j, k;
		i=j=0;
		k=nums.length-1;
		while(j<=k) {
			if(nums[j]==0) {
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
				i++;
				j++;
			}
			else if(nums[j]==1) {
				j++;
			}
			else {
				while(j<k && nums[k]==2) {
					k--;
				}
				int tmp = nums[j];
				nums[j] = nums[k];
				nums[k] = tmp;
				k--;
			}
		}
		return;
	}

}
