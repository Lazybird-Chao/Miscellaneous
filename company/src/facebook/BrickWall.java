package facebook;

public class BrickWall {
	/*
    public int leastBricks(List<List<Integer>> wall) {
        if(wall == null || wall.isEmpty())
            return 0;
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        for(int i = 0; i < wall.size(); i++)
            q.offer(new Pair(wall.get(i), 0));
        int mincut = wall.size();
        while(!q.isEmpty()){
            int size = q.size();
            int n = q.peek().list.get(q.peek().idx);
            while(!q.isEmpty() && q.peek().list.get(q.peek().idx) == n){
                Pair tmp = q.poll();
                size--;
                if(tmp.idx < tmp.list.size()-1){
                    tmp.list.set(tmp.idx + 1, tmp.list.get(tmp.idx) + tmp.list.get(tmp.idx+1));
                    tmp.idx++;
                    q.offer(tmp);
                }
            }
            if(!q.isEmpty())
                mincut = Math.min(mincut, size);
        }
        return mincut;
    }
    
    class Pair implements Comparable<Pair>{
        List<Integer> list;
        int idx;
        public Pair(List<Integer> l, int i){
            list = l;
            idx = i;
        }
        public int compareTo(Pair other){
            return this.list.get(this.idx) - other.list.get(other.idx);
        }
    }
    */
     public int leastBricks(List<List<Integer>> wall) {
         if(wall == null || wall.isEmpty())
            return 0;
         int maxSameEnd = 0;
         Map<Integer, Integer> endRecord = new HashMap<Integer, Integer>();
         for(int i=0; i<wall.size(); i++){
             int end = 0;
             List<Integer> curLayer = wall.get(i);
             for(int j=0; j<curLayer.size()-1; j++){
                 end = curLayer.get(j) + end;
                 endRecord.put(end, endRecord.getOrDefault(end, 0)+1);
                 maxSameEnd = Math.max(maxSameEnd, endRecord.get(end));
             }
         }
         return wall.size() - maxSameEnd;
     }

}
