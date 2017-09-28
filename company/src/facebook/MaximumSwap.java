package facebook;

public class MaximumSwap {
	public int maximumSwap(int num) {
        if(num < 10)
            return num;
        char[] n = Integer.toString(num).toCharArray();
        boolean changed = false;
        for(int i = 0; i < n.length; i++){
            int swapa = i;
            int swapb = i;
            for(int j = i; j < n.length; j++){
                if(n[j] >= n[swapb])
                    swapb = j;
            }
            if(n[swapb] != n[swapa]){
                char tmp = n[swapa];
                n[swapa] = n[swapb];
                n[swapb] = tmp;
                changed = true;
                break;
            }
        }
        if(changed)
            return Integer.parseInt(new String(n));
        else
            return num;
    }

}
