package google;

public class CreateMaxNumber {
	vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<int> res;
        cout<<nums1.size()<<" "<<nums2.size()<<endl;
        for(int i=0; i<=k; i++){
            if(i>nums1.size() || k-i>nums2.size())
                continue;
            vector<int> n1 = maxK(nums1, i);
            vector<int> n2 = maxK(nums2, k-i);
            vector<int> cur_n = combineMax(n1, n2);
            /*
            for(auto it:n1)
                cout<<it<<" ";
            cout<<endl;
            for(auto it:n2)
                cout<<it<<" ";
            cout<<endl;
            for(auto it:cur_n)
                cout<<it<<" ";
            cout<<endl;
            cout<<endl;
            */
            if(mycomp(res, cur_n) > 0)
                res = cur_n;
        }
        return res;
    }
    vector<int> combineMax(vector<int>& n1, vector<int>& n2){
        vector<int> res;
        int i=0, j=0;
        while(i<n1.size() && j<n2.size()){
            if(n1[i]>n2[j]){
                res.push_back(n1[i]);
                i++;
            }
            else if(n1[i]<n2[j]){
                res.push_back(n2[j]);
                j++;
            }else{
                int ii=i+1;
                int jj=j+1;
                while(ii<n1.size() && jj<n2.size() && n1[ii]==n2[jj]){
                    ii++;
                    jj++;
                }
                if(jj==n2.size() || (ii<n1.size() && jj<n2.size() && n1[ii]>n2[jj])){
                    res.push_back(n1[i]);
                    i++;
                    
                }else{
                    res.push_back(n2[j]);
                    j++;
                    
                }
            }
        }
        while(i<n1.size()){
            res.push_back(n1[i]);
            i++;
        }
        while(j<n2.size()){
            res.push_back(n2[j]);
            j++;
        }
        return res;
    }
    int mycomp(vector<int>& a, vector<int>& b){
        if(a.size()<b.size())
            return 1;
        if(a.size()>b.size())
            return -1;
        for(int i=0; i<a.size(); i++){
            if(a[i]<b[i])
                return 1;
            else if(a[i]>b[i])
                return -1;
        }
        return 0;
    }
    vector<int> maxK(vector<int> &num, int k){
        if(k==0 || k>num.size())
            return vector<int>();
        if(k==num.size())
            return num;
        deque<int> q;
        for(int i = num.size()-k; i>=0; i--){
            if(q.empty())
                q.push_front(num[i]);
            else if(num[i] >= q.front())
                q.push_front(num[i]);
        }
        vector<int> res;
        res.push_back(q.front());
        q.pop_front();
        for(int i=num.size()-k+1; i<num.size(); i++){
            while(!q.empty() && num[i] > q.back()){
                q.pop_back();
            }
            q.push_back(num[i]);
            res.push_back(q.front());
            q.pop_front();
        }
        return res;
    }

}
