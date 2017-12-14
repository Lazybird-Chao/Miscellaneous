package contest;

public class PrefixAndSuffixSearch_745 {
	class TrieNode{
        public:
        vector<int> weight;
        string word;
        TrieNode *next[26];
        TrieNode(){
            word = "";
            for(int i=0; i<26; i++)
                next[i] = nullptr;
        }
        
        void addWord(string word, int w){
            TrieNode *p = this;
            for(int i=0; i<word.size(); i++){
                char c = word[i];
                if(p->next[c-'a'] == nullptr)
                    p->next[c-'a'] = new TrieNode();
                p = p->next[c-'a'];
                p->weight.push_back(w);
            }
            p->word = word;
            return;
        }
        
        /*
        void search(unordered_map<string, int> &s, TrieNode *root){
            if(root == nullptr)
                return;
            if(root->weight != -1)
                s[root->word] = root->weight;
            for(int i=0; i<26; i++)
                search(s, root->next[i]);
        }
        void searchPrefix(string prefix, unordered_map<string, int> &s){
            TrieNode *p = this;
            for(int i=0; i<prefix.size(); i++){
                char c = prefix[i];
                if(p->next[c-'a']==nullptr)
                    return;
                p = p->next[c-'a'];
            }
            search(s, p);
            return;
        }
        */
        vector<int>* search(string prefix){
            TrieNode *p = this;
            for(int i=0; i<prefix.size(); i++){
                char c = prefix[i];
                if(p->next[c-'a'] == nullptr)
                    return nullptr;
                p = p->next[c-'a'];
            }
            return &(p->weight);
        }
    };
    TrieNode forwardTrie;
    TrieNode backwardTrie;
    WordFilter(vector<string> words) {
        if(!words.empty()){
            for(int i=0; i<words.size(); i++){
                forwardTrie.addWord(words[i], i);
            }
            for(int i=0; i<words.size(); i++){
                reverse(words[i].begin(), words[i].end());
                backwardTrie.addWord(words[i], i);
            }
        }
        
    }
    
    /*
    int f(string prefix, string suffix) {
        unordered_map<string, int> preWords;
        unordered_map<string, int> sufWords;
        if(!prefix.empty())
            forwardTrie.searchPrefix(prefix, preWords);
        if(!suffix.empty())
            backwardTrie.searchPrefix(suffix, sufWords);
        int maxw = -1;
        if(prefix.empty()){
            for(auto &it: sufWords)
                maxw = max(maxw, it.second);
        }else if(suffix.empty()){
            for(auto &it: preWords)
                maxw = max(maxw, it.second);
        }else{
            for(auto &it: preWords){
                if(sufWords.find(it.first) != sufWords.end())
                    maxw = max(maxw, it.second);
            }
        }
        return maxw;
        
    }
    */
    int f(string prefix, string suffix){
        vector<int> *w1 = nullptr;
        vector<int> *w2 = nullptr;
        if(!prefix.empty())
            w1 = forwardTrie.search(prefix);
        if(!suffix.empty())
            w2 = backwardTrie.search(suffix);
        if(w1 == nullptr && w2==nullptr)
            return 0;
        else if(w1 == nullptr)
            return w2->back();
        else if(w2==nullptr)
            return w1->back();
        else{
            int i, j;
            i = w1->size()-1;
            j = w2->size()-1;
            while(i>=0 && j>=0){
                if((*w1)[i]>(*w2)[j])
                    i--;
                else if((*w1)[i]<(*w2)[j])
                    j--;
                else
                    return (*w1)[i];
            }
            return -1;
        }
        
    }

}
