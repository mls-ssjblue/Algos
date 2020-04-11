package codejam2020.round1A.patternmatching.pascalwalk;

import java.util.*;

public class Solution {
    static List<int[]> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<List<int[]>> solutions = new ArrayList<>();

        for (int i = 0; i < T; i++) {

            int N = sc.nextInt();
            res = new ArrayList<>();
            solutions.add(pascalWalk(N));
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ":");
            for (int j = 0; j < solutions.get(i).size(); j++) {
                System.out.println(solutions.get(i).get(j)[0]+1 + " " + (solutions.get(i).get(j)[1]+1));
            }
        }
    }

    private static List<int[]> pascalWalk(int n) {
        Integer[][] triangle = new Integer[n][n];
        triangle[0][0] = 1;
        for (int i = 1; i < n; i++) {
            triangle[i][0] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
            triangle[i][i] = 1;
        }
        List<List<Integer>> tri = new ArrayList<>();

        List<int[]> path = new ArrayList<>();
        Set<List<Integer>> vis = new HashSet<>();
        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (triangle[i][j] != null) cur.add(triangle[i][j]);
            }
            tri.add(cur);
        }
        path.add(new int[]{0,0});
        vis.add(Arrays.asList(0,0));
        helper(tri, path, n-1, 0, 0,vis);
        return res;
    }

    private static int helper(List<List<Integer>> tri, List<int[]> path, int target, int r, int k, Set<List<Integer>> vis) {
        if (target == 0) {
            res.addAll(path);
            return 1;
        }
        if (target < 0) return 0;

        List<int[]> dirs = Arrays.asList(new int[]{0, -1}, new int[]{0, 1}, new int[]{1, 0}, new int[]{1, 1},
                new int[]{-1,-1}, new int[]{-1,0});

        // i,j-1|i,j+1|i+1,j|i+1,j+1

        for (int i = 0; i < dirs.size(); i++) {
            int newRow = r + dirs.get(i)[0];
            int newCol = k + dirs.get(i)[1];
            if(newRow < 0 || newRow>= tri.size() || newCol<0 || newCol>= tri.get(newRow).size())continue;
            if(vis.contains(Arrays.asList(newRow,newCol)))continue;
            path.add(new int[]{newRow,newCol});
            vis.add(Arrays.asList(newRow,newCol));
            int ans = helper(tri, path, target - tri.get(newRow).get(newCol), newRow, newCol,vis);
            if(ans == 1)return 1;
            path.remove(path.size()-1);
            vis.remove(Arrays.asList(newRow,newCol));
        }

        return 0;
    }


}
