package Graph;

import java.util.ArrayList;

/**
 * Created by mingyazh on 2/28/17.
 */
public class OJ399 {

    private ArrayList<String> nodes;
    private int nodeNum;

    private class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            next = null;
        }
    }
    private class Graph{
        Node[] edges;
        boolean [] marked;

        public Graph(int nodeNum){
            edges = new Node[nodeNum];
            marked = new boolean[nodeNum];
        }

        public void add(int v, int w){
            if(edges[v] == null)
                edges[v] = new Node(w);
            else{
                Node node = edges[v];
                while(node.next != null)
                    node = node.next;
                node.next = new Node(w);
            }
        }

        private void dfs(int v, int w , ArrayList<Integer>path){
            marked[v] = true;
            path.add(v);
            if(v == w) return;

            Node node = edges[v];
            while(node != null) {
                if (!marked[node.val]) {
                    dfs(node.val, w, path);
                }
                node = node.next;
            }
            if(path.get(path.size()-1) == v)
                path.remove(path.size()-1);
        }

        private void reset(){
            for(int i=0; i<nodeNum; i++)
                marked[i] = false;
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        nodes = new ArrayList<>();
        double[] result = new double[queries.length];
        for(String[] list:equations)
            for(String str:list){
                if(!nodes.contains(str))
                    nodes.add(str);
            }
        nodeNum = nodes.size();

        Graph graph = new Graph(nodeNum);

        for(String[] list:equations){
            graph.add(nodes.indexOf(list[0]), nodes.indexOf(list[1]));
            graph.add(nodes.indexOf(list[1]), nodes.indexOf(list[0]));
        }

        ArrayList<Integer> path = new ArrayList<>();
        for(int i=0; i<queries.length; i++) {
            if(!nodes.contains(queries[i][0]) || !nodes.contains(queries[i][1])) {
                result[i] = -1.0;
                continue;
            }
            int v = nodes.indexOf(queries[i][0]);
            int w = nodes.indexOf(queries[i][1]);
            graph.dfs(v, w, path);
            graph.reset();
            if(path.size() == 0)
                result[i] = -1.0;
            else{
                double ans = 1;
                for(int j=0; j<path.size()-1; j++){
                    String p = nodes.get(path.get(j));
                    String q = nodes.get(path.get(j+1));
                    for(int k=0; k<equations.length; k++){
                        String[] list = equations[k];
                        if(p.equals(list[0]) && q.equals(list[1]))
                            ans *= values[k];
                        else if(q.equals(list[0]) && p.equals(list[1]))
                            ans *= 1.0 / values[k];
                        else
                            continue;
                    }
                }
                result[i] = ans;
            }
            path.clear();
        }
        return result;
    }

    public static void main(String[] args){
        String[][] equations = {{"a", "b"}, {"b", "c"}, {"bc", "cd"}};
        double[] values = {1.5, 2.5, 5.0};
        String[][] queries = {{"cd","bc"}};

        OJ399 sol = new OJ399();
        sol.calcEquation(equations, values, queries);
    }
}
