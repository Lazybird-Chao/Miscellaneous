package myleetcode;

public class SingleNumber3 {
	public int[] singleNumber(int[] nums){
		int sum;
		sum = 0;
		for(int i=0; i<nums.length; i++)
			sum ^= nums[i];
		int bitpos=1;
		for(int i=0; i<32; i++){
			if((sum&bitpos)!=0){
				break;
			}
			bitpos = bitpos<<1;
		}
		int r1, r2;
		r1=r2=0;
		for(int i=0; i<nums.length; i++){
			if((nums[i]&bitpos)!=0)
				r1 ^= nums[i];
			else
				r2 ^= nums[i];
		}
		return new int[]{r1, r2};
	}
}
