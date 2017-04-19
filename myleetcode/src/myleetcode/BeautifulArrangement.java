package myleetcode;

public class BeautifulArrangement {
	static public int countArrangement(int N){
		if(N < 2)
			return 1;
		int[] arrange = new int[N+1];
		for(int i=1; i< N+1; i++)
			arrange[i] = i;
		return subcount(arrange, N);
		
	}
	
	static public int subcount(int[] arrange, int n){
		if(n<=2){
			int count=0;
			if(arrange[1]%2==0 || 2%arrange[1]==0)
				count++;
			if(arrange[2]%2==0 || 2%arrange[2]==0)
				count++;
			return count;
		}
		else{
			int count = 0;
			for(int i=1; i<n; i++){
				if(arrange[i]%n==0 || n%arrange[i]==0){
					int tmp = arrange[n];
					arrange[n] = arrange[i];
					arrange[i] =  tmp;
					count += subcount(arrange, n-1);
					tmp = arrange[n];
					arrange[n] = arrange[i];
					arrange[i] =  tmp;
				}
			}
			if(arrange[n]%n==0 || n%arrange[n]==0)
				count += subcount(arrange, n-1);
			return count;
		}
	}
	
	static public void main(String args[]){
		System.out.print(countArrangement(15));
	}
}
