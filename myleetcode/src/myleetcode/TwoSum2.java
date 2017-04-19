package myleetcode;

public class TwoSum2 {
	public int[] twoSum(int[] numbers, int target){
		if(target < numbers[0])
			return new int[0];
		int[] res = new int[2];
		for(int i=0; i<numbers.length; i++){
			if(numbers[i] <= target/2){
				int tmp = binarySearch(numbers, i+1, numbers.length-1, target-numbers[i]);
				if( tmp  != -1){
					res[0] = i+1;
					res[1] = tmp+1;
					return res;
				}
			}
			else
				break;
		}
		return new int[0];
	}
	
	public int binarySearch(int[]nums, int start, int end, int target){
		if(start <0 || end > nums.length-1)
			return -1;
		if(target>nums[end] || target <nums[start])
			return -1;
		int mid = start + (end-start)/2;
		while(start <= end){
			if(nums[mid] == target)
				break;
			else if(nums[mid] > target)
				end = mid-1;
			else
				start = mid+1;
			mid = start + (end-start)/2;
		}
		if(start<=end)
			return mid;
		else
			return -1;
	}
	
	public int[] method2(int[] numbers, int target){
		if(target < numbers[0])
			return new int[0];
		int[] res = new int[2];
		int i=0;
		int j= numbers.length-1;
		while(i<j){
			if(numbers[i]+numbers[j] == target)
				break;
			else if(numbers[i]+numbers[j] > target)
				j--;
			else
				i++;
		}
		if(i<j){
			res[0] = i+1;
			res[1] = j+1;
			return res;
		}
		else
			return new int[0];
	}
}
