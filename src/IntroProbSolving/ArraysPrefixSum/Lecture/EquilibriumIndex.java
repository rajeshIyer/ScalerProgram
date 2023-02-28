package IntroProbSolving.ArraysPrefixSum.Lecture;

import java.util.Scanner;

public class EquilibriumIndex {

    private int fetchEquilibriumIndex(int[] prefixSumArray){
        if(0 == prefixSumArray[prefixSumArray.length-1] - prefixSumArray[0]) {  // Handle when the first index is the equilibrium index
            return 0;
        } else if(0 == prefixSumArray[prefixSumArray.length-2]){                // Handle when the last index is the equilibrium index
            return prefixSumArray.length-1;
        }
        for(int i=1; i<=prefixSumArray.length-2; i++){                          // Iterate from second to last but second element
            if(prefixSumArray[i-1] == prefixSumArray[prefixSumArray.length-1] - prefixSumArray[i]){
                return i;
            }
        }
        return -1;
    }

    // Equilibrium index - An index such that the sum of elements to its left is same as the sum of elements to its right.
    // When there are no elements to the left, assume left sum to be 0
    // When there are no elements to the right, assume right sum to be 0
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
        System.out.println();
        EquilibriumIndex eqIndex = new EquilibriumIndex();
        int result = eqIndex.fetchEquilibriumIndex(prefixSumArray);
        if(result == -1){
            System.out.println(" There is no equilibrium index in the given array");
        } else {
            System.out.println(" The equilibrium index is: " + result + " and the corresponding value is: " + input[result]);
        }
    }
    // TC = O(N)
    // SC = O(N)        O(N) for prefix sum array
    // This can be done TC = O(N) and SC = O(1) using  2 pointers.https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
}
