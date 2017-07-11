package mylintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		if(num==null || num.length==0)
			return new ArrayList<List<Integer>>();
		Arrays.sort(num);
		if(target<num[0])
			return new ArrayList<List<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> curR = new ArrayList<Integer>();
		helper(num, 0, result, curR, target);
		return result;
	}
	
	public void helper(int[] num, int start, List<List<Integer>> result, List<Integer> curR, int restSum){
		if(restSum ==0){
			result.add(curR);
			return;
		}
		if(start >= num.length){
			return;
		}
		
		int i=start;
		while(i<num.length){
    		int j=i+1;
    		while(j<num.length && num[j]==num[i])
    			j++;
    		int k=j-i;
    		while(i<j){
    			if(num[i]*k <=restSum){
    				List<Integer> curR_copy = new ArrayList<Integer>();
    				curR_copy.addAll(curR);
    				for(int p=0; p<k;p++)
    					curR_copy.add(num[i]);
    				helper(num, j, result, curR_copy, restSum-num[i]*k);
    			}
    			k--;
    			i++;
    		}
		}
		return;
		
	}

}
