package contest;

public class SlidingPuzzle_773 {
	int slidingPuzzle(vector<vector<int>>& board) {
        if(board.empty() || board[0].empty())
            return 0;
        string s = getString(&board);
        if(s == "123450")
            return 0;
        deque<vector<vector<int>>*> boards;
        boards.push_back(&board);
        unordered_set<string> record;
        record.insert(s);
        return bfs(boards, 0, record);
        
    }
    
    int bfs(deque<vector<vector<int>>*>& boards, int steps, unordered_set<string>& record){
        int size = boards.size();
        if(size == 0)
            return -1;
        //cout<<size<<endl;
        for(int k=0; k<size; k++){
            vector<vector<int>>* cur = boards.front();
            boards.pop_front();
            for(int i=0; i<2; i++){
                for(int j=0; j<3; j++){
                    //cout<<i<<" "<<j<<":"<<(*cur)[i][j]<<endl;
                    if((*cur)[i][j]==0){
                        if(i-1>=0){
                            swap(cur, i, j, i-1, j);
                            string tmp = getString(cur);
                            //cout<<"i-1 "<< tmp<<endl;
                            if(tmp == "123450")
                                return steps+1;
                            if(record.find(tmp) == record.end()){
                                boards.push_back(new vector<vector<int>>(*cur));
                                record.insert(tmp);
                            }
                            swap(cur, i, j, i-1, j);
                        }
                        if(i+1 < 2){
                            swap(cur, i, j, i+1, j);
                            string tmp = getString(cur);
                            //cout<<"i+1 "<< tmp<<endl;
                            if(tmp == "123450")
                                return steps+1;
                            if(record.find(tmp) == record.end()){
                                boards.push_back(new vector<vector<int>>(*cur));
                                record.insert(tmp);
                            }
                            swap(cur, i, j, i+1, j);
                        }
                        if(j-1 >=0){
                            swap(cur, i, j, i, j-1);
                            string tmp = getString(cur);
                            //cout<<"j-1 "<< tmp<<endl;
                            if(tmp == "123450")
                                return steps+1;
                            if(record.find(tmp) == record.end()){
                                boards.push_back(new vector<vector<int>>(*cur));
                                record.insert(tmp);
                            }
                            swap(cur, i, j, i, j-1);
                        }
                        if(j+1 < 3){
                            swap(cur, i, j, i, j+1);
                            string tmp = getString(cur);
                            //cout<<"j+1 "<< tmp<<endl;
                            if(tmp == "123450")
                                return steps+1;
                            if(record.find(tmp) == record.end()){
                                boards.push_back(new vector<vector<int>>(*cur));
                                record.insert(tmp);
                            }
                            swap(cur, i, j, i, j+1);
                        }
                        break;
                    }
                }
            }
        }
        return bfs(boards, steps+1, record);
    }
    
    string getString(vector<vector<int>> *board){
        string s = "";
        for(int i=0; i<2; i++)
            for(int j=0; j<3; j++)
                s += to_string((*board)[i][j]);
        return s;
    }
    void swap(vector<vector<int>> *board, int i1, int j1, int i2, int j2){
        int tmp = (*board)[i1][j1];
        (*board)[i1][j1] = (*board)[i2][j2];
        (*board)[i2][j2] = tmp;
    }

}
