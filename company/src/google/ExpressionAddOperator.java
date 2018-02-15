package google;

public class ExpressionAddOperator {
	vector<string> addOperators(string num, int target) {
        if(num.empty())
            return vector<string>();
        vector<string> res;
        dfs(num, 0, target, 0, 0, "", res);
        return res;
        
    }
    void dfs(string num, int start, int target, long presum, long premul, string exp, vector<string>& res){
        if(start == num.size()){
            //cout<<exp<<" "<<presum<<" "<<premul<<endl;
            if(presum + premul == target){
                res.push_back(exp);
            }
            return;
        }
        int end = start;
        while(end < num.size()){
            long n = stol(num.substr(start, end-start+1));
            string exp1 = num.substr(start, end-start+1);
            if(exp=="")
                dfs(num, end+1, target, 0, n, exp1, res);
            else{
                dfs(num, end+1, target, presum+premul, n, exp+"+"+exp1, res);
                dfs(num, end+1, target, presum+premul, -n, exp+"-"+exp1, res);
                dfs(num, end+1, target, presum, premul*n, exp+"*"+exp1, res);
            }
            if(n==0)
                break;
            end++;
        }
        return;
    }

}
