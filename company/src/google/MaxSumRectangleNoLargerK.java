package google;

public class MaxSumRectangleNoLargerK {
	public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix[0] == null)
            return 0;
        int[] rowSum = new int[matrix.length];
        int maxsum = Integer.MIN_VALUE;
        TreeSet<Integer> s = new TreeSet<Integer>();
        for(int c1 = 0; c1 < matrix[0].length; c1++){
            Arrays.fill(rowSum, 0);
            for(int c2 = c1; c2 < matrix[0].length; c2++){
                int pres = 0;
                s.clear();
                s.add(0);
                for(int r=0; r<matrix.length; r++){
                    int curs = pres + rowSum[r] + matrix[r][c2];
                    //System.out.println(curs);
                    Integer tmp = s.ceiling(curs-k);
                    if(tmp != null){
                        maxsum = Math.max(maxsum, curs-tmp);
                        //System.out.println(tmp);
                    }
                    s.add(curs);
                    pres = curs;
                    rowSum[r] += matrix[r][c2];
                }
            }   
        }
        return maxsum;
        
    }

}
