package google;

public class RangeSum2D {
	/*
    class SegSumTree{
    public:
        int i1;
        int j1;
        int i2;
        int j2;
        int sum;
        int flag;
        SegSumTree *left;
        SegSumTree *right;
        SegSumTree(){
            i1 = j1 = i2 = j2 =0;
            sum = 0;
            flag = 0;
            left = nullptr;
            right = nullptr;
        }
    };
    void buildSegTree(SegSumTree *root, int i1, int j1, int i2, int j2, vector<vector<int>>& presum){
        root->i1 = i1;
        root->i2 = i2;
        root->j1 = j1;
        root->j2 = j2;
        int sum = presum[i2][j2];
        if(j1-1>=0)
            sum -= presum[i2][j1-1];
        if(i1-1>=0)
            sum -= presum[i1-1][j2];
        if(i1-1>=0 && j1-1>=0)
            sum += presum[i1-1][j1-1];
        root->sum = sum;
        //cout<<sum<<endl;
        if(i1 != i2){
            int mid = i1 + (i2-i1)/2;
            root->left = new SegSumTree();
            root->right = new SegSumTree();
            buildSegTree(root->left, i1, j1, mid, j2, presum);
            buildSegTree(root->right, mid+1, j1, i2, j2, presum);
        }else if(j1 != j2){
            int mid = j1 + (j2-j1)/2;
            root->left = new SegSumTree();
            root->right = new SegSumTree();
            buildSegTree(root->left, i1, j1, i2, mid, presum);
            buildSegTree(root->right, i1, mid+1, i2, j2, presum);
        }
        //if(i1==2 && i2 ==2)
       //     cout<<sum<<endl;
    }
    int getSum(SegSumTree *root, int i1, int j1, int i2, int j2){
        if(i1 <= root->i1 && j1 <= root->j1 && i2 >= root->i2 && j2 >= root->j2)
            return root->sum;
        else if(i1 <= root->i1 && i2 >= root->i2){
            int sum = 0;
            if(root->i1 == root->i2){
                if(root->j2 < j1 || root->j1 > j2)
                    return 0;
                else{
                    sum += getSum(root->left, i1, j1, i2, j2);
                    sum += getSum(root->right, i1, j1, i2, j2);
                }
                //cout<<root->i1<<" "<<root->i2<<"row"<<sum<<endl;
            }else{
                sum += getSum(root->left, i1, j1, i2, j2);
                sum += getSum(root->right, i1, j1, i2, j2);
            }
            //cout<<root->i1<<" "<<root->i2<<"row"<<sum<<endl;
            return sum;
        }else{
            int sum = 0;
            if(root->i2 < i1 || root->i1 > i2)
                return 0;
            else{
                sum += getSum(root->left, i1, j1, i2, j2);
                sum += getSum(root->right, i1, j1, i2, j2);
            }
            //cout<<root->j1<<" "<<root->j2<<"col"<<sum<<endl;
            return sum;
        }
    }
    void updateTree(SegSumTree *root, int i, int j, int val){
        if(root == nullptr || i < root->i1 || i> root->i2 || j < root->j1 || j >root->j2)
            return;
        else {
            root->sum += val;
            updateTree(root->left, i, j, val);
            updateTree(root->right, i, j, val);
        }
        return;
    }
    int rows;
    int cols;
    SegSumTree *root;
    vector<vector<int>> matrix;
    
    NumMatrix(vector<vector<int>> matrix) {
        if( matrix.size()==0 || matrix[0].size() == 0){
            root = nullptr;
            return;
        }
        this->matrix = matrix;
        rows = matrix.size();
        cols = matrix[0].size();
        vector<vector<int>> presum(rows, vector<int>(cols));
        presum[0][0] = matrix[0][0];
        for(int i=1; i<rows;i++)
            presum[i][0] = matrix[i][0] + presum[i-1][0];
        for(int i=1; i<cols; i++)
            presum[0][i] = matrix[0][i] + presum[0][i-1];
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                presum[i][j] = matrix[i][j] + presum[i-1][j]+presum[i][j-1]-presum[i-1][j-1];
            }
        }

        root = new SegSumTree();
        buildSegTree(root, 0, 0, rows-1, cols-1, presum);
        
    }
    
    void update(int row, int col, int val) {
        if(root == nullptr)
            return;
        updateTree(root, row, col, val-matrix[row][col]);
        matrix[row][col] = val;
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        if(root == nullptr)
            return 0;
        return getSum(root, row1, col1, row2, col2);
    }
    */
    
    
    int rows;
    int cols;
    vector<vector<int>> matrix;
    vector<vector<int>> column_presum;
    NumMatrix(vector<vector<int>> matrix) {
        if(matrix.empty() || matrix[0].empty())
            return;
        this->matrix = matrix;
        rows = matrix.size();
        cols = matrix[0].size();
        column_presum.push_back(vector<int>(cols));
        for(int i=0; i<cols; i++)
            column_presum[0][i] = matrix[0][i];
        for(int i=1; i<rows; i++){
            column_presum.push_back(vector<int>(cols));
            for(int j=0; j<cols; j++)
                column_presum[i][j] = column_presum[i-1][j] + matrix[i][j];
        }
    }
    
    void update(int row, int col, int val) {
        if(matrix.empty())
            return;
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        for(int i = row; i<rows; i++)
            column_presum[i][col] += diff;
        return;
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        if(matrix.empty())
            return 0;
        int sum = 0;
        for(int i=col1; i<= col2; i++){
            sum += column_presum[row2][i];
            if(row1-1>=0)
                sum -= column_presum[row1-1][i];
        }
        return sum;
    }


}
