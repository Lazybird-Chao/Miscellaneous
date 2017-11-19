package contest;

public class FallingSquares_699 {
	public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if(positions == null || positions.length == 0 || positions[0].length ==0)
            return res;
        List<Pair> posList = new ArrayList<Pair>();
        int maxHight = 0;
        for(int i = 0; i < positions.length; i++){
            int[] square = positions[i];
            if(posList.isEmpty()){
                posList.add(new Pair(square[0], square[0]+square[1], square[1]));
                maxHight = Math.max(maxHight, square[1]);
                res.add(maxHight);
                continue;
            }
            Pair cur = new Pair(square[0], square[0]+square[1], square[1]);
            int j = 0;
            int maxh = 0;
            while(j < posList.size()){
                if(posList.get(j).end > cur.start && posList.get(j).start < cur.end){
                    maxh = Math.max(maxh, posList.get(j).height);
                }
                j++;
            }
            cur.height += maxh;
            posList.add(cur);  
            maxHight = Math.max(maxHight, cur.height);
            res.add(maxHight);
        }
        return res;
        
    }
    class Pair{
        int start;
        int end;
        int height;
        public Pair(int s, int e, int h){
            start = s;
            end = e;
            height = h;
        }
    }

}
