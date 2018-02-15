package google;

public class SuperUglyNumber {
	 /*
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        if(primes.empty())
            return 0;
        if(n==1)
            return 1;
        priority_queue<long, vector<long>, greater<long>> q;
        q.push(1);
        int count = 0;
        long lastn = 0;
        while(count < n){
            long cur = q.top();
            q.pop();
            if(cur == lastn)
                continue;
            //cout<<count<<" "<<q.size()<<endl;
            lastn = cur;
            count++;
            for(int i=0; i<primes.size(); i++){
                if(cur*primes[i] > 0)
                    q.push(cur*primes[i]);
            }
        }
        return lastn;
    }
    */
    
    /*
    int nthSuperUglyNumber(int n, vector<int>& primes){
        if(primes.empty())
            return 0;
        int ugly[n];
        int idx[primes.size()];
        ugly[0] = 1;
        memset(idx, 0, sizeof(int)*primes.size());
        for(int i=1; i<n; i++){
            int next_ugly = INT_MAX;
            for(int j = 0; j<primes.size(); j++){
                if(primes[j] * ugly[idx[j]] == ugly[i-1])
                    idx[j]++;
                next_ugly = min(next_ugly, primes[j]*ugly[idx[j]]);
            }
            ugly[i] = next_ugly;
        }
        return ugly[n-1];
    }
    */
    struct mycomp{
        bool operator()(pair<int, int>& a, pair<int, int>& b){
            return a.first > b.first;
        }
    };
    int nthSuperUglyNumber(int n, vector<int>& primes){
        if(primes.empty())
            return 0;
        int ugly[n];
        int idx[primes.size()];
        ugly[0] = 1;
        memset(idx, 0, sizeof(int)*primes.size());
        priority_queue<pair<int,int>, vector<pair<int, int>>, mycomp> q;
        for(int i=0; i<primes.size(); i++){
            q.push(make_pair(ugly[0]*primes[i], i));
            idx[i]++;
        }
        for(int i=1; i<n; i++){
            while(!q.empty() && q.top().first == ugly[i-1]){
                pair<int, int> tmp = make_pair(ugly[idx[q.top().second]]*primes[q.top().second], q.top().second);
                //cout<<tmp.first<<" "<<tmp.second<<endl;
                idx[q.top().second]++;
                q.pop();
                q.push(tmp);
            }
            ugly[i] = q.top().first;
            //cout<<ugly[i]<<endl;
        }
        return ugly[n-1];
    }

}
