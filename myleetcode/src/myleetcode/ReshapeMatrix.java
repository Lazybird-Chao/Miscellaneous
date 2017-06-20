package myleetcode;

public class ReshapeMatrix {
	public int[][] matrixReshape(int[][] nums, int r, int c){
		int orig_r=0;
		orig_r = nums.length;
		int orig_c=0;
		if(nums.length>0)
			orig_c = nums[0].length;
		if(orig_r * orig_c != r*c)
			return nums;
		
		int[][] ret = new int[r][c];
		for(int i=0; i<orig_r; i++){
			for(int j=0; j<orig_c; j++){
				int index = i*orig_c + j;
				ret[index/c][index%c] = nums[i][j];
			}
		}
		return ret;
	}

}
