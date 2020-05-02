package codejam2020.round1C.overexcitedfan;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] solutions = new String[T];
        for (int i = 0; i < T; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            String path = sc.next();

            solutions[i] = fan(x, y, path);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions[i]);
        }
    }

    private static String fan(int X, int Y, String path) {
        int x = X, y = Y;
        int T = path.length();

        if (x == 0 && y == 0) return String.valueOf(0);

        for (int i = 0; i < T; i++) {
            char c = path.charAt(i);
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
            }
            if (i + 1 >= Math.abs(x) + Math.abs(y)) {
                return String.valueOf(i + 1);
            }
        }
        return "IMPOSSIBLE";
    }
}
