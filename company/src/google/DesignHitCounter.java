package google;

public class DesignHitCounter {
	
	 /** Initialize your data structure here. */
    deque<int> hitRecord;
    HitCounter() {
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    void hit(int timestamp) {
        hitRecord.push_back(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    int getHits(int timestamp) {
        while(!hitRecord.empty() && timestamp - hitRecord.front() >= 300){
            hitRecord.pop_front();
        }
        return hitRecord.size();
    }
    
    
    
    int[] timeRecord;
    int[] hitCount;

    /** Initialize your data structure here. */
    public HitCounter() {
        timeRecord = new int[300];
        hitCount = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(timestamp == timeRecord[timestamp%300])
            hitCount[timestamp%300]++;
        else
            hitCount[timestamp%300] = 1;
        timeRecord[timestamp % 300] = timestamp;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for(int i=0; i<300; i++){
            if(timestamp - timeRecord[i] < 300)
                count += hitCount[i];
        }
        return count;
    }

}
