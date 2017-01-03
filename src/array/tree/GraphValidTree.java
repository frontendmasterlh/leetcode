package array.tree;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.

 For example:

 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

 Hint:

 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
 Show More Hint Note: you can assume that no duplicate edges will appear in edges.
 Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 * https://segmentfault.com/a/1190000003791051
 */
public class GraphValidTree {

    public class UnionFind {
        int[] ids;
        int count;

        public UnionFind(int n) {
            this.count = n;
            this.ids = new int[n];
            for (int i = 0; i < n; i++) {
                this.ids[i] = i;
            }
        }

        public boolean union(int m, int n) {
            int src = find(m);
            int dst = find(n);
            if (src == dst) {
                return false;
            } else {
                for (int i = 0; i < ids.length; i++) {
                    if (ids[i] == src) {
                        ids[i] = dst;
                    }
                }
                count--;
                return true;
            }
        }
        public int find(int x) {
            return this.ids[x];
        }
        public boolean areConnected(int m, int n) {
            return find(m) == find(n);
        }
        public int count() {
            return count;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            if (!unionFind.union(edges[i][0], edges[i][1])) {
                return false;
            }
        }
        return unionFind.count() == 1;
    }

    public static void main(String[] args) {
        GraphValidTree g = new GraphValidTree();
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(g.validTree(5, edges));
    }
}
