package contest;

public class MyCalendar_729 {
	class MyCalendar {
	    
	    TreeMap<Integer, Integer> events;
	    public MyCalendar() {
	        events = new TreeMap<Integer, Integer>();
	    }
	    
	    public boolean book(int start, int end) {
	        Map.Entry<Integer, Integer> left = events.floorEntry(start);
	        Map.Entry<Integer, Integer> right = events.ceilingEntry(start);
	        if(left == null && right == null){
	            events.put(start, end);
	            return true;
	        }else if(left == null){
	            if(end <= right.getKey()){
	                events.put(start, end);
	                return true;
	            }
	        }else if(right == null){
	            if(start >= left.getValue()){
	                events.put(start, end);
	                return true;
	            }
	        }else{
	            if(start >= left.getValue() && end <= right.getKey()){
	                events.put(start, end);
	                return true;
	            }
	        }
	        return false;
	    }
	}

}
