package myleetcode;

public class RemoveDuplicates {
	public int removeDuplicates(int[] nums){
		int i=1;
		int j=0;
		while(i<nums.length){
			if(nums[j]!=nums[i]){
				if(j+1!=i)
					nums[j+1] = nums[i];
				j++;
			}
			i++;
		}
		return j+1;
	}
	
}
