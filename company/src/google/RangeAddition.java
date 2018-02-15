package google;

public class RangeAddition {
	vector<int> getModifiedArray(int length, vector<vector<int>>& updates) {
        if(updates.empty())
            return vector<int>(length, 0);
        vector<int> res(length, 0);
        for(int i=0; i<updates.size(); i++){
            res[updates[i][0]] += updates[i][2];
            if(updates[i][1]+1 < length)
                res[updates[i][1]+1] -= updates[i][2];
        }
        for(int i=1; i<length; i++)
            res[i] += res[i-1];
        return res;
    }

}
