package google;

public class MagicDictionary {
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
	    
	    bool find(TrieNode *p, string w, int index){
	        int i = index;
	        while(i<w.size()){
	            if(p->next[w[i]-'a'] == nullptr)
	                return false;
	            p = p->next[w[i]-'a'];
	            i++;
	        }
	        return !(p->w.empty());
	    }
	    
	    TrieNode *head;
	    int dict_size;
	    /** Initialize your data structure here. */
	    MagicDictionary() {
	        head = new TrieNode();
	        dict_size;
	    }
	    
	    /** Build a dictionary through a list of words */
	    void buildDict(vector<string> dict) {
	        dict_size = dict.size();
	        for(int i=0; i<dict.size(); i++){
	            string w = dict[i];
	            TrieNode *p = head;
	            int j = 0;
	            while(j<w.size()){
	                if(p->next[w[j]-'a'] == nullptr)
	                    p->next[w[j]-'a'] = new TrieNode();
	                p = p->next[w[j]-'a'];
	                j++;
	            }
	            p->w = w;
	        }
	    }
	    
	    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	    bool search(string word) {
	        if(word.empty() || dict_size==0)
	            return false;
	        int i=0;
	        TrieNode *p = head;
	        while(i<word.size()){
	            if(p->next[word[i]-'a'] == nullptr)
	                break;
	            for(int j=0; j<26; j++){
	                if(p->next[j] != nullptr && j != word[i]-'a'){
	                    if(find(p->next[j], word, i+1))
	                        return true;
	                }
	            }
	            p = p->next[word[i]-'a'];
	            i++;
	        }
	        if(i==word.size())
	            return false;
	        for(int j=0; j<26; j++){
	            if(p->next[j] != nullptr){
	                if(find(p->next[j], word, i+1))
	                    return true;
	            }
	        }
	        return false;
	    }

}
