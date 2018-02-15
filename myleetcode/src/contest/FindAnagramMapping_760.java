package contest;

public class FindAnagramMapping_760 {
	vector<int> anagramMappings(vector<int>& A, vector<int>& B) {
        if(A.empty())
            return vector<int>();
        unordered_map<int, vector<int>> pos_map;
        for(int i=0; i<B.size(); i++){
            if(pos_map.find(B[i])==pos_map.end())
                pos_map[B[i]] = vector<int>(1, i);
            else
                pos_map[B[i]].push_back(i);
        }
        vector<int> res;
        for(int i=0; i<A.size(); i++){
            res.push_back(pos_map[A[i]].back());
            pos_map[A[i]].pop_back();
        }
        return res;
    }

}
