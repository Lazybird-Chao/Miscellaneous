package google;

public class AddBoldTagInString {
	string addBoldTag(string s, vector<string>& dict) {
        if(s.empty() || dict.empty())
            return s;
        vector<int> starts;
        vector<int> ends;
        for(auto &w : dict){
            int pos = s.find(w, 0);
            while(pos != -1){
                starts.push_back(pos);
                ends.push_back(pos+w.size()-1);
                pos = s.find(w, pos+1);
            }
        }
        if(starts.empty())
            return s;
        sort(starts.begin(), starts.end());
        sort(ends.begin(), ends.end());
        //cout<<starts.size()<<" "<<ends.size()<<endl;
        vector<int> starts2;
        vector<int> ends2;
        int i=0;
        int j=0;
        starts2.push_back(starts[0]);
        int count = 0;
        while(i<starts.size() && j<ends.size()){
            if(starts[i] <= ends[j]+1){
                count++;
                i++;
            }else{
                count--;
                j++;
                if(count==0){
                    //cout<<starts2.back()<<" "<<ends[j-1]<<endl;
                    ends2.push_back(ends[j-1]);
                    starts2.push_back(starts[i]);
                }
            }
        }
        ends2.push_back(ends.back());
        //cout<<starts2.size()<<" "<<ends2.size()<<endl;
        string res;
        int pre = 0;
        for( i=0; i<starts2.size(); i++){
            res += s.substr(pre, starts2[i]-pre);
            pre = starts2[i];
            res += "<b>";
            res += s.substr(pre, ends2[i]-pre+1);
            pre = ends2[i]+1;
            res += "</b>";
            //cout<<starts2[i]<<" "<<ends2[i]<<endl;
        }
        res += s.substr(pre);
        return res;
    }

}
