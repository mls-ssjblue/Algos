package kickstartapril.trinkets;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] N = new int[T];
        int[] S = new int[T];
        int[] solutions = new int[T];
        for (int i = 0; i < T; i++) {
            N[i] = sc.nextInt();
            S[i] = sc.nextInt();
            int[] trinkets = new int[N[i]];

            for (int j = 0; j < N[i]; j++) {
                trinkets[j] = sc.nextInt();
            }
            solutions[i] = findMaxTrinkets(trinkets, S[i]);

        }
        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions[i]);
        }
    }

    private static int findMaxTrinkets(int[] trinkets, int maxOfSingleType) {
        int left = 0, right = 0;
        int max_so_far = 0;
        List<Integer> maxValues = new ArrayList<>();
        while (left <= right && left < trinkets.length) {
            if (isValid(trinkets, left, right, maxOfSingleType)) {
                max_so_far = Arrays.copyOfRange(trinkets, left, right + 1).length;
                if (right != trinkets.length - 1)
                    right++;
                else {
                    maxValues.add(max_so_far);
                    break;
                }
            } else {
                if (right != trinkets.length - 1) {
                    right++;
                }
                left++;

                maxValues.add(max_so_far);
            }


        }
        return Collections.max(maxValues);

    }

    private static boolean isValid(int[] trinkets, int left, int right, int m) {
        Set<Integer> set = new HashSet<>();
        int[] numDupes = new int[100000];
        Arrays.fill(numDupes,1);
        for (int x : Arrays.copyOfRange(trinkets, left, right + 1)) {
            if (set.contains(x)) numDupes[x]+=1;
            set.add(x);
        }
        if (Arrays.stream(numDupes).max().getAsInt() > m) return false;
        return true;

    }
}
