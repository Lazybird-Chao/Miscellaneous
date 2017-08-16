package mylintcode;

public class PartitionArray2 {
	 public void partition2(int[] nums, int low, int high) {
		 if(nums==null || nums.length==0)
			 return;
		 int i,j,k;
		 i=j=0;
		 k=nums.length-1;
		 while(j<=k) {
			 if(nums[j]<low) {
				 if(i==j){
			         i++;
			         j++;
			     }
			     else{
    				 int tmp = nums[j];
    				 nums[j] = nums[i];
    				 nums[i] = tmp;
    				 ++i;
			     }
			 }
			 else if(nums[j]>high) {
				 int tmp = nums[j];
				 nums[j] = nums[k];
				 nums[k] = tmp;
				 ++j;
				 --k;
			 }
			 else
				 ++j;
		 }
		 return;
	 }

}
