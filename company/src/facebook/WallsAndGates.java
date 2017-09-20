package facebook;

public class WallsAndGates {
	public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;
        int row = rooms.length;
        int column = rooms[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(rooms[i][j] == 0)
                    expand(rooms, i, j);
            }
        }
        return;
    }
    
    void expand(int[][] rooms, int x, int y){
        int[] xn = {0,0,1,-1};
        int[] yn = {1,-1,0,0};
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        q1.offer(x);
        q2.offer(y);
        int distance = 0;
        while(!q1.isEmpty()){
            distance++;
            int size = q1.size();
            for(int j=0; j<size; j++){
                int curx = q1.poll();
                int cury = q2.poll();
                for(int i=0; i<4; i++){
                    int nextx = curx + xn[i];
                    int nexty = cury + yn[i];
                    if(isvalid(rooms, nextx, nexty) && rooms[nextx][nexty] > distance){
                        rooms[nextx][nexty] = distance;
                        q1.offer(nextx);
                        q2.offer(nexty);
                    }
                }
            }
        }
        return;
    }
    boolean isvalid(int[][] rooms, int x, int y){
        int row = rooms.length;
        int column = rooms[0].length;
        if(x < 0 || x >= row || y < 0 || y>= column)
            return false;
        return true;
    }

}
