package google;

public class Flatten2Dvector {
	class Vector2D {
		public:
		    Vector2D(vector<vector<int>>& vec2d) {
		        iter_out = vec2d.begin();
		        end_out = vec2d.end();
		        while(iter_out != vec2d.end()){
		            iter_inner = iter_out->begin();
		            if(iter_inner != iter_out->end())
		                break;
		            else
		                iter_out++;
		        }
		    }

		    int next() {
		        int val = *iter_inner;
		        iter_inner++;
		        while(iter_out != end_out){
		            if(iter_inner != iter_out->end())
		                break;
		            else{
		                iter_out++;
		                if(iter_out != end_out)
		                    iter_inner = iter_out->begin();
		            }
		        }
		        return val;
		    }

		    bool hasNext() {
		        if(iter_out == end_out)
		            return false;
		        else
		            return true;
		    }
		private:
		    vector<vector<int>>::iterator iter_out;
		    vector<vector<int>>::iterator end_out;
		    vector<int>::iterator iter_inner;
		    
		};

}
