package contest;

public class BasicCalculator5_770 {
	static bool mycomp(pair<vector<string>, int> &a, pair<vector<string>, int> &b){
        if(a.first.size() != b.first.size())
            return a.first.size() > b.first.size();
        else{
            for(int i=0; i<a.first.size(); i++){
                if(a.first[i] != b.first[i])
                    return a.first[i] < b.first[i];
            }
            return true;
        }
    }
    
    typedef unordered_map<string, pair<vector<string>, int>> exp_type;
    
    vector<string> basicCalculatorIV(string expression, vector<string>& evalvars, vector<int>& evalints) {
        if(expression.empty())
            return vector<string>();
        unordered_map<string, int> val_eval;
        for(int i=0; i<evalvars.size(); i++)
            val_eval[evalvars[i]] = evalints[i];
        stack<exp_type> oprands;
        stack<string> operators;
        int index = 0;
        while(index < expression.size()){
            string token = getNextToken(expression, index);
            //cout<<token<<endl;
            if(token=="(")
                operators.push(token);
            else if(token=="+" || token=="-" || token==")"){
                while(!operators.empty() && operators.top()!="("){
                    string op = operators.top();
                    operators.pop();
                    exp_type op1 = oprands.top();
                    oprands.pop();
                    exp_type op2 = oprands.top();
                    oprands.pop();
                    oprands.push(comp(op, op2, op1));
                }
                if(token==")")
                    operators.pop();
                else
                    operators.push(token);
            }else if(token=="*")
                operators.push(token);
            else{
                if(token[0] >= '0' && token[0]<='9'){
                    exp_type tmp;
                    tmp["$"] = make_pair(vector<string>(), stoi(token));
                    oprands.push(tmp); 
                }
                else if(val_eval.find(token) != val_eval.end()){
                    exp_type tmp;
                    tmp["$"] = make_pair(vector<string>(), val_eval[token]);
                    oprands.push(tmp);
                }else{
                    exp_type tmp;
                    vector<string> tmp2;
                    tmp2.push_back(token);
                    tmp[token] = make_pair(tmp2, 1);
                    oprands.push(tmp);
                }
            }
        }
        while(!operators.empty()){
            string op = operators.top();
            operators.pop();
            exp_type op1 = oprands.top();
            oprands.pop();
            exp_type op2 = oprands.top();
            oprands.pop();
            oprands.push(comp(op, op2, op1));
            //cout<<op<<endl;
        }
        exp_type value = oprands.top();
        oprands.pop();
        vector<pair<vector<string>, int>> terms;
        for(auto &it : value){
            terms.push_back(it.second);
        }
        sort(terms.begin(), terms.end(), mycomp);
        vector<string> res;
        for(int i=0; i<terms.size(); i++){
            //cout<<terms[i].second<<endl;
            if(terms[i].second ==0)
                continue;
            string tmp = to_string(terms[i].second);
            for(int j=0; j<terms[i].first.size(); j++)
                tmp += "*"+terms[i].first[j];
            res.push_back(tmp);
        }
        return res;
    }
    exp_type comp(string op, exp_type &op1, exp_type &op2){
        if(op == "+"){
            for(auto &it : op2){
                if(op1.find(it.first) != op1.end()){
                    op1[it.first].second += it.second.second; 
                    if(op1[it.first].second == 0)
                        op1.erase(it.first);
                }else
                    op1[it.first] = it.second;
            }
            return op1;
        }else if(op == "-"){
            for(auto &it : op2){
                if(op1.find(it.first) != op1.end()){
                    op1[it.first].second -= it.second.second;
                    if(op1[it.first].second == 0)
                        op1.erase(it.first);
                }else{
                    it.second.second *= -1;
                    op1[it.first] = it.second;
                }
            }
            return op1;
        }else{
            exp_type res;
            for(auto &it1 : op1){
                for(auto &it2 : op2){
                    vector<string> vars;
                    int coef = it1.second.second*it2.second.second;
                    if(coef==0)
                        continue;
                    for(int i=0; i<it1.second.first.size(); i++)
                        vars.push_back(it1.second.first[i]);
                    for(int i=0; i<it2.second.first.size(); i++)
                        vars.push_back(it2.second.first[i]);
                    sort(vars.begin(), vars.end());
                    string s = "";
                    if(vars.empty())
                        s = "$";
                    else{
                        s += vars[0];
                        for(int i=1; i<vars.size(); i++)
                            s += "*" + vars[i];
                    }
                    if(res.find(s) == res.end())
                        res[s] = make_pair(vars, coef);
                    else{
                        res[s].second += coef;
                        if(res[s].second ==0)
                            res.erase(s);
                    }
                }
            }
            return res;
        }
        
    }
    string getNextToken(string expression, int &index){
        while(expression[index]==' ')
            index++;
        if(expression[index] == '(' || 
            expression[index] == ')' ||
            expression[index] == '+' ||
            expression[index] == '-' ||
            expression[index] == '*'){
            index++;
            return string(1,expression[index-1]);
        }
        int pos = index+1;
        while(pos < expression.size() && 
              expression[pos] != '(' && 
             expression[pos] != ')' &&
             expression[pos] != '+' &&
             expression[pos] != '-' &&
             expression[pos] != '*' && 
             expression[pos] != ' ')
            pos++;
        string res;
        res = expression.substr(index, pos-index);
        index = pos;
        return res;
    }

}
