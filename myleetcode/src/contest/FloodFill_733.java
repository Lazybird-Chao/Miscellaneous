package contest;

public class FloodFill_733 {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length ==0 || image[0].length ==0)
            return new int[0][0];
        if(newColor == image[sr][sc])
            return image;
        int oldColor = image[sr][sc];
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        int[] x_n = {0,0,1,-1};
        int[] y_n = {1,-1,0,0};
        qx.offer(sr);
        qy.offer(sc);
        image[sr][sc] = newColor;
        while(!qx.isEmpty()){
            int xx = qx.poll();
            int yy = qy.poll();
            for(int i=0; i<4; i++){
                int x = xx + x_n[i];
                int y = yy + y_n[i];
                if(isValid(image, x, y) && image[x][y] == oldColor){
                    qx.offer(x);
                    qy.offer(y);
                    image[x][y] = newColor;
                }
            }
        }
        return image;
    }
    boolean isValid(int[][] image, int x, int y){
        if(x<0 || x>=image.length || y<0 || y>=image[0].length)
            return false;
        return true;
    }

}
