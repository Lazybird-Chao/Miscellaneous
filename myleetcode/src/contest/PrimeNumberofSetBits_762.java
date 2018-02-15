package contest;

public class PrimeNumberofSetBits_762 {
	int countPrimeSetBits(int L, int R) {
        int n = L;
        int count = 0;
        int primes[32];
        memset(primes, 0, sizeof(int)*32);
        primes[2] = primes[3] = primes[5] = primes[7] = primes[11] =
            primes[13] = primes[17] = primes[19] = primes[23] = 
            primes[29] = primes[31] = 1;
        while(n <= R){
            int c = 0;
            int tmp = n;
            while(tmp>0){
                if((tmp &1)==1)
                    c++;
                tmp >>= 1;
            }
            if(primes[c] == 1)
                count++;
            n++;
        }
        return count;
    }

}
