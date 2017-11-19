package google;

public class WordSearch2 {
	public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<String>();
        if(board == null || words == null){
            ans.add("");
            return ans;
        }
        Node trieHead = new Node('#');
        buildTrie(trieHead, words);
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j<board[0].length; j++)
                dfs(board, i, j, trieHead, ans);
        return ans;
    }
    class Node{
        char ch;
        String word;
        Node[] next;
        public Node(char c){
            ch = c;
            next = new Node[26];
            word = null;
        }
    }
    void buildTrie(Node trieHead, String[] words){
        for(int i = 0; i<words.length; i++){
            char[] w = words[i].toCharArray();
            Node p  = trieHead;
            for(int j = 0; j<w.length; j++){
                char c = w[j];
                if(p.next[c-'a'] == null){
                    p.next[c-'a'] = new Node(c);
                }
                p = p.next[c-'a'];
            }
            p.word = words[i];
        }
        return;
    }
    void dfs(char[][] board, int i, int j, Node lastnode, List<String> ans){
        if(i<0 || i>= board.length || j < 0 || j >= board[0].length)
            return;
        char c = board[i][j];
        if(c == '#' || lastnode.next[c-'a'] == null)
            return;
        lastnode = lastnode.next[c-'a'];
        if(lastnode.word != null){
            ans.add(lastnode.word);
            lastnode.word = null;
        }
        board[i][j] = '#';
        dfs(board, i+1, j, lastnode, ans);
        dfs(board, i-1, j, lastnode, ans);
        dfs(board, i, j+1, lastnode, ans);
        dfs(board, i, j-1, lastnode, ans);
        board[i][j] = c;
        return;
    }

}
