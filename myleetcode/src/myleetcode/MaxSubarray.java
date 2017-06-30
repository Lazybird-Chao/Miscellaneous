package myleetcode;

public class MaxSubarray {
	public int maxSubArray(int[] nums){
		if(nums==null || nums.length==0)
			return 0;
		int maxsum = nums[0];
		int tmpsum = 0;
		for(int i=0; i<nums.length; i++){
			tmpsum += nums[i];
			maxsum = Math.max(maxsum, tmpsum);
			if(tmpsum<0){
				tmpsum = 0;
			}
				
		}
		return maxsum;
	}
	
	public int method2(int[] nums){
		retValue r = helper(nums, 0, nums.length-1);
		return r.m;
	}
	
	public class retValue{
		int l;  //max sum start with left
		int m;  //max sum in the array
		int r;  //max sum end with right
		int s;  //total sum
		retValue(int a, int b, int c, int d){
			l=a;
			m=b;
			r=c;
			s=d;
		}
	}
	
	retValue helper(int[]nums, int begin, int end){
		if(begin==end)
			return new retValue(nums[begin],nums[begin],nums[begin],nums[begin]);
		int mid = begin+(end-begin)/2;
		retValue r1 = helper(nums, begin, mid);
		retValue r2 = helper(nums, mid+1, end);
		retValue r = new retValue(0,0,0,0);
		r.l = Math.max(r1.l, r1.s + r2.l);
		r.r = Math.max(r2.r, r2.s + r1.r);
		r.m = Math.max(Math.max(r1.m, r2.m), r1.r + r2.l);
		r.s = r1.s + r2.s;
	
		return r;
	}
}
