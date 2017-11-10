package contest;

public class AccountMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(accounts == null || accounts.size() == 0)
            return res;
        Set<Node> g = new HashSet<Node>();
        Map<String, Node> emails = new HashMap<String, Node>();
        for(int i = 0; i< accounts.size(); i++){
            List<String> cur = accounts.get(i);
            Node first = null;
            Node pre = null;
            
            for(int j = 1; j < cur.size(); j++){
                if(!emails.isEmpty() && emails.containsKey(cur.get(j))){
                    if(j == 1){
                        first = emails.get(cur.get(j));
                        pre = first;
                    }else{
                        Node tmp = emails.get(cur.get(j));
                        pre.neighbor.add(tmp);
                        pre = tmp;
                    }
                }else{
                    if(j == 1){
                        first = new Node(cur.get(j));
                        pre = first;
                    }else{
                        Node tmp = new Node(cur.get(j));
                        pre.neighbor.add(tmp);
                        pre = tmp;
                    } 
                    emails.put(cur.get(j), pre);
                    g.add(pre);
                }
            }
            pre.neighbor.add(first);
        }
        //System.out.println(g.size());
        for(int i = 0; i < accounts.size(); i++){
            String name = accounts.get(i).get(0);
            //System.out.println(name);
            if(g.contains(emails.get(accounts.get(i).get(1)))){
                List<String> list = new ArrayList<String>();
                dfs(g, emails.get(accounts.get(i).get(1)), list);
                Collections.sort(list);
                list.add(0, name);
                res.add(list);
            }
        }
        return res;
        
    }
    void dfs(Set<Node> g, Node start, List<String> list){
        list.add(start.email);
        g.remove(start);
        for(int i = 0; i<start.neighbor.size(); i++){
            Node next = start.neighbor.get(i);
            if(g.contains(next)){
                dfs(g, next, list);
            }
        }
    }
    class Node{
        String email;
        List<Node> neighbor;
        public Node(String e){
            email = e;
            neighbor = new ArrayList<Node>();
        }
    }

}
