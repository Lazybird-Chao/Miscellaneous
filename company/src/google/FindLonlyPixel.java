package google;

public class FindLonlyPixel {
	int findLonelyPixel(vector<vector<char>>& picture) {
        if(picture.empty() || picture[0].empty())
            return 0;
        int blackcount1 = 0;
        int blackcount2 = 0;
        int pos = -1;
        int count = 0;
        for(int i=0; i<picture.size(); i++){
            blackcount1 = 0;
            blackcount2 = 0;
            for(int j=0; j<picture[0].size(); j++){
                if(picture[i][j] == 'B'){
                    blackcount1++;
                    pos = j;
                    if(blackcount1>1)
                        break;
                }
            }
            if(blackcount1==1){
                for(int k=0; k<picture.size(); k++){
                    if(picture[k][pos] == 'B'){
                        blackcount2++;
                        if(blackcount2>1)
                            break;
                    }
                }
                if(blackcount2==1)
                    count++;
            }
        }
        return count;
    }

}
