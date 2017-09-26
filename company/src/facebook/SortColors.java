package facebook;

public class SortColors {
	public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int i = 0; 
        int j = nums.length - 1;
        int k = 0;
        while(k <= j){
            int tmp = 0;
            if(nums[k] == 0){
                tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                i++;
                k++;
            } else if(nums[k] == 1){
                k++;
            } else {
                tmp = nums[j];
                nums[j] = nums[k];
                nums[k] = tmp;
                j--;
            }
        }
        return;
    }

}
