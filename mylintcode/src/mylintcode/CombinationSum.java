package mylintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
		 if(candidates==null || candidates.length==0)
			 return new ArrayList<List<Integer>>();
		 Arrays.sort(candidates);
		 if(target<candidates[0])
			 return new ArrayList<List<Integer>>();
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 List<Integer> curR = new ArrayList<Integer>();
		 helper(candidates, 0, target, result, curR);
		 return result;
			 
	 }
	 
	 void helper(int[] candidates, int start, int remainSum, List<List<Integer>> result, List<Integer> curR){
		 if(remainSum ==0){
			 List<Integer> curR_copy = new ArrayList<Integer>();
			 curR_copy.addAll(curR);
			 result.add(curR_copy);
			 return;
		 }
		 if(start>=candidates.length)
			 return;
		 int i=start;
		 int j = i+1;
		 while(j<candidates.length && candidates[j] == candidates[i])
			 j++;
		 int k=0;
		 while(k*candidates[i]<=remainSum){
			 for(int p=0; p<k; p++)
				 curR.add(candidates[i]);
			 helper(candidates, j, remainSum-k*candidates[i], result, curR);
			 for(int p=0; p<k; p++)
				 curR.remove(curR.size()-1);
			 k++;
		 }
		 return;
	 }

}
