package google;

public class SentenceScreenFitting {
	/*
    int wordsTyping(vector<string>& sentence, int rows, int cols) {
         if(sentence.empty())
             return 0;
        int count = 0;
        int i=0;
        int j=0;
        int len = 0;
        while(i < rows){
            if(cols - len >= (int)sentence[j].size()){
                len += sentence[j].size()+1;
                j++;
                if(j==sentence.size()){
                    count++;
                    j = 0;
                }
            }else{
                len = 0;
                i++;
            }
            //cout<<cols-len<<" "<<sentence[j].size()<<endl;
        }
        return count;
    }
    */
    int wordsTyping(vector<string>& sentence, int rows, int cols){
        if(sentence.empty())
             return 0;
        int dp[sentence.size()];
        for(int i=0; i<sentence.size(); i++){
            int j = i;
            int len = 0;
            while(cols - len >= (int)sentence[j % sentence.size()].size()){
                len += sentence[j % sentence.size()].size()+1;
                j++;
            }
            dp[i] = j-i;
        }
        int total_words = 0;
        int start_word = 0;
        for(int i=0; i<rows; i++){
            total_words += dp[start_word];
            start_word = (start_word + dp[start_word])%sentence.size();
        }
        return total_words / sentence.size();
    }

}
