package contest;

public class FindKthSmallestPairDistance_719 {
	/*
    public int smallestDistancePair(int[] nums, int k) {
        if(nums == null || nums.length ==0)
            return 0;
        Arrays.sort(nums);
        int[] diff = new int[nums.length-1];
        for(int i = 1; i< nums.length; i++)
            diff[i-1] = nums[i] - nums[i-1];
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        int i = 0;
        while( i < diff.length){
            if(q.size() < k || diff[i] < q.peek()){
                int s = 0;
                for(int j = i; j>=0; j--){
                    s += diff[j];
                    if(q.size() < k)
                        q.offer(s);
                    else if(s < q.peek()){
                        q.poll();
                        q.offer(s);
                    }else
                        break;
                }
            }
            i++;
        }
        return q.peek();
    }
    */
    public int smallestDistancePair(int[] nums, int k){
        if(nums == null || nums.length ==0)
            return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length-1] - nums[0];
        while(left + 1 < right){
            int mid = left + (right-left)/2;
            int count = findCount(nums, mid);
            if(count < k)
                left = mid;
            else
                right = mid;
        }
        if(findCount(nums, left) >= k)
            return left;
        else
            return right;
    }
    
    int findCount(int[] nums, int mid){
        int count = 0;
        for(int start = 0; start < nums.length; start++){
            int end = start +1;
            while(end < nums.length && nums[end] - nums[start] <= mid){
                end++;
            }
            count += end - start -1;
        }
        return count;
    }

}
