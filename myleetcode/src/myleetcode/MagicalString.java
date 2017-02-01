package myleetcode;

public class MagicalString {
	public int magicalString(int n){
		if(n<1)
            return 0;
		if(n<=3)
			return 1;
		int[] ms= new int[n];
		ms[0]=1;
		ms[1]=2;
		ms[2]=2;
		int i,j;
		i=j=2;
		int count = 1;
		while(i<n){
			int tmp = ms[i]==1?2:1; // tmp = ms[i]^3
			for(int k=1; k<=ms[j]; k++){
				i++;
				if(i>=n)
				    break;
				if(tmp==1)
				    count++;
				ms[i] = tmp;
			}
			j++;
		}
		return count;
	}
}
