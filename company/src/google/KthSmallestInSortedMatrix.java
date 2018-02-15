package google;

public class KthSmallestInSortedMatrix {
	class Pair{
        int v;
        int pos;
        public Pair(int a, int b){
            v = a;
            pos = b;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || k<1 || k>matrix.length*matrix.length)
            return 0;
        PriorityQueue<Pair> q = new PriorityQueue<Pair>(1, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.v - b.v;
            }
        });
        boolean[][] accessed = new boolean[matrix.length][matrix.length];
        q.offer(new Pair(matrix[0][0], 0));
        accessed[0][0] = true;
        int count = 0;
        while(count < k-1){
            Pair cur = q.poll();
            count++;
            int i = cur.pos / matrix.length;
            int j = cur.pos % matrix.length;
            if(i+1 < matrix.length && accessed[i+1][j]==false){
                q.offer(new Pair(matrix[i+1][j], (i+1)*matrix.length+j));
                accessed[i+1][j] = true;
            }
            if(j+1 < matrix.length && accessed[i][j+1] == false){
                q.offer(new Pair(matrix[i][j+1], i*matrix.length+j+1));
                accessed[i][j+1] = true;
            }
        }
        return q.peek().v;
    }

}
