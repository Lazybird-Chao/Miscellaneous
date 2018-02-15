package google;

public class OptimalAccountBalance {
	 /*
    class myequal{
    public:
        bool operator()(const pair<int,int>& a, const pair<int,int>& b){
            return a.first == a.second;
        }
    };
    class myhash{
    public:
        size_t operator()(const pair<int, int>& a){
            return hash<int>{}(a.first);
        }
    };
    
    int minTransfers(vector<vector<int>>& transactions) {
        if(transactions.empty())
            return 0;
        int maxid = 0;
        unordered_set<int> ids;
        for(int i=0; i<transactions.size(); i++){
            int to = transactions[i][0];
            int from = transactions[i][1];
            maxid = max(maxid, from);
            maxid = max(maxid, to);
            ids.insert(from);
            ids.insert(to);
        }
        vector<vector<int>> g = vector<vector<int>>(maxid+1, vector<int>(maxid+1, 0));
        for(int i=0; i<transactions.size(); i++){
            int to = transactions[i][0];
            int from = transactions[i][1];
            int v = transactions[i][2];
            g[from][to] += v;
            if(g[from][to] >= g[to][from]){
                g[from][to] -= g[to][from];
                g[to][from] = 0;
            }else{
                g[to][from] -= g[from][to];
                g[from][to] = 0;
            }
        }
        for(int i=0; i<g.size(); i++){
            if(ids.find(i) == ids.end())
                continue;
            bool flag = true;
            while(flag){
                flag = false;
                for(int j = 0; j<g.size(); j++){
                    if(j==i || g[i][j] == 0)
                        continue;
                    for(int k=0; k<g.size(); k++){
                        if(g[j][k] == 0)
                            continue;
                        if(g[i][j]>=g[j][k]){
                            g[i][j] -= g[j][k];
                            g[i][k] += g[j][k];
                            g[j][k] = 0;
                        }else{
                            g[i][k] += g[i][j];
                            g[j][k] -= g[i][j];
                            g[i][j] = 0;
                        }
                        flag = true;
                        if(g[i][k] >= g[k][i]){
                            g[i][k] -= g[k][i];
                            g[k][i] = 0;
                        }else{
                            g[k][i] -= g[i][k];
                            g[i][k] = 0;
                        }
                    }
                }
            }
        }
        int count = 0;
        for(int i=0; i<g.size(); i++){
            for(int j=i+1; j<g.size(); j++){
                if(g[i][j]!= 0 || g[j][i] != 0)
                    count++;
            }
        }
        return count;
        
    }
    */
    
    int minTransfers(vector<vector<int>>& transactions){
        if(transactions.empty())
            return 0;
        unordered_map<int, int> payment;
        for(int i=0; i<transactions.size(); i++){
            int to = transactions[i][0];
            int from = transactions[i][1];
            int v = transactions[i][2];
            if(payment.find(to)==payment.end())
                payment[to] = v;
            else
                payment[to] += v;
            if(payment.find(from) == payment.end())
                payment[from] = -v;
            else
                payment[from] -= v;
        }
        vector<int> pay;
        vector<int> recv;
        for(auto &it : payment){
            if(it.second > 0)
                recv.push_back(it.second);
            else if(it.second < 0)
                pay.push_back(-it.second);
            //cout<<it.second<<endl;
        }
        if(pay.empty())
            return 0;
        //cout<<pay.size()<<" "<<recv.size()<<endl;
        return findMinMatch(pay, 0, recv);
        
    }
    int findMinMatch(vector<int>& pay, int i, vector<int>& recv){
        if(i==pay.size()-1){
            int c = 0;
            for(int j=0; j<recv.size(); j++){
                if(recv[j] != 0)
                    c++;
            }
            return c;
        }
        int mincount = INT_MAX;
        unordered_set<int> checked;
        for(int k = 0; k<recv.size(); k++){
            if(recv[k]==0)
                continue;
            if(checked.find(recv[k]) != checked.end())
                continue;
            checked.insert(recv[k]);
            int tmpi = pay[i];
            int tmpk = recv[k];
            if(pay[i] == recv[k]){
                pay[i] = 0;
                recv[k] = 0;
                mincount = min(mincount, 1+findMinMatch(pay, i+1, recv));
            }else if(pay[i] > recv[k]){
                pay[i] -= recv[k];
                recv[k] = 0;
                mincount = min(mincount, 1+findMinMatch(pay, i, recv));
            }else{
                recv[k] -= pay[i];
                pay[i] = 0;
                mincount = min(mincount, 1+findMinMatch(pay, i+1, recv));
            }
            //if(i==3)
            //    cout<<mincount<<" "<<k<<" "<<recv[k]<<endl;
            pay[i] = tmpi;
            recv[k] = tmpk; 
        }
        
        return mincount;
    }

}
