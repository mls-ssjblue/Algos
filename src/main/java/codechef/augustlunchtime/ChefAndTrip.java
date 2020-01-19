package codechef.augustlunchtime;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChefAndTrip {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] ans = new int[T][];
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] A = new int[N];
            for (int j = 0; j < N; j++) {
                A[j] = sc.nextInt();
            }
            ans[i] = chefAndTrip(N, K, A);
        }

        for (int i = 0; i < T; i++) {
            if (ans[i].length == 0) System.out.println("NO");
            else {
                System.out.println("YES");
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }

    private static int[] chefAndTrip(int n, int k, int[] a) {
        Set<Integer> all = Stream.iterate(1, num -> num + 1)
                .limit(k)
                .collect(Collectors.toSet());

        boolean isRepeating = false;
//        for (int i = 0; i < n - 1; i++) {
//            if (a[i] != -1 && a[i + 1] == a[i]) {
//                isRepeating = true;
//                break;
//            }
//        }
        if (isRepeating) return new int[]{};
        for (int i = 0; i < n; i++) {
            if (a[i] == -1) {
                int prev = i > 0 ? a[i - 1] : -1;
                int next = i < n - 1 ? a[i + 1] : -1;
                all.remove(prev);
                all.remove(next);
                if(all.size()>0)a[i] = all.stream().findFirst().get();
                else return new int[]{};
                if(prev!=-1)all.add(prev);
                if(next!=-1)all.add(next);
            }
        }

        return a;
    }

}
