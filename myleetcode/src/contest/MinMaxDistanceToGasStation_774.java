package contest;

public class MinMaxDistanceToGasStation_774 {
	double minmaxGasDist(vector<int>& stations, int K) {
        if(stations.empty())
            return 0;
        double len = stations.back()-stations.front();
        double maxD = 0;
        vector<double> dis;
        for(int i=0; i<stations.size()-1; i++){
            dis.push_back(stations[i+1]-stations[i]);
            maxD = max(maxD, (double)stations[i+1]-stations[i]);
        }
        sort(dis.begin(), dis.end(), greater<double>());
        double minD = len / (stations.size()-1+K);
        while(maxD - minD >1e-6){
            double midD = minD + (maxD-minD)/2;
            if(checkDistance(dis, midD, K) == false)
                minD = midD;
            else
                maxD = midD;
        }
        if(checkDistance(dis, minD, K) == false)
            return maxD;
        else
            return minD;
    }
    bool checkDistance(vector<double>& dis, double target_dis, int k){
        for(int i=0; i<dis.size(); i++){
            if(dis[i] > target_dis){
                int c = (int)(floor(dis[i] / target_dis));
                k -= c;
                if(k < 0)
                    return false;
            }else
                break;
        }
        return true;
        
    }

}
