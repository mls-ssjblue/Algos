package ctci;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] ip = new int[][]{
                {1, 0, 3},
                {1, 2, 0},
                {1, 5, 3},
        };

         transform(ip);
        for(int i = 0 ;i<3;i++){
            System.out.println();
            for(int j = 0;j<3;j++)
                System.out.print(ip[i][j]);
        }
    }

    private static void transform(int[][] ip) {
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroColumns = new HashSet<>();
        int R = ip.length;
        int C = ip[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(zeroColumns.contains(j) || zeroRows.contains(i)) continue;
                if(ip[i][j] == 0){
                    zeroRows.add(i);
                    zeroColumns.add(j);
                    setRowToZero(i, ip);
                    setColToZero(j, ip);
                }
            }
        }
    }

    private static void setColToZero(int col, int[][] ip) {
        for(int i =0;i<ip.length;i++){
            ip[i][col] = 0;
        }
    }

    private static void setRowToZero(int row, int[][] ip) {
        for(int i =0;i<ip[0].length;i++){
            ip[row][i] = 0;
        }
    }
}
