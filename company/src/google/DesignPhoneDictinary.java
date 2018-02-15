package google;

public class DesignPhoneDictinary {
	class PhoneDirectory {
		public:
		    /** Initialize your data structure here
		        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
		    PhoneDirectory(int maxNumbers) {
		        maxnum = maxNumbers;
		        for(int i=0; i<maxnum; i++)
		            avail_num.push(i);
		    }
		    
		    /** Provide a number which is not assigned to anyone.
		        @return - Return an available number. Return -1 if none is available. */
		    int get() {
		        if(avail_num.empty())
		            return -1;
		        int r = avail_num.front();
		        avail_num.pop();
		        used_num.insert(r);
		        return r;
		    }
		    
		    /** Check if a number is available or not. */
		    bool check(int number) {
		        return used_num.find(number) == used_num.end();
		    }
		    
		    /** Recycle or release a number. */
		    void release(int number) {
		        if(used_num.find(number) == used_num.end())
		            return;
		        used_num.erase(number);
		        avail_num.push(number);
		    }
		private:
		    int maxnum;
		    unordered_set<int> used_num;
		    queue<int> avail_num;
		};

}
