package facebook;

public class MeetingRooms2 {
	public int minMeetingRooms(Interval[] intervals) {
        /*
        if(intervals == null || intervals.length ==0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        PriorityQueue<Interval> q = new PriorityQueue<Interval>(1, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.end - b.end;
            }});
        int max =0;
        for(int i=0; i<intervals.length; i++){
            if(!q.isEmpty() && q.peek().end <= intervals[i].start){
                q.poll();
                q.offer(intervals[i]);
            }else {
                q.offer(intervals[i]);
            }
            max = Math.max(q.size(), max);
        }
        return max;
        */
        
        return method2(intervals);
    }
    
    
    public int method2(Interval[] intervals) {
        if(intervals == null || intervals.length ==0)
            return 0;
        int[] starttime = new int[intervals.length];
        int[] endtime = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            starttime[i] = intervals[i].start;
            endtime[i] = intervals[i].end;
        }
        Arrays.sort(starttime);
        Arrays.sort(endtime);
        
        int max=0;
        int minend = 0;
        int rooms=0;
        for(int i=0; i<intervals.length; i++){
            if(starttime[i] < endtime[minend]){
                rooms++;
                max = Math.max(rooms, max);
            } else{
                minend++;
            }
        }
        return max;
    }

}
