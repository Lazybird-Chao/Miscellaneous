package google;

public class InsertInterval {
	vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
        vector<Interval> res;
        if(intervals.empty()){
            res.push_back(newInterval);
            return res;
        }
        int start, end;
        start = newInterval.start;
        end = newInterval.end;
        int i = 0;
        for(; i<intervals.size(); i++){
            if(intervals[i].end < newInterval.start)
                res.push_back(intervals[i]);
            else{
                start = min(intervals[i].start, newInterval.start);
                break;
            }
        }
        for(;i<intervals.size(); i++){
            if(intervals[i].start > newInterval.end){
                break;
            }
        }
        if(i>0)
            end = max(intervals[i-1].end, newInterval.end);
        Interval tmp(start, end);
        res.push_back(tmp);
        for(; i<intervals.size(); i++)
            res.push_back(intervals[i]);
        return res;

    }

}
