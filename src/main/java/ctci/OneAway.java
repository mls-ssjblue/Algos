package ctci;

import java.util.Scanner;

public class OneAway {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();

        System.out.println(isOneAway(first,second));
    }

    private static boolean isOneAway(String first, String second) {

        if (first.equals(second)) return true;
        int l1 = first.length();
        int l2 = second.length();
        int diff = 0;
        if (Math.abs(l1 - l2) > 1) return false;
        int max = Math.max(l1, l2);

        if (l1 > l2) {
            for (int i = 0, j = 0; i < max; i++) {
                if(j==l2) return true;
                if (first.charAt(i) == second.charAt(j)) {
                    j++;
                } else {
                    diff++;
                }
            }
            if (diff > 1) return false;
            return true;
        } else if (l1 < l2) {
            for (int i = 0, j = 0; j < max; j++) {
                if(i==l1) return true;
                if (first.charAt(i) == second.charAt(j)) {
                    i++;
                } else {
                    diff++;
                }
            }
            if (diff > 1) return false;
            return true;
        } else {
            for (int i = 0, j = 0; i < max; i++, j++) {
                if (first.charAt(i) != second.charAt(i)) {
                    diff++;
                }

            }
            if (diff > 1) return false;
            return true;
        }

    }
}
