package facebook;

public class SimplifyPath {
	public String simplifyPath(String path) {
        if(path == null || path.isEmpty())
            return "";
        String[] dirs = path.split("/");
        StringBuilder sb = new StringBuilder();
        Stack<String> s = new Stack<String>();
        for(int i = 0; i < dirs.length; i++){
            //System.out.println(dirs[i]);
            if(dirs[i].isEmpty() || dirs[i].equals("."))    //after split there are "" in array
                continue;
            if(dirs[i].equals("..")){
                if(s.size() > 0)
                    s.pop();
                continue;
            }
            s.push(dirs[i]);
        }
        String res = "";
        if(!s.isEmpty())
            res = s.pop();
        while(!s.isEmpty())
            res = s.pop()+"/"+res;
        res = "/"+res;
        return res;
    }

}
