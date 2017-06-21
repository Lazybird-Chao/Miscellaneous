package myleetcode;

public class RangeAddition2 {
	public int maxCount(int m, int n, int[][] ops){
		int min_m = m;
		int min_n = n;
		for(int i=0; i<ops.length; i++){
			if(min_m > ops[i][0])
				min_m = ops[i][0];
			if(min_n > ops[i][1])
				min_n = ops[i][1];
		}
		return min_m*min_n;
	}

}
