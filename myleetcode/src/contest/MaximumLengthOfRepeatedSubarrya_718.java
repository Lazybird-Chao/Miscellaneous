package contest;

public class MaximumLengthOfRepeatedSubarrya_718 {
	public int findLength(int[] A, int[] B) {
        if(A==null || B == null || A.length == 0 || B.length == 0)
            return 0;
        record = new int[A.length][B.length];
        for(int i = 0; i<A.length; i++)
            Arrays.fill(record[i], -1);
         helper(A, 0, B, 0);
        return max;
    }
    int[][] record;
    int max = 0;
    int helper(int[] A, int i, int[] B, int j){
        if(i == A.length || j == B.length)
            return 0;
        if(record[i][j] != -1)
            return record[i][j];
        int ret = 0;
        if(A[i] == B[j])
            ret = 1 + helper(A, i+1, B, j+1);
        max = Math.max(max, ret);
        record[i][j] = ret;
        helper(A, i, B, j+1);
        helper(A, i+1, B, j);
        return ret;
    }

}
