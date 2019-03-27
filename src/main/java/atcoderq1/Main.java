package atcoderq1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Records question
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();
        List<String> records = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            records.add(sc.next());
        }

        int low = K * (M - 1);
        int high = Math.min(K * (M - 1) + K - 1, N - 1);

        for(int i =low; i<=high; i++)
        {
            System.out.println(records.get(i));
        }
    }

}
