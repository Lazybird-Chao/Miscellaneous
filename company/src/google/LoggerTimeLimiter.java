package google;

public class LoggerTimeLimiter {
	class Logger {
		public:
		    unordered_map<string, int> records;
		    /** Initialize your data structure here. */
		    Logger() {
		        
		    }
		    
		    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
		        If this method returns false, the message will not be printed.
		        The timestamp is in seconds granularity. */
		    bool shouldPrintMessage(int timestamp, string message) {
		        if(records.find(message) == records.end()){
		            records[message] = timestamp;
		            return true;
		        }else{
		            if(records[message] <= timestamp-10){
		                records[message] = timestamp;
		                return true;
		            }else
		                return false;
		        }
		    }
		};

}
