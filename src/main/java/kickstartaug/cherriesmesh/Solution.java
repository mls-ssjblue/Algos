package kickstartaug.cherriesmesh;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[]minSugar = new int[T];
        for (int i = 0; i < T; i++) {

            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] p = DisjointSets.createSets(N);
            int ans = 0;

            for (int j = 0; j < M; j++) {
                int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
                if (DisjointSets.unite(p, a, b)) ans++;
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i+1) + ": " + minSugar[i]);
        }
    }

}
class DisjointSets {
    public static int[] createSets(int size) {
        int[] p = new int[size];
        for (int i = 0; i < size; i++)
            p[i] = i;
        return p;
    }

    public static int root(int[] p, int x) {
        return x == p[x] ? x : (p[x] = root(p, p[x]));
    }

    public static boolean unite(int[] p, int a, int b) {
        a = root(p, a);
        b = root(p, b);
        if (a != b) {
            if (Math.random() < 0.5)
                p[a] = b;
            else
                p[b] = a;
            return true;
        }
        return false;
    }

}




