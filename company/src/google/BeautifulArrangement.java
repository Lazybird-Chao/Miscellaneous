package google;

public class BeautifulArrangement {
	int countArrangement(int N) {
        int used[N+1];
        memset(used, 0, sizeof(int)*(N+1));
        helper(used, 1, N);
        return count;
    }
    int count = 0;
    void helper(int used[], int cur_pos, int N){
        if(cur_pos == N+1){
            count++;
            return;
        }
        for(int i=1; i<=N; i++){
            if(used[i] == 0 && (i%cur_pos==0 || cur_pos%i==0)){
                used[i] = 1;
                helper(used, cur_pos+1, N);
                used[i] = 0;
            }
        }
        return;
    }

}
