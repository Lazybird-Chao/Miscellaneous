package google;

public class CoinPath {
	/*
    vector<int> cheapestJump(vector<int>& A, int B) {
        if(A.empty() || B < 1)
            return vector<int>();
        vector<int> fcost(A.size(), INT_MAX);
        vector<int> fidx(A.size(), -1);
        fcost[0] = A[0];
        fidx[0] = 0;
        for(int i=0; i<A.size()-1; i++){
            if(A[i]==-1 || fcost[i] == INT_MAX)
                continue;
            for(int j=1; j<=B && i+j<A.size(); j++){
                if(A[i+j] == -1)
                    continue;
                int tmp = fcost[i] + A[i+j];
                if(tmp < fcost[i+j]){
                    fcost[i+j] = tmp;
                    fidx[i+j] = i;
                }
            }
        }
        vector<int> res;
        if(fcost[A.size()-1] == INT_MAX)
            return res;
        int idx = A.size()-1;
        while(idx != 0){
            res.push_back(idx+1);
            idx = fidx[idx];
        }
        res.push_back(1);
        reverse(res.begin(), res.end());
        return res;
    }
    */
    vector<int> cheapestJump(vector<int>& A, int B) {
        if(A.empty() || B <1 || A.back() == -1)
            return vector<int>();
        deque<pair<int, int>> q;
        q.push_back(make_pair(A.back(), A.size()-1));
        vector<int> idx(A.size(), -1);
        idx[A.size()-1] = A.size()-1;
        int i = (int)A.size()-2;
        while(i>=0){
            if(A[i] == -1){
                i--;
                continue;
            }
            if(q.empty())
                break;
            //cout<<q.front().second<<endl;
            if(q.front().second - i > B){
                q.pop_front();
                continue;
            }
            idx[i] = q.front().second;
            int cur_cost = A[i] + q.front().first;
            while(!q.empty() && cur_cost <= q.back().first)
                q.pop_back();
            q.push_back(make_pair(cur_cost, i));
            i--;
        }
        
        if(idx[0] == -1)
            return vector<int>();
        else{
            vector<int> res;
            i = 0;
            while(i != A.size()-1){
                res.push_back(i+1);
                i = idx[i];
            }
            res.push_back(i+1);
            return res;
        }
        
    }

}
