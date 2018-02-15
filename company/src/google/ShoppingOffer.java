package google;

public class ShoppingOffer {
	int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        int num_items = price.size();
        vector<vector<int>> items;
        vector<int> value;
        for(int i=0; i<num_items; i++){
            items.push_back(vector<int>());
            value.push_back(price[i]);
            for(int j=0; j<num_items; j++){
                if(j==i)
                    items[i].push_back(1);
                else
                    items[i].push_back(0);
            }
        }
        for(int i=0; i<special.size(); i++){
            items.push_back(vector<int>());
            value.push_back(special[i].back());
            for(int j=0; j<special[i].size()-1; j++)
                items[items.size()-1].push_back(special[i][j]);
        }
        int total_needs=1;
        for(int i=0; i<needs.size(); i++){
            total_needs *= needs[i]+1;    
        }
        vector<vector<int>> pos_needs;
        pos_needs.push_back(vector<int>(num_items, 0));
        for(int i=1; i<total_needs; i++){
            vector<int> cur = pos_needs.back();
            for(int j=0; j<num_items; j++){
                if(cur[j]+1 <= needs[j]){
                    cur[j] = cur[j]+1;
                    break;
                }else
                    cur[j] = 0;
            }
            pos_needs.push_back(cur);
        }
        int f[pos_needs.size()];
        f[0] = 0;
        for(int i=1; i<pos_needs.size(); i++)
            f[i] = -1;
        //cout<<items.size()<<endl;
        for(int i=1; i<=items.size(); i++){
            for(int j=1; j<pos_needs.size(); j++){
                //cout<<j<<"- ";
                if(mycomp(items[i-1], pos_needs[j])==false)
                    continue;
                int jj = conv(mysub(pos_needs[j], items[i-1]), needs);
                /*for(int k=0; k<pos_needs[jj].size();k++)
                    cout<<pos_needs[jj][k]<<" ";
                cout<<endl;*/
                if(f[jj]==-1)
                    continue;
                if(f[j] == -1)
                    f[j] = f[jj] + value[i-1];
                else
                    f[j] = min(f[j], f[jj] + value[i-1]);
                //cout<<f[j]<<", ";
            }
            //cout<<endl;
        }
        
        return f[pos_needs.size()-1];
    }
    
    bool mycomp(vector<int>& a, vector<int>& b){
        for(int i=0; i<a.size(); i++){
            if(a[i] > b[i])
                return false;
        }
        return true;
    }
    vector<int> mysub(vector<int>& a, vector<int>& b){
        vector<int> res(a.size());
        for(int i=0; i<a.size(); i++)
            res[i] = a[i] - b[i];
        return res;
    }
    int conv(vector<int> a, vector<int> needs){
        int b = 1;
        int r = 0;
        for(int i=0; i<a.size(); i++){
            r += a[i]*b;
            b *= needs[i]+1;
        }
        return r;
    }

}
