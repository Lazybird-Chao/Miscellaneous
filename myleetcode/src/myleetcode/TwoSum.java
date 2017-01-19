package myleetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target){
		int[] ret = new int[2];
		Map<Integer, Integer> nummap = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++)
			nummap.put(nums[i], i);
		for(int i=0; i<nums.length; i++){
			if(nummap.containsKey(target-nums[i])){
				ret[0] = i;
				ret[1] = nummap.get(target-nums[i]);
				if(ret[0] == ret[1]){
        			for(int j=0; j<nums.length-1; j++){
        				if(nums[j] == nums[ret[0]] && j != ret[0]){
        					ret[1] = j;
        					break;
        				}
        			}
        			
        		}
        		if(ret[0]!=ret[1])
        			    break;
        	    else
        	        ret[0]=ret[1]=0;
			}
		}
		
		return ret;
	}
	
	public int[] method2(int[] nums, int target){
		int[] ret = new int[2];
		Map<Integer, Integer> nummap = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++){
			if(nummap.containsKey(target-nums[i])){
				ret[0] = i;
				ret[1] = nummap.get(target-nums[i]);
				break;
			}
			nummap.put(nums[i],i);
		}
		return ret;
	}
}
