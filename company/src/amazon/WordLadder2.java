package amazon;
import java.util.*;

public class WordLadder2 {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size()==0)
            return new ArrayList<List<String>>();
        Map<String, List<Integer>> wordneighbormap = new HashMap<String, List<Integer>>();
        for(String w: wordList){
            wordneighbormap.put(w, new ArrayList<Integer>());
        }
        if(!wordneighbormap.containsKey(endWord))
            return new ArrayList<List<String>>();
        List<List<String>> res = new ArrayList<List<String>>();
        if(differ1(beginWord, endWord)){
            List<String> tmp = new ArrayList<String>();
            tmp.add(beginWord);
            tmp.add(endWord);
            res.add(tmp);
            return res;
        }
        for(int i=0; i<wordList.size(); i++){
            for(int j= i+1; j<wordList.size(); j++){
                if(differ1(wordList.get(i), wordList.get(j))){
                    wordneighbormap.get(wordList.get(i)).add(j);
                    wordneighbormap.get(wordList.get(j)).add(i);
                }
            }
        }
        wordneighbormap.put(beginWord, new ArrayList<Integer>());
        for(int i=0; i<wordList.size(); i++){
            if(differ1(beginWord, wordList.get(i))){
                wordneighbormap.get(beginWord).add(i);
            }
        }
        Map<String, Integer> spEndToAll = new HashMap<String, Integer>();
        int spEndToBegin = Integer.MAX_VALUE;
        Queue<String> q = new LinkedList<String>();
        Set<String> accessed = new HashSet<String>();
        q.offer(endWord);
        accessed.add(endWord);
        int step = 0;
        while(!q.isEmpty()){
            step++;
            int qsize = q.size();
            for(int  j=0; j<qsize; j++){
                String cur = q.poll();
                for(int i : wordneighbormap.get(cur)){
                    if(!accessed.contains(wordList.get(i))){
                        q.offer(wordList.get(i));
                        accessed.add(wordList.get(i));
                        spEndToAll.put(wordList.get(i), step);
                    }
                }
                if(differ1(cur, beginWord))
                    spEndToBegin = Math.min(spEndToBegin, step);
            }
        }
        if(spEndToBegin == Integer.MAX_VALUE)
            return res;
        accessed.clear();
        List<String> path = new ArrayList<String>();
        path.add(beginWord);
        dfs(wordList, accessed, wordneighbormap, beginWord, endWord, path, spEndToAll, spEndToBegin, res);
        return res;
        
    }
    
    void dfs(List<String> wordList, Set<String> accessed, Map<String, List<Integer>> wordneighbormap, String src, String dst, List<String> path, Map<String, Integer> spEndToAll, int sp, List<List<String>> res){
        for(int i: wordneighbormap.get(src)){
            String w = wordList.get(i);
            if(w.equals(dst) ){
                if(path.size()==sp){
                    path.add(dst);
                    res.add(new ArrayList<String>(path));
                    path.remove(path.size()-1);
                }
            } else{
                if(!accessed.contains(w) && spEndToAll.containsKey(w) && spEndToAll.get(w) + path.size() == sp){
                    path.add(w);
                    accessed.add(w);
                    dfs(wordList, accessed, wordneighbormap, w, dst, path, spEndToAll, sp, res);
                    accessed.remove(w);
                    path.remove(path.size()-1);
                }
            }
        }
        return;
    }
    
    boolean differ1(String s1, String s2){
        int count = 0;
        if(s1.length() != s2.length())
            return false;
        for(int i = 0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
            if(count > 1)
                break;
        }
        return count == 1; 
    }

}
