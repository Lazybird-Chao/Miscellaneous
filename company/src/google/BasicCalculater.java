package google;

public class BasicCalculater {
	class Solution {
		public:
		    /*int calculate(string s) {
		        if(s.empty())
		            return 0;
		        Symbols ss(s);
		        string cur = ss.getSymbol();
		        vector<int> oprands;
		        vector<string> oprators;
		        while(!cur.empty()){
		            //cout<<cur<<endl;
		            if(cur=="("){
		                int count = 1;
		                string sub;
		                while(count!=0){
		                    string tmp = ss.getSymbol();
		                    if(tmp == ")")
		                        count--;
		                    else if(tmp == "(")
		                        count++;
		                    if(count !=0)
		                        sub.append(tmp);
		                }
		                oprands.push_back(calculate(sub));
		            }else if(cur[0]>='0' && cur[0]<='9')
		                oprands.push_back(stoi(cur));
		            else
		                oprators.push_back(cur);
		            cur = ss.getSymbol();
		        }
		        reverse(oprands.begin(), oprands.end());
		        reverse(oprators.begin(), oprators.end());
		        int res = 0;
		        while(!oprators.empty()){
		            string op = oprators.back();
		            //cout<<op<<endl;
		            oprators.pop_back();
		            int op1 = oprands.back();
		            oprands.pop_back();
		            int op2 = oprands.back();
		            oprands.pop_back();
		            if(op == "+")
		                oprands.push_back(op2+op1);
		            else if(op == "-")
		                oprands.push_back(op1-op2);
		            else
		                cout<<"error with exp"<<endl;
		        }
		        res = oprands.back();
		        oprands.pop_back();
		        if(!oprands.empty())
		            cout<<"error with exp"<<endl;
		        return res;
		    }*/
		    int calculate(string s){
		        if(s.empty())
		            return 0;
		        vector<string> s1;
		        vector<string> s2;
		        Symbols syms(s);
		        string cur = syms.getSymbol();
		        while(!cur.empty()){
		            //cout<<cur<<endl;
		            if(cur[0]>='0' && cur[0]<='9')
		                s1.push_back(cur);
		            else if(cur[0] == '(')
		                s2.push_back(cur);
		            else if(cur[0] == ')'){
		                while(!s2.empty()){
		                    string tmp = s2.back();
		                    if(tmp[0] == '('){
		                        s2.pop_back();
		                        break;
		                    }else{
		                        s1.push_back(tmp);
		                        s2.pop_back();
		                    }
		                }
		            }else{
		                while(!s2.empty()){
		                    string tmp = s2.back();
		                    if(tmp[0] == '('){
		                        break;
		                    }else{
		                        s1.push_back(tmp);
		                        s2.pop_back();
		                    }
		                }
		                s2.push_back(cur);
		            }
		            cur = syms.getSymbol();
		        }
		        while(!s2.empty()){
		            s1.push_back(s2.back());
		            s2.pop_back();
		        }
		        
		        vector<int> r;
		        for(int i = 0; i<s1.size(); i++){
		            //cout<<s1[i]<<" ";
		            if(s1[i][0] == '-'){
		                int op2 = r.back();
		                r.pop_back();
		                int op1 = r.back();
		                r.pop_back();
		                r.push_back(op1-op2);
		            }else if(s1[i][0] == '+'){
		                int op2 = r.back();
		                r.pop_back();
		                int op1 = r.back();
		                r.pop_back();
		                r.push_back(op1+op2);
		            }else
		                r.push_back(stoi(s1[i]));
		        }
		        int res = r.back();
		        r.pop_back();
		        if(!r.empty())
		            cout<<"error exp"<<endl;
		        return res;
		    }
		    class Symbols{
		        string s;
		        int pos;
		        public:
		        Symbols(string ss):s(ss){
		            pos = 0;
		        }
		        string getSymbol(){
		            string res;
		            int i = pos;
		            while(i<s.size() && s[i] == ' ')
		                i++;
		            if(i<s.size()&& s[i]>='0' && s[i] <='9'){
		                while(i<s.size() && s[i]>='0' && s[i] <='9'){
		                    res.push_back(s[i]);
		                    i++;
		                }
		            }else if(i<s.size()){
		                res.push_back(s[i]);
		                i++;
		            }
		            pos = i; 
		            return res;
		        }
		    };
		};

}
