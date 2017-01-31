package myleetcode;

public class ArithmeticSlices {
	public int numberOfArithmeticSlices(int[] A){
		if(A==null || A.length<3)
			return 0;
		int count=0;
		int i=0;
		while(i<A.length){
			int j;
			for( j=i; j<A.length-2; j++){
				if(A[j+1]-A[j]!=A[j+2]-A[j+1])
					break;
			}
			if(j>i){
				int slice_length = j+1 - i +1;
				for(int k=3; k<=slice_length; k++)
					count += 1 + slice_length - k;
				i = j+1;
			}
			else
				i++;
		}
		return count;
	}
	
	public int method2(int[] A){
		if(A==null || A.length<3)
			return 0;
		int i=0; 
		int count=0;
		int sub_count=0;
		while(i<A.length-2){
			if(A[i+1]-A[i]==A[i+2]-A[i+1]){
				sub_count += 1;
				count += sub_count;
			}
			else
				sub_count = 0;
		}
		return count;
	}
}
