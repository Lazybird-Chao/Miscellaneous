package facebook;

public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length ==0)
            return 0;
        int[][] r = new int[nums.length][m+1];
        return helper(nums, 0, m, r);
    }
    
    public int helper(int[] nums, int index, int m , int[][]record){
        if(nums.length - index < m)
            return -1;
        if(record[index][m] > 0)
            return record[index][m];
        if(m == 1){
            int sum = 0;
            for(int i = index; i < nums.length; i++)
                sum += nums[i];
            record[index][m] = sum;
            return sum;
        }else{
            int min = Integer.MAX_VALUE;
            int cur = nums[index];
            for(int i = index+1; i < nums.length; i++){
                int tmp = helper(nums, i, m-1, record);
                if(tmp > 0)
                    min = Math.min(min, Math.max(cur, tmp));
                cur += nums[i];
            }
            record[index][m] = min;
            return min;
        }
    }

}
