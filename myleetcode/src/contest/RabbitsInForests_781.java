package contest;

public class RabbitsInForests_781 {
	int numRabbits(vector<int>& answers) {
        if(answers.empty())
            return 0;
        vector<int> count(10001, 0);
        for(int i=0; i<answers.size(); i++)
            count[answers[i]]++;
        int totalcount = 0;
        for(int i=0; i<10001; i++){
            if(count[i] != 0){
                totalcount += (count[i] + i)/(i+1) * (i+1);
            }
        }
        return totalcount;
    }

}
