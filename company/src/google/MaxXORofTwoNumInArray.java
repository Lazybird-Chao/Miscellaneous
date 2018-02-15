package google;

public class MaxXORofTwoNumInArray {
	struct TrieNode{
        struct TrieNode *next[2];
        TrieNode(){
            next[0] = nullptr;
            next[1] = nullptr;
        }
    };
    int findMaximumXOR(vector<int>& nums) {
        TrieNode trie;
        for(int i=0; i<nums.size(); i++){
            int num = nums[i];
            TrieNode *p = &trie;
            for(int j=31; j>=0; j--){
                int curbit = (num>>j) & 1;
                if(p->next[curbit] == nullptr)
                    p->next[curbit] = new TrieNode();
                p = p->next[curbit];
            }
        }
        
        int maxxor = 0;
        for(int i=0; i<nums.size(); i++){
            int num = nums[i];
            TrieNode *p = &trie;
            int curmax = 0;
            for(int j = 31; j>=0; j--){
                int curbit = (num>>j) &1;
                if(p->next[curbit ^ 1] != nullptr){
                    p = p->next[curbit ^ 1];
                    curmax = curmax | (1<<j);
                }
                else{
                    p = p->next[curbit];
                }
            }
            maxxor = max(curmax, maxxor);
        }
        return maxxor;
    }

}
