package facebook;

public class AddSearchWord {
	class WordDictionary {

	    class Node{
	        char v;
	        Node[] next;
	        boolean isleaf;
	        public Node(char c){
	            v = c;
	            isleaf = false;
	            next = new Node[26];
	        }
	    }
	    Node dictHead;
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        dictHead = new Node('#');
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        char[] w = word.toCharArray();
	        Node lastNode = dictHead;
	        for(int i = 0; i < w.length; i++){
	            if(lastNode.next[w[i]-'a'] != null){
	                lastNode = lastNode.next[w[i]-'a'];
	            } else{
	                Node node = new Node(w[i]);
	                lastNode.next[w[i]-'a'] = node;
	                lastNode = node;
	            }
	        }
	        lastNode.isleaf = true;
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        char[] w = word.toCharArray();
	        Node lastNode = dictHead;
	        return helper(word.toCharArray(), 0, lastNode);
	    }
	    
	    boolean helper(char[] w, int index, Node lastNode){
	        if(index == w.length && lastNode.isleaf)
	            return true;
	        else if(index == w.length)
	            return false;
	        if(w[index] == '.'){
	            for(int i = 0; i < 26; i++){
	                if(lastNode.next[i] != null && helper(w, index+1, lastNode.next[i]))
	                    return true;
	            }
	            return false;
	        } else{
	            Node  tmp = lastNode.next[w[index]-'a'];
	            if(tmp != null && helper(w, index+1, tmp))
	                return true;
	            return false;
	        } 
	    }
	    
	    
	}


}
