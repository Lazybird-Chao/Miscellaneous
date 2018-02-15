package google;

public class MovingSumFromDataStream {
	public:
	    /** Initialize your data structure here. */
	    int win_size;
	    int cur_win_size;
	    double win_sum;
	    deque<int> q;
	    MovingAverage(int size) {
	        win_size = size;
	        cur_win_size = 0;
	        win_sum = 0;
	    }
	    
	    double next(int val) {
	        if(cur_win_size == win_size){
	            win_sum += val;
	            win_sum -= q.front();
	            q.pop_front();
	            q.push_back(val);
	        }else{
	            win_sum += val;
	            q.push_back(val);
	            cur_win_size++;
	        }
	        return win_sum/cur_win_size;
	    }

}
