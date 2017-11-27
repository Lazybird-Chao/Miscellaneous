package google;

public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if(tickets == null || tickets.length ==0 || tickets[0].length ==0)
            return res;
        Map<String, PriorityQueue<String>> g = new HashMap<String, PriorityQueue<String>>();
        for(int i = 0; i<tickets.length; i++){
            if(!g.containsKey(tickets[i][0]))
                g.put(tickets[i][0], new PriorityQueue<String>());
            g.get(tickets[i][0]).add(tickets[i][1]);
        }
        Stack<String> path = new Stack<String>();
        dfs("JFK", g, path);
        while(!path.isEmpty())
            res.add(path.pop());
        return res;
        
    }
    void dfs(String start, Map<String, PriorityQueue<String>> g, Stack<String> path){
        PriorityQueue<String> neighbor = g.getOrDefault(start, null);
        while(neighbor != null && !neighbor.isEmpty()){
            String next = neighbor.poll();
            dfs(next, g, path);
        }
        path.push(start);
    }

}
