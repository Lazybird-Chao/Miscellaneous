package contest;

public class MyCalendar2_731 {
	class MyCalendarTwo {

	    class Point{
	        int time;
	        int isStart;
	        public Point(int t, int s){
	            time = t;
	            isStart = s;
	        }
	        public int compareTo(Point other){
	            if(this.time != other.time)
	                return this.time - other.time;
	            else
	                return this.isStart - other.isStart;
	        }
	    }
	    List<Point> eventsTimePoint;
	    public MyCalendarTwo() {
	        eventsTimePoint = new LinkedList<Point>();
	    }
	    
	    public boolean book(int start, int end) {
	        int activecount = 0;
	        int pos1, pos2;
	        pos1 = pos2 = -1;
	        Point s = new Point(start, 1);
	        Point e = new Point(end, 0);
	        ListIterator<Point> iter = eventsTimePoint.listIterator();
	        int i = 0;
	        while(iter.hasNext()){
	            Point cur = iter.next();
	            /*if(start == 89 && end == 100){
	                System.out.print(cur.time);System.out.println();
	            }*/
	            if(pos1 == -1 && cur.compareTo(s) > 0){
	                pos1 = i;
	                activecount += 1;
	                if(activecount >= 3){
	                    return false;
	                }
	            }
	            if(pos2 == -1 && cur.compareTo(e)> 0){
	                pos2 = i;
	                activecount -= 1;
	            }
	            if(cur.isStart == 1){
	                activecount++;
	                if(activecount >= 3){
	                    return false;
	                }
	            }
	            else
	                activecount--; 
	            i++;
	        }
	        if(pos1 == -1)
	            pos1 = eventsTimePoint.size();
	        if(pos2 == -1)
	            pos2 = eventsTimePoint.size();
	        eventsTimePoint.add(pos1, s);
	        eventsTimePoint.add(pos2+1, e);
	        return true;
	    }
	}

}
