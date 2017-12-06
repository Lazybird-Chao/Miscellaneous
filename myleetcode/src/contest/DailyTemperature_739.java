package contest;

public class DailyTemperature_739 {
	public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length ==0)
            return new int[0];
        int[] f = new int[temperatures.length];
        f[temperatures.length-1] = 0;
        for(int j = temperatures.length-1; j>0; j--){
            int d = findHigher(temperatures, f, j-1, j);
            if(d == -1)
                f[j-1] = 0;
            else
                f[j-1] = d - (j-1);
        }
        return f;
    }
    int findHigher(int[] t, int[] f, int i, int j){
        if(t[j] > t[i])
            return j;
        else if(f[j] == 0 || j == t.length-1)
            return -1;
        else
            return findHigher(t, f, i, j+f[j]);
    }

}
