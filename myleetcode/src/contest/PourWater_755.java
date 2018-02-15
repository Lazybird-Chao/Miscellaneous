package contest;

public class PourWater_755 {
	vector<int> pourWater(vector<int>& heights, int V, int K) {
        vector<int> minh;
        int  i = 0;
        minh.push_back(K);
        
        while(V>0){
            i = K;
            while(V > 0){
                while(i>0 && heights[i-1]<=heights[i]){
                    if(heights[i-1] < heights[i])
                        minh.push_back(i-1);
                    i--;
                }
                int j = minh.back();
                if(j==K)
                    break;
                minh.pop_back();
                heights[j]++;
                V--;
                if(heights[j] < heights[minh.back()])
                    minh.push_back(j);
                if(j>i)
                    minh.push_back(j-1);
            }
            i = K;
            while(V > 0){
                while(i<heights.size()-1 && heights[i+1]<=heights[i]){
                    if(heights[i+1] < heights[i])
                        minh.push_back(i+1);
                    i++;
                }
                int j = minh.back();
                if(j==K)
                    break;
                minh.pop_back();
                heights[j]++;
                V--;
                if(heights[j] < heights[minh.back()])
                    minh.push_back(j);
                if(j<i)
                    minh.push_back(j+1);
            }
            if(V == 0)
                break;
            heights[K]++;
            V--;
        }
       
        return vector<int>(heights);
    }

}
