package contest;

public class SwapAdjacentInLRstring_777 {
	bool canTransform(string start, string end) {
        if(start.size() != end.size())
            return false;
        int i = end.size()-1;
        while(i >=0){
            while(i>=0 && end[i] != 'R')
                i--;
            if(i>=0){
                int j = i;
                while(j >=0 && start[j] != 'R'){
                    if(start[j] != 'X')
                        return false;
                    j--;
                }
                if(j<0)
                    return false;
                if(j!= i){
                    start[j] = 'X';
                    start[i] = 'R';
                }
                i--;
            }
        }
        i = 0;
        while(i < end.size()){
            while(i<end.size() && end[i] != 'L')
                i++;
            if(i<end.size()){
                int j = i;
                while(j<start.size() && start[j] != 'L'){
                    if(start[j] != 'X')
                        return false;
                    j++;
                }
                if(j==start.size())
                    return false;
                if(j != i){
                    start[i] = 'L';
                    start[j] = 'X';
                }
                i++;
            }
        }
        if(start != end)
            return false;
        else
            return true;
    }

}
