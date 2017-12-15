package google;

public class ImplementTrie {
	class Trie {
		public:
		    class Node{
		    public:
		        Node *next[26];
		        string word;
		        Node(){
		            for(int i=0; i<26; i++)
		                next[i] = nullptr;
		            word = "";
		        }
		    };
		    /** Initialize your data structure here. */
		    Trie() {
		        
		    }
		    ~Trie(){
		        for(Node *p : trieHead.next)
		            deleteNode(p);
		    }
		    void deleteNode(Node *p){
		        if(p==nullptr)
		            return;
		        for(int i=0; i<26; i++){
		            if(p->next[i]!=nullptr)
		                delete p->next[i];
		        }
		        delete p;
		    }
		    
		    /** Inserts a word into the trie. */
		    void insert(string word) {
		        Node *p = &trieHead;
		        for(int i =0; i<word.size(); i++){
		            char c = word[i];
		            if(p->next[c-'a'] == nullptr)
		                p->next[c-'a'] = new Node();
		            p = p->next[c-'a'];
		        }
		        p->word = word;
		    }
		    
		    /** Returns if the word is in the trie. */
		    bool search(string word) {
		        Node *p = &trieHead;
		        for(int i=0; i<word.size(); i++){
		            char c = word[i];
		            if(p->next[c-'a'] == nullptr)
		                return false;
		            p = p->next[c-'a'];
		        }
		        if(p->word == word)
		            return true;
		        else
		            return false;
		    }
		    
		    /** Returns if there is any word in the trie that starts with the given prefix. */
		    bool startsWith(string prefix) {
		        Node *p = &trieHead;
		        for(int i=0; i<prefix.size(); i++){
		            char c = prefix[i];
		            if(p->next[c-'a'] == nullptr)
		                return false;
		            p = p->next[c-'a'];
		        }
		        return true;
		    }
		    
		    
		private:
		    Node trieHead;
		};

}
