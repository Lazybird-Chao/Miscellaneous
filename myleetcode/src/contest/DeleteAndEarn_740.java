package contest;

public class DeleteAndEarn_740 {
	public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> numC = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            if(numC.containsKey(nums[i]))
                numC.put(nums[i], numC.get(nums[i])+nums[i]);
            else
                numC.put(nums[i], nums[i]);
        }
        int[] uniqueNum = new int[numC.size()];
        int i = 0;
        for(int k : numC.keySet())
            uniqueNum[i++] = k;
        Arrays.sort(uniqueNum);
        /*
        int[][] memo = new int[uniqueNum.length][uniqueNum.length];
        for( i =0; i<uniqueNum.length; i++)
            for(int j=0; j<uniqueNum.length; j++)
                memo[i][j] = -1;
        int res = maxPoint(numC, uniqueNum, 0, uniqueNum.length-1, memo);
        return res;
        */
        int[] f = new int[uniqueNum.length+1];
        f[0] = 0;
        f[1] = numC.get(uniqueNum[0]);
        for( i = 2; i<=uniqueNum.length; i++){
            if(uniqueNum[i-1] == uniqueNum[i-2]+1)
                f[i] = Math.max(f[i-2] + numC.get(uniqueNum[i-1]), f[i-1]);
            else
                f[i] = f[i-1]+numC.get(uniqueNum[i-1]);
        }
        return f[uniqueNum.length];
    }
    
    int maxPoint(Map<Integer, Integer> numC, int[] uniqueNum, int left, int right, int[][] memo){
        if(left == right)
            return numC.get(uniqueNum[left]);
        if(left > right)
            return 0;
        if(memo[left][right] != -1)
            return memo[left][right];
        int max = 0;
        for(int i = left; i<= right; i++){
            int leftpoint = 0;
            int rightpoint = 0;
            if(i>left && uniqueNum[i-1] == uniqueNum[i] -1)
                leftpoint = maxPoint(numC, uniqueNum, left, i-2, memo);
            else
                leftpoint = maxPoint(numC, uniqueNum, left, i-1, memo);
            if(i<right && uniqueNum[i+1] == uniqueNum[i]+1)
                rightpoint = maxPoint(numC, uniqueNum, i+2, right, memo);
            else
                rightpoint = maxPoint(numC, uniqueNum, i+1, right, memo);
            max = Math.max(max, leftpoint+rightpoint + numC.get(uniqueNum[i]));
        }
        memo[left][right] = max;
        return max;
    }

}
