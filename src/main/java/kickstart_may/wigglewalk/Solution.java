package kickstart_may.wigglewalk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        List<List<Integer>> solutions = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            String instructions;
            int N,R,C,Sr,Sc;
            N = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            Sr = sc.nextInt();
            Sc = sc.nextInt();
            instructions = sc.next();
            solutions.add(findAnswer(N, R, C, Sr - 1, Sc - 1, instructions));

        }
        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions.get(i).get(0) + " " + solutions.get(i).get(1));
        }
    }

    private static List<Integer> findAnswer(int n, int r, int c, int sr, int sc, String instructions) {
        if(r == 1 && c == 1) return Arrays.asList(1,1);
        int[][] board = new int[r][c];
        int currRow = sr;
        int currCol = sc;
        for (int i = 0; i < instructions.length() && currRow>=0 && currCol>= 0 && currRow < r && currCol < c ; i++) {
            char inst = instructions.charAt(i);
            board[currRow][currCol] = 1;

            while (currRow>=0 && currCol>= 0 && currRow < r && currCol < c && board[currRow][currCol] == 1) {
                board[currRow][currCol] = 1;

                switch (inst) {
                    case 'N':
                    case 'n': {
                        currRow -= 1;
                        break;
                    }
                    case 'e':
                    case 'E': {
                        currCol += 1;
                        break;
                    }
                    case 's':
                    case 'S': {
                        currRow += 1;
                        break;
                    }
                    case 'w':
                    case 'W': {
                        currCol -= 1;
                        break;
                    }
                    default: {
                        board[currRow][currCol] = 0;
                    }

                }
            }
            if(currRow == -1) currRow = 0;
            if(currRow == r) currRow = r - 1;
            if(currCol == -1) currCol = 0;
            if(currCol == c) currCol = c - 1;
        }

        return Arrays.asList(currRow+ 1, currCol + 1);
    }


}
