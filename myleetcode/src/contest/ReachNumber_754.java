package contest;

public class ReachNumber_754 {
	/*
    int reachNumber(int target) {
        if(target ==0)
            return 0;
        deque<int> q;
        q.push_back(0);
        int step = 0;
        while(true){
            step++;
            int cur_size = q.size();
            for(int i=0; i<cur_size; i++){
                int cur = q.front();
                q.pop_front();
                int n1 = cur+step;
                int n2 = cur-step;
                if(n1 == target || n2 == target)
                    return step;
                q.push_back(n1);
                q.push_back(n2);
            }
        }
        return -1;
    }
    */
    int reachNumber(int target){
        if(target == 0)
            return 0;
        if(target<0)
            target *= -1;
        int step = 0;
        int sum = 0;
        while(true){
            step++;
            sum += step;
            if(sum>=target && (sum-target) % 2==0)
                break;
        }
        return step;
        
    }

}
