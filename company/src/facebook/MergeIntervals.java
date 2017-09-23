package facebook;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0)
            return res;
        intervals.sort(new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        int curminStart = intervals.get(0).start;
        int curmaxEnd = intervals.get(0).end;
        for(int i = 0; i < intervals.size(); i++){
            Interval tmp = intervals.get(i);
            if(tmp.start <= curmaxEnd){
                curmaxEnd = Math.max(curmaxEnd, tmp.end);
            }else{
                res.add(new Interval(curminStart, curmaxEnd));
                curminStart = tmp.start;
                curmaxEnd = tmp.end;
            }
        }
        res.add(new Interval(curminStart, curmaxEnd));
        return res;
        
        return method2(intervals);
    }
    
    public List<Interval> method2(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0)
            return res;
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        for(int i = 0; i < intervals.size(); i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int minstart = starts[0];
        for(int i=0,j=0;i<starts.length;i++){
            if(i==starts.length-1||starts[i+1]>ends[i]){
                res.add(new Interval(starts[j],ends[i]));
                j=i+1;
            }
        }
        return res;
    }

}
