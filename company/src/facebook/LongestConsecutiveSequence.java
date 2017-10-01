package facebook;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        Set<Integer> s = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
            s.add(nums[i]);
        int up = 0;
        int down = 0;
        int maxlen = 0;
        for(int i = 0; i < nums.length; i++){
            if(s.contains(nums[i])){
                up = down = 0;
                int n = nums[i]+1;
                while(s.contains(n)){
                    s.remove(n);
                    n++;
                    up++;
                }
                n = nums[i] - 1;
                while(s.contains(n)){
                    s.remove(n);
                    n--;
                    down++;
                }
                maxlen = Math.max(maxlen, up+down+1);
                s.remove(nums[i]);
            }
        }
        return maxlen;
    }

}
