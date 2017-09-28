package facebook;

class Trie {

    class TrieNode{
        char letter;
        boolean isleaf;
        TrieNode[] next;
        public TrieNode(char c){
            letter = c;
            isleaf = false;
            next = new TrieNode[26];
        }
    }
    TrieNode head;
    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode('#');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.isEmpty())
            return;
        char[] w = word.toCharArray();
        TrieNode p = head;
        for(int i = 0; i < w.length; i++){
            if(p.next[w[i]-'a'] == null){
                p.next[w[i]-'a'] = new TrieNode(w[i]);
            }
            p = p.next[w[i]-'a'];
        }
        p.isleaf = true;
        return;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null)
            return false;
        if(word.isEmpty())
            return true;
        char[] w = word.toCharArray();
        TrieNode p = head;
        for(int i = 0; i < w.length; i++){
            if(p.next[w[i]-'a'] == null)
                return false;
            p = p.next[w[i]-'a'];
        }
        return p.isleaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null)
            return false;
        if(prefix.isEmpty())
            return true;
        char[] w = prefix.toCharArray();
        TrieNode p = head;
        for(int i = 0; i < w.length; i++){
            if(p.next[w[i]-'a'] == null)
                return false;
            p = p.next[w[i]-'a'];
        }
        return true;
    }
}
