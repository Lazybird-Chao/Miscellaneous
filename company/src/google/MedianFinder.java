package google;

public class MedianFinder {
	
	    PriorityQueue<Integer> larger;
	    PriorityQueue<Integer> smaller;
	    /** initialize your data structure here. */
	    public MedianFinder() {
	        larger = new PriorityQueue<Integer>();
	        smaller = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
	            public int compare(Integer a, Integer b){
	                return b-a;
	            }
	        });
	    }
	    
	    public void addNum(int num) {
	        if(larger.size() == smaller.size()){
	            if(smaller.isEmpty())
	                smaller.offer(num);
	            else if(num <= larger.peek())
	                smaller.offer(num);
	            else{
	                larger.offer(num);
	                int tmp = larger.poll();
	                smaller.offer(tmp);
	            }
	        }else{
	            if(num < smaller.peek()){
	                smaller.offer(num);
	                int tmp = smaller.poll();
	                larger.offer(tmp);
	            }else
	                larger.offer(num);
	        }
	    }
	 
	    
	    public double findMedian() {
	        if(larger.isEmpty() && smaller.isEmpty())
	            return 0.0;
	        else if(larger.isEmpty())
	            return smaller.peek();
	        else if(smaller.isEmpty())
	            return larger.peek();
	        else if(larger.size() == smaller.size())
	            return ((double)larger.peek() + smaller.peek())/2;
	        else
	            return smaller.peek();
	    }
	

}
