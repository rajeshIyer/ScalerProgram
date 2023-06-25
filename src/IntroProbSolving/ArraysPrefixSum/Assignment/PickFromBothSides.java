package IntroProbSolving.ArraysPrefixSum.Assignment;

import IntroProbSolving.ArraysPrefixSum.Lecture.PrefixSumArray;

import java.util.Scanner;

// Pick From Both Sides
// Given an integer array A of size N, perform B operations such that in one operation, one can remove either the leftmost or the rightmost element of the array.
// Find and return the maximum possible sum of the elements that were removed after B operations.
public class PickFromBothSides {
    public static void main(String[] args) {
        System.out.println("Enter the size of array n followed by elements of the array: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println("The input array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(input[i] + " ");
        }
        int[] prefixSumArray;
        PrefixSumArray psArray = new PrefixSumArray();
        prefixSumArray = psArray.generatePrefixSumArray(input);
        System.out.println("The prefix sum array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(prefixSumArray[i] + " ");
        }
        System.out.println();
        System.out.println("Enter the count of elements that can be picked: ");
        int count = scanner.nextInt();
        int result = prefixSumArray[count-1];
        int remove_factor = 0;
        int add_factor = 0;
        for (int i = count-1, j=input.length-1; i >= 0; i--,j--) {
            remove_factor +=  input[i];
            add_factor += input[j];
            result = result > prefixSumArray[count-1] - remove_factor + add_factor ? result : prefixSumArray[count-1] - remove_factor + add_factor;
        }
        System.out.println("The maximum sum formed by picking from both sides is:" + result);
    }
    // TC: O(N), SC: O(N)
}
