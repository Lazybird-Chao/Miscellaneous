package others;

public class LargestRectanguleInHistogram {
	public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length ==0)
            return 0;
        int[] left = new int[heights.length];
        Stack<Integer> s = new Stack<Integer>();
        int maxarea = 0;
        left[0] = 0;
        s.push(0);
        maxarea = heights[0];
        for(int i=1; i<heights.length; i++){
            if(heights[i] > heights[i-1]){
                left[i] = i;
                s.push(i);
            } else if(heights[i] == heights[i-1]){
                left[i] = left[i-1];
                s.push(i);
            } else{
                int j = s.peek();
                while( heights[j] > heights[i]){
                    s.pop();
                    int area = (i-1 - left[j] + 1)*heights[j];
                    maxarea = Math.max(maxarea, area);
                    if(s.isEmpty())
                        break;
                    j = s.peek();
                }
                if(s.isEmpty())
                    left[i] = 0;
                else
                    left[i] = heights[j] == heights[i] ? left[j] : j+1;
                s.push(i);
            }
        }
        while(!s.isEmpty()){
            int j = s.pop();
            int area = (heights.length - left[j]) * heights[j];
            maxarea = Math.max(maxarea, area);
        }
        return maxarea;
    }

}
