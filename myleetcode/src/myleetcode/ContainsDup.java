package myleetcode;
import java.util.HashSet;
import java.util.Arrays;

public class ContainsDup {
	public boolean containsDuplicate(int[] nums){
		HashSet<Integer> numSet = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++){
			if(!numSet.add(nums[i]))
				return true;
		}
		return false;
	}
	
	public boolean method2(int[] nums){
		Arrays.sort(nums);
		for(int i=0; i<nums.length-1; i++)
			if(nums[i] == nums[i+1])
				return true;
		return false;
	}
}
