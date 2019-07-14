package kickstartapril.palindrome;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final int NO_OF_CHARS = 256;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] N = new int[T];
        int[] Q = new int[T];
        String sequence;
        int[] solutions = new int[T];
        for (int i = 0; i < T; i++) {
            N[i] = sc.nextInt();
            Q[i] = sc.nextInt();
            sequence = sc.next();
            int[] start = new int[Q[i]], end = new int[Q[i]];
            for (int j = 0; j < Q[i]; j++) {
                start[j] = sc.nextInt();
                end[j] = sc.nextInt();
            }
            solutions[i] = findNumPalindromes(sequence, start, end, Q[i]);

        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i+1) + ": " + solutions[i]);
        }
    }

    private static int findNumPalindromes(String sequence, int[] start, int[] end, int q) {

        int count = 0;
        for (int i = 0; i < q; i++) {
            String subString = sequence.substring(start[i] - 1, end[i]);
            count += canFormPalindrome(subString);
        }
        return count;

    }



    private static int canFormPalindrome(String str) {

        int count[] = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);

        for (int i = 0; i < str.length(); i++)
            count[(int)(str.charAt(i))]++;

        int odd = 0;

        for (int i = 0; i < NO_OF_CHARS; i++)
        {
            if (count[i] % 2 == 1)
                odd++;
            if (odd > 1)
                return 0;
        }
        return 1;
    }



}
