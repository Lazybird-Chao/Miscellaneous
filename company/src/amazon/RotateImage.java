package amazon;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if(matrix == null)
			return;
		int h = matrix.length;
		int w = matrix[0].length;
		
		for(int i=0; i<h; i++) {
			for(int j=i+1; j<w; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
		for(int i=0; i<h; i++) {
			for(int j=0; j<w/2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][w-j-1];
				matrix[i][w-j-1] = tmp;
			}
		}
		return;
	      
	}

}
