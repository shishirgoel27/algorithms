package union.find;

import java.util.Arrays;

public class DisjointSet {
    int size;
    int components;
    int[] sizes;
    int[] id;

    public DisjointSet(int numComponents) {
        components = numComponents;
        id = new int[numComponents];
        sizes = new int[numComponents];
        Arrays.fill(sizes, 1);
        for(int i=0;i<numComponents;i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        int root = id[p];
        if(root == p) {
            return p;
        }
        while(root != id[root]) {
            root = id[root];
        }
        // path compression
        int current = p;
        while(id[current] != root) {
            int temp = id[current];
            id[current] = root;
            current = temp;
        }
        return root;
    }

    public void union(int p, int r) {
        int root1 = find(p);
        int root2 = find(r);
        if(root1 == root2) {
            return;
        }
        if(sizes[root1] < sizes[root2]) {
            sizes[root2] += sizes[root1];
            id[root2] = root1;
        }else {
            sizes[root1] += sizes[root2];
            id[root1] = root2;
        }
        components--;
    }
}
