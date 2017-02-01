package myleetcode;

import java.util.Arrays;

public class MiniMovesToEqualArray2 {
	public int minMoves2(int[] nums){
		int min, max;
		min = max = nums[0];
		for(int i=1; i<nums.length; i++){
			if(min>nums[i])
				min = nums[i];
			else if(max<nums[i])
				max = nums[i];
		}
		int minMove = Integer.MAX_VALUE;
		for(int k=min; k<=max; k++){
			int tmp=0;
			for(int i=0; i<nums.length; i++)
				tmp += Math.abs(nums[i]-k);
			if(minMove>tmp)
				minMove = tmp;
		}
		return minMove;
	}
	
	public int method2(int[] nums){
		Arrays.sort(nums);
		int minMove=0;
		int i=0;
		int j=nums.length-1;
		while(i<j){
			minMove += nums[j]-nums[i];
			i++;
			j--;
		}
		return minMove;
	}
}
