package myleetcode;

public class CountPrimes {
	public int countPrimes(int n){
		int count = 0;
		for(int i=2; i<n; i++){
			boolean isprime=true;
			for(int j=2; j*j<=n; j++)
				if(i%j==0){
					isprime = false;
					break;
				}
			if(isprime)
				count++;
		}
		return count;
	}
	
	public int method2(int n){
		if(n<=2)
			return 0;
		boolean[] isprime = new boolean[n];
		for(int i=2; i<n; i++)
			isprime[i] = true;
		int count=n-2;
		for(int i=2; i*i<=n; i++){
			if(isprime[i]){
				for(int j= i*i; j<n; j+=i){
					isprime[j]=false;
					count--;
				}
			}
		}
		return count;
	}
}
