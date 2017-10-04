package facebook;

public class AlienDictionary {
	public String alienOrder(String[] words) {
        if(words == null || words.length ==0)
            return "";
        List<Character>[] g = new List[26];
        int[] inDegree = new int[26];
        for(int i = 0; i < words.length; i++){
            char[] w = words[i].toCharArray();
            int j = 0;
            if(i==0){
                while(j < w.length){
                    if(g[w[j]-'a'] == null)
                        g[w[j]-'a'] = new ArrayList<Character>();
                    j++;
                }
            }else{
                while(j < w.length && j < words[i-1].length() && w[j] == words[i-1].charAt(j))
                    j++;
                if(j < w.length && j < words[i-1].length()){
                    char from = words[i-1].charAt(j);
                    char to = w[j];
                    if(g[to-'a'] == null)
                        g[to-'a'] = new ArrayList<Character>();
                    g[from-'a'].add(to);
                    inDegree[to-'a']++;
                }
                while(j < w.length){
                    if(g[w[j]-'a'] == null)
                        g[w[j]-'a'] = new ArrayList<Character>();
                    j++;
                }
            }
        }
        
        char[] res = new char[26];
        int index = 0;
        Queue<Character> q = new LinkedList<Character>();
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(g[i] != null ){
                if(inDegree[i] == 0)
                    q.offer((char)(i+'a'));
                count++;
            }
        }
        while(!q.isEmpty()){
            char c = q.poll();
            res[index++] = c;
            for(char neighbor : g[c-'a']){
                inDegree[neighbor-'a']--;
                if(inDegree[neighbor-'a']==0)
                    q.offer(neighbor);
            }
        }
        if(index == count)
            return new String(res, 0, index);
        else
            return "";
        
    }

}
