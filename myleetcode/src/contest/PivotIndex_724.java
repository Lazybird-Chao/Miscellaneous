package contest;

public class PivotIndex_724 {
	public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int[] sum = new int[nums.length];
        int pre = 0;
        for(int i = 0; i<nums.length; i++){
            sum[i] = nums[i] + pre;
            pre = sum[i];
        }
        int total = sum[nums.length-1];
        for(int i = 0; i<nums.length; i++){
            if(sum[i] - nums[i] == total - sum[i])
                return i;
        }
        return -1;
    }

}
