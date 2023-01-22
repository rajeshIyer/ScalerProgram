package IntroProbSolving.IntroToArrays.Lecture;

import java.util.Scanner;

public class AtLeastOneGreater {

    public int getMaxElementInAnArray(int[] input) {
        int maxElement = Integer.MIN_VALUE;
        for (int j : input) {
            if (j > maxElement) {
                maxElement = j;
            }
        }
        return maxElement;
    }

    public int getCountOfMaxElementInAnArray(int[] input, int maxElement) {
        int countMaxElement = 0;
        for (int j : input) {
            if (j == maxElement) {
                countMaxElement++;
            }
        }
        return countMaxElement;
    }

    public int getCountOfAtLeastOneGreater(int[] input) {
        int maxElement = getMaxElementInAnArray(input);
        int countMaxElement = getCountOfMaxElementInAnArray(input, maxElement);
        return input.length-countMaxElement;
    }

    public int getCountOfAtLeastOneGreaterWithSingleLoop(int[] input) {
        int countMaxElement = 0;
        int maxElement = Integer.MIN_VALUE;
        for (int j : input) {
            if (j > maxElement) {
                maxElement = j;
                countMaxElement = 1;
            } else if (j == maxElement) {
                countMaxElement++;
            }
        }
        return input.length-countMaxElement;
    }

    // Given an array of size N, count no of elements which have at least one element greater than itself
    // If A[] = {1,2,3,4,5}, output is 4
    // If A[] = {1,2,3,4,4}, output is 3
    public static void main(String[] args) {
        System.out.println("Enter the size N of array followed by its elements:");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] input = new int[N];
        for(int i=0; i<N; i++) {
            input[i] = in.nextInt();
        }
        AtLeastOneGreater atleastOneGreater = new AtLeastOneGreater();
        int count = atleastOneGreater.getCountOfAtLeastOneGreater(input);

        int countAlt = atleastOneGreater.getCountOfAtLeastOneGreaterWithSingleLoop(input);

        System.out.println(" Approach1 : The count of elements which have at least one element greater than itself is " + count);
        System.out.println(" Better Approach : The count of elements which have at least one element greater than itself is " + countAlt);
    }
    // TC = O(N)
    // SC = O(1)
}
