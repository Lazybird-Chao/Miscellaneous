package google;

public class MagicalString {
	public int magicalString(int n) {
        if(n==0)
            return 0;
        if(n<=3)
            return 1;
        Queue<Integer> m = new LinkedList<Integer>();
        m.offer(2);
        int count1 = 1;
        int total = 3;
        int next = 2;
        while(total < n){
            next = next % 2 +1;
            int cnt = m.poll();
            m.offer(next);
            if(cnt>1)
                m.offer(next);
            total += cnt;
            if(next==1)
                count1 += cnt;
        }
        if(next == 2)
            return count1;
        else
            return count1 - (total-n);
    }
	 

}
