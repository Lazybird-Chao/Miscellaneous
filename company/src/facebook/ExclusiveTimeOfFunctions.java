package facebook;

public class ExclusiveTimeOfFunctions {
	public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size()==0)
            return new int[0];
        Stack<Finfo> callstack = new Stack<Finfo>();
        Finfo[] allfunctions = new Finfo[n];
        for(int i=0; i<n; i++)
            allfunctions[i] = new Finfo(i);
        for(int i = 0; i < logs.size(); i++){
            String[] sublog = logs.get(i).split(":");
            int id = Integer.valueOf(sublog[0]);
            int time = Integer.valueOf(sublog[2]);
            if(!callstack.isEmpty()){
                Finfo lastf = callstack.peek();
                if(id != lastf.id || sublog[1].equals("start")){
                    lastf.endtime = time-1;
                    lastf.updateExe();
                    allfunctions[id].starttime = time;
                    callstack.push(allfunctions[id]);    // must be a begin stamp
                } else{
                    if(sublog[1].equals("end")){
                        callstack.pop();
                        lastf.endtime = time;
                        lastf.updateExe();
                        if(!callstack.isEmpty())
                            callstack.peek().starttime = time+1;
                    } 
                }
            }else{
                allfunctions[id].starttime = time; //must be a begin stamp
                callstack.push(allfunctions[id]);
            }        
        }
        int[] exetimes = new int[n];
        for(int i = 0; i < n; i++)
            exetimes[i] = allfunctions[i].exetime;
        return exetimes;
    }
    
    class Finfo{
         int id;
         int starttime;
         int endtime;
         int exetime;
         Finfo(int id){
            this.id = id;
            starttime = 0;
            endtime = 0;
            exetime = 0;
        }
        int updateExe(){
            if(endtime >= starttime)
                exetime += endtime - starttime + 1;
            return exetime;
        }
    }

}
