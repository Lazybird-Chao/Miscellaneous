package google;

public class WordSquare {
	class TrieNode{
	    public:
	        string w;
	        TrieNode *next[26];
	        TrieNode(){
	            w = "";
	            for(int i=0; i<26; i++)
	                next[i] = nullptr;
	        }
	        
	    };
	    void addWord(TrieNode *root, string w){
	        TrieNode *p = root;
	        for(int i=0; i<w.size(); i++){
	            if(p->next[w[i]-'a'] == nullptr)
	                p->next[w[i]-'a'] = new TrieNode();
	            p = p->next[w[i]-'a'];
	        }
	        p->w = w;
	        return;
	    }
	    TrieNode *findPrefix(TrieNode *root, string prefix){
	        TrieNode *p = root;
	        for(int i=0; i<prefix.size(); i++){
	            if(root->next[prefix[i]-'a']==nullptr)
	                return nullptr;
	            root = root->next[prefix[i]-'a'];
	        }
	        return root;
	    }
	    void getWords(TrieNode *root, vector<string> &wlist){
	        if(root->w != ""){
	            wlist.push_back(root->w);
	            return;
	        }
	        for(int i=0; i<26; i++){
	            if(root->next[i] != nullptr)
	                getWords(root->next[i], wlist);
	        }
	        return;
	    }
	    bool checkWord(vector<string> &word_seq, int size, string w){
	        for(int i=0; i<size; i++){
	            if(w == word_seq[i])
	                return true;
	        }
	        return false;
	    }
	    
	    vector<vector<string>> res;
	    vector<vector<string>> wordSquares(vector<string>& words) {
	        if(words.empty())
	            return vector<vector<string>>();
	        TrieNode *head = new TrieNode();
	        for(int i=0; i<words.size(); i++)
	            addWord(head, words[i]);
	        vector<string> word_seq(words[0].size());
	        for(int i=0; i<words.size(); i++){
	            string word = words[i];
	            word_seq[0] = word;
	            if(word.size() <2)
	                res.push_back(word_seq);
	            else
	                findNextWord(word_seq, 1, head, word.substr(1,1));
	        }
	        return res;
	    }
	    void findNextWord(vector<string> &word_seq, int index, TrieNode *root, string prefix){
	        string nextprefix = "";
	        if(index + 1 < word_seq.size()){
	            for(int i=0; i<index; i++)
	                nextprefix.push_back(word_seq[i][index+1]);
	        }
	        //cout<<index<<" "<<prefix<<" "<<nextprefix<<endl;
	        TrieNode *p = findPrefix(root, prefix);
	        if(p==nullptr)
	            return;
	        vector<string> wlist;
	        getWords(p, wlist);
	        for(int i=0; i<wlist.size(); i++){
	            //if(checkWord(word_seq, index, wlist[i])==true)
	            //    continue;
	            if(index + 1 < word_seq.size()){
	                nextprefix.push_back(wlist[i][index+1]);
	                word_seq[index] = wlist[i];
	                findNextWord(word_seq, index+1, root, nextprefix);
	            nextprefix.pop_back();
	            }else{
	                word_seq[index] = wlist[i];
	                res.push_back(word_seq);
	            }
	        }
	        return;
	    }

}
