package contest;

public class DegreeOfArray_697 {
	public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        Map<Integer, Integer> freqmap = new HashMap<Integer, Integer>();
        Map<Integer,  Integer> firstpos = new HashMap<Integer, Integer>();
        int maxfreq = 0;
        int minlen = nums.length;
        for(int i = 0; i < nums.length; i++){
            int freq = freqmap.getOrDefault(nums[i], 0);
            freq++;
            freqmap.put(nums[i], freq);
            if(!firstpos.containsKey(nums[i]))
                firstpos.put(nums[i], i);
            if(freq > maxfreq){
                maxfreq = freq;
                minlen = i - firstpos.get(nums[i]) + 1;
            } else if(freq == maxfreq){
                minlen = Math.min(minlen, i-firstpos.get(nums[i])+1);
            }
        }
        return minlen;
    }

}
