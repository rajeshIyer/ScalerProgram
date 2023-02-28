package IntroProbSolving.ArraysPrefixSum.Lecture;

import java.util.Map;
import java.util.Scanner;

public class CountOfSpecialIndices {

    // Given an array, arr[] of size N,
    // the task is to find the count of array indices such that removing an element from these indices makes
    // the sum of even-indexed and odd-indexed array elements equal.
    public static void main(String[] args) {
        System.out.println("Enter the size of array n followed by elements of the array: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        EvenOddPrefixSumArrayInGivenRange evenOddIndexed = new EvenOddPrefixSumArrayInGivenRange();
        Map<String,int[]> resultArrayMap = evenOddIndexed.fetchEvenOddPrefixSumArrayInGivenRange(input);
        int countSpecialIndex = 0;
        int evenSum = 0;
        int oddSum  = 0;
        for(int j=0; j<input.length; j++){
                if(j==0){
                    evenSum = resultArrayMap.get("O")[input.length - 1] - resultArrayMap.get("O")[j];
                    oddSum = resultArrayMap.get("E")[input.length - 1] - resultArrayMap.get("E")[j];
                } else {
                    evenSum = resultArrayMap.get("E")[j - 1] + (resultArrayMap.get("O")[input.length - 1] - resultArrayMap.get("O")[j]);
                    oddSum = resultArrayMap.get("O")[j - 1] + (resultArrayMap.get("E")[input.length - 1] - resultArrayMap.get("E")[j]);
                }
            if(evenSum == oddSum)
                countSpecialIndex++;
        }
        System.out.println(" The result is:" + countSpecialIndex);
    }

    // TC: O(N), SC: O(N)
    // The idea is that even sum follows prefix sum even array until the index-1 element and flips to follow prefix sum odd array from index+1 element until the end.
    // Similarly, odd sum follows prefix sum odd array until the index-1 element and flips to follow prefix sum even array from index+1 element until the end.
    // Generic Formula : Sum of even elements = Sum of even elements until i-1 index + Sum of odd elements from i+1 index to n-1 index
    //                                        = PSE[i-1] + (PSO[n-1] - PSO[i])
    //                   Sum of odd elements = Sum of odd elements until i-1 index + Sum of even elements from i+1 index to n-1 index
    //                                        = PSO[i-1] + (PSE[n-1] - PSE[i])
}
