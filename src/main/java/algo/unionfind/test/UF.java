package algo.unionfind.test;

import java.util.Arrays;

public class UF {

    private int count = 0;
    private int[] parent;
    // 树的重量
    private int[] weight;

    public UF(int n) {
        count = n;
        parent = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b) return;
        if (weight[a] >= weight[b]) {
            parent[b] = a;
            weight[a] += weight[b];
        } else {
            parent[a] = b;
            weight[b] += weight[a];
        }
        count--;
    }

    // 压缩路径 parent[x] = parent[parent[x]]
    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int[] getParent() {
        return parent;
    }

    public int getWeight(int index) {
        return weight[find(index)];
    }

    public static void main(String[] args) {
        UF uf = new UF(8);
        System.out.println(uf.getCount());

        uf.union(1, 2);
        System.out.println(uf.getCount());

        uf.union(3, 4);
        System.out.println(uf.getCount());

        uf.union(1, 4);
        System.out.println(uf.getCount());

        uf.union(2, 3);
        System.out.println(uf.getCount());

        System.out.println(uf.find(4));
        System.out.println(uf.connected(1, 3));
        System.out.println(uf.getWeight(2));
        System.out.println(Arrays.toString(uf.getParent()));
    }
}
