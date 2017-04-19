package myleetcode;

public class RelativeRanks {
	public String[] findRelativeRanks(int[] nums){
		if(nums==null || nums.length==0)
			return new String[0];
		int max, min;
		max = min = nums[0];
		for(int i=1; i<nums.length; i++){
			if(max < nums[i])
				max = nums[i];
			else if(min > nums[i])
				min = nums[i];
				
		}
		int[] harray = new int[max-min+1];
		for(int i=0; i<harray.length; i++)
			harray[i] = -1;
		for(int i=0; i<nums.length; i++){
			harray[max-nums[i]] = i;
		}
		String[] ret = new String[nums.length];
		int rank = 1;
		for(int i=0; i<harray.length; i++){
			if(harray[i]!=-1){
				switch (rank){
				case 1:
					ret[harray[i]] = new String("Gold Medal");
					break;
				case 2:
					ret[harray[i]] =  new String("Silver Medal");
					break;
				case 3:
					ret[harray[i]] = new String("Bronze Medal");
					break;
				default:
					ret[harray[i]] = Integer.toString(rank);
				}
				rank++;
			}
		}
		return ret;
	}
}
