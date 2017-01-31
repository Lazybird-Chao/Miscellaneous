package myleetcode;

public class QueueReconByHeight {
	static public int[][] reconstructQueue(int[][] people) {
        for(int i=0; i<people.length-1; i++){
        	for(int j=people.length-1; j>i; j--){
        		if(people[j][0]>people[j-1][0] ||
        				(people[j][0]==people[j-1][0]&&
        				people[j][1]<people[j-1][1])){
        			int tmp0 = people[j][0];
        			int tmp1 = people[j][1];
        			people[j][0] = people[j-1][0];
        			people[j][1] = people[j-1][1];
        			people[j-1][0] = tmp0;
        			people[j-1][1] = tmp1;
        		}
        	}
        }
        
        
        for(int i=0; i<people.length; i++){
        	if(people[i][1] !=i){
        		// people[i][1] can only <=i
        		int idx = people[i][1];
        		for(int j=i; j>idx; j--){
        			int tmp0 = people[j][0];
        			int tmp1 = people[j][1];
        			people[j][0] = people[j-1][0];
        			people[j][1] = people[j-1][1];
        			people[j-1][0] = tmp0;
        			people[j-1][1] = tmp1;
        		}
        	}
        }
        
        return people;
        
    }
	
	public int[][] method2(int[][] people){
		for(int i=0; i<people.length; i++){
			int max_pos = i;
			for(int j=i+1; j<people.length; j++){
				if(people[j][0]>people[max_pos][0] ||
						(people[j][0]==people[max_pos][0] && people[j][1]<people[max_pos][1])){
					max_pos = j;
				}
			}
			int idx = people[max_pos][1];
			for(int j= max_pos; j>idx; j--){
				int tmp0 = people[j][0];
				int tmp1 = people[j][1];
				people[j][0] = people[j-1][0];
				people[j][1] = people[j-1][1];
				people[j-1][0] = tmp0;
				people[j-1][1] = tmp1;
			}
		}
		return people;
	}
	
	
	
	public static void main(String args[]){
		int[][] p = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		reconstructQueue(p);
	}
}
