package toptal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println(solution(2,"1A 2F 1C"));
    }

    public static int solution(int N, String S) {
        // write your code in Java SE 8
        if (N == 1 && S.equals("")) return 2;
        int[][] matrix = new int[N][10];
        String[] seats = S.split(" ");
        for (int i = 0; i < seats.length; i++) {
            int row = seats[i].charAt(0) -'1';
            int column = mapToColumn(seats[i].charAt(1));
            matrix[row][column] = 1;
            List<Integer> a = new ArrayList<>();
            String s = "a";
            Map<Integer, Integer> b= new HashMap<>();
            
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            int[] row = matrix[i];
            if (adjFree(row, 1) && adjFree(row, 3) && adjFree(row, 5) && adjFree(row, 7)) count += 2;
            else if (adjFree(row, 3) && adjFree(row, 5)) count += 1;
            else if (adjFree(row, 1) && adjFree(row, 3)) count += 1;
            else if (adjFree(row, 5) && adjFree(row, 7)) count += 1;
        }
        return count;
    }

    private static boolean adjFree(int[] row, int index) {
        if(row[index] == 0 && row[index+1] ==0)return true;
        return false;
    }


    private static int mapToColumn(char c) {
        return c - 'A';
    }
}
