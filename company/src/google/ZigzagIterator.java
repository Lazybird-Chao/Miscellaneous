package google;

public class ZigzagIterator {
	public:
	    int n;
	    int index[2];
	    vector<int> v[2];
	    int idx_pos;
	    ZigzagIterator(vector<int>& v1, vector<int>& v2) {
	        v[0] = v1;
	        v[1] = v2;
	        n = v1.size() + v2.size();
	        index[0] = index[1] = 0;
	        idx_pos = 0;
	    }

	    int next() {
	        if(index[idx_pos] >= v[idx_pos].size())
	            idx_pos = (idx_pos+1)%2;
	        int res = v[idx_pos][index[idx_pos]];
	        index[idx_pos]++;
	        idx_pos = (idx_pos+1)%2;
	        n--;
	        return res;
	    }

	    bool hasNext() {
	        if(n>0)
	            return true;
	        else
	            return false;
	    }

}
