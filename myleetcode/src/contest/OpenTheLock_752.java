package contest;

public class OpenTheLock_752 {
	int openLock(vector<string>& deadends, string target) {
        if(deadends.empty() || target.empty())
            return -1;
        unordered_set<string> deadsets;
        for(string s : deadends)
            deadsets.insert(s);
        unordered_set<string> checked;
        checked.insert("0000");
        deque<string> q;
        q.push_back("0000");
        int count = 0;
        while(!q.empty()){
            int j = q.size();
            count++;
            while(j>0){
                string cur = q.front();
                q.pop_front();
                int i=0;
                while(i<4){
                    int ni = cur[i] - '0';
                    int niup = (ni+1)%10;
                    int nidown = (ni+9)%10;
                    cur[i] = niup+'0';
                    if(target == cur)
                        return count;
                    else if(checked.find(cur) == checked.end() && deadsets.find(cur) == deadsets.end())
                        q.push_back(cur);
                    cur[i] = nidown + '0';
                    if(target == cur)
                        return count;
                    else if(checked.find(cur) == checked.end())
                        q.push_back(cur);
                    cur[i] = ni+'0';
                    i++;
                }
                j--;
            }
        }
        return -1;
    }

}
