package contest;

public class KthSmallestPrimeFraction_786 {
	class mycomp{
	    public:
	        bool operator()(const pair<vector<int>&, pair<int, int>> &a, const pair<vector<int>&, pair<int, int>> &b){
	            return a.first[a.second.first]*b.first[b.second.second] >= b.first[b.second.first]*a.first[a.second.second];
	        }
	    };
	    /*
	    vector<int> kthSmallestPrimeFraction(vector<int>& A, int K) {
	        if(A.empty())
	            return vector<int>();
	        priority_queue<pair<vector<int>&, pair<int, int>>, vector<pair<vector<int>&, pair<int,int>>>, mycomp> q;
	        q.push(make_pair(ref(A), make_pair(0, (int)A.size()-1)));
	        K--;
	        unordered_set<int> accessed;
	        accessed.insert(0*A.size() + A.size()-1);
	        while(K>0){
	            pair<vector<int>&, pair<int, int>> cur = q.top();
	            q.pop();
	            int i = cur.second.first;
	            int j = cur.second.second;
	            if(j-1 > i && accessed.count(i*A.size() + j-1) == 0){
	                q.push(make_pair(ref(A), make_pair(i, j-1)));
	                accessed.insert(i*A.size() + j-1);
	            }
	            if(i+1 < j && accessed.count((i+1)*A.size()+j)==0){
	                q.push(make_pair(ref(A), make_pair(i+1, j)));
	                accessed.insert((i+1)*A.size()+j);
	            }
	            K--;
	            //cout<<A[i]<<" "<<A[j]<<endl;
	        }
	        vector<int> res(2);
	        res[0] = A[q.top().second.first];
	        res[1] = A[q.top().second.second];
	        return res;
	    }
	    */
	    vector<int> kthSmallestPrimeFraction(vector<int>& A, int K){
	        if(A.empty())
	            return vector<int>();
	        int n = A.size();
	        double left = 1.0 / A.back();
	        double right = 1;
	        pair<int, int> pos;
	        while(right -left > 1e-10){
	            double mid = left + (right-left)/2;
	            int c = countSmaller(A, mid, pos);
	            if(c==K)
	                break;
	            else if(c>K)
	                right = mid;
	            else
	                left = mid;
	        }
	        vector<int> res(2);
	        res[0] = A[pos.first];
	        res[1] = A[pos.second];
	        return res;
	    }
	    int countSmaller(vector<int>& A, double mid, pair<int, int>& pos){
	        int i= 0; 
	        int j= 1;
	        int n = A.size();
	        int count = 0;
	        double closest = -1;
	        while(j<n){
	            double tmp = (double)A[i]/A[j];
	            //cout<<mid<<" "<<i<<" "<<j<<" "<<tmp<<" "<<tmp2;
	            /*if(abs(tmp-mid) < abs(tmp2-mid)){
	                pos.first = i;
	                pos.second = j;
	            }*/
	            if(tmp <= mid){
	                if(closest == -1 || mid-tmp < mid- closest){
	                    pos.first = i;
	                    pos.second = j;
	                    closest = tmp;
	                }
	                count += n-j;
	                i++;
	                if(i == j)
	                    j = i+1;
	            }else{
	                j++;
	            }
	            //cout<<" "<<count<<endl;
	        }
	        //cout<<count<<endl;
	        return count;
	    }

}
