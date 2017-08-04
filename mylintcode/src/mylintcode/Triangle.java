package mylintcode;

public class Triangle {
	public int minimumTotal(int[][] triangle) {
		if(triangle==null)
			return 0;
		int h = triangle.length;
		int w = triangle[h-1].length;
		int[][] minSum = new int[h][w];
		for(int i=0; i<w; i++)
			minSum[h-1][i] = triangle[h-1][i];
		for(int i=h-2; i>=0; i--){
		    w--;
			for(int j=0; j<w; j++) {
				minSum[i][j] = triangle[i][j] + Math.min(minSum[i+1][j], 
						minSum[i+1][j+1]);
			}
		}
		return minSum[0][0];
	}
	
	public static void main(String[] args) {
		Triangle test = new Triangle();
		int[][] triangle = {{-1,0,0},{2,3,0},{1,-1,-3}};
		System.out.println(test.minimumTotal(triangle));
	}

}
