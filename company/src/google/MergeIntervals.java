package google;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.isEmpty())
            return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        Interval currentInterval = new Interval(intervals.get(0).start, intervals.get(0).end);
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start > currentInterval.end){
                res.add(currentInterval);
                currentInterval = new Interval(intervals.get(i).start, intervals.get(i).end);
            }else{
                if(currentInterval.end < intervals.get(i).end)
                    currentInterval.end = intervals.get(i).end;
            }
        }
        res.add(currentInterval);
        return res;
    }

}
