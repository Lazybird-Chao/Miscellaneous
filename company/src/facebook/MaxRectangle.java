package facebook;

public class MaxRectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length==0)
            return 0;
        int[] height = new int[matrix[0].length];
        int maxarea = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0')
                    height[j] = 0;
                else
                    height[j] += 1;
            }
            maxarea = Math.max(maxarea, maxInOneRow(height));
        }
        return maxarea;
    }
    int maxInOneRow(int[] height){
        int maxarea = 0;
        Stack<Integer> incH = new Stack<Integer>();
        incH.push(0);
        for(int i = 1; i < height.length; i++){
            //System.out.print(height[i]);
            if(height[i] >= height[i-1])
                incH.push(i);
            else if(height[i] < height[i-1]){
                while(!incH.isEmpty() && height[incH.peek()] > height[i]){
                    int idx = incH.pop();
                    int h = height[idx];
                    int w = incH.isEmpty() ? i : i - incH.peek() -1;
                    maxarea = Math.max(maxarea, h*w);
                }
                incH.push(i);
            }
            
        }
        while(!incH.isEmpty()){
            int idx = incH.pop();
            int h = height[idx];
            int w = incH.isEmpty() ? height.length : height.length - incH.peek() -1;
            maxarea = Math.max(maxarea, h*w);

        }
        //System.out.println(maxarea);
        return maxarea;
    }

}
