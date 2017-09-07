package amazon;

public class TrapRainWater {
	public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int[] max = new int[height.length];
        max[0] = height[0];
        for(int i=1; i<height.length; i++){
            if(height[i] <= max[i-1])
                max[i] = max[i-1];
            else
                max[i] =  height[i];
        }
        int rmax = height[height.length-1];
        int sum = 0;
        for(int i=height.length-2; i>=0 ;i--){
            if(height[i]>rmax){
                rmax = height[i];
            }
            sum += Math.min(max[i], rmax) - height[i];
        }
        return sum;
    }
}
