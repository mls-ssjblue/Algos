package codejam2020.round1A.patternmatching;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] solutions = new String[T];
        for (int i = 0; i < T; i++) {

            int N = sc.nextInt();
            List<String> patterns = new ArrayList<>();


            for (int j = 0; j < N; j++) {
                patterns.add(sc.next());
            }
            solutions[i] = patterns(N, patterns);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions[i]);
        }
    }

    private static String patterns(int n, List<String> patterns) {
        Map<Integer, Integer> pointers = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        while (true) {
            char current = 0;
            //Find current common character
            int finish = 0;
            for (int i = 0; i < n; i++) {
                String pat = patterns.get(i);
                int curPtr = pointers.getOrDefault(i, 0);
                if (curPtr < pat.length()) {
                    if (finish == 1) return "*";
                    if (current == 0) current = pat.charAt(curPtr);
                    else if (current != pat.charAt(curPtr)) return "*";
                } else {
                    finish = 1;
                }
            }
            if (finish == 1) return sb.toString();

            //Move pointers and create result string
            int append = 0;
            for (int i = 0; i < n; i++) {
                String pat = patterns.get(i);
                int curPtr = pointers.getOrDefault(i, 0);
                //if common char is *
                if (current == '*') {
                    if (curPtr != pat.length() - 1) {
                        pointers.put(i, curPtr + 1);

                    }
                    continue;
                }

//
//                    if (curPtr < pat.length() - 1) sb.append(pat.substring(curPtr));
//                    return sb.toString();

                // if common char is a letter
                if (curPtr < pat.length() && pat.charAt(curPtr) != '*') {
                    if (current == pat.charAt(curPtr)) {
                        pointers.put(i, curPtr + 1);
                        if (append == 0) sb.append(current);
                        append = 1;
                    } else return "*";
                } else if (pat.charAt(curPtr) == '*') {
                    if (curPtr == pat.length() - 1 || pat.charAt(curPtr + 1) == current) {
                        pointers.put(i, curPtr + 1);
                    }
                }
            }
        }
    }
}
