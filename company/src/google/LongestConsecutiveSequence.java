package google;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        int maxlen = 0;
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            int c = 1;
            int tmp = n-1;
            while(set.contains(tmp)){
                set.remove(tmp);
                c++;
                tmp--;
            }
            tmp = n+1;
            while(set.contains(tmp)){
                set.remove(tmp);
                c++;
                tmp++;
            }
            maxlen = Math.max(maxlen, c);
        }
        return maxlen;
    }

}
