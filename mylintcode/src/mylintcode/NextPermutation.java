package mylintcode;

public class NextPermutation {
	public int[] nextPermutation(int[] nums) {
		if(nums==null || nums.length==0)
			return new int[0];
		
		int[] res = new int[nums.length];
		int assendStart = nums.length-1;
		int assendEnd = assendStart-1;
		while(assendEnd>=0) {
			if(nums[assendEnd]<nums[assendEnd+1])
				break;
			assendEnd--;
		}
		if(assendEnd<0) {
			for(int i=0; i<nums.length; i++)
				res[i] = nums[nums.length-1-i];
			return res;
		}
		for(int i=0; i<assendEnd; i++)
			res[i] = nums[i];
		int exchangePos = assendEnd+1;
		for(int i=assendStart; i>assendEnd;i--) {
			if(nums[i]>nums[assendEnd]) {
				exchangePos = i;
				break;
			}
		}
		int tmp = nums[exchangePos];
		nums[exchangePos] = nums[assendEnd];
		nums[assendEnd] = tmp;
		res[assendEnd] = nums[assendEnd];
		for(int i= assendEnd+1; i<nums.length; i++)
			res[i] = nums[nums.length+assendEnd-i];
		
		return res;
	}

}
