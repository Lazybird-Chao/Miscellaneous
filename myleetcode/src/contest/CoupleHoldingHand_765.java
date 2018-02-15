package contest;

public class CoupleHoldingHand_765 {
	int minSwapsCouples(vector<int>& row) {
        if(row.empty() || row.size() % 2 ==1)
            return 0;
        int n = row.size()/2;
        int couples[2*n];
        for(int i=0; i<2*n; i++)
            couples[i] = -1;
        for(int i=0; i<2*n; i+= 2){
            int a0 = row[i];
            int a1 = row[i+1];
            if(a0 > a1){
                a0 = a1;
                a1 = row[i];
            }
            if(a0 % 2 ==1 || a1-a0 !=1){
                couples[a0] = a1;
                couples[a1] = a0;
            }
        }
        int swapcount = 0;
        for(int i=0; i<2*n; i++){
            if(couples[i] == -1)
                continue;
            int a0 = i;
            int b0 = couples[i];
            int a1, b1;
            if(a0 % 2==0)
                a1 = a0+1;
            else
                a1 = a0-1;
            if(b0 % 2==0)
                b1 = b0+1;
            else
                b1 = b0-1;
            if(couples[a1] == b1 && couples[b1]==a1){
                swapcount++;
                couples[a0] = -1;
                couples[a1] = -1;
                couples[b1] = -1;
                couples[b0] = -1;
            }
        }
        for(int i=0; i<2*n; i++){
            if(couples[i] == -1)
                continue;
            int j = i;
            while(true){
                int a0 = j;
                int b0 = couples[j];
                int a1, b1;
                if(a0 % 2==0)
                    a1 = a0+1;
                else
                    a1 = a0-1;
                if(b0 % 2==0)
                    b1 = b0+1;
                else
                    b1 = b0-1;
                if(couples[a1] == b1 && couples[b1]==a1){
                    swapcount++;
                    couples[a0] = -1;
                    couples[a1] = -1;
                    couples[b1] = -1;
                    couples[b0] = -1;
                    break;
                }else{
                    swapcount++;
                    couples[b0] = couples[a1];
                    couples[couples[b0]] = b0;
                    couples[a0] = -1;
                    couples[a1] = -1;
                    j = b0;
                }
            }
        }
        return swapcount;
        
    }

}
