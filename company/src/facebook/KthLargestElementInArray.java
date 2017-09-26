package facebook;

public class KthLargestElementInArray {
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length)
            return 0;
        //return method1(nums, k);
        return method2(nums, k);
    }
    
    int method1(int[] nums, int k){
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int i = 0;
        while(i < nums.length){
            if(i < k)
                q.offer(nums[i]);
            else{
                if(nums[i] > q.peek()){
                    q.poll();
                    q.offer(nums[i]);
                }
            }
            i++;
        }
        return q.peek();
    }
    
    int method2(int[] nums, int k){
        return quickSelect(nums, 0, nums.length-1, k);
    }
    
    int quickSelect(int[] nums, int left, int right, int k){
        if(left >= right  || left < 0 || right > nums.length-1){
            if(left == k-1)
                return nums[left];
            else if(right == k-1)
                return nums[right];
            else
                return -1;
        } 
        int pivot = nums[right];
        int i = left;
        int j = right - 1;
        while(i <= j){
            if(nums[i] > pivot){
                i++;
                continue;
            }
            if(nums[j] < pivot){
                j--;
                continue;
            }
            if(i != j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }else
                i++;
        }
        int tmp = nums[i];
        nums[i] = nums[right];
        nums[right] = tmp;
        if(i == k-1)
            return nums[i];
        else if(i<k-1)
            return quickSelect(nums, i+1, right, k);
        else
            return quickSelect(nums, left, j, k);
    }

}
