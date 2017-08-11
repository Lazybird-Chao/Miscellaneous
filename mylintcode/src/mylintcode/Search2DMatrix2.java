package mylintcode;

public class Search2DMatrix2 {
	public int searchMatrix(int[][] matrix, int target) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int row=0;
		int column = n-1;
		int occur=0;
		while(row<m && column>=0) {
			if(matrix[row][column]==target) {
				occur++;
				row++;
				column--;
			}
			else if(matrix[row][column]>target)
				column--;
			else
				row++;
		}
		return occur;
	}

}
