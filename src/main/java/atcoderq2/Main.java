package atcoderq2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        printMax(nums, N, L);
//        for (int s = 0; s < N - L + 1; s++) {
//            int[] subArray = new int[L];
//            int max = Integer.MIN_VALUE;
//            for (int j = 0; j < L; j++) {
//                subArray[j] = nums[s + j];
//                if (subArray[j] > max) max = subArray[j];
//            }
//
//            System.out.println(max);
//        }

    }

    private static void printMax(int[] nums, int N, int L) {
        Deque<Integer> Qi = new LinkedList<Integer>();

        int i;
        for(i = 0; i < L; ++i)
        {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while(!Qi.isEmpty() && nums[i] >= nums[Qi.peekLast()])
                Qi.removeLast();   // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for( ;i < N; ++i)
        {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(nums[Qi.peek()] + " ");

            // Remove the elements which are out of this window
            while((!Qi.isEmpty()) && Qi.peek() <= i-L)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!Qi.isEmpty()) && nums[i] >= nums[Qi.peekLast()])
                Qi.removeLast();


            // Add current element at the rear of Qi
            Qi.addLast(i);

        }

        // Print the maximum element of last window
        System.out.println(nums[Qi.peek()]);

    }
}
