package google;

public class CountNumWithUniqueDigit {
	int countNumbersWithUniqueDigits(int n) {
        if(n > 10)
            n = 10;
        int m = 0;
        int f[11];
        f[0] = 1;
        int count = 1;
        for(int i=1; i<=n; i++){
            f[i] = f[i-1]*(10-i+1);
            count += f[i] - (f[i]/10);
        }
        return count;
    }

}
