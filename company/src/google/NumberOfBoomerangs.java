package google;

public class NumberOfBoomerangs {
	int numberOfBoomerangs(vector<pair<int, int>>& points) {
        if(points.size() < 3)
            return 0;
        int distance[points.size()][points.size()];
        unordered_map<int, int> s;
        int count = 0;
        for(int i=0; i<points.size(); i++){
            s.clear();
            for(int j= 0; j<points.size(); j++){
                int d = dis2(points[i], points[j]);
                if(s.find(d) == s.end())
                    s[d] = 1;
                else{
                    count += 2*s[d];
                    s[d] += 1;
                }
            }
        }
        return count;
    }
    int dis2(pair<int, int>& a, pair<int, int>& b){
        return (a.first-b.first)*(a.first-b.first) + (a.second-b.second)*(a.second-b.second);
    }

}
