package Graph;

import BreathFirstSearch.OJ417;

/**
 * Created by mingyazh on 2/27/17.
 */
public class OJ210 {
    private DirectedGraph dg;
    private boolean isPossible = true;
    private int d = 0;
    int[] order;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        order = new int[numCourses];
        dg = new DirectedGraph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            dg.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }
        int[] marked = new int[numCourses];
        for (int k = 0; k < numCourses; k++) {
            if (marked[k] == 0)
                dfs(k, this.d, marked);
        }
        if (!this.isPossible)
            return new int[]{};
        else
            return order;
    }
    private class DirectedGraph{
        private Node[] nodes;
        public DirectedGraph(int numCourses){
            this.nodes = new Node[numCourses];
            for(int i = 0; i<numCourses; i++){
                nodes[i] = new Node(i);
            }
        }

        public void addEdge(int i, int j){
            Node node = new Node(j);
            Node v = nodes[i];
            while(v.next != null) v = v.next;
            v.next = node;
        }

        public Node edges(int i){
            return nodes[i];
        }
    }

    private class Node{
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private void dfs(int i, int d, int[] marked){

        if(marked[i] == -1) {
            this.isPossible = false;
            return;
        }

        Node node = dg.edges(i);
        marked[i] = 1;
        node = node.next;
        while(node != null){
            int index = node.val;
            if(marked[index] == 0) {
                marked[i] = -1;
                dfs(index, this.d, marked);
                marked[i] = 1;
            }
            if(marked[index] == -1){
                this.isPossible = false;
                return;
            }
            node = node.next;
        }
        this.order[this.d++] = i;
    }

    public static void main(String[] args){
        OJ210 sol = new OJ210();
        int numCourses = 3;
        int[][] prerequisites = {{0, 1}, {1, 0}};
        int[] result = sol.findOrder(numCourses, prerequisites);
        for(int i: result)
            System.out.println(result[i]);
    }
}
