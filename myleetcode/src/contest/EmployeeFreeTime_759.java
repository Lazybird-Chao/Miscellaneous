package contest;

public class EmployeeFreeTime_759 {
	vector<Interval> employeeFreeTime(vector<vector<Interval>>& schedule) {
        if(schedule.empty())
            return vector<Interval>();
        vector<Interval> total_worktime_interval;
        vector<int> starts;
        vector<int> ends;
        for(int i=0; i<schedule.size(); i++){
            for(int j=0; j<schedule[i].size(); j++){
                starts.push_back(schedule[i][j].start);
                ends.push_back(schedule[i][j].end);
            }
        }
        sort(starts.begin(), starts.end());
        sort(ends.begin(), ends.end());
        int s = starts[0];
        int count = 0;
        int i=0, j=0;
        while(i<starts.size() && j<ends.size()){
            if(starts[i] <= ends[j]){
                count++;
                i++;
                continue;
            }
            count--;
            if(count==0){
                total_worktime_interval.push_back(Interval(s, ends[j]));
                s = starts[i];
            }
            j++;
        }
        total_worktime_interval.push_back(Interval(s, ends.back()));
        vector<Interval> res;
        for(int i = 1; i<total_worktime_interval.size(); i++){
            res.push_back(Interval(total_worktime_interval[i-1].end, total_worktime_interval[i].start));
        }
        return res;
        
    }

}
