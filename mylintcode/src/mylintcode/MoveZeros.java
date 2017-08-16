package mylintcode;

public class MoveZeros {
	 public void moveZeroes(int[] nums) {
		 if(nums==null || nums.length==0)
			 return;
		 int i,j;
		 i=j=0;
		 while(j<nums.length) {
			 if(nums[j]==0) {
				 ++j;
				 continue;
			 }
			 int tmp = nums[j];
			 nums[j] = nums[i];
			 nums[i] = tmp;
			 ++i;
			 ++j;
		 }
		 return;
	 }

}
