package facebook;

public class SearchAutoCompleteSystem {
	class AutocompleteSystem {

	    class Node{
	        String sentence;
	        int freq;
	        Node[] next;
	        Node pre;
	        TreeSet<Node> followSentences;
	        public Node(){
	            sentence = "";
	            freq = 0;
	            next = new Node[27];
	            pre = null;
	            followSentences = new TreeSet<Node>(new Comparator<Node>(){
	                public int compare(Node a, Node b){
	                    if(a.freq != b.freq)
	                        return b.freq - a.freq;
	                    else
	                        return a.sentence.compareTo(b.sentence);
	                }
	            });
	        }
	    }
	    Node head;
	    Node lastFind;
	    StringBuilder prefixSentence;
	    public AutocompleteSystem(String[] sentences, int[] times) {
	        head = new Node();
	        for(int i = 0; i<sentences.length; i++){
	            char[] s = sentences[i].toCharArray();
	            int freq = times[i];
	            addSentence(head, s, 0, freq);
	        }
	        lastFind = head;
	        prefixSentence = new StringBuilder();
	    }
	    
	    public List<String> input(char c) {
	        List<String> res = new ArrayList<String>();
	        Node cur = null;
	        if(c != '#'){
	            prefixSentence.append(c);
	            int nextidx = -1;
	            if(c == ' ')
	                nextidx = 26;
	            else
	                nextidx = c - 'a';
	            cur = lastFind.next[nextidx];
	            if(cur == null){
	                lastFind.next[nextidx] = new Node();
	                lastFind.next[nextidx].pre = lastFind;
	                lastFind = lastFind.next[nextidx];
	                return res;
	            }
	            else{
	                TreeSet<Node> sentences = cur.followSentences;
	                Iterator<Node> iter = sentences.iterator();
	                int i = 0;
	                while(iter.hasNext() && i < 3){
	                    res.add(iter.next().sentence);
	                    i++;
	                }
	                lastFind = cur;
	                return res;
	            }
	        }else{
	            if(lastFind.sentence.isEmpty())
	                lastFind.sentence = prefixSentence.toString();
	            prefixSentence.setLength(0);
	            updateFollowSentences(lastFind, lastFind);
	            lastFind = head;
	            return res;
	        }
	    }
	    
	    Node addSentence(Node pre, char[] s, int index, int freq){
	        if(index == s.length){
	            return null;
	        }
	        int nextidx = -1;
	        if(s[index] == ' ')
	            nextidx = 26;
	        else
	            nextidx = s[index]-'a';
	        if(pre.next[nextidx] == null){
	            pre.next[nextidx] = new Node();
	            pre.next[nextidx].pre = pre;
	        }
	        Node cur = pre.next[nextidx];
	        Node snode = addSentence(cur, s, index+1, freq);
	        if(snode == null){
	            cur.sentence = new String(s);
	            cur.freq = freq;
	            cur.followSentences.add(cur);
	            snode = cur;
	        }else
	            cur.followSentences.add(snode);
	        return snode;
	    }
	    
	    void updateFollowSentences(Node cur, Node snode){
	        Node p = cur;
	        while(p != head){
	            if(!p.followSentences.remove(snode))
	                break;
	            p = p.pre;
	        }
	        snode.freq++;
	        p = cur;
	        while(p != head){
	            p.followSentences.add(snode);
	            p = p.pre;
	        }
	        
	        return;
	    }
	    
	  
	}

}
