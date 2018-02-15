package google;

public class FindKclosestElement {
	 vector<int> findClosestElements(vector<int>& arr, int k, int x) {
	        if(arr.empty())
	            return vector<int>();
	        int left = 0;
	        int right = arr.size()-1;
	        int x_pos = 0;
	        int mid = 0;
	        while(left+1 < right){
	            mid = left + (right-left)/2;
	            if(arr[mid] == x){
	                x_pos = mid;
	                break;
	            }else if(arr[mid] > x)
	                right = mid;
	            else
	                left = mid;
	        }
	        if(left+1>=right){
	            if(x-arr[left] <= arr[right]-x)
	                x_pos = left;
	            else
	                x_pos = right;
	        }
	        int i=x_pos-1;
	        int j=x_pos+1;
	        //cout<<x_pos<<" "<<i<<" "<<j<<endl;
	        while(j-i-1 <k ){
	            if(j>arr.size()-1 || (i>=0 && x-arr[i] <= arr[j]-x))
	                i--;
	            else
	                j++;
	        }
	        i++;
	        vector<int> res;
	        while(i<j){
	            res.push_back(arr[i]);
	            i++;
	        }
	        return res;
	    }

}
