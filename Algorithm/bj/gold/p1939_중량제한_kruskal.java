package going;

import java.io.*;
import java.util.*;

public class p1939_중량제한_kruskal {
    
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Path> path = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            path.add(new Path(a, b, w));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        Collections.sort(path);
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (Path e : path) {
            union(e.a, e.b);
            if (find(from) == find(to)) {
                System.out.println(e.w);
                return;
            }
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
    
    static class Path implements Comparable<Path> {
        int a, b, w;
        Path(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
        @Override
        public int compareTo(Path o) {
            return o.w - this.w;
        }
    }
}
