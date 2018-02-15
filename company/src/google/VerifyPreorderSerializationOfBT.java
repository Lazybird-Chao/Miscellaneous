package google;

public class VerifyPreorderSerializationOfBT {
	bool isValidSerialization(string preorder) {
        if(preorder.empty())
            return true;
        stack<string> s;
        int start = 0;
        s.push(getNext(preorder, start));
        while(!s.empty()){
            string r = s.top();
            s.pop();
            if(r == "#")
                continue;
            string left;
            if(start < preorder.size()){
                left = getNext(preorder, start);
            }else
                return false;
            string right;
            if(start < preorder.size()){
                right = getNext(preorder, start);
            }else
                return false;
            s.push(right);
            s.push(left);
        }
        if(start!=preorder.size() || !s.empty())
            return false;
        return true;
    }
    string getNext(string preorder, int &start){
        int end = preorder.find(',', start);
        string res;
        //cout<<start<<" "<<end<<endl;
        if(end != -1){
            res = preorder.substr(start, end-start);
            start = end+1;
        }
        else{
            res = preorder.substr(start, end-start);
            start = preorder.size();
        }
        //cout<<res<<endl;
        return res;
    }

}
