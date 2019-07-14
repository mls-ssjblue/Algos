package zigzagconversion;

import java.util.Scanner;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("A", 1));
    }

    public static String convert(String s, int numRows) {
        if( numRows == 1) return s;
        String result = "";
        int length = s.length();
        int steps = length / (2 * numRows) + 1;
        int stepSize = numRows;
        int i = 0, j = 0;
        char[][] zigzag = new char[numRows][steps * stepSize];
        for (i = 0; i < numRows; i++) {
            for (j = 0; j < length / numRows; j++) zigzag[i][j] = 0;
        }
        int currIndex = 0;
        i = j = 0;
        while (currIndex < length) {
            for (i = 0; i < numRows - 1 && currIndex < length; i++) {
                zigzag[i][j] = s.charAt(currIndex);
                currIndex++;
            }

            for (i = numRows - 1; i > 0 && currIndex < length; i--, j++) {
                zigzag[i][j] = s.charAt(currIndex);
                currIndex++;
            }
//            j--;
        }
        for (i = 0; i < numRows; i++) {
            for (j = 0; j < steps * stepSize; j++) {
                if (zigzag[i][j] != 0) {
                    result += zigzag[i][j];
                }
            }
        }

        return result;
    }
}
