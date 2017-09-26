package facebook;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null && newInterval == null)
            return res;
        else if(intervals == null || intervals.size() == 0){
            if(newInterval != null)
                res.add(newInterval);
            return res;
        } else if(newInterval == null)
            return intervals;
        
        int i = 0;
        int start = 0;
        int end = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i));
            i++;
        }
        if(i < intervals.size())
            start = Math.min(newInterval.start, intervals.get(i).start);
        else
            start = newInterval.start;
        end = newInterval.end;
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        res.add(new Interval(start, end));
        while(i < intervals.size()){
            res.add(intervals.get(i));
            i++;
        }
        return res;
        
        return method2(intervals, newInterval);
    }
    
    public List<Interval> method2(List<Interval> intervals, Interval newInterval){
        List<Interval> res = new ArrayList<Interval>();
        int leftinsert = findPos(intervals, newInterval.start);
        int rightinsert = findPos(intervals, newInterval.end);
        //System.out.println(leftinsert);
        //System.out.println(rightinsert);
        int start = 0;
        int end = 0;
        int k1 = 0;
        int k2 = 0;
        if(rightinsert == 0){
            start = newInterval.start;
            end = newInterval.end;
            k1 = 0;
            k2 = 0;
        } else if(leftinsert == intervals.size()*2){
            start = newInterval.start;
            end = newInterval.end;
            k1 = intervals.size();
            k2 = k1;
        } else{
            if(leftinsert == 0){
                start = newInterval.start;
                k1 = 0;
            }else{
                if(leftinsert % 2 ==0){
                    start = newInterval.start;
                    k1 = leftinsert/2;
                } else{
                    start = intervals.get(leftinsert/2).start;
                    k1 = leftinsert/2;
                }
            }
            if(rightinsert == intervals.size()*2){
                end = newInterval.end;
                k2 = intervals.size();
            }else{
                if(rightinsert % 2 ==0){
                    end = newInterval.end;
                    k2 = rightinsert / 2;
                }else{
                    end = intervals.get(rightinsert/2).end;
                    k2 = rightinsert /2 +1;
                }
            }
        }
        for(int i=0; i<k1; i++)
            res.add(intervals.get(i));
        res.add(new Interval(start, end));
        for(int i=k2; i<intervals.size(); i++)
            res.add(intervals.get(i));
        return res;
    }
    int findPos(List<Interval> intervals, int k){
        int left = 0;
        int right = intervals.size()-1;
        while(left + 1 < right){
            int mid = left + (right-left)/2;
            if(intervals.get(mid).start <=k  && intervals.get(mid).end >=k)
                return mid*2+1;
            else if(k < intervals.get(mid).start)
                right = mid;
            else
                left = mid;
        }
        //System.out.println(left);
        //System.out.println(right);
        if( k < intervals.get(left).start)
            return 0;
        else if( k <= intervals.get(left).end)
            return left*2+1;
        else if( k <intervals.get(right).start)
            return left*2+2;
        else if(k <= intervals.get(right).end)
            return right*2+1;
        else
            return right*2+2;
    }

}
