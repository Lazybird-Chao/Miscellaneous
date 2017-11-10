package google;

public class SlidingWindowMax {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length ==0 || nums.length < k)
            return new int[0];
        int[] res = new int[nums.length-k+1];
        int maxindex= 0;
        int maxval = nums[0];
        for(int i= 1; i < k; i++){
            if(nums[i] >= maxval){
                maxval = nums[i];
                maxindex = i;
            }
        }
        LinkedList<Integer> nextMax = new LinkedList<Integer>();
        for(int i = maxindex; i < nums.length; i++){
            if(i >= k){
                if(i-k == nextMax.getFirst())
                    nextMax.removeFirst();
            }
            while(!nextMax.isEmpty() && nums[i] >= nums[nextMax.getLast()])
                nextMax.removeLast();
            nextMax.addLast(i);
            if(i>=k-1)
                res[i-k+1] = nums[nextMax.getFirst()];
        }
        return res;
    }

}
