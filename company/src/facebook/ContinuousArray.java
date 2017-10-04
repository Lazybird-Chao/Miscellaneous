package facebook;

public class ContinuousArray {
    /*
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[]f = new int[nums.length];
        int maxlen = 0;
        f[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            f[i] = f[i-1]+nums[i];
            if(i+1 == f[2]*2)
                maxlen = i+1;
            else{
                for(int j = 0; j < i; j++){
                    if(i-j <= maxlen)
                        break;
                    if(i-j ==2*(f[i]-f[j])){
                        maxlen = Math.max(maxlen, i-j);
                        break;
                    }
                }
            }
            
        }
        
        return maxlen;
    }
    */
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int maxlen = 0;
        Map<Integer, Integer> diffmap = new HashMap<Integer, Integer>();
        int countOnes = nums[0];
        if(nums[0] == 1)
            diffmap.put(1, 0);
        else
            diffmap.put(-1, 0);
        for(int i = 1; i < nums.length; i++){
            countOnes += nums[i];
            if(i+1 == countOnes*2)
                maxlen = i+1;
            else{
                int diff = 2*countOnes - (i+1);
                if(diffmap.containsKey(diff))
                    maxlen = Math.max(maxlen, i-diffmap.get(diff));
                else
                    diffmap.put(diff, i);
            }
        }
        
        return maxlen;
    }

}
