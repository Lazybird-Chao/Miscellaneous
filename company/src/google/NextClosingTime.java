package google;

public class NextClosingTime {
	public String nextClosestTime(String time) {
        if(time == null || time.isEmpty())
            return "";
        int[] timeNum = new int[4];
        timeNum[0] = time.charAt(0) - '0';
        timeNum[1] = time.charAt(1) - '0';
        timeNum[2] = time.charAt(3) - '0';
        timeNum[3] = time.charAt(4) - '0';
        
        int[] nexttime = {timeNum[0]*10+timeNum[1], timeNum[2]*10+timeNum[3]};
        while(true){
            increaseOne(nexttime);
            if(valid(timeNum, nexttime))
                break;
        }
        String r;
        if(nexttime[0] < 10)
            r = "0" + String.valueOf(nexttime[0]) + ":";
        else
            r = String.valueOf(nexttime[0]) + ":";
        if(nexttime[1]<10)
            r += "0" + String.valueOf(nexttime[1]);
        else
            r += String.valueOf(nexttime[1]);
        return r;
    }
    
    void increaseOne(int[] num){
        int[] limit = {25,60};
        int i = num.length-1;
        while(i>=0){
            num[i]++;
            if(num[i] == limit[i]){
                num[i] = 0;
                i--;
            }else
                break;
        }
    }
    
    boolean valid(int[] num, int[] num2){
        int samecount = 0;
        int[] newnum = {num2[0]/10, num2[0]%10, num2[1]/10, num2[1]%10};
        for(int i = 0; i<newnum.length; i++){
            for(int j = 0; j<num.length; j++){
                if(newnum[i] ==  num[j]){
                    samecount++;
                    break;
                }
            }
        }
        return samecount == newnum.length;
    }

}
