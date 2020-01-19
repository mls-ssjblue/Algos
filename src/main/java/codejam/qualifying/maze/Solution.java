//package codejam.qualifying.maze;
//
//import sun.latest.Queue;
//
//import java.util.ArrayList;
//import java.util.LinkedListNode;
//import java.util.List;
//import java.util.Scanner;
//
//public class Solution {
//    private static String path;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        List<String> lydiaPaths = new ArrayList<>();
//        int[] N = new int[T];
//        for (int i = 0; i < T; i++) {
//            N[i] = sc.nextInt();
//            lydiaPaths.add(sc.next());
//
//        }
//        for (int i = 0; i < T; i++) {
//            path = "";
//            findPath(N[i], lydiaPaths.get(i));
//            System.out.println("Case #" + (i + 1) + ": " + path);
//
//        }
//
//    }
//
//    private static String findPath(int n, String lydiaPath) {
//        String solution = "";
//        findPath(n, solution, 0, 0, 0, 0, 0, lydiaPath);
//        return solution;
//    }
//
//    private static Boolean findPath(int N, String solution, int x1, int y1, int x2, int y2, int step, String lydiaPath) {
//        if (x1 == N - 1 && y1 == N - 1) {
//            path = solution;
//            return true;
//        }
//        x2 = lydiaPath.charAt(step) == 'E' ? x2 + 1 : x2;
//        y2 = lydiaPath.charAt(step) == 'S' ? y2 + 1 : y2;
//        if (isNextMoveAllowed(solution + 'E', N, x1 + 1, y1, x2, y2, step + 1, lydiaPath) && findPath(N, solution + 'E', x1 + 1, y1, x2, y2, step + 1, lydiaPath)) {
//            return true;
//        }
//        if (isNextMoveAllowed(solution + 'S', N, x1, y1 + 1, x2, y2, step + 1, lydiaPath) && findPath(N, solution + 'S', x1, y1 + 1, x2, y2, step + 1, lydiaPath)) {
//            return true;
//        }
//        return false;
//    }
//
//    private static boolean isNextMoveAllowed(String solution, int N, int x1, int y1, int x2, int y2, int step, String lydiaPath) {
//        if (x1 < 0 || x1 >= N || y1 < 0 || y1 >= N) return false;
//        if (x1 != x2 || y1 != y2) return true;
//        if (solution.charAt(step - 1) == lydiaPath.charAt(step - 1)) return false;
//        return true;
//    }
//
//    public boolean hasPath(int[][] maze, int N, String lydiaPath ) {
//        boolean[][] visited = new boolean[maze.length][maze[0].length];
////        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
//        int x2=0,y2=0;
//        String solution="";
//        Queue< int[] > queue = new LinkedListNode< >();
//        queue.add({0,0});
//        visited[start[0]][start[1]] = true;
//        char[] dirs = {'E','S'};
//        while (!queue.isEmpty()) {
//            int[] s = queue.remove();
//            if (s[0] == N-1 && s[1] == N-1)
//                return true;
//            for (Character c: dirs) {
//                int x = s[0] + dir[0];
//                int y = s[1] + dir[1];
//                int temp = step;
//                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && isNextMoveAllowed(solution, N, x,y,x2,y2,temp,lydiaPath) ) {
//                    x += dir[0];
//                    y += dir[1];
//                    temp++;
//                    x2 = lydiaPath.charAt(temp) == 'E' ? x2 + 1 : x2;
//                    y2 = lydiaPath.charAt(temp) == 'S' ? y2 + 1 : y2;
//                }
//                if (!visited[x - dir[0]][y - dir[1]]) {
//                    queue.add(new int[] {x - dir[0], y - dir[1]});
//                    visited[x - dir[0]][y - dir[1]] = true;
//                    solution.charAt(step) =
//                }
//            }
//        }
//        return false;
//    }
//
//}
