package google;

public class ConvexPolygen {
	bool isConvex(vector<vector<int>>& points) {
        if(points.size() < 3)
            return false;
        points.push_back(points[0]);
        points.push_back(points[1]);
        int direct = 0;
        for(int i=0; i<points.size()-2; i++){
            int cur = getOrientation(points[i], points[i+1], points[i+2]);
            if(cur==0)
                continue;
            if(direct == 0)
                direct = cur;
            else if(cur != direct)
                return false;
        }
        return true;
        
    }
    int getOrientation(vector<int>& p1, vector<int>& p2, vector<int>& p3){
        int tmp1 = (p2[1]-p1[1])*(p3[0]-p2[0]);
        int tmp2 = (p3[1]-p2[1])*(p2[0]-p1[0]);
        if(tmp1==tmp2)
            return 0;
        else if(tmp1<tmp2)
            return -1;
        else
            return 1;            // =0:  colinear
                                // >0: clockwise
                                // <0: counterclockwise
    }

}
