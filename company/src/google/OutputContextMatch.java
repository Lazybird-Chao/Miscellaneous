package google;

public class OutputContextMatch {
	string findContestMatch(int n) {
        vector<int> num(n);
        for(int i=0; i<n; i++)
            num[i] = i+1;
        return helper(num);
    }
    string helper(vector<int>& num){
        if(num.size() == 2){
            return "(" + to_string(num[0]) + "," + to_string(num[1]) +")";
        }
        vector<int> num1;
        vector<int> num2;
        int flag1 = 1;
        int flag2 = 0;
        for(int i=0; i<num.size(); i++){
            if(flag1<2){
                num1.push_back(num[i]);
                flag1++;
                if(flag1==2)
                    flag2 = 0;
            }else if(flag2 < 2){
                num2.push_back(num[i]);
                flag2++;
                if(flag2==2)
                    flag1 = 0;
            }
        }
        string s1 = helper(num1);
        string s2 = helper(num2);
        return "(" + s1 + "," + s2 + ")";
    }

}
