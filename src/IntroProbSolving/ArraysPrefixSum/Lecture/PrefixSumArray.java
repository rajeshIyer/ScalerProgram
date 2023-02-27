package IntroProbSolving.ArraysPrefixSum.Lecture;

import java.util.Scanner;

public class PrefixSumArray {
    public int[] generatePrefixSumArray(int[] input) {
        int[] prefixSumArray = new int[input.length];
        prefixSumArray[0] = input[0];
        // Iterate with start index as 1
        for(int i=1; i<input.length; i++){
            prefixSumArray[i] = prefixSumArray[i-1] + input[i];
        }
        return prefixSumArray;
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of array n followed by elements of the array: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        int[] prefixSumArray;
        PrefixSumArray psArray = new PrefixSumArray();
        prefixSumArray = psArray.generatePrefixSumArray(input);

        System.out.println("The prefix sum array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(prefixSumArray[i] + " ");
        }
    }
    // TC = O(N)
    // SC = O(N)        O(N) for prefix sum array
}
