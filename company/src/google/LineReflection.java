package google;

public class LineReflection {
	bool isReflected(vector<pair<int, int>>& points) {
        if(points.empty())
            return true;
        sort(points.begin(), points.end(), less<pair<int,int>>());
        float midx = points[0].first + ((float)points.back().first - points[0].first)/2;
        int i=0;
        int j=points.size()-1;
        //cout<<midx<<endl;
        while(i<j){
            if(points[i].first == points[j].first){
                if(points[i].first == midx)
                    break;
                else
                    return false;
            }
            int k = j;
            while(k>i && points[k].first == points[j].first)
                k--;
            int j2 = k+1;
            while(midx-points[i].first == points[j2].first-midx && points[i].second == points[j2].second && j2<=j){
                if(points[i].first == points[i+1].first && points[i].second == points[i+1].second){
                    i++;
                    continue;
                }
                if(points[j2].first == points[j2+1].first && points[j2].second == points[j2+1].second){
                    j2++;
                    continue;
                }
                i++;
                j2++;
            }
            if(j2<=j)
                return false;
            j = k;
            //cout<<i<<" "<<j<<endl;
        }
        if(i==j && points[i].first != midx)
            return false;
        return true;
    }

}
