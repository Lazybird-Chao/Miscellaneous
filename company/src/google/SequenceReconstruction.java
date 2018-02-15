package google;

public class SequenceReconstruction {
	bool sequenceReconstruction(vector<int>& org, vector<vector<int>>& seqs) {
        if(seqs.empty())
            return org.empty();
        vector<int> indegree(org.size()+1, 0);
        vector<int> neighbors[org.size()+1];
        bool allempty = true;
        for(int i=0; i<seqs.size(); i++){
            if(seqs[i].empty()==false)
                allempty = false;
            for(int j=0; j<(int)seqs[i].size()-1; j++){
                if(seqs[i][j]>org.size() || seqs[i][j+1]>org.size())
                    return false;
                neighbors[seqs[i][j]].push_back(seqs[i][j+1]);
                indegree[seqs[i][j+1]]++;
            }
            if(seqs[i].empty()==false && seqs[i].back() > org.size())
                return false;
        }
        if(allempty)
            return false;
        
        vector<int> topo_seq;
        for(int i=1; i<indegree.size(); i++){
            if(indegree[i] == 0)
                topo_seq.push_back(i);
        }
        if(topo_seq.size() != 1 || topo_seq[0] != org[0])
            return false;
        for(int i=1; i<=topo_seq.size() && i<org.size(); i++){
            int idx = topo_seq[i-1];
            for(int j=0; j<neighbors[idx].size(); j++){
                indegree[neighbors[idx][j]]--;
                if(indegree[neighbors[idx][j]]==0)
                    topo_seq.push_back(neighbors[idx][j]);
            }
            //cout<<topo_seq.size()<<endl;
            if(topo_seq.size() != i+1 || topo_seq[i] != org[i])
                return false;
        }
        return true;
    }

}
