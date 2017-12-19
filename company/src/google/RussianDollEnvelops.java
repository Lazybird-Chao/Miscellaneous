package google;

public class RussianDollEnvelops {
	/*
    int maxEnvelopes(vector<pair<int, int>>& envelopes) {
        if(envelopes.empty())
            return 0;
        sort(envelopes.begin(), envelopes.end(), mycomp);
        vector<int> f(envelopes.size(), 1);
        int maxdoll = 1;
        for(int i=1; i<envelopes.size(); i++){
            for(int j= i-1; j>=0; j--){
                if(envelopes[i].first > envelopes[j].first && 
                    envelopes[i].second > envelopes[j].second && f[j]+1>f[i])
                    f[i] = f[j]+1;
            }
            maxdoll = max(maxdoll, f[i]);
        }
        return maxdoll;
        
    }
    
    static bool mycomp(pair<int,int> a, pair<int, int> b){
        if(a.first != b.first)
            return a.first < b.first;
        else
            return a.second < b.second;
    }
    */
    int maxEnvelopes(vector<pair<int, int>>& envelopes) {
        if(envelopes.empty())
            return 0;
        sort(envelopes.begin(), envelopes.end(), mycomp);
        set<int> h_list;
        for(int i=0; i<envelopes.size(); i++){
            int curh = envelopes[i].second;
            auto tmp = h_list.lower_bound(curh);
            if( tmp == h_list.end())
                h_list.insert(curh);
            else{
                h_list.erase(tmp);
                h_list.insert(curh);
            }
        }
        return h_list.size();
    }
    
    static bool mycomp(pair<int, int> a, pair<int,int> b){
        if(a.first != b.first)
            return a.first < b.first;
        else
            return b.second < a.second;
    }

}
