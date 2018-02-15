package google;

public class MeetingRooms2 {
	int minMeetingRooms(vector<Interval>& intervals) {
        if(intervals.empty())
            return 0;
        vector<int> s;
        vector<int> e;
        for(int i=0; i<intervals.size(); i++){
            s.push_back(intervals[i].start);
            e.push_back(intervals[i].end);
        }
        sort(s.begin(), s.end());
        sort(e.begin(), e.end());
        int count = 0;
        int maxcount = 0;
        int i=0;
        int j=0;
        while(i<s.size()){
            if(s[i] < e[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            maxcount = max(maxcount, count);
        }
        return maxcount;
    }

}
