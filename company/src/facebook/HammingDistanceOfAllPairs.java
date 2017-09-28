package facebook;

public class HammingDistanceOfAllPairs {
	public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] bitones = new int[32];
        for(int i = 0; i < nums.length; i++){
            int n = 1;
            for(int j = 0; j < 32; j++){
                bitones[j] += (nums[i] & n) == 0 ? 0 : 1;
                n = n << 1;
            }
        }
        int distance = 0;
        for(int i = 0; i < 32; i++){
            distance += bitones[i] * (nums.length - bitones[i]);
        }
        return distance;
        
    }

}
