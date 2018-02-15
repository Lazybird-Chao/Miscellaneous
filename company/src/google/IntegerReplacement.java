package google;

public class IntegerReplacement {
	int integerReplacement(int n) {
        /*
        int f[n+1];
        f[1] = 0;
        for(int i=2; i<=n; i++){
            if(i % 2==0)
                f[i]= 1+f[i/2];
            else{
                f[i] = 2 + min(f[(i+1)/2], f[(i-1)/2]);
            }
        }
        return f[n];
        */
        int count = 0;
        long m = n;
        while(m!=1){
            if((m & 1)==0)
                m = m>>1;
            else if((m & 2)==0)
                m = m-1;
            else if(m==3)
                m = m-1;
            else
                m = m+1;
            count++;
        }
        return count;
    }

}
