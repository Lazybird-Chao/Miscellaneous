package google;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
        if(nums == null || nums.length ==0)
            return;
        int start = nums.length-1;
        while(start>0 && nums[start] <= nums[start-1]){
            start --;
        }
        if(start>0){
            int i = nums.length-1;
            while(i>0 && nums[i] <= nums[start-1])
                i--;
            swap(nums, i, start-1);
        }
        int end = nums.length-1;
        while(start<end){
            swap(nums, start, end);
            start++;
            end--;
        }
        return;
    }
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
