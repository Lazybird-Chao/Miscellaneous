package others;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
        if(height == null || height.length ==0)
            return 0;
        int maxarea = 0;
        int i = 0;
        int j = height.length-1;
        while(i<j){
            maxarea = Math.max(maxarea, Math.min(height[i], height[j])*(j-i));
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return maxarea;
    }

}
