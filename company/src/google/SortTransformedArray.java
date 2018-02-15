package google;

public class SortTransformedArray {
	 vector<int> sortTransformedArray(vector<int>& nums, int a, int b, int c) {
	        if(nums.empty())
	            return vector<int>();
	        vector<int> res;
	        for(int i=0; i<nums.size(); i++)
	            res.push_back(a*nums[i]*nums[i] + b*nums[i] + c);
	        if(a == 0){
	            if(b >= 0)
	                return res;
	            if(b<0){
	                reverse(res.begin(), res.end());
	                return res;
	            }
	        }else if(a > 0){
	            int min_v = res[0];
	            int min_p = 0;
	            for(int i=1; i<res.size(); i++){
	                if(res[i] < min_v){
	                    min_v = res[i];
	                    min_p = i;
	                }
	            }
	            int i1 = min_p - 1;
	            int i2 = min_p + 1;
	            int i3 = 0;
	            vector<int> r(res.size());
	            r[i3++] = min_v;
	            while(i1>=0 && i2<res.size()){
	                if(res[i1] < res[i2])
	                    r[i3++] = res[i1--];
	                else
	                    r[i3++] = res[i2++];
	            }
	            while(i1>=0)
	                r[i3++] = res[i1--];
	            while(i2<res.size())
	                r[i3++] = res[i2++];
	            return r;
	        }else{
	            int max_v = res[0];
	            int max_p = 0;
	            for(int i=0; i<res.size(); i++){
	                if(res[i] > max_v){
	                    max_v = res[i];
	                    max_p = i;
	                }
	            }
	            int i1 = max_p-1;
	            int i2 = max_p + 1;
	            int i3 = res.size()-1;
	            vector<int> r(res.size());
	            r[i3--] = max_v;
	            while(i1>=0 && i2 <res.size()){
	                if(res[i1] > res[i2])
	                    r[i3--] = res[i1--];
	                else
	                    r[i3--] = res[i2++];
	            }
	            while(i1>=0)
	                r[i3--] = res[i1--];
	            while(i2<res.size())
	                r[i3--] = res[i2++];
	            return r;
	        }
	        
	    }

}
