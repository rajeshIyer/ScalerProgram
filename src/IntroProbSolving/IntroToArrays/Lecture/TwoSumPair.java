package IntroProbSolving.IntroToArrays.Lecture;

import java.util.Scanner;

public class TwoSumPair {

    public boolean checkIfPairExistsWithSumK(int[] input, int k){
        for(int i=0; i<input.length; i++){
            // Iterate on j greater than i only
            for(int j=i+1; j<input.length; j++) {
                if (input[i] + input[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check if there is a pair(i, j) such that A[i] + A[j] == k. Also (i!=j)
    public static void main(String[] args) {
        System.out.println("Enter the array size n followed by its elements: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i =0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println("Enter the sum value k to check if the array has 2 elements that add up to k or not: ");
        int k = scanner.nextInt();

        TwoSumPair twoSumPair = new TwoSumPair();
        boolean result = twoSumPair.checkIfPairExistsWithSumK(input, k);
        if(result){
            System.out.println(" There exists a pair that adds up to K");
        } else {
            System.out.println(" No pair exists that adds up to K");
        }
        // Iterate using 2 loops for combinations of i!=j such that i is less than j; as the other possibility of i greater than j would already be considered.
        // TC = O(N^2)
        // SC= O(1)

        // This can be done in a better TC using hashmap and sorting algorithms.
    }
}
