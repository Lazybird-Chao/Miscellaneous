package contest;

public class NumberOfDistinctIslands_694 {
	public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        Set<String> distinIsland = new HashSet<String>();
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    List<Pair> curland  = new ArrayList<Pair>();
                    Pair minxy = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
                    helper(grid, i, j, curland, minxy);
                    addIsland(curland, minxy, distinIsland);
                }
            }
        }
        return distinIsland.size();
        
    }
    class Pair{
        int x;
        int y;
        public Pair(int a, int b){
            x = a;
            y = b;
        }
    }
    void addIsland(List<Pair> island, Pair minxy, Set<String> distinIsland){
        StringBuilder sb = new StringBuilder();
        Collections.sort(island, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                if(a.x != b.x)
                    return a.x-b.x;
                else
                    return a.y-b.y;
            }
        });
        for(Pair item : island){
            sb.append(String.valueOf(item.x-minxy.x));
            sb.append(String.valueOf(item.y-minxy.y));
        }
        distinIsland.add(sb.toString());
    }
    void helper(int[][] grid, int i, int j, List<Pair> island, Pair minxy){
        if(i < 0 || i >= grid.length || j<0 || j>=grid[0].length)
            return;
        if(grid[i][j] == 0)
            return;
        minxy.x = Math.min(minxy.x, i);
        minxy.y = Math.min(minxy.y, j);
        island.add(new Pair(i, j));
        grid[i][j] = 0;
        helper(grid, i+1, j, island, minxy);
        helper(grid, i-1, j, island, minxy);
        helper(grid, i, j+1, island, minxy);
        helper(grid, i, j-1, island, minxy);
        return;
    }

}
