package myleetcode;
import java.util.HashMap;
import java.util.Arrays;

public class MajorityElement {
	public int majorityElement(int[] nums){
		int maxCount=0;
		int maxKey=0;
		HashMap<Integer, Integer> numCounts = new HashMap<Integer,Integer>();
		for(int i=0; i<nums.length; i++){
			int key = nums[i];
			int count = 0;
			if(numCounts.containsKey(key)){
				count = numCounts.get(key);
			}
			count++;
			if(count>maxCount){
				maxCount=count;
				maxKey = key;
			}
			numCounts.put(key, count);
		}
		return maxKey;
		
	}
	
	public int method2(int[] nums){
		Arrays.sort(nums);
		return nums[(nums.length/2)+1];
	}
	
	public int method3(int[] nums){
		int maxCount=0;
		int maxKey = 0;
		for(int i=0; i<nums.length; i++){
			if(maxCount==0){
				maxCount++;
				maxKey = nums[i];
			}
			else if(maxKey == nums[i]){
				maxCount++;
			}
			else
				maxCount--;
		}
		return maxKey;
	}
}
