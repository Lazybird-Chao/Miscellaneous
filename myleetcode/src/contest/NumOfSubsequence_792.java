package contest;

public class NumOfSubsequence_792 {
	class TrieNode{
	    public:
	        TrieNode* next[26];
	        //string w;
	        int count;
	        TrieNode(){
	            for(int i=0; i<26; i++)
	                next[i] = nullptr;
	            //w = "";
	            count=0;
	        }
	    };
	    int numMatchingSubseq(string S, vector<string>& words) {
	        if(words.empty())
	            return 0;
	        TrieNode trie;
	        for(int i=0; i<words.size(); i++){
	            addWords(&trie, words[i]);
	        }
	        int count = findCount(&trie, S, 0);
	        return count;
	        
	    }
	    void addWords(TrieNode *root, string& w){
	        for(int i=0; i<w.size(); i++){
	            char c = w[i];
	            if(root->next[c-'a']==nullptr)
	                root->next[c-'a'] = new TrieNode();
	            root = root->next[c-'a'];
	        }
	        //root->w = w;
	        root->count++;
	    }
	    int findCount(TrieNode *root, string &s, int index){
	        int count = 0;
	        if(root->count != 0)
	            count += root->count;
	        if(index >= s.size())
	            return count;
	        for(int i=0; i<26; i++){
	            if(root->next[i] != nullptr){
	                char c = (char)(i+'a');
	                int pos = s.find(c, index);
	                //cout<<c<<" "<<pos<<endl;
	                if(pos != -1)
	                    count += findCount(root->next[i], s, pos+1);
	            }
	        }
	        return count;
	    }

}
