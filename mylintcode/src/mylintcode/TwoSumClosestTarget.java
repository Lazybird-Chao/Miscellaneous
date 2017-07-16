package mylintcode;

import java.util.Arrays;

public class TwoSumClosestTarget {
	 public int twoSumClosest(int[] nums, int target) {
		 if(nums==null || nums.length==0)
			 return 0;
		 Arrays.sort(nums);
		 int i,j;
		 i=0;
		 j=nums.length-1;
		 int mindiff = Math.abs(nums[j]+nums[i] -target);
		 while(i<j){
			 int sum = nums[i]+nums[j];
			 if(sum == target){
				 mindiff = 0;
				 break;
			 }
			 else if(sum > target){
				 j--;
				 mindiff = Math.min(mindiff, sum-target);
			 }
			 else{
				 i++;
				 mindiff = Math.min(mindiff, target-sum);
			 }
		 }
		 return mindiff;
	 }

}
