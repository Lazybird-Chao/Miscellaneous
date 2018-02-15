package google;

public class StrobogrammaticNum {
	bool isStrobogrammatic(string num) {
        if(num.empty())
            return true;
        // 0,1,8, 6, 9
        int i = 0;
        int j = num.size()-1;
        while(i<=j){
            if(num[i] != num[j]){
               if((num[i] != '6' && num[i] != '9') ||
                  (num[j] != '6' && num[j] != '9'))
                   return false;
            }else{
                if(num[i] != '0' && num[i] != '1' && num[i] != '8')
                    return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
