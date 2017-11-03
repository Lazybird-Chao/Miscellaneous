package google;

public class Skyline {
	public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0)
            return res;
        List<Point> points = new ArrayList<Point>();
        for(int i = 0; i < buildings.length; i++){
            points.add(new Point(buildings[i][0], buildings[i][2]));
            points.add(new Point(buildings[i][1], -buildings[i][2]));
        }
        Collections.sort(points);
        TreeMap<Integer, Integer> hights = new TreeMap<Integer, Integer>();
        hights.put(0, 1);
        for(int i = 0; i < points.size(); i++){
            Point cur = points.get(i);
            int curh = cur.h;
            //System.out.println(curh);
            if(curh > 0){
                int maxh = hights.lastKey();
                if(curh > maxh){
                    hights.put(curh, 1);
                    int[] tmp = {cur.x, curh};
                    res.add(tmp);
                }else{
                    if(hights.containsKey(curh))
                        hights.put(curh, hights.get(curh)+1);
                    else
                        hights.put(curh, 1);
                }
            }else if(curh < 0){
                int count = hights.get(-curh);
                count--;
                if(count == 0)
                    hights.remove(-curh);
                else
                    hights.put(-curh, count);
                int maxh = hights.lastKey();
                if(-curh > maxh){
                    int[] tmp = {cur.x, maxh};
                    res.add(tmp);
                }
            }
        }

        return res;
    }
    class Point implements Comparable<Point>{
        int x;
        int h;
        public Point(int x, int h){
            this.x = x;
            this.h = h;
        }
        public int compareTo(Point other){
            if(this.x != other.x)
                return this.x - other.x;
            else{
                return other.h - this.h;
            }
        }
    }

}
