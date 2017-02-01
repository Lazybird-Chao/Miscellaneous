package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDupInArray {
	public List<Integer> findDuplicates(int[] nums){
		List<Integer> res = new ArrayList<Integer>();
		int i=0;
		while(i<nums.length){
			if(nums[i]!=i+1 && nums[i]!=0){
				int tmp = nums[i]-1;
				if(nums[tmp] == nums[i]){
					res.add(nums[i]);
					nums[i] = 0;
					i++;
				}
				else{
					nums[i] = nums[tmp];
					nums[tmp] = tmp+1;
				}
			}
			else
				i++;
		}
		return res;
	}
	
	public List<Integer> method2(int[] nums){
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0; i<nums.length; i++){
			int tmp  = Math.abs(nums[i])-1;
			if(nums[tmp]<0)
				res.add(tmp+1);
			else
				nums[tmp] = -nums[tmp];
		}
		return res;
	}
}
