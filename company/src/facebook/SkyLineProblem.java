package facebook;

public class SkyLineProblem {
	public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if(buildings == null || buildings.length == 0)
            return res;
        Point[] allPoints = new Point[buildings.length*2];
        for(int i = 0; i < buildings.length; i++){
            int[] building = buildings[i];
            Point left = new Point(building[0], -building[2], true);
            Point right = new Point(building[1], building[2], false);
            allPoints[i*2] = left; 
            allPoints[i*2+1] = right;
        }
        Arrays.sort(allPoints, new Comparator<Point>(){
            public int compare(Point a, Point b){
                if(a.x != b.x)
                    return a.x - b.x;
                else{
                    return a.h - b.h;
                }
            }
        });
        PriorityQueue<Integer> preBuildingLeft = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        //int lastmaxh = 0;
        for(int i = 0; i < allPoints.length; i++){
            Point cur = allPoints[i];
            if(cur.isleft){
                if(preBuildingLeft.isEmpty() || -cur.h > preBuildingLeft.peek()){
                    int[] item = {cur.x, -cur.h};
                    res.add(item);
                }
                preBuildingLeft.offer(-cur.h);
            }else{
                preBuildingLeft.remove(cur.h);
                if(!preBuildingLeft.isEmpty() && preBuildingLeft.peek() < cur.h){
                    int[] item = {cur.x, preBuildingLeft.peek()};
                    res.add(item);
                } else if(preBuildingLeft.isEmpty()){
                    int[] item = {cur.x, 0};
                    res.add(item);
                }
            }
        }
        
        return res;
        
    }
    class Point{
        int x;
        int h;
        boolean isleft;
        public Point(int x, int h, boolean isleft){
            this.x = x;
            this.h = h;
            this.isleft = isleft;
        }
    }

}
