package myleetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
	public boolean containsNearbyDuplicate(int[] nums, int k){
		for(int i=0; i<nums.length-k; i++){
			for(int j=i+1; j<=k+i; j++)
				if(nums[i]==nums[j])
					return true;
		}
		return false;
	}
	
	public boolean method2(int[] nums, int k){
		Set<Integer> window = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++){
			if(i>k){
				window.remove(nums[i-k-1]);
			}
			if(window.add(nums[i]) == false)
				return true;
		}
		return false;
	}
}
