package google;

public class EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if(equations == null || values == null || queries == null)
            return new double[0];
        Map<String, Map<String, Double>> g = new HashMap<String, Map<String, Double>>();
        for(int i = 0; i < equations.length; i++){
            if(!g.containsKey(equations[i][0])){
                Map<String, Double> tmp = new HashMap<String, Double>();
                tmp.put(equations[i][1], values[i]);
                g.put(equations[i][0], tmp);
            }else
                g.get(equations[i][0]).put(equations[i][1], values[i]);
            if(!g.containsKey(equations[i][1])){
                Map<String, Double> tmp = new HashMap<String, Double>();
                tmp.put(equations[i][0], 1.0/values[i]);
                g.put(equations[i][1], tmp);
            }else
                g.get(equations[i][1]).put(equations[i][0], 1/values[i]);
        }
        Map<String, Map<String, Double>> p = new HashMap<String, Map<String, Double>>();
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++){
            if((!g.containsKey(queries[i][0]))  ||  (!g.containsKey(queries[i][1])))
                res[i] = -1.0;
            else if(queries[i][0].equals(queries[i][1]))
                res[i] = 1.0;
            else{
                if(!p.containsKey(queries[i][0]) ){
                    Map<String, Double> tmp = new HashMap<String, Double>();
                    tmp.put(queries[i][0], 1.0);
                    p.put(queries[i][0], tmp);
                    findpath(g, p, queries[i][0], queries[i][0], 1.0);
                }
                if(p.get(queries[i][0]).containsKey(queries[i][1]))
                    res[i] = p.get(queries[i][0]).get(queries[i][1]);
                else
                    res[i] = -1.0;
            }
        }
        return res;
    }
    void findpath(Map<String, Map<String, Double>> g, Map<String, Map<String, Double>> p, String start, String cur,  double pathvalue){
        if(!g.containsKey(cur) || g.get(cur).isEmpty())
            return;
        for(String dst : g.get(cur).keySet()){
            if(p.get(start).containsKey(dst))
                continue;
            double v = g.get(cur).get(dst);
            p.get(start).put(dst, pathvalue*v);
            findpath(g, p, start, dst, pathvalue*v);
        }
        return;
    }

}
