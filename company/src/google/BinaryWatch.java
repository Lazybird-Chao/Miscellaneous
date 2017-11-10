package google;

public class BinaryWatch {

	
	/*
	 public List<String> readBinaryWatch(int num) {
	        List<String> a = new ArrayList<>();
	        for(int i=0; i< 12; i++){
	            for(int j=0; j<60; j++){
	                if(Integer.bitCount(i) + Integer.bitCount(j) == num){
	                    a.add(String.format("%d:%02d",i,j));
	                }
	            }
	        }
	        return a;
	    }
	    */
	
	public List<String> readBinaryWatch(int num) {
        if(num < 0 || num >10)
            return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        helper(num, 0, 0, res);
        return res;
    }
    void helper(int num, int time, int idx, List<String> res){
        if(num == 0){
            String s = "";
            int hour = (time & (1<<10)-64)>>6;
            if(hour < 12)
                s = String.valueOf(hour) + ":";
            else
                return;
            int min = time & 63;
            if(min < 10){
                s += "0" + String.valueOf(min);
            }else if(min < 60)
                s += String.valueOf(min);
            else
                return;
            res.add(s);
            return;
        }
        if(idx == 10)
            return;
        helper(num, time, idx+1, res);
        helper(num-1, time|(1<<idx), idx+1, res);
        return;
    }
	
}
