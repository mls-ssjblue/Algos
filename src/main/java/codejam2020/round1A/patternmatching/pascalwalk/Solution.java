package codejam2020.round1A.patternmatching.pascalwalk;

import java.util.*;

public class Solution {
    static List<int[]> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {

            int N = sc.nextInt();
            res = new ArrayList<>();

            int rows = Math.min(30,N);
            int side=0;
            N -= rows;
            Vector<Integer>a = new Vector<>(rows);


            for (int row = rows - 1; row >= 0; row--) {
                if (N >= (1 << row) - 1) {
                    a.add(row,1);
                    N -= (1 << row) - 1;
                }
            }
            rows += N;

            a.setSize(rows);

            for (int row = 0; row < rows; row++) {
                if (a.get(row) == 1) {
                    if (side == 0) {
                        for (int j = 0; j <= row; j++) {
                            System.out.println(row + 1 + " " + (j + 1));
                        }
                    } else {
                        for (int j = row; j >= 0; j--) {
                            System.out.println(row + 1 + " " + (j + 1));
                        }
                    }
                    side ^= 1;
                } else {
                    if (side == 0) {
                        System.out.println(row + 1 + " " +  1);
                    } else {
                        System.out.println(row + 1 + " " + (row + 1));

                    }
                }
            }
            System.out.println();
        }

    }


}
